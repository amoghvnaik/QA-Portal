package com.qa.portal.cv.smoke.rest;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.portal.cv.rest.CvManagementController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvManagementControllerSmokeTest {

    @Autowired
    public CvManagementController cvManagementController;

    @Test
    public void portalApplicationApiApplicationSmokeTest() {
        assertThat(this.cvManagementController).isNotNull();
    }

}