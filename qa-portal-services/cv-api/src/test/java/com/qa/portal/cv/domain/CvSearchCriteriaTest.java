package com.qa.portal.cv.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvSearchCriteriaTest {

    @InjectMocks
    public CvSearchCriteria cvSearchCriteria;

    @Before
    public void setVariables() {
        cvSearchCriteria.setFullName("Steve Roddy");
        cvSearchCriteria.setCohort("October");
        cvSearchCriteria.setCvStatus("Completed");
        cvSearchCriteria.setTechnology("AWS");
    }

    @Test
    public void toStringTest() {
        assertEquals("toString() is returning an unexpected result",
                "CvSearchCriteria{cvStatus='Completed', " +
                        "fullName='Steve Roddy', " +
                        "cohort='October', " +
                        "technology='AWS'}",
                cvSearchCriteria.toString());
    }

    @Test
    public void getCvStatusTest() {
        assertEquals("getCvStatus() returning incorrect value", "Completed", cvSearchCriteria.getCvStatus());
    }

    @Test
    public void getFullNameTest() {
        assertEquals("getFullName() returning incorrect value", "Steve Roddy", cvSearchCriteria.getFullName());
    }

    @Test
    public void getCohortTest() {
        assertEquals("getCohort() returning incorrect value", "October", cvSearchCriteria.getCohort());
    }

    @Test
    public void getTechnologyTest() {
        assertEquals("getTechnology() returning incorrect value", "AWS", cvSearchCriteria.getTechnology());
    }

}
