package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockProfiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileTest {

    private MockProfiles profiles = new MockProfiles();

    @Test
    public void getProfileDetailsTest() {
        assertEquals("getProfileDetails() returning an unexpected result",
                "some details about profile",
                profiles.getProfile1().getProfileDetails());
    }

    @Test
    public void getProfileFeedbackTest() {
        assertEquals("Feedback list incorrectly sized",
                3,
                profiles.getProfile1().getProfileFeedback().size());
    }

    @Test
    public void toStringTest() {
        assertEquals("toString() is returning an unexpected result",
                "Profile [profileDetails=some details about profile, profileFeedback={Feedback [reviewer=Dan Ryan, date=2019-11-12, comment=feedback 1],Feedback [reviewer=Steve Roddy, date=1972-06-30, comment=feedback 2],Feedback [reviewer=Tom Bennett, date=2011-06-31, comment=feedback 3]}]",
                profiles.getProfile1().toString());
    }


}
