package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.Feedback;

import java.util.ArrayList;
import java.util.List;

public class MockFeedback {
    private List<Feedback> feedbackList = new ArrayList<>();

    public MockFeedback() {
        Feedback f1 = new Feedback();
        f1.setReviewer("Dan Ryan");
        f1.setDate("2019-11-12");
        f1.setComment("feedback 1");

        Feedback f2 = new Feedback();
        f2.setReviewer("Steve Roddy");
        f2.setDate("1972-06-30");
        f2.setComment("feedback 2");

        Feedback f3 = new Feedback();
        f3.setReviewer("Tom Bennett");
        f3.setDate("2011-06-31");
        f3.setComment("feedback 3");

        feedbackList.add(f1);
        feedbackList.add(f2);
        feedbackList.add(f3);
    }


    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}