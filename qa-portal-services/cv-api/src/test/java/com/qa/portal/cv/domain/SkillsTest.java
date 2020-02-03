package com.qa.portal.cv.domain;

import com.qa.portal.cv.mocks.MockSkills;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillsTest {


    private MockSkills skills = new MockSkills();

    @Test
    public void getProgrammingLanguagesTest() {
        assertEquals("getProgrammingLanguages() returning an unexpected value",
                Arrays.asList("Java", "Go", "Python"),
                skills.getSkills1().getProgrammingLanguages());
        assertEquals("Programming language list incorrectly sized",
                3,
                skills.getSkills1().getProgrammingLanguages().size());
    }

    @Test
    public void getIdesTest() {
        assertEquals("getIdes() returning an unexpected value",
                Arrays.asList("IntelliJ", "VS Code"),
                skills.getSkills1().getIdes());
        assertEquals("IDE list incorrectly sized",
                2,
                skills.getSkills1().getIdes().size());
    }

    @Test
    public void getOperatingSystemsTest() {
        assertEquals("getOperatingSystems() returning an unexpected value",
                Arrays.asList("Ubuntu", "Debian", "Windows 10"),
                skills.getSkills1().getOperatingSystems());
        assertEquals("OS list incorrectly sized",
                3,
                skills.getSkills1().getOperatingSystems().size());
    }

    @Test
    public void getDevopsTest() {
        assertEquals("getDevops() returning an unexpected value",
                Arrays.asList("Docker", "Maven", "Git"),
                skills.getSkills1().getDevops());
        assertEquals("DevOps list incorrectly sized",
                3,
                skills.getSkills1().getDevops().size());
    }

    @Test
    public void getDatabasesTest() {
        assertEquals("getDatabases returning an unexpected value",
                Arrays.asList("MySQL", "SQLite", "Redis", "PostgreSQL"),
                skills.getSkills1().getDatabases());
        assertEquals("Databases list incorrectly sized",
                4,
                skills.getSkills1().getDatabases().size());
    }

    @Test
    public void getPlatformsTest() {
        assertEquals("getPlatforms() returning an unexpected value",
                Arrays.asList("Windows", "Mac", "Android"),
                skills.getSkills1().getPlatforms());
        assertEquals("Platforms list incorrectly sized",
                3,
                skills.getSkills1().getPlatforms().size());
    }

    @Test
    public void getOtherTest() {
        assertEquals("getOther() returning an unexpected value",
                Arrays.asList("Photoshop", "Vegas Pro"),
                skills.getSkills1().getOther());
        assertEquals("Other list incorrectly sized",
                2,
                skills.getSkills1().getOther().size());
    }

}
