package com.qa.portal.cv.rest;

import com.qa.portal.common.security.QaSecurityContext;
import com.qa.portal.cv.domain.CvSearchCriteria;
import com.qa.portal.cv.domain.CvVersion;
import com.qa.portal.cv.mocks.MockCvs;
import com.qa.portal.cv.services.CvManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CvManagementControllerTest {

    private MockCvs mockCvs = new MockCvs();

    @InjectMocks
    public CvManagementController cvManagementController;

    @Mock
    public CvManagementService cvManagementService;

    @Mock
    public QaSecurityContext qaSecurityContext;


    @Test
    public void createCvTest() {
        Mockito.when(this.cvManagementService.createCv(mockCvs.getCv1(), qaSecurityContext)).thenReturn(mockCvs.getCv1());
        assertEquals(this.cvManagementController.createCv(mockCvs.getCv1()).getBody(), mockCvs.getCv1());
        assertEquals(200, this.cvManagementController.createCv(mockCvs.getCv1()).getStatusCodeValue());
    }

    @Test
    public void updateCvTest() {
        Mockito.when(this.cvManagementService.updateCv(mockCvs.getCv1())).thenReturn(mockCvs.getCv1());
        assertEquals(this.cvManagementController.updateCv(mockCvs.getCv1()).getBody(), mockCvs.getCv1());
        assertEquals(200, this.cvManagementController.updateCv(mockCvs.getCv1()).getStatusCodeValue());
    }

    @Test
    public void getCvByIdTest() {
        Mockito.when(this.cvManagementService.findById("1234567890")).thenReturn(mockCvs.getCv1());
        assertEquals(this.cvManagementController.getCvById("1234567890").getBody(), mockCvs.getCv1());
        assertEquals(200, this.cvManagementController.getCvById("1234567890").getStatusCodeValue());
    }

    @Test
    public void getAllTest() {
        Mockito.when(this.cvManagementService.getAll()).thenReturn(mockCvs.getCvs());
        assertEquals(this.cvManagementController.getAll().getBody(), mockCvs.getCvs());
        assertEquals(200, this.cvManagementController.getAll().getStatusCodeValue());
    }

    @Test
    public void findByFullNameIgnoreCaseTest() {
        List<CvVersion> matches = new ArrayList<>();
        matches.add(mockCvs.getCv1());
        Mockito.when(this.cvManagementService.findByFullNameIgnoreCase("Steve Roddy"))
                .thenReturn(matches);
        assertTrue(Objects.requireNonNull(this.cvManagementController.findByFullNameIgnoreCase("Steve Roddy").getBody()).contains(mockCvs.getCv1()));
        assertEquals(200, this.cvManagementController.findByFullNameIgnoreCase("Steve Roddy").getStatusCodeValue());
    }

    @Test
    public void findCvVersionsForTraineeTest() {
        Mockito.when(this.cvManagementService.findByUserNameIgnoreCase(null))
                .thenReturn(mockCvs.getCvs());
        assertTrue(Objects.requireNonNull(this.cvManagementController.findCvVersionsForTrainee().getBody()).contains(mockCvs.getCv1()));
        assertEquals(200, this.cvManagementController.findCvVersionsForTrainee().getStatusCodeValue());
    }

    @Test
    public void findCurrentCvVersionForTraineeTest() {
        Mockito.when(this.cvManagementService.getCurrentCvVersionForUser(ArgumentMatchers.any()))
                .thenReturn(mockCvs.getCv1());
        assertEquals(this.cvManagementController.findCurrentCvVersionForTrainee().getBody(), mockCvs.getCv1());
        assertEquals(200, this.cvManagementController.findCurrentCvVersionForTrainee().getStatusCodeValue());
    }

    @Test
    public void cvSearchTest() {
        Mockito.when(this.cvManagementService.cvSearch("cohort", "tech", "status", "Steve Roddy")).thenReturn(mockCvs.getCvs());
        assertEquals(mockCvs.getCvs(), this.cvManagementController.cvSearch("cohort", "tech", "status", "Steve Roddy").getBody());
    }

}
