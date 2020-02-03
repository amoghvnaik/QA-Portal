package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
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
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.mapper.ApplicationProjectsMapper;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetPortalApplicationByIdOperationUnitTests {

	@InjectMocks
	public GetPortalApplicationByIdOperation getPortalApplicationByIdOperation;

	@Mock
	public BaseMapper baseMapper;

	@Mock
	public ApplicationProjectsMapper applicationProjectsMapper;

	@Mock
	public PortalApplicationRepository portalApplicationRepository;

	@Mock
	public RoleRepository roleRepository;

	@Before
	public void SetUp() {
		this.getPortalApplicationByIdOperation = new GetPortalApplicationByIdOperation(portalApplicationRepository,
				roleRepository, applicationProjectsMapper, baseMapper);
	}

	@Test
	public void getPortalApplicationByIdTestWithoutRolleProjectPages() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setBaseUrl("Test URL");
		portalApplicationDto.setDescription("Test Description");
		portalApplicationDto.setDisplayOrder(1);
		portalApplicationDto.setId(123);
		portalApplicationDto.setName("Test Name");
		Set<PortalProjectDto> portalProjectDtoSet = new HashSet<PortalProjectDto>();
		ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(portalApplicationDto,portalProjectDtoSet);
		PortalApplicationEntity portalApplicationEntity = new PortalApplicationEntity();
		portalApplicationEntity.setBaseUrl("");
		portalApplicationEntity.setDescription("");
		portalApplicationEntity.setDisplayOrder(1);
		portalApplicationEntity.setId(123);
		portalApplicationEntity.setLastUpdatedBy("");
		portalApplicationEntity.setName("");
		portalApplicationEntity.setVersion(1);

		Mockito.when(portalApplicationRepository.findById(123)).thenReturn(Optional.of(portalApplicationEntity));
		Mockito.when(baseMapper.mapObject(portalApplicationEntity, PortalApplicationDto.class)).thenReturn(portalApplicationDto);

		assertThat(this.getPortalApplicationByIdOperation.getPortalApplicationById(123)).isEqualTo(applicationProjectsDto);
	}

	@Test
	public void getPortalApplicationByIdTestWithRolleProjectPages() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setBaseUrl("Test URL");
		portalApplicationDto.setDescription("Test Description");
		portalApplicationDto.setDisplayOrder(1);
		portalApplicationDto.setId(123);
		portalApplicationDto.setName("Test Name");
		Set<PortalProjectDto> portalProjectDtoSet = new HashSet<PortalProjectDto>();
		List<ApplicationProjectsDto> ApplicationProjectsDtoList = new ArrayList<ApplicationProjectsDto>();
		ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(portalApplicationDto,portalProjectDtoSet);
		ApplicationProjectsDtoList.add(applicationProjectsDto);
		PortalApplicationEntity portalApplicationEntity = new PortalApplicationEntity();
		portalApplicationEntity.setBaseUrl("Test URL");
		portalApplicationEntity.setDescription("Test Description");
		portalApplicationEntity.setDisplayOrder(1);
		portalApplicationEntity.setId(123);
		portalApplicationEntity.setLastUpdatedBy("");
		portalApplicationEntity.setName("Test Name");
		portalApplicationEntity.setVersion(1);

		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		projectPageEntity.setPortalProject(portalProjectEntity);

		List<RoleEntity> roleEntityList = new ArrayList<RoleEntity>();
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName("Test Name");
		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		roleProjectPageEntity.setProjectPage(projectPageEntity);
		List<RoleProjectPageEntity> roleProjectPageEntityList = new ArrayList<RoleProjectPageEntity>();
		Set<RoleProjectPageEntity> roleProjectPageEntitySet = new HashSet<RoleProjectPageEntity>();
		roleProjectPageEntitySet.add(roleProjectPageEntity);
		roleProjectPageEntityList.add(roleProjectPageEntity);
		roleEntity.setRoleProjectPages(roleProjectPageEntityList);
		roleEntityList.add(roleEntity);

		Mockito.when(portalApplicationRepository.findById(123)).thenReturn(Optional.of(portalApplicationEntity));
		Mockito.when(baseMapper.mapObject(portalApplicationEntity, PortalApplicationDto.class)).thenReturn(portalApplicationDto);
		Mockito.when(roleRepository.findByPortalApplication(portalApplicationEntity)).thenReturn(roleEntityList);
		Mockito.when(roleRepository.findByName("Test Name")).thenReturn(Optional.of(roleEntity));
		Mockito.when(applicationProjectsMapper.createApplicationProjectsDto(roleProjectPageEntitySet)).thenReturn(ApplicationProjectsDtoList);

		System.out.println(this.getPortalApplicationByIdOperation.getPortalApplicationById(123));

		assertThat(this.getPortalApplicationByIdOperation.getPortalApplicationById(123)).isEqualTo(applicationProjectsDto);
	}

}
