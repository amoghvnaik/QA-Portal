package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.rest.PortalProjectController;
import com.qa.portal.application.service.project.PortalProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProjectControlerUnitTest {

	@InjectMocks
	PortalProjectController portalProjectController;
	
	@Mock
	PortalProjectService portalProjectService;
	
	@Test
	public void getPortalProjectsTest() {
		
		List<PortalProjectDto> list = new ArrayList<PortalProjectDto>();
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		list.add(portalProjectDto);
		
		Mockito.when(this.portalProjectService.getPortalProjects()).thenReturn(list);
		
		assertThat(this.portalProjectController.getPortalProjects().getBody()).isEqualTo(list);
		assertThat(this.portalProjectController.getPortalProjects().getStatusCodeValue()).isEqualTo(200);
	}
	
	
	@Test
	public void getPortalProjectTest() {
		
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		
		Mockito.when(this.portalProjectService.getPortalProject(111)).thenReturn(portalProjectDto);
		
		assertThat(this.portalProjectController.getPortalProject(111).getBody()).isEqualTo(portalProjectDto);
		assertThat(this.portalProjectController.getPortalProject(111).getStatusCodeValue()).isEqualTo(200);
	}
	
}
