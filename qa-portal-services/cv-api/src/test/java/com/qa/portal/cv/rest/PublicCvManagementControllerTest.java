package com.qa.portal.cv.rest;

import com.qa.portal.cv.domain.CvVersion;
import com.qa.portal.cv.services.CvManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicCvManagementControllerTest {

    private CvVersion cv1 = new CvVersion();

    @InjectMocks
    public PublicCvManagementController publicCvManagementController;

    @Mock
    public CvManagementService cvManagementService;

    @Test
    public void getCvAsPdfPublicTest() throws IOException {
        byte[] bytes = {0, 1};
        Mockito.when(this.cvManagementService.getGeneratedCv(ArgumentMatchers.any(CvVersion.class))).thenReturn(bytes);
        assertEquals(bytes, this.publicCvManagementController.getCvAsPdfPublic(cv1).getBody());
        assertEquals(200, this.publicCvManagementController.getCvAsPdfPublic(cv1).getStatusCodeValue());
    }




}
