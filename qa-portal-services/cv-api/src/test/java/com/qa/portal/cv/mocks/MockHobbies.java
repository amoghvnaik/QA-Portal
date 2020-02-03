package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.Hobbies;

public class MockHobbies {

    private Hobbies hobbies1 = new Hobbies();

    private Hobbies hobbies2 = new Hobbies();

    private MockFeedback mockFeedback = new MockFeedback();


    public MockHobbies() {
        hobbies1.setHobbiesDetails("some details about hobbies");
        hobbies1.setHobbiesFeedback(mockFeedback.getFeedbackList());


        hobbies2.setHobbiesDetails(setLimitExceedingHobbies());
    }

    private String setLimitExceedingHobbies() {
        StringBuilder details = new StringBuilder("a");
        while (details.length() < 1000000) {
            details.append("a");
        }
        return details.toString();
    }

    public Hobbies getHobbies1() {
        return hobbies1;
    }

    public Hobbies getHobbies2() {
        return hobbies2;
    }
}
