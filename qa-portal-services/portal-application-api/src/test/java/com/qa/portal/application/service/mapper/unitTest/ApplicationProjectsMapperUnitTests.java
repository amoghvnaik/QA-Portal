package com.qa.portal.application.service.mapper.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;
import com.qa.portal.application.service.mapper.ApplicationProjectsMapper;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationProjectsMapperUnitTests {

	@InjectMocks
	public ApplicationProjectsMapper applicationProjectsMapper;

	@Mock
	public BaseMapper baseMapper;

	@Test
	public void getProjectPagesForPortalProject() {
		PortalProjectEntity portalProjectEntity1 = new PortalProjectEntity();
		portalProjectEntity1.setId(1);
		portalProjectEntity1.setLastUpdatedBy("");
		portalProjectEntity1.setLastUpdatedTimestamp(null);
		portalProjectEntity1.setName("");
		portalProjectEntity1.setProjectPages(null);//projectPages
		portalProjectEntity1.setVersion(1);
		PortalProjectEntity portalProjectEntity2 = new PortalProjectEntity();
		portalProjectEntity2.setId(2);
		portalProjectEntity2.setLastUpdatedBy("");
		portalProjectEntity2.setLastUpdatedTimestamp(null);
		portalProjectEntity2.setName("");
		portalProjectEntity2.setProjectPages(null);//projectPages
		portalProjectEntity2.setVersion(1);
		PortalProjectEntity portalProjectEntity3 = new PortalProjectEntity();
		portalProjectEntity3.setId(3);
		portalProjectEntity3.setLastUpdatedBy("");
		portalProjectEntity3.setLastUpdatedTimestamp(null);
		portalProjectEntity3.setName("");
		portalProjectEntity3.setProjectPages(null);//projectPages
		portalProjectEntity3.setVersion(1);
		PortalProjectEntity portalProjectEntity4 = new PortalProjectEntity();
		portalProjectEntity4.setId(4);
		portalProjectEntity4.setLastUpdatedBy("");
		portalProjectEntity4.setLastUpdatedTimestamp(null);
		portalProjectEntity4.setName("");
		portalProjectEntity4.setProjectPages(null);//projectPages
		portalProjectEntity4.setVersion(1);

		Timestamp timestamp = new Timestamp(0);
		Set<RoleProjectPageEntity> roleProjectPageEntitieset = new HashSet<RoleProjectPageEntity>();
		RoleProjectPageEntity roleProjectPageEntity1 = new RoleProjectPageEntity();
		RoleEntity roleEntity1 = new RoleEntity();
		PortalApplicationEntity portalApplicationEntity1 = new PortalApplicationEntity();
		portalApplicationEntity1.setId(1);
		portalApplicationEntity1.setBaseUrl("test url");
		portalApplicationEntity1.setDescription("test description");
		portalApplicationEntity1.setDisplayOrder(1);
		portalApplicationEntity1.setLastUpdatedBy("test person");
		portalApplicationEntity1.setName("test name");
		portalApplicationEntity1.setVersion(1);
		portalApplicationEntity1.setLastUpdatedTimestamp(timestamp);
		roleEntity1.setPortalApplication(portalApplicationEntity1);
		roleProjectPageEntity1.setRole(roleEntity1);
		ProjectPageEntity projectPageEntity1 = new ProjectPageEntity();
		projectPageEntity1.setDisplayOnMenu(true);
		projectPageEntity1.setIcon("");
		projectPageEntity1.setId(1);
		projectPageEntity1.setLastUpdatedBy("test person");
		projectPageEntity1.setLastUpdatedTimestamp(null);
		projectPageEntity1.setName("");
		projectPageEntity1.setPortalProject(portalProjectEntity1);
		projectPageEntity1.setRoleProjectPageEntities(null); //roleProjectPageEntities
		projectPageEntity1.setTooltip("");
		projectPageEntity1.setUrl("");
		projectPageEntity1.setVersion(1);
		roleProjectPageEntity1.setProjectPage(projectPageEntity1);
		roleProjectPageEntity1.setId(1);
		roleProjectPageEntity1.setVersion(1);
		roleProjectPageEntitieset.add(roleProjectPageEntity1);
		
		RoleProjectPageEntity roleProjectPageEntity2 = new RoleProjectPageEntity();
		RoleEntity roleEntity2 = new RoleEntity();
		PortalApplicationEntity portalApplicationEntity2 = new PortalApplicationEntity();
		portalApplicationEntity2.setId(1);
		portalApplicationEntity2.setBaseUrl("test url");
		portalApplicationEntity2.setDescription("test description");
		portalApplicationEntity2.setDisplayOrder(1);
		portalApplicationEntity2.setLastUpdatedBy("test person");
		portalApplicationEntity2.setName("test name");
		portalApplicationEntity2.setVersion(1);
		portalApplicationEntity2.setLastUpdatedTimestamp(timestamp);
		roleEntity2.setPortalApplication(portalApplicationEntity2);
		roleProjectPageEntity2.setRole(roleEntity2);
		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
		projectPageEntity2.setDisplayOnMenu(true);
		projectPageEntity2.setIcon("");
		projectPageEntity2.setId(1);
		projectPageEntity2.setLastUpdatedBy("test person");
		projectPageEntity2.setLastUpdatedTimestamp(null);
		projectPageEntity2.setName("");
		projectPageEntity2.setPortalProject(portalProjectEntity2); //portalProject
		projectPageEntity2.setRoleProjectPageEntities(null); //roleProjectPageEntities
		projectPageEntity2.setTooltip("");
		projectPageEntity2.setUrl("");
		projectPageEntity2.setVersion(1);
		roleProjectPageEntity2.setProjectPage(projectPageEntity2);
		roleProjectPageEntity2.setId(2);
		roleProjectPageEntity2.setVersion(2);
		roleProjectPageEntitieset.add(roleProjectPageEntity2);
		
		RoleProjectPageEntity roleProjectPageEntity3 = new RoleProjectPageEntity();
		RoleEntity roleEntity3 = new RoleEntity();
		PortalApplicationEntity portalApplicationEntity3 = new PortalApplicationEntity();
		portalApplicationEntity3.setId(1);
		portalApplicationEntity3.setBaseUrl("test url");
		portalApplicationEntity3.setDescription("test description");
		portalApplicationEntity3.setDisplayOrder(1);
		portalApplicationEntity3.setLastUpdatedBy("test person");
		portalApplicationEntity3.setName("test name");
		portalApplicationEntity3.setLastUpdatedTimestamp(timestamp);
		roleEntity3.setPortalApplication(portalApplicationEntity3);
		roleProjectPageEntity3.setRole(roleEntity3);
		ProjectPageEntity projectPageEntity3 = new ProjectPageEntity();
		projectPageEntity3.setDisplayOnMenu(true);
		projectPageEntity3.setIcon("");
		projectPageEntity3.setId(1);
		projectPageEntity3.setLastUpdatedBy("test person");
		projectPageEntity3.setLastUpdatedTimestamp(null);
		projectPageEntity3.setName("");
		projectPageEntity3.setPortalProject(portalProjectEntity3); //portalProject
		projectPageEntity3.setRoleProjectPageEntities(null); //roleProjectPageEntities
		projectPageEntity3.setTooltip("");
		projectPageEntity3.setUrl("");
		projectPageEntity3.setVersion(1);
		roleProjectPageEntity3.setProjectPage(projectPageEntity3);
		roleProjectPageEntity3.setId(3);
		roleProjectPageEntity3.setVersion(3);
		roleProjectPageEntitieset.add(roleProjectPageEntity3);
		
		RoleProjectPageEntity roleProjectPageEntity4 = new RoleProjectPageEntity();
		RoleEntity roleEntity4 = new RoleEntity();
		PortalApplicationEntity portalApplicationEntity4 = new PortalApplicationEntity();
		portalApplicationEntity4.setId(1);
		portalApplicationEntity4.setBaseUrl("test url");
		portalApplicationEntity4.setDescription("test description");
		portalApplicationEntity4.setDisplayOrder(1);
		portalApplicationEntity4.setLastUpdatedBy("test person");
		portalApplicationEntity4.setName("test name");
		portalApplicationEntity4.setVersion(1);
		portalApplicationEntity4.setLastUpdatedTimestamp(timestamp);
		roleEntity4.setPortalApplication(portalApplicationEntity4);
		roleProjectPageEntity4.setRole(roleEntity4);
		ProjectPageEntity projectPageEntity4 = new ProjectPageEntity();
		projectPageEntity4.setDisplayOnMenu(true);
		projectPageEntity4.setIcon("");
		projectPageEntity4.setId(1);
		projectPageEntity4.setLastUpdatedBy("test person");
		projectPageEntity4.setLastUpdatedTimestamp(null);
		projectPageEntity4.setName("");
		projectPageEntity4.setPortalProject(portalProjectEntity4); //portalProject
		projectPageEntity4.setRoleProjectPageEntities(null); //roleProjectPageEntities
		projectPageEntity4.setTooltip("");
		projectPageEntity4.setUrl("");
		projectPageEntity4.setVersion(1);
		roleProjectPageEntity4.setProjectPage(projectPageEntity4);
		roleProjectPageEntity4.setId(4);
		roleProjectPageEntity4.setVersion(4);
		roleProjectPageEntitieset.add(roleProjectPageEntity4);

		
		List<ApplicationProjectsDto> applicationProjectslist = new ArrayList<ApplicationProjectsDto>();
		PortalApplicationDto portalApplication1 = new PortalApplicationDto();
		PortalApplicationDto portalApplication2 = new PortalApplicationDto();
		PortalApplicationDto portalApplication3 = new PortalApplicationDto();
		PortalApplicationDto portalApplication4 = new PortalApplicationDto();
		Set<PortalProjectDto> portalProjects = new HashSet<PortalProjectDto>();
		PortalProjectDto portalProjectDto1 = new PortalProjectDto();
		portalProjectDto1.setId(1);
		portalProjectDto1.setName("");
		portalProjectDto1.setUrl("");
		portalProjectDto1.setProjectPages(null);
		portalProjects.add(portalProjectDto1);
		PortalProjectDto portalProjectDto2 = new PortalProjectDto();
		portalProjectDto2.setId(2);
		portalProjectDto2.setName("");
		portalProjectDto2.setUrl("");
		portalProjectDto2.setProjectPages(null);
		portalProjects.add(portalProjectDto2);
		PortalProjectDto portalProjectDto3 = new PortalProjectDto();
		portalProjectDto3.setId(3);
		portalProjectDto3.setName("");
		portalProjectDto3.setUrl("");
		portalProjectDto3.setProjectPages(null);
		portalProjects.add(portalProjectDto3);
		PortalProjectDto portalProjectDto4 = new PortalProjectDto();
		portalProjectDto4.setId(4);
		portalProjectDto4.setName("");
		portalProjectDto4.setUrl("");
		portalProjectDto4.setProjectPages(null);
		portalProjects.add(portalProjectDto4);
		
		ProjectPageDto projectPageDto1 = new ProjectPageDto();
		projectPageDto1.setDisplayOnMenu(true);
		projectPageDto1.setIcon("");
		projectPageDto1.setId(1);
		projectPageDto1.setLevel(1);
		projectPageDto1.setName("");
		projectPageDto1.setPortalProjectName("");
		projectPageDto1.setRoles(null);
		projectPageDto1.setTooltip("");
		projectPageDto1.setUrl("");
		ProjectPageDto projectPageDto2 = new ProjectPageDto();
		projectPageDto2.setDisplayOnMenu(true);
		projectPageDto2.setIcon("");
		projectPageDto2.setId(1);
		projectPageDto2.setLevel(1);
		projectPageDto2.setName("");
		projectPageDto2.setPortalProjectName("");
		projectPageDto2.setRoles(null);
		projectPageDto2.setTooltip("");
		projectPageDto2.setUrl("");		
		ProjectPageDto projectPageDto3 = new ProjectPageDto();
		projectPageDto3.setDisplayOnMenu(true);
		projectPageDto3.setIcon("");
		projectPageDto3.setId(1);
		projectPageDto3.setLevel(1);
		projectPageDto3.setName("");
		projectPageDto3.setPortalProjectName("");
		projectPageDto3.setRoles(null);
		projectPageDto3.setTooltip("");
		projectPageDto3.setUrl("");		
		ProjectPageDto projectPageDto4 = new ProjectPageDto();
		projectPageDto4.setDisplayOnMenu(true);
		projectPageDto4.setIcon("");
		projectPageDto4.setId(1);
		projectPageDto4.setLevel(1);
		projectPageDto4.setName("");
		projectPageDto4.setPortalProjectName("");
		projectPageDto4.setRoles(null);
		projectPageDto4.setTooltip("");
		projectPageDto4.setUrl("");
				
		
		ApplicationProjectsDto applicationProjects = new ApplicationProjectsDto(portalApplication1, portalProjects);
		applicationProjectslist.add(applicationProjects);
		
		
				
		Mockito.when(this.baseMapper.mapObject(portalApplicationEntity1, PortalApplicationDto.class)).thenReturn(portalApplication1);
		Mockito.when(this.baseMapper.mapObject(portalApplicationEntity2, PortalApplicationDto.class)).thenReturn(portalApplication2);
		Mockito.when(this.baseMapper.mapObject(portalApplicationEntity3, PortalApplicationDto.class)).thenReturn(portalApplication3);
		Mockito.when(this.baseMapper.mapObject(portalApplicationEntity4, PortalApplicationDto.class)).thenReturn(portalApplication4);
		Mockito.when(this.baseMapper.mapObject(portalProjectEntity1, PortalProjectDto.class)).thenReturn(portalProjectDto1);
		Mockito.when(this.baseMapper.mapObject(portalProjectEntity2, PortalProjectDto.class)).thenReturn(portalProjectDto2);
		Mockito.when(this.baseMapper.mapObject(portalProjectEntity3, PortalProjectDto.class)).thenReturn(portalProjectDto3);
		Mockito.when(this.baseMapper.mapObject(portalProjectEntity4, PortalProjectDto.class)).thenReturn(portalProjectDto4);
		Mockito.when(this.baseMapper.mapObject(projectPageEntity1, ProjectPageDto.class)).thenReturn(projectPageDto1);
		Mockito.when(this.baseMapper.mapObject(projectPageEntity2, ProjectPageDto.class)).thenReturn(projectPageDto2);
		Mockito.when(this.baseMapper.mapObject(projectPageEntity3, ProjectPageDto.class)).thenReturn(projectPageDto3);
		Mockito.when(this.baseMapper.mapObject(projectPageEntity4, ProjectPageDto.class)).thenReturn(projectPageDto4);
		
		assertThat(applicationProjectsMapper.createApplicationProjectsDto(roleProjectPageEntitieset)).isEqualTo(applicationProjectslist);
	}

}










