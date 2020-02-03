package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.rest.PortalProjectManagementController;
import com.qa.portal.application.service.project.PortalProjectManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProjectManagementControllerUnitTest {
	
	@InjectMocks
	PortalProjectManagementController portalProjectManagementController;
	
	@Mock
	PortalProjectManagementService portalProjectManagementService;

	@Test
	public void createPortalProjectTest() {
		
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		
		Mockito.when(this.portalProjectManagementService.createPortalProject(portalProjectDto)).thenReturn(portalProjectDto);
		
		assertThat(this.portalProjectManagementController.createPortalProject(portalProjectDto).getBody()).isEqualTo(portalProjectDto);
		assertThat(this.portalProjectManagementController.createPortalProject(portalProjectDto).getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void updatePortalProjectTest() {
		
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		
		Mockito.when(this.portalProjectManagementService.updatePortalProject(portalProjectDto)).thenReturn(portalProjectDto);
		
		assertThat(this.portalProjectManagementController.updatePortalProject(portalProjectDto).getBody()).isEqualTo(portalProjectDto);
		assertThat(this.portalProjectManagementController.updatePortalProject(portalProjectDto).getStatusCodeValue()).isEqualTo(200);
	}
}
