package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.ApplicationProjectsDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.persistence.repository.RoleProjectPageRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.mapper.ApplicationProjectsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationServiceUnitTests {

	@InjectMocks
	public PortalApplicationService portalApplicationService;
	
	@Mock
    public ApplicationProjectsMapper applicationProjectsMapper;

	@Mock
    public RoleRepository roleRepository;

	@Mock
    public RoleProjectPageRepository roleProjectPageRepository;
	
	@Test
	public void getPortalApplicationsTest() {
		Collection<String> userRoles = new ArrayList<String>();
		userRoles.add("Test Role");
		RoleEntity roleEntity = new RoleEntity();
		List<RoleProjectPageEntity> roleProjectPagesList = new ArrayList<RoleProjectPageEntity>();
		Set<RoleProjectPageEntity> roleProjectPagesSet = new HashSet<RoleProjectPageEntity>();
		RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		projectPageEntity.setPortalProject(portalProjectEntity);
		roleProjectPageEntity.setProjectPage(projectPageEntity);
		roleProjectPagesList.add(roleProjectPageEntity);
		roleProjectPagesSet.add(roleProjectPageEntity);
		roleEntity.setRoleProjectPages(roleProjectPagesList);
		List<ApplicationProjectsDto> applicationProjectsDtoList = new ArrayList<ApplicationProjectsDto>();
		ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(null, null);
		applicationProjectsDtoList.add(applicationProjectsDto);
	
		
		Mockito.when(roleRepository.findByName("Test Role")).thenReturn(Optional.of(roleEntity));
		Mockito.when(roleRepository.findByName("any")).thenReturn(Optional.of(roleEntity));
		Mockito.when(applicationProjectsMapper.createApplicationProjectsDto(roleProjectPagesSet)).thenReturn(applicationProjectsDtoList);
		
		System.out.println(this.portalApplicationService.getPortalApplications(userRoles));
		
		assertThat(this.portalApplicationService.getPortalApplications(userRoles)).isEqualTo(applicationProjectsDtoList);
	}
}
