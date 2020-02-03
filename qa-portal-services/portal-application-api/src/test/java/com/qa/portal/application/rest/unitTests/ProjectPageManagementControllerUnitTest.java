package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.rest.ProjectPageManagementController;
import com.qa.portal.application.service.page.ProjectPageManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPageManagementControllerUnitTest {
	
	@InjectMocks
	ProjectPageManagementController projectPageManagementController;
	
	@Mock
	ProjectPageManagementService projectPageManagementService;

	@Test
	public void createProjectPageTest() {
		
		ProjectPageDto projectPageDto = new ProjectPageDto();
		
		Mockito.when(this.projectPageManagementService.createProjectPage(projectPageDto)).thenReturn(projectPageDto);
		
		assertThat(this.projectPageManagementController.createProjectPage(projectPageDto).getBody()).isEqualTo(projectPageDto);
		assertThat(this.projectPageManagementController.createProjectPage(projectPageDto).getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void updateProjectPageTest() {
		
		ProjectPageDto projectPageDto = new ProjectPageDto();
		
		Mockito.when(this.projectPageManagementService.updateProjectPage(projectPageDto)).thenReturn(projectPageDto);
		
		assertThat(this.projectPageManagementController.updateProjectPage(projectPageDto).getBody()).isEqualTo(projectPageDto);
	}







}

