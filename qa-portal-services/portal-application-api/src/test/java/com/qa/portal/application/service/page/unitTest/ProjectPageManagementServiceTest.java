package com.qa.portal.application.service.page.unitTest;

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
import com.qa.portal.application.service.page.CreateProjectPageOperation;
import com.qa.portal.application.service.page.ProjectPageManagementService;
import com.qa.portal.application.service.page.UpdateProjectPageOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPageManagementServiceTest {
	
	@InjectMocks
	public ProjectPageManagementService projectPageManagementService;
	
	@Mock
	public CreateProjectPageOperation createProjectPageOperation;
	
	@Mock
	public UpdateProjectPageOperation updateProjectPageOperation;
	
	@Test
	public void createProjectPageTest() {
		ProjectPageDto pageDto = new ProjectPageDto();
		pageDto.setDisplayOnMenu(true);
		pageDto.setIcon("icon");
		pageDto.setId(1);
		pageDto.setLevel(1);
		pageDto.setName("pname");
		pageDto.setPortalProjectName("p-p-name");
		List<String> dummyData = new ArrayList<String>();
		dummyData.add("a");
		dummyData.add("b");
		dummyData.add("c");
		pageDto.setRoles(dummyData);
		pageDto.setTooltip("tooltip");
		pageDto.setUrl("www.test.co.uk");
		
		Mockito.when(createProjectPageOperation.createProjectPage(pageDto)).thenReturn(pageDto);
		assertThat(this.projectPageManagementService.createProjectPage(pageDto).getName()).isEqualTo(pageDto.getName());
		
	}
	
	@Test
	public void updateProjectPageTest() {
		ProjectPageDto pageDto = new ProjectPageDto();
		pageDto.setDisplayOnMenu(true);
		pageDto.setIcon("icon");
		pageDto.setId(1);
		pageDto.setLevel(1);
		pageDto.setName("pname");
		pageDto.setPortalProjectName("p-p-name");
		List<String> dummyData = new ArrayList<String>();
		dummyData.add("a");
		dummyData.add("b");
		dummyData.add("c");
		pageDto.setRoles(dummyData);
		pageDto.setTooltip("tooltip");
		pageDto.setUrl("www.test.co.uk");
		
		Mockito.when(updateProjectPageOperation.updateProjectPage(pageDto)).thenReturn(pageDto);
		assertThat(this.projectPageManagementService.updateProjectPage(pageDto).getName()).isEqualTo(pageDto.getName());
	} 

}
