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

import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.rest.RoleManagementController;
import com.qa.portal.application.service.role.RoleManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RollManagementControllerUnitTests {

	@InjectMocks
	RoleManagementController roleManagementController;

	@Mock
	RoleManagementService roleManagementService;
	
	@Test
	public void getPortalRolesNamesFromKeycloakTest() {
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		Mockito.when(this.roleManagementService.getPortalRolesNames()).thenReturn(list);
		
		assertThat(this.roleManagementController.getPortalRolesNamesFromKeycloak().getBody()).isEqualTo(list);
		assertThat(this.roleManagementController.getPortalRolesNamesFromKeycloak().getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void getPortalRolesFromKeycloakTest() {
		
		RoleDto roleDto = new RoleDto();
		roleDto.setId(1);
		roleDto.setName("test name");
		roleDto.setPortalApplication(null);
		List<RoleDto> list = new ArrayList<RoleDto>();
		list.add(roleDto);
		
		Mockito.when(this.roleManagementService.getPortalRoles()).thenReturn(list);
		
		assertThat(this.roleManagementController.getPortalRolesFromKeycloak().getStatusCodeValue()).isEqualTo(200);
		assertThat(this.roleManagementController.getPortalRolesFromKeycloak().getBody()).isEqualTo(list);
	}
	
	@Test
	public void createRoleTest() {
		
		RoleDto roleDto = new RoleDto();
		
		Mockito.when(this.roleManagementService.createRole(roleDto)).thenReturn(roleDto);
		
		assertThat(this.roleManagementController.createRole(roleDto).getBody()).isEqualTo(roleDto);
		assertThat(this.roleManagementController.createRole(roleDto).getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	public void updateRoleTest() {
		
		RoleDto roleDto = new RoleDto();
		
		Mockito.when(this.roleManagementService.updateRole(roleDto)).thenReturn(roleDto);
		
		assertThat(this.roleManagementController.updateRole(roleDto).getBody()).isEqualTo(roleDto);
		assertThat(this.roleManagementController.updateRole(roleDto).getStatusCodeValue()).isEqualTo(200);
	}
}
