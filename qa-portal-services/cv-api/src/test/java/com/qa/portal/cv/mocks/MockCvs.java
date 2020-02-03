package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.CvVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockCvs {
    private CvVersion cv1 = new CvVersion();

    private CvVersion cv2 = new CvVersion();

    private List<CvVersion> cvs = new ArrayList<>();
    public MockCvs() {
        MockProfiles profiles = new MockProfiles();
        MockSkills skills = new MockSkills();
        MockQualifications qualifications = new MockQualifications();
        MockAllWorkExperience work = new MockAllWorkExperience();
        MockHobbies hobbies = new MockHobbies();

        // This CV should pass the validator
        cv1.setId("1234567890");
        cv1.setVersionNumber(1);
        cv1.setStatus("updated");
        cv1.setUserName("steverodriguez123");
        cv1.setFirstName("Steve");
        cv1.setSurname("Roddy");
        cv1.setFullName("Steve Roddy");
        cv1.setCohort("October");
        cv1.setProfile(profiles.getProfile1());
        cv1.setAllSkills(Arrays.asList(skills.getSkills1()));
        cv1.setAllQualifications(qualifications.getQualifications1());
        cv1.setAllWorkExperience(work.getWork1());
        cv1.setOtherWorkExperience(work.getWork1());
        cv1.setHobbies(hobbies.getHobbies1());
        cv1.setSourceControlLink("source control link");


        // This CV should fail the validator
        cv2.setId("0987654321");
        cv2.setVersionNumber(3);
        cv2.setStatus("completed");
        cv2.setUserName("smith_john");
        cv2.setFirstName("John");
        cv2.setSurname("Smith");
        cv2.setFullName("John Smith");
        cv2.setCohort("September");
        cv2.setProfile(profiles.getProfile2());
        cv2.setAllQualifications(qualifications.getQualifications2());
        cv2.setAllWorkExperience(work.getWork2());
        cv2.setOtherWorkExperience(work.getWork2());
        cv2.setHobbies(hobbies.getHobbies2());
        cv2.setSourceControlLink("source control link");

        cvs.add(cv1);
        cvs.add(cv2);
    }

    public CvVersion getCv1() {
        return cv1;
    }

    public CvVersion getCv2() {
        return cv2;
    }

    public List<CvVersion> getCvs() {
        return cvs;
    }
}
