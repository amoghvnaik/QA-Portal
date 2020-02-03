package com.qa.portal.cv.smoke.services;

import static org.assertj.core.api.Assertions.assertThat;


import com.qa.portal.cv.services.GetCvVersionsOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetCvVersionsOperationSmokeTest {

    @Autowired
    public GetCvVersionsOperation getCvVersionsOperation;

    @Test
    public void portalApplicationApiApplicationSmokeTest() {
        assertThat(this.getCvVersionsOperation).isNotNull();
    }

}