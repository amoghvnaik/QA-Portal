package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockCvs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvVersionTest {

    private MockCvs cvs = new MockCvs();

    @Test
    public void getIdTest() {
        assertEquals("getId() returning unexpected", "1234567890", cvs.getCv1().getId());
    }

    @Test
    public void getStatusTest() {
        assertEquals("getStatus() returning unexpected", "updated", cvs.getCv1().getStatus());
    }

    @Test
    public void getCohortTest() {
        assertEquals("getCohort() returning unexpected", "October", cvs.getCv1().getCohort());
    }

    @Test
    public void getSourceControlLinkTest() {
        assertEquals("getSourceControlLink() returning unexpected", "source control link", cvs.getCv1().getSourceControlLink());
    }
}