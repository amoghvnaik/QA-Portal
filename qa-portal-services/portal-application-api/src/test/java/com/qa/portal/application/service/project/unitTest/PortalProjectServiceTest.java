package com.qa.portal.application.service.project.unitTest;

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


import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.persistence.repository.PortalProjectRepository;
import com.qa.portal.application.service.project.PortalProjectService;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProjectServiceTest {

	@InjectMocks
	public PortalProjectService portalProjectService;

	@Mock
	public PortalProjectRepository portalProjectRepository;

	@Mock
	public BaseMapper baseMapper;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void getPortalProjectsTest() {
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
		
		
		PortalProjectDto portalDto = new PortalProjectDto();
		portalDto.setId(1);
		portalDto.setName("name");
		portalDto.setUrl("url");
		List<ProjectPageDto> pageDtoList = new ArrayList<ProjectPageDto>();
		pageDtoList.add(pageDto);
		portalDto.setProjectPages(pageDtoList);
		
		List<PortalProjectDto> portalDtoList = new ArrayList<PortalProjectDto>();
		portalDtoList.add(portalDto);
		
		
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity); 
		portalProjectEntity.setProjectPages(projectPageEntityList);
		
		List<PortalProjectEntity> portalProjectEntityList = new ArrayList<PortalProjectEntity>();
		portalProjectEntityList.add(portalProjectEntity);
		
		Mockito.when(portalProjectRepository.findAll()).thenReturn(portalProjectEntityList);
		Mockito.when(baseMapper.mapObject(portalProjectEntity, PortalProjectDto.class))
		.thenReturn(portalDto);
		assertThat(portalProjectService.getPortalProjects()).isEqualTo(portalDtoList);
	}
	
	@Test
	public void getPortalProjectByIdTest() {
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
		
		PortalProjectDto portalDto = new PortalProjectDto();
		portalDto.setId(1);
		portalDto.setName("name");
		portalDto.setUrl("url");
		List<ProjectPageDto> pageDtoList = new ArrayList<ProjectPageDto>();
		pageDtoList.add(pageDto);
		portalDto.setProjectPages(pageDtoList);
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("test name");
		
		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setRole(roleEntity);
		
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity); 
		portalProjectEntity.setProjectPages(projectPageEntityList);
		Optional<PortalProjectEntity> optionalPortalProjectEntity = Optional.of(portalProjectEntity);
		
		List<PortalProjectEntity> portalProjectEntityList = new ArrayList<PortalProjectEntity>();
		portalProjectEntityList.add(portalProjectEntity);
		
		Mockito.when(portalProjectRepository.findById(portalDto.getId())).thenReturn(optionalPortalProjectEntity);
		Mockito.when(baseMapper.mapObject(portalProjectEntity, PortalProjectDto.class))
		.thenReturn(portalDto);
		assertThat(portalProjectService.getPortalProject(portalDto.getId())).isEqualTo(portalDto);
	}
	
	@Test
	public void getPortalProjectByIdNoneFoundExceptionTest() {
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
		
		PortalProjectDto portalDto = new PortalProjectDto();
		portalDto.setId(1);
		portalDto.setName("name");
		portalDto.setUrl("url");
		List<ProjectPageDto> pageDtoList = new ArrayList<ProjectPageDto>();
		pageDtoList.add(pageDto);
		portalDto.setProjectPages(pageDtoList);
		
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("test name");
		
		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setRole(roleEntity);
		
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntityList.add(roleProjectPageEntity);
		projectPageEntity.setRoleProjectPageEntities(roleProjectPageEntityList);

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity); 
		portalProjectEntity.setProjectPages(projectPageEntityList);
		Optional<PortalProjectEntity> optionalPortalProjectEntity = Optional.of(portalProjectEntity);
		
		List<PortalProjectEntity> portalProjectEntityList = new ArrayList<PortalProjectEntity>();
		portalProjectEntityList.add(portalProjectEntity);
		
		Mockito.when(portalProjectRepository.findById(portalDto.getId())).thenReturn(optionalPortalProjectEntity);
		Mockito.when(baseMapper.mapObject(portalProjectEntity, PortalProjectDto.class))
		.thenReturn(portalDto);
		thrown.expectMessage(containsString("No Portal Project found for supplied id"));
		assertThat(portalProjectService.getPortalProject(3)).isEqualTo(portalDto);
	}

}
