package com.qa.portal.application.service.page.unitTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.persistence.repository.ProjectPageRepository;
import com.qa.portal.application.service.page.ProjectPageService;
import com.qa.portal.application.service.page.mapper.ProjectPageMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPageServiceTest {

	@InjectMocks
	public ProjectPageService projectPageService;

	@Mock
	public ProjectPageRepository projectPageRepository;

	@Mock
	public ProjectPageMapper projectPageMapper;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void getAllProjectPagesTest() {
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

		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity2); 
		portalProjectEntity.setProjectPages(projectPageEntityList);

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();

		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1); 
		projectPageEntity.setName("pename");
		projectPageEntity.setUrl("www.url.com");
		projectPageEntity.setTooltip("tooltip two");
		projectPageEntity.setIcon("icons");
		projectPageEntity.setPortalProject(portalProjectEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
		projectPageEntity.setDisplayOnMenu(true);

		List<ProjectPageDto> projectPageList = new ArrayList<ProjectPageDto>();
		projectPageList.add(pageDto);

		Mockito.when(projectPageRepository.findAll()).thenReturn(projectPageEntityList);
		Mockito.when(projectPageMapper.mapToProjectPageDto(projectPageEntity2)).thenReturn(pageDto);
		assertThat(projectPageService.getAllProjectPages()).isEqualTo(projectPageList);
	}

	@Test
	public void getProjectPageIdWhenExistsTest() {
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

		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity2);
		portalProjectEntity.setProjectPages(projectPageEntityList);

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();

		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1);
		projectPageEntity.setName("pename");
		projectPageEntity.setUrl("www.url.com");
		projectPageEntity.setTooltip("tooltip two");
		projectPageEntity.setIcon("icons");
		projectPageEntity.setPortalProject(portalProjectEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
		projectPageEntity.setDisplayOnMenu(true);

		Optional<ProjectPageEntity> optionalProjectPageEntity = Optional.of(projectPageEntity);

		Mockito.when(projectPageRepository.findById(pageDto.getId())).thenReturn(optionalProjectPageEntity);
		Mockito.when(projectPageMapper.mapToProjectPageDto(projectPageEntity)).thenReturn(pageDto);
		assertThat(projectPageService.getProjectPageForId(pageDto.getId())).isEqualTo(pageDto);
	}

	@Test
	public void getProjectPageIdWhenDoesNotExistTest() {
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

		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity2);
		portalProjectEntity.setProjectPages(projectPageEntityList);

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();

		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1);
		projectPageEntity.setName("pename");
		projectPageEntity.setUrl("www.url.com");
		projectPageEntity.setTooltip("tooltip two");
		projectPageEntity.setIcon("icons");
		projectPageEntity.setPortalProject(portalProjectEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
		projectPageEntity.setDisplayOnMenu(true);

		Optional<ProjectPageEntity> optionalProjectPageEntity = Optional.of(projectPageEntity);

		Mockito.when(projectPageRepository.findById(pageDto.getId())).thenReturn(optionalProjectPageEntity);
		Mockito.when(projectPageMapper.mapToProjectPageDto(projectPageEntity)).thenReturn(pageDto);
		thrown.expectMessage(containsString("No Project Page found for supplied id"));
		assertThat(projectPageService.getProjectPageForId(2)).isEqualTo(pageDto);
	}

}
