package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.Qualification;

import java.util.ArrayList;
import java.util.List;

public class MockQualifications {

    private List<Qualification> qualifications1 = new ArrayList<>();

    private List<Qualification> qualifications2 = new ArrayList<>();

    public MockQualifications() {
        MockFeedback mockFeedback = new MockFeedback();

        Qualification q1 = new Qualification();
        q1.setQualificationDetails("some qualification details");
        q1.setQualificationFeedback(mockFeedback.getFeedbackList());
        qualifications1.add(q1);

        Qualification q2 = new Qualification();
        q2.setQualificationDetails("some qualification details");
        q2.setQualificationFeedback(mockFeedback.getFeedbackList());
        qualifications1.add(q2);


        Qualification q3 = new Qualification();
        q3.setQualificationDetails("English 2:2 at University of Sheffield");
        q3.setQualificationFeedback(mockFeedback.getFeedbackList());
        qualifications2.add(q3);
    }

    public List<Qualification> getQualifications1() {
        return qualifications1;
    }

    public List<Qualification> getQualifications2() {
        return qualifications2;
    }
}
