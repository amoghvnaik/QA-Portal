package com.qa.portal.cv.smoke.util.pdf;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.portal.cv.util.pdf.CvPdfGeneratorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvPdfGeneratorImplSmokeTest {

    @Autowired
    public CvPdfGeneratorImpl cvPdfGenerator;

    @Test
    public void portalApplicationApiApplicationSmokeTest() {
        assertThat(this.cvPdfGenerator).isNotNull();
    }

}