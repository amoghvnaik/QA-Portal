package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockHobbies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HobbiesTest {

    private MockHobbies hobbies = new MockHobbies();


    @Test
    public void getHobbiesFeedbackTest() {
        assertEquals("Feedback list incorrectly sized",
                3,
                hobbies.getHobbies1().getHobbiesFeedback().size());
    }

    @Test
    public void getHobbiesDetailsTest() {
        assertEquals("getHobbiesDetails() returning unexpected result", "some details about hobbies", hobbies.getHobbies1().getHobbiesDetails());

    }



}
