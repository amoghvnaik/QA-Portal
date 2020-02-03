package com.qa.portal.application.service.page.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

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


import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.persistence.repository.ProjectPageRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.page.mapper.ProjectPageMapper;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectPageMapperTest {

	@InjectMocks
	public ProjectPageMapper projectPageMapper;

	@Mock
	public ProjectPageRepository projectPageRepository;
	
	@Mock
	public RoleRepository roleRepository;

	@Mock
	public BaseMapper baseMapper;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void mapToProjectPageTest() {
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
		List<ProjectPageEntity> projectPageList = new ArrayList<ProjectPageEntity>();
		projectPageList.add(projectPageEntity2);
		portalProjectEntity.setProjectPages(projectPageList);

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("test name");

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setId(1);
		roleProjectPageEntity.setRole(roleEntity);

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
		

		Mockito.when(baseMapper.mapObject(projectPageEntity, ProjectPageDto.class)).thenReturn(pageDto);
		assertThat(projectPageMapper.mapToProjectPageDto(projectPageEntity)).isEqualTo(pageDto);
	}
//	@Test
//	public void mapToNewProjectPageEntity() {
//		ProjectPageDto pageDto = new ProjectPageDto();
//		pageDto.setDisplayOnMenu(true);
//		pageDto.setIcon("icon");
//		pageDto.setId(1);
//		pageDto.setLevel(1);
//		pageDto.setName("pname");
//		pageDto.setPortalProjectName("p-p-name");
//		List<String> dummyData = new ArrayList<String>();
//		dummyData.add("a");
//		dummyData.add("b");
//		dummyData.add("c");
//		pageDto.setRoles(dummyData);
//		pageDto.setTooltip("tooltip");
//		pageDto.setUrl("www.test.co.uk");
//		
//		RoleEntity roleEntity = new RoleEntity();
//		roleEntity.setName("f");
//		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
//
//		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
//		portalProjectEntity.setId(1);
//		portalProjectEntity.setName("ppname");
//		List<ProjectPageEntity> projectPageList = new ArrayList<ProjectPageEntity>();
//		projectPageList.add(projectPageEntity2);
//		portalProjectEntity.setProjectPages(projectPageList);
//
//		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
//		roleProjectPageEntity.setId(1);
//		roleProjectPageEntity.setRole(roleEntity);
//
//		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
//		projectPageEntity.setId(1);
//		projectPageEntity.setName("pename");
//		projectPageEntity.setUrl("www.url.com");
//		projectPageEntity.setTooltip("tooltip two");
//		projectPageEntity.setIcon("icons");
//		projectPageEntity.setPortalProject(portalProjectEntity);
//		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
//		roleProjectPageEntityList.add(roleProjectPageEntity);
//		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
//		
//		Optional<RoleEntity> optionalRoleEntity= Optional.of(roleEntity);
//		roleProjectPageEntityList.add(roleProjectPageEntity);
//		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
//		projectPageEntity.setDisplayOnMenu(true);
//
//		
//		Mockito.when(baseMapper.mapObject(pageDto, ProjectPageEntity.class)).thenReturn(projectPageEntity);
//		Mockito.when(roleRepository.findByName(roleEntity.getName())).thenReturn(optionalRoleEntity);
//		assertThat(projectPageMapper.mapToNewProjectPageEntity(pageDto)).isEqualTo(projectPageEntity);
//	}
	
	@Test
	public void mapToUpdatedProjectPageEntityTest () { 
		ProjectPageDto pageDto = new ProjectPageDto();
		pageDto.setDisplayOnMenu(true);
		pageDto.setIcon("icon");
		pageDto.setId(1);
		pageDto.setLevel(1);
		pageDto.setName("pname");
		pageDto.setPortalProjectName("p-p-name");
		List<String> dummyData = new ArrayList<String>();
		dummyData.add("test name");
		pageDto.setRoles(dummyData);
		pageDto.setTooltip("tooltip");
		pageDto.setUrl("www.test.co.uk");
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("test name");
		
		Optional<RoleEntity> optionalRoleEntity= Optional.of(roleEntity);

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setId(1);
		roleProjectPageEntity.setRole(roleEntity);
		
		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPageEntityList2 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList2.add(roleProjectPageEntity);

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageList = new ArrayList<ProjectPageEntity>();
		projectPageList.add(projectPageEntity2);
		portalProjectEntity.setProjectPages(projectPageList);



		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(pageDto.getId());
		projectPageEntity.setName(pageDto.getName());
		projectPageEntity.setUrl(pageDto.getUrl());
		projectPageEntity.setTooltip(pageDto.getTooltip());
		projectPageEntity.setIcon(pageDto.getIcon());
		projectPageEntity.setPortalProject(portalProjectEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
		projectPageEntity.setDisplayOnMenu(true);
		
		Mockito.when(roleRepository.findByName(roleEntity.getName())).thenReturn(optionalRoleEntity);
		assertThat(projectPageMapper.mapToUpdatedProjectPageEntity(pageDto, projectPageEntity)).isEqualTo(projectPageEntity);
	}
	@Test
	public void mapToUpdatedProjectPageEntityTestException () {
		ProjectPageDto pageDto = new ProjectPageDto();
		pageDto.setDisplayOnMenu(true);
		pageDto.setIcon("icon");
		pageDto.setId(1);
		pageDto.setLevel(1);
		pageDto.setName("pname");
		pageDto.setPortalProjectName("p-p-name");
		List<String> dummyData = new ArrayList<String>();
		dummyData.add("test name");
		pageDto.setRoles(dummyData);
		pageDto.setTooltip("tooltip");
		pageDto.setUrl("www.test.co.uk");
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("fail test");
		
		Optional<RoleEntity> optionalRoleEntity= Optional.of(roleEntity);

		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setId(1);
		roleProjectPageEntity.setRole(roleEntity);
		
		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPageEntityList2 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList2.add(roleProjectPageEntity);

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageList = new ArrayList<ProjectPageEntity>();
		projectPageList.add(projectPageEntity2);
		portalProjectEntity.setProjectPages(projectPageList);



		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(pageDto.getId());
		projectPageEntity.setName(pageDto.getName());
		projectPageEntity.setUrl(pageDto.getUrl());
		projectPageEntity.setTooltip(pageDto.getTooltip());
		projectPageEntity.setIcon(pageDto.getIcon());
		projectPageEntity.setPortalProject(portalProjectEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);
		projectPageEntity.setDisplayOnMenu(true);
		
		Mockito.when(roleRepository.findByName(roleEntity.getName())).thenReturn(optionalRoleEntity);
		thrown.expectMessage(containsString("Role not found for supplied name"));
		assertThat(projectPageMapper.mapToUpdatedProjectPageEntity(pageDto, projectPageEntity)).isEqualTo(projectPageEntity);
	}
}