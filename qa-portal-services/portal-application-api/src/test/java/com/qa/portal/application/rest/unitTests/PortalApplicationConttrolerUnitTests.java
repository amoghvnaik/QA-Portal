package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
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
import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.rest.PortalApplicationController;
import com.qa.portal.application.service.PortalApplicationService;
import com.qa.portal.common.security.QaSecurityContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationConttrolerUnitTests {
	
	@InjectMocks
	public PortalApplicationController portalApplicationController;
	
	
	@Mock
	public PortalApplicationService portalApplicationService;
	
	@Mock
	public QaSecurityContext qaSecurityContext;
	
	@Test
	public void getPortalApplicationsUnitTest() {
		List<String> rolesDummyData = new ArrayList<String>();
		rolesDummyData.add("a");
		rolesDummyData.add("b");
		rolesDummyData.add("c");
		ProjectPageDto projectPageDto1 = new ProjectPageDto();
		projectPageDto1.setDisplayOnMenu(true);
		projectPageDto1.setIcon("a");
		projectPageDto1.setId(1);
		projectPageDto1.setLevel(1);
		projectPageDto1.setName("a");
		projectPageDto1.setPortalProjectName("a");
		projectPageDto1.setTooltip("a");
		projectPageDto1.setUrl("a");
		projectPageDto1.setRoles(rolesDummyData);
		List<ProjectPageDto> listInputTestProjectData = new ArrayList<ProjectPageDto>();
		listInputTestProjectData.add(projectPageDto1);
		PortalApplicationDto testPortalApplication = new PortalApplicationDto();
		testPortalApplication.setBaseUrl("a");
		testPortalApplication.setDescription("a");
		testPortalApplication.setDisplayOrder(1);
		testPortalApplication.setId(1234);
		testPortalApplication.setName("a");
		PortalProjectDto testPortalProjectDto1 = new PortalProjectDto();
		testPortalProjectDto1.setId(1111);
		testPortalProjectDto1.setName("a");
		testPortalProjectDto1.setProjectPages(listInputTestProjectData);
		testPortalProjectDto1.setUrl("a");
		PortalProjectDto testPortalProjectDto2 = new PortalProjectDto();
		testPortalProjectDto2.setId(3333);
		testPortalProjectDto2.setName("a");
		testPortalProjectDto2.setProjectPages(listInputTestProjectData);
		testPortalProjectDto2.setUrl("a");		 
		Set<PortalProjectDto> PortalProjectDtoSet = new HashSet<PortalProjectDto>();
		PortalProjectDtoSet.add(testPortalProjectDto1);
		PortalProjectDtoSet.add(testPortalProjectDto2);		
		ApplicationProjectsDto testApplicationProjectsDto1 = new ApplicationProjectsDto(testPortalApplication, PortalProjectDtoSet);
		ApplicationProjectsDto testApplicationProjectsDto2 = new ApplicationProjectsDto(testPortalApplication, PortalProjectDtoSet);
		List<ApplicationProjectsDto> testResult = new ArrayList<ApplicationProjectsDto>();
		testResult.add(testApplicationProjectsDto1);
		testResult.add(testApplicationProjectsDto2);
		Set<String> colectionInput = new HashSet<String>();
		colectionInput.add("a");
		colectionInput.add("b");
		colectionInput.add("c");
		
		Mockito.when(this.qaSecurityContext.getRoles()).thenReturn(colectionInput);
		Mockito.when(this.portalApplicationService.getPortalApplications(colectionInput)).thenReturn(testResult);
		
		assertThat(this.portalApplicationController.getPortalApplications().getBody()).isEqualTo(testResult);
		assertThat(this.portalApplicationController.getPortalApplications().getStatusCodeValue()).isEqualTo(200);
	}

}
