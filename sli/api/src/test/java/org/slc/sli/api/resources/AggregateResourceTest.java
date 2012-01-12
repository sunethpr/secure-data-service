package org.slc.sli.api.resources;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.slc.sli.api.resources.util.ResourceConstants.ENTITY_TYPE_AGGREGATION;
import static org.slc.sli.api.resources.util.ResourceConstants.PATH_PARAM_DISTRICT;
import static org.slc.sli.api.resources.util.ResourceConstants.QUERY_PARAM_GRADE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.api.uri.UriBuilderImpl;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.slc.sli.api.resources.url.AggregateURLCreator;
import org.slc.sli.api.service.MockRepo;
import org.slc.sli.api.test.WebContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml" })
@TestExecutionListeners({ WebContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class })
public class AggregateResourceTest {
	private static final String PATH_VALUE = "1234";
	private static final String QUERY_VALUE = "5678";
	
	@Autowired
	AggregateResource aggApi; //class under test
	
	@Before
	public void setup() {
		AggregateURLCreator creator = new AggregateURLCreator();
		
		Map<String, Object> agg = buildTestAggregationEntity();
		
		MockRepo repo = new MockRepo();
		repo.create(ENTITY_TYPE_AGGREGATION, agg);
		creator.setRepo(repo);
				
		aggApi.setAggregateURLCreator(creator);
	}
	
	@Test
    public void testResourceMethods() throws Exception {
        UriInfo info = buildMockUriInfo(null);
        
        //test district based aggregates
        //test basic case
        Response response1 = aggApi.getDistrictBasedAggregates("12", "8", null, null, info);
        assertNotNull(response1);
        assertEquals(Status.OK.getStatusCode(), response1.getStatus());
        
        //test empty query param map
        Response response2 = aggApi.getDistrictBasedAggregates("12", null, null, null, info);
        assertNotNull(response2);
        assertEquals(Status.OK.getStatusCode(), response2.getStatus());

        //test school based aggregates
        //test basic case
        Response response3 = aggApi.getSchoolBasedAggregates("12", "8", null, null, info);
        assertNotNull(response3);
        assertEquals(Status.OK.getStatusCode(), response3.getStatus());
	}
	
	@Test
	public void testCombineParams() {
		Map<String, List<String>> pathParams = new HashMap<String, List<String>>();
		Map<String, List<String>> queryParams = new HashMap<String, List<String>>();
		
		List<String> pathValues = new ArrayList<String>();
		pathValues.add(PATH_VALUE);
		
		List<String> queryValues = new ArrayList<String>();
		queryValues.add(QUERY_VALUE);
		
		pathParams.put(PATH_PARAM_DISTRICT, pathValues);
		queryParams.put(QUERY_PARAM_GRADE, queryValues);
		 
		Map<String, String> params = aggApi.combineParameters(pathParams, queryParams);
		
		assertEquals("Should have 2 values", params.size(), 2);
		assertEquals("Distrct value should match", params.get(PATH_PARAM_DISTRICT), PATH_VALUE);
		assertEquals("Grade value should match", params.get(QUERY_PARAM_GRADE), QUERY_VALUE);
	}
	
	public UriInfo buildMockUriInfo(final String queryString) throws Exception {
        UriInfo mock = mock(UriInfo.class);
        when(mock.getAbsolutePathBuilder()).thenAnswer(new Answer<UriBuilder>() {
            
            @Override
            public UriBuilder answer(InvocationOnMock invocation) throws Throwable {
                return new UriBuilderImpl().path("absolute");
            }
        });
        when(mock.getBaseUriBuilder()).thenAnswer(new Answer<UriBuilder>() {
            
            @Override
            public UriBuilder answer(InvocationOnMock invocation) throws Throwable {
                return new UriBuilderImpl().path("base");
            }
        });
        when(mock.getRequestUriBuilder()).thenAnswer(new Answer<UriBuilder>() {
            
            @Override
            public UriBuilder answer(InvocationOnMock invocation) throws Throwable {
                return new UriBuilderImpl().path("request");
            }
        });
        
        //when(mock.getRequestUri()).thenReturn(new UriBuilderImpl().replaceQuery(queryString).build(null));
        return mock;
    }
	
	private Map<String, Object> buildTestAggregationEntity() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("entityId", "9876543");
        body.put("educationOrganization", "12");
        body.put("grade", "8");
        body.put("subject", "Math");
        body.put("aggregate", "1234");
        return body;
    }
}
