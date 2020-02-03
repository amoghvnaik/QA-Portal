package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockQualifications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QualificationTest {

    private MockQualifications qualifications = new MockQualifications();

    @Test
    public void getQualificationFeedbackTest() {
        assertEquals("Feedback list incorrectly sized",
                3,
                qualifications.getQualifications1().get(0).getQualificationFeedback().size());
    }

    @Test
    public void getQualificationDetailsTest() {
        assertEquals("getQualificationDetails() returning unexpected value",
                "some qualification details",
                qualifications.getQualifications1().get(0).getQualificationDetails());
    }

    @Test
    public void toStringTest() {
        assertEquals("toString() returning an unexpected result",
                "Qualification [qualificationDetails=some qualification details, qualificationFeedback=" + qualifications.getQualifications1().get(0).getQualificationFeedback() + "]",
                qualifications.getQualifications1().get(0).toString());
    }

}
