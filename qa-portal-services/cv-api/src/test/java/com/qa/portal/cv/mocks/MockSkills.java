package com.qa.portal.cv.mocks;

import com.qa.portal.cv.domain.Skills;

import java.util.Arrays;

public class MockSkills {

    private Skills skills1 = new Skills();

    private Skills skills2 = new Skills();

    public MockSkills() {
        skills1.setProgrammingLanguages(Arrays.asList("Java", "Go", "Python"));
        skills1.setIdes(Arrays.asList("IntelliJ", "VS Code"));
        skills1.setOperatingSystems(Arrays.asList("Ubuntu", "Debian", "Windows 10"));
        skills1.setDevops(Arrays.asList("Docker", "Maven", "Git"));
        skills1.setDatabases(Arrays.asList("MySQL", "SQLite", "Redis", "PostgreSQL"));
        skills1.setPlatforms(Arrays.asList("Windows", "Mac", "Android"));
        skills1.setOther(Arrays.asList("Photoshop", "Vegas Pro"));

        skills2.setProgrammingLanguages(Arrays.asList("JavaScript", "PHP", "Ruby"));
        skills2.setIdes(Arrays.asList("Eclipse", "Anaconda", "MatLab"));
        skills2.setOperatingSystems(Arrays.asList("Windows", "MacOS"));
        skills2.setDevops(Arrays.asList("Docker", "Git"));
        skills2.setDatabases(Arrays.asList("h2", "SQL"));
        skills2.setPlatforms(Arrays.asList("Windows"));
        skills2.setOther(Arrays.asList("Ableton"));


    }

    public Skills getSkills1() {
        return skills1;
    }

    public Skills getSkills2() {
        return skills2;
    }
}
