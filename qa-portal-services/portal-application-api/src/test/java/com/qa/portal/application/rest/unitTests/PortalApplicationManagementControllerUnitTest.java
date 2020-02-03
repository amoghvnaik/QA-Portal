package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.ApplicationProjectsDto;
import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.rest.PortalApplicationManagementController;
import com.qa.portal.application.service.PortalApplicationManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationManagementControllerUnitTest {
	
	@InjectMocks
	PortalApplicationManagementController portalApplicationManagementController;

	@Mock
	PortalApplicationManagementService portalApplicationManagementService;
	
	@Test
	public void getAllPortalApplicationsTest() {
		
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setBaseUrl("");
		portalApplicationDto.setDescription("");
		portalApplicationDto.setDisplayOrder(1);
		portalApplicationDto.setId(1);
		portalApplicationDto.setName("");
		List<PortalApplicationDto> list = new ArrayList<PortalApplicationDto>();
		list.add(portalApplicationDto);				
		
		Mockito.when(this.portalApplicationManagementService.getAllPortalApplications()).thenReturn(list);
		
		assertThat(this.portalApplicationManagementController.getAllPortalApplications().getBody()).isEqualTo(list);
		assertThat(this.portalApplicationManagementController.getAllPortalApplications().getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void getPortalApplicationByIdTest() {
					
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		Set<PortalProjectDto> list = new HashSet<PortalProjectDto>();
		list.add(portalProjectDto);
		ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(portalApplicationDto, list);
		
		Mockito.when(this.portalApplicationManagementService.getPortalApplicationById(123)).thenReturn(applicationProjectsDto);
		
		assertThat(this.portalApplicationManagementController.getPortalApplicationById(123).getBody()).isEqualTo(applicationProjectsDto);
		assertThat(this.portalApplicationManagementController.getPortalApplicationById(123).getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void createPortalApplicationTest() {

		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		
		
		Mockito.when(this.portalApplicationManagementService.createPortalApplication(portalApplicationDto)).thenReturn(portalApplicationDto);
		
		assertThat(this.portalApplicationManagementController.createPortalApplication(portalApplicationDto).getBody()).isEqualTo(portalApplicationDto);
		assertThat(this.portalApplicationManagementController.createPortalApplication(portalApplicationDto).getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void updatePortalApplicationTest() {
		
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		
		Mockito.when(this.portalApplicationManagementService.updatePortalApplication(portalApplicationDto)).thenReturn(portalApplicationDto);
		
		assertThat(this.portalApplicationManagementController.updatePortalApplication(portalApplicationDto).getBody()).isEqualTo(portalApplicationDto);
		assertThat(this.portalApplicationManagementController.updatePortalApplication(portalApplicationDto).getStatusCodeValue()).isEqualTo(200);
	}
}









