package com.qa.portal.application.service.role.unitTest;

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

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.keycloak.KeycloakRoleResourceManager;
import com.qa.portal.application.service.role.CreateRoleOperation;
import com.qa.portal.application.service.role.GetRoleByNameOperation;
import com.qa.portal.application.service.role.RoleManagementService;
import com.qa.portal.application.service.role.UpdateRoleOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleManagementServiceTest {
	
	@InjectMocks
	RoleManagementService roleManagementService;
	
	@Mock
	KeycloakRoleResourceManager keycloakRoleResourceManager;
	
	@Mock
	CreateRoleOperation createRoleOperation;
	
	@Mock
	UpdateRoleOperation updateRoleOperation;
	
	@Mock
	GetRoleByNameOperation getRoleByNameOperation;
	
	@Test
	public void createRoleTest() {
		RoleDto rd = new RoleDto();
		PortalApplicationDto pae = new PortalApplicationDto();
		
		rd.setId(123);
		rd.setName("User");
		rd.setPortalApplication(pae);
		
		assertThat(this.roleManagementService.createRole(rd)).isEqualTo(rd);
	}
	
	@Test
	public void updateRoleTest() {
		RoleDto rd = new RoleDto();
		PortalApplicationDto pae = new PortalApplicationDto();
		
		rd.setId(123);
		rd.setName("User");
		rd.setPortalApplication(pae);
		
		assertThat(this.roleManagementService.updateRole(rd)).isEqualTo(rd);
		
	}
	
	@Test
	public void getPortalRolesTest() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("User");
		
		RoleDto rd = new RoleDto();
		rd.setName("User");
		
		List<RoleDto> roleListDto = new ArrayList<RoleDto>();
		roleListDto.add(rd);
		
		Mockito.when(this.keycloakRoleResourceManager.getPortalRoles()).thenReturn(roleList);
		Mockito.when(this.getRoleByNameOperation.getRoleByName("User")).thenReturn(rd);
		
		assertThat(this.roleManagementService.getPortalRoles()).contains(rd);
		
	}
	
	@Test
	public void getPortalRolesNamesTest() {
		ArrayList<String> portalRoleList = new ArrayList<String>();
		portalRoleList.add("User");
		
		Mockito.when(this.keycloakRoleResourceManager.getPortalRoles()).thenReturn(portalRoleList);
		
		assertThat(this.roleManagementService.getPortalRolesNames()).asList();
		assertThat(this.roleManagementService.getPortalRolesNames()).contains("User");
	}

}
