/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.slc.sli.ingestion.smooks.mappings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import org.slc.sli.domain.Entity;
import org.slc.sli.domain.Repository;
import org.slc.sli.ingestion.NeutralRecord;
import org.slc.sli.ingestion.util.EntityTestUtils;
import org.slc.sli.validation.EntityValidationException;
import org.slc.sli.validation.EntityValidator;

/**
 *
 * @author ablum
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml" })
public class TeacherSchoolAssociationEntityTest {

    @Value("${sli.ingestion.recordLevelDeltaEntities}")
    private String recordLevelDeltaEnabledEntityNames;

    @InjectMocks
    @Autowired
    private EntityValidator validator;

    @Mock
    private Repository<Entity> mockRepository;

    String xmlTestData = "<InterchangeStaffAssociation xmlns=\"http://ed-fi.org/0100\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"Interchange-StaffAssociation.xsd\">"
            + "<TeacherSchoolAssociation>"
            + "<TeacherReference>"
            + "<StaffIdentity>"
            + "<StaffUniqueStateId>333333332</StaffUniqueStateId>"
            + "</StaffIdentity>"
            + "</TeacherReference>"
            + "<SchoolReference>"
            + "<EducationalOrgIdentity>"
            + "<StateOrganizationId>123456111</StateOrganizationId>"
            + "</EducationalOrgIdentity>"
            + "</SchoolReference>"
            + "<ProgramAssignment>Title I-Academic</ProgramAssignment>"
            + "<InstructionalGradeLevels>"
            + "<GradeLevel>Second grade</GradeLevel>"
            + "<GradeLevel>Seventh grade</GradeLevel>"
            + "</InstructionalGradeLevels>"
            + "<AcademicSubjects>"
            + "<AcademicSubject>English</AcademicSubject>"
            + "<AcademicSubject>Mathematics</AcademicSubject>"
            + "</AcademicSubjects>"
            + "</TeacherSchoolAssociation>"
            + "</InterchangeStaffAssociation>";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidTeacherSchoolAssociation() throws Exception {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";
        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        NeutralRecord record = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                xmlTestData, recordLevelDeltaEnabledEntityNames);

        // mock repository will simulate "finding" the references
        Mockito.when(mockRepository.exists("staff", "333333332")).thenReturn(true);
        Mockito.when(mockRepository.exists("educationOrganization", "123456111")).thenReturn(true);

        //EntityTestUtils.mapValidation(record.getAttributes(), "teacherSchoolAssociation", validator);
    }

    @Test(expected = EntityValidationException.class)
    public void testInvalidTeacherSchoolAssociationMissingTeacherReference() throws Exception {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";
        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        String invalidXmlMissingTeacherReference = "<InterchangeStaffAssociation xmlns=\"http://ed-fi.org/0100\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"Interchange-StaffAssociation.xsd\">"
                + "<TeacherSchoolAssociation>"
                + "<SchoolReference>"
                + "<EducationalOrgIdentity>"
                + "<StateOrganizationId>123456111</StateOrganizationId>"
                + "</EducationalOrgIdentity>"
                + "</SchoolReference>"
                + "<ProgramAssignment>Title I-Academic</ProgramAssignment>"
                + "<InstructionalGradeLevels>"
                + "<GradeLevel>Ungraded</GradeLevel>"
                + "</InstructionalGradeLevels>"
                + "<AcademicSubjects>"
                + "<AcademicSubject>English</AcademicSubject>"
                + "</AcademicSubjects>"
                + "</TeacherSchoolAssociation>" + "</InterchangeStaffAssociation>";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                invalidXmlMissingTeacherReference, recordLevelDeltaEnabledEntityNames);

        Entity e = mock(Entity.class);
        when(e.getBody()).thenReturn(neutralRecord.getAttributes());
        when(e.getType()).thenReturn("teacherSchoolAssociation");

        validator.validate(e);

    }

    @Test(expected = EntityValidationException.class)
    public void testInvalidTeacherSchoolAssociationMissingSchoolReference() throws Exception {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";
        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        String invalidXmlMissingSchoolReference = "<InterchangeStaffAssociation xmlns=\"http://ed-fi.org/0100\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"Interchange-StaffAssociation.xsd\">"
                + "<TeacherSchoolAssociation>"
                + "<TeacherReference>"
                + "<StaffIdentity>"
                + "<StaffUniqueStateId>333333332</StaffUniqueStateId>"
                + "</StaffIdentity>"
                + "</TeacherReference>"
                + "<ProgramAssignment>Title I-Academic</ProgramAssignment>"
                + "<InstructionalGradeLevels>"
                + "<GradeLevel>Ungraded</GradeLevel>"
                + "</InstructionalGradeLevels>"
                + "<AcademicSubjects>"
                + "<AcademicSubject>English</AcademicSubject>"
                + "</AcademicSubjects>"
                + "</TeacherSchoolAssociation>"
                + "</InterchangeStaffAssociation>";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                invalidXmlMissingSchoolReference, recordLevelDeltaEnabledEntityNames);

        Entity e = mock(Entity.class);
        when(e.getBody()).thenReturn(neutralRecord.getAttributes());
        when(e.getType()).thenReturn("teacherSchoolAssociation");

        validator.validate(e);

    }

    @Test(expected = EntityValidationException.class)
    public void testInvalidTeacherSchoolAssociationMissingProgramAssignment() throws Exception {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";
        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        String invalidXmlMissingProgramAssignment = "<InterchangeStaffAssociation xmlns=\"http://ed-fi.org/0100\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"Interchange-StaffAssociation.xsd\">"
                + "<TeacherSchoolAssociation>"
                + "<TeacherReference>"
                + "<StaffIdentity>"
                + "<StaffUniqueStateId>333333332</StaffUniqueStateId>"
                + "</StaffIdentity>"
                + "</TeacherReference>"
                + "<SchoolReference>"
                + "<EducationalOrgIdentity>"
                + "<StateOrganizationId>123456111</StateOrganizationId>"
                + "</EducationalOrgIdentity>"
                + "</SchoolReference>"
                + "<InstructionalGradeLevels>"
                + "<GradeLevel>Ungraded</GradeLevel>"
                + "</InstructionalGradeLevels>"
                + "<AcademicSubjects>"
                + "<AcademicSubject>English</AcademicSubject>"
                + "</AcademicSubjects>" + "</TeacherSchoolAssociation>" + "</InterchangeStaffAssociation>";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                invalidXmlMissingProgramAssignment, recordLevelDeltaEnabledEntityNames);

        Entity e = mock(Entity.class);
        when(e.getBody()).thenReturn(neutralRecord.getAttributes());
        when(e.getType()).thenReturn("teacherSchoolAssociation");

        validator.validate(e);

    }


    @Test(expected = EntityValidationException.class)
    public void testInvalidTeacherSchoolAssociationIncorrectEnum() throws Exception {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";
        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        String invalidXmIncorrectEnum = "<InterchangeStaffAssociation xmlns=\"http://ed-fi.org/0100\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"Interchange-StaffAssociation.xsd\">"
                + "<TeacherSchoolAssociation>"
                + "<TeacherReference>"
                + "<StaffIdentity>"
                + "<StaffUniqueStateId>333333332</StaffUniqueStateId>"
                + "</StaffIdentity>"
                + "</TeacherReference>"
                + "<SchoolReference>"
                + "<EducationalOrgIdentity>"
                + "<StateOrganizationId>123456111</StateOrganizationId>"
                + "</EducationalOrgIdentity>"
                + "</SchoolReference>"
                + "<ProgramAssignment>Title I-Academics</ProgramAssignment>"
                + "<InstructionalGradeLevels>"
                + "<GradeLevel>Ungraded</GradeLevel>"
                + "</InstructionalGradeLevels>"
                + "<AcademicSubjects>"
                + "<AcademicSubject>English</AcademicSubject>"
                + "</AcademicSubjects>"
                + "</TeacherSchoolAssociation>" + "</InterchangeStaffAssociation>";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                invalidXmIncorrectEnum, recordLevelDeltaEnabledEntityNames);

        Entity e = mock(Entity.class);
        when(e.getBody()).thenReturn(neutralRecord.getAttributes());
        when(e.getType()).thenReturn("teacherSchoolAssociation");

        validator.validate(e);

    }

    @Ignore
    @Test
    public void testValidTeacherSchoolAssociaitionCSV() throws Exception {

        String smooksConfig = "smooks_conf/smooks-teacherSchoolAssociation-csv.xml";

        String targetSelector = "csv-record";

        String csvTestData = "333333332,123456111,Title I-Academic,Second grade,English";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                csvTestData, recordLevelDeltaEnabledEntityNames);

        checkValidTeacherSchoolAssociationNeutralRecord(neutralRecord);

    }

    @Test
    public void testValidTeacherSchoolAssociationXML() throws IOException, SAXException {
        String smooksConfig = "smooks_conf/smooks-all-xml.xml";

        String targetSelector = "InterchangeStaffAssociation/TeacherSchoolAssociation";

        NeutralRecord neutralRecord = EntityTestUtils.smooksGetSingleNeutralRecord(smooksConfig, targetSelector,
                xmlTestData, recordLevelDeltaEnabledEntityNames);

        checkValidTeacherSchoolAssociationNeutralRecord(neutralRecord);
    }

    private void checkValidTeacherSchoolAssociationNeutralRecord(NeutralRecord neutralRecord) {

        Assert.assertEquals("RecordType not teacherSchoolAssociation", "teacherSchoolAssociation",
                neutralRecord.getRecordType());
        Map<?, ?> localParentIds = neutralRecord.getLocalParentIds();
        Assert.assertNotNull("null localParentIds map", localParentIds);

        Assert.assertEquals("333333332", neutralRecord.getAttributes().get("teacherId"));

        @SuppressWarnings("unchecked")
        Map<String, Object> schoolRef = (Map<String, Object>) neutralRecord.getAttributes().get("SchoolReference");
        assertNotNull(schoolRef);
        @SuppressWarnings("unchecked")
        Map<String, Object> schoolEdOrgId = (Map<String, Object>) schoolRef.get("EducationalOrgIdentity");
        assertNotNull(schoolEdOrgId);
        assertEquals("123456111", schoolEdOrgId.get("StateOrganizationId"));

        Assert.assertEquals("Title I-Academic", neutralRecord.getAttributes().get("programAssignment"));

        List<?> gradeLevels = (List<?>) neutralRecord.getAttributes().get("instructionalGradeLevels");
        Assert.assertNotNull("Null gradelevel list", gradeLevels);
        // Assert.assertEquals("gradelevel list does not contain one element", 1,
        // gradelevels.size());
        Assert.assertEquals("Second grade", gradeLevels.get(0));
        if (gradeLevels.size() > 1) {
            // TODO: remove if block when we support csv lists
            Assert.assertEquals("Seventh grade", gradeLevels.get(1));
        }

        List<?> academicSubjectList = (List<?>) neutralRecord.getAttributes().get("academicSubjects");
        Assert.assertNotNull("Null academiSubject list", academicSubjectList);
        Assert.assertEquals("English", academicSubjectList.get(0));
        if (academicSubjectList.size() > 1) {
            // TODO: remove if block when we support csv lists
            Assert.assertEquals("Mathematics", academicSubjectList.get(1));
        }
    }
}
