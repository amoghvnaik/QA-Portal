package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.rest.RoleController;
import com.qa.portal.application.service.role.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControlerUnitTest {

	@InjectMocks
	RoleController roleController;
	
	@Mock
	RoleService roleService;
	
	@Test
	public void getRoleById() {
		
		RoleDto roleDto = new RoleDto();
		
		Mockito.when(this.roleService.getRole(1)).thenReturn(roleDto);
		
		assertThat(this.roleController.getRoleById(1).getBody()).isEqualTo(roleDto);
		assertThat(this.roleController.getRoleById(1).getStatusCodeValue()).isEqualTo(200);
	}
	
}
