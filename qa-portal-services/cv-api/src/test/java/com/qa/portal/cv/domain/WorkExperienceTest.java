package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockAllWorkExperience;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkExperienceTest {

    @InjectMocks
    public MockAllWorkExperience work = new MockAllWorkExperience();

    @Test
    public void getWorkExperienceFeedbackTest() {
        assertEquals("getWorkExperienceFeedback() returning incorrect feedback", 3, work.getWork1().get(0).getWorkExperienceFeedback().size());
    }
}
