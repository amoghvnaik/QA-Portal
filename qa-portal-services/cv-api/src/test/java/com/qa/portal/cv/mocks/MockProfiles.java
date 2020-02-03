package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.Profile;

public class MockProfiles {

    private Profile profile1 = new Profile();

    private Profile profile2 = new Profile();

    private MockFeedback feedback = new MockFeedback();

    public MockProfiles() {
        profile1.setProfileDetails("some details about profile");
        profile1.setProfileFeedback(feedback.getFeedbackList());

        profile2.setProfileDetails(setLimitExceedingProfile());
        profile2.setProfileFeedback(feedback.getFeedbackList());
    }

    private String setLimitExceedingProfile() {
        StringBuilder details = new StringBuilder("a");
        while (details.length() < 1000000) {
            details.append("a");
        }
        return details.toString();
    }

    public Profile getProfile1() {
        return profile1;
    }

    public Profile getProfile2() {
        return profile2;
    }
}
