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

import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.rest.ProjectPageController;
import com.qa.portal.application.service.page.ProjectPageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPageControllerUnitTest {

	@InjectMocks
	ProjectPageController  projectPageControllerUnit;
	
	@Mock
	ProjectPageService projectPageService;
	
	@Test
	public void getAllProjectPagesTest() {
		
		ProjectPageDto projectPageDto = new ProjectPageDto();
		List<ProjectPageDto> list = new ArrayList<ProjectPageDto>();
		list.add(projectPageDto);
		
		Mockito.when(this.projectPageService.getAllProjectPages()).thenReturn(list);
		
		assertThat(this.projectPageControllerUnit.getAllProjectPages().getBody()).isEqualTo(list);
		assertThat(this.projectPageControllerUnit.getAllProjectPages().getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void getProjectPageForIdTest() {
		
		ProjectPageDto projectPageDto = new ProjectPageDto();
		
		Mockito.when(this.projectPageService.getProjectPageForId(111)).thenReturn(projectPageDto);
		
		assertThat(this.projectPageControllerUnit.getProjectPageForId(111).getBody()).isEqualTo(projectPageDto);
		assertThat(this.projectPageControllerUnit.getProjectPageForId(111).getStatusCodeValue()).isEqualTo(200);
	}
}
