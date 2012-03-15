package org.slc.sli.controller;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedSet;

import freemarker.ext.beans.BeansWrapper;

//import org.slc.sli.view.AttendanceResolver;
import org.slc.sli.view.AttendanceResolver;
import org.slc.sli.view.GradebookEntryResolver;
import org.slc.sli.view.GradebookEntryViewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.slc.sli.config.LozengeConfig;
import org.slc.sli.config.StudentFilter;
import org.slc.sli.config.ViewConfig;
import org.slc.sli.entity.GenericEntity;
import org.slc.sli.manager.ConfigManager;
import org.slc.sli.manager.HistoricalViewManager;
import org.slc.sli.manager.PopulationManager;
import org.slc.sli.manager.StudentProgressManager;
import org.slc.sli.manager.ViewManager;
import org.slc.sli.util.Constants;
import org.slc.sli.util.SecurityUtil;
import org.slc.sli.view.AssessmentResolver;
import org.slc.sli.view.HistoricalDataResolver;
import org.slc.sli.view.LozengeConfigResolver;
import org.slc.sli.view.StudentResolver;
import org.slc.sli.view.widget.WidgetFactory;

/**
 * Controller for showing the list of studentview.
 * 
 */
@Controller
@RequestMapping("/studentlistcontent")
public class StudentListContentController extends DashboardController {
    
    private ConfigManager configManager;
    private PopulationManager populationManager;
    private ViewManager viewManager;
    private StudentProgressManager progressManager;
    
    public StudentListContentController() {
    }
    
    /**
     * Retrieves information for the student list and sends back an html table to be displayed
     * 
     * @param population
     *            Don't know what this could be yet... For now, a list of student uids
     * @param model
     * @param viewIndex
     *            The selected view configuration index
     * @param sessionId
     *            is the id of the session you're in to describe historical data.
     * @return a ModelAndView object
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView studentListContent(@RequestParam(required = false, value = Constants.ATTR_SESSION_ID) String sessionId,
            @RequestParam(required = false, value = Constants.ATTR_COURSE_ID) String selectedCourseId,
            @RequestParam(required = false, value = Constants.ATTR_SECTION_ID) String selectedSectionId,
            String population, Integer viewIndex, Integer filterIndex, ModelMap model) throws Exception {
        
        UserDetails user = SecurityUtil.getPrincipal();
                        
        // get the list of all available viewConfigs
        List<ViewConfig> viewConfigs = configManager.getConfigsWithType(user.getUsername(),
                Constants.VIEW_TYPE_STUDENT_LIST);
        
        // insert the lozenge config object into modelmap
        List<LozengeConfig> lozengeConfig = configManager.getLozengeConfig(user.getUsername());
        if (lozengeConfig != null)
            model.addAttribute(Constants.MM_KEY_LOZENGE_CONFIG, new LozengeConfigResolver(lozengeConfig));
        
        List<String> uids = new ArrayList<String>();
        if (population != null && !population.isEmpty()) {
            uids = Arrays.asList(population.split(","));
        }
        
        viewManager.setViewConfigs(viewConfigs);
        List<ViewConfig> applicableViewConfigs = viewManager.getApplicableViewConfigs(uids, SecurityUtil.getToken());
        
        if (applicableViewConfigs.size() > 0) {
            
            // add applicable viewConfigs to model map
            model.addAttribute(Constants.MM_KEY_VIEW_CONFIGS, applicableViewConfigs);
            
            ViewConfig viewConfig = applicableViewConfigs.get(viewIndex);


            // If we have the historical data view get historical information - this logic really
            // should be moved from the controller class
            if (viewConfig.getName().equals(Constants.HISTORICAL_DATA_VIEW)) {
                
                Map<String, List<GenericEntity>> historicalData = progressManager.getStudentHistoricalAssessments(
                        SecurityUtil.getToken(), uids, selectedCourseId);
                
                SortedSet<String> schoolYears = progressManager.applySessionAndTranscriptInformation(
                        SecurityUtil.getToken(), historicalData);
                
                HistoricalDataResolver historicalDataResolver = new HistoricalDataResolver(historicalData, schoolYears,
                        null);
                
                model.addAttribute(Constants.MM_KEY_HISTORICAL, historicalDataResolver);
                
                HistoricalViewManager historicalViewManager = new HistoricalViewManager(historicalDataResolver);
                viewConfig = historicalViewManager.addHistoricalData(viewConfig);
            } else if (viewConfig.getName().equals("Current Grades")) {

                SortedSet<GenericEntity> gradebookIds;
                Map<String, Map<String, GenericEntity>> gradebookData =
                        progressManager.getCurrentProgressForStudents(SecurityUtil.getToken(), uids, selectedSectionId);
                gradebookIds = progressManager.retrieveSortedGradebookEntryList(gradebookData);

                GradebookEntryViewManager gradebookEntryViewManager = new GradebookEntryViewManager(gradebookIds);
                viewConfig = gradebookEntryViewManager.addGradebookEntries(viewConfig);

                GradebookEntryResolver gradebookEntryResolver = new GradebookEntryResolver(gradebookData);
                model.addAttribute("gradebookEntryData", gradebookEntryResolver);

            }
            
            model.addAttribute(Constants.MM_KEY_VIEW_CONFIG, viewConfig);
            
            // prepare student filter
            List<StudentFilter> studentFilterConfig = configManager.getStudentFilterConfig(user.getUsername());
            model.addAttribute("studentFilters", studentFilterConfig);
            
            if (filterIndex == null) {
                filterIndex = 0;
            }
            String studentFilterName = "";
            if (studentFilterConfig != null) {
                studentFilterName = studentFilterConfig.get(filterIndex).getName();
            }
            
            // get student, program, attendance, and assessment result data
            List<GenericEntity> studentSummaries = populationManager.getStudentSummaries(SecurityUtil.getToken(), uids,
                    viewConfig, sessionId);
            StudentResolver studentResolver = new StudentResolver(studentSummaries);
            studentResolver.filterStudents(studentFilterName);
            
            model.addAttribute(Constants.MM_KEY_STUDENTS, studentResolver);
            
            // insert the assessments object into the modelmap
            List<GenericEntity> assmts = populationManager.getAssessments(SecurityUtil.getToken(), studentSummaries);
            model.addAttribute(Constants.MM_KEY_ASSESSMENTS, new AssessmentResolver(studentSummaries, assmts));
            
            // Get attendance
            model.addAttribute(Constants.MM_KEY_ATTENDANCE, new AttendanceResolver());
            
        }
        
        // insert a widget factory into the modelmap
        model.addAttribute(Constants.MM_KEY_WIDGET_FACTORY, new WidgetFactory());
        
        // let template access Constants
        model.addAttribute(Constants.MM_KEY_CONSTANTS,
                BeansWrapper.getDefaultInstance().getStaticModels().get(Constants.class.getName()));
        
        return new ModelAndView("studentListContent");
    }
    
    /*
     * Getters and setters
     */
    
    @Autowired
    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }
    
    @Autowired
    public void setConfigManager(ConfigManager configManager) {
        this.configManager = configManager;
    }
    
    @Autowired
    public void setPopulationManager(PopulationManager populationManager) {
        this.populationManager = populationManager;
    }
    
    @Autowired
    public void setProgressManager(StudentProgressManager progressManager) {
        this.progressManager = progressManager;
    }
    
}
