package com.qa.portal.cv.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.portal.CvApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvSmokeTest {

    @Autowired
    public CvApiApplication cvApiApplication;

    @Test
    public void portalApplicationApiApplicationSmokeTest() {
        assertThat(this.cvApiApplication).isNotNull();
    }

}