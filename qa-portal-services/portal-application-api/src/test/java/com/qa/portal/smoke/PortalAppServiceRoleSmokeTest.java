package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.service.role.CreateRoleOperation;
import com.qa.portal.application.service.role.GetRoleByNameOperation;
import com.qa.portal.application.service.role.RoleManagementService;
import com.qa.portal.application.service.role.RoleService;
import com.qa.portal.application.service.role.UpdateRoleOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppServiceRoleSmokeTest {

	@Autowired
	public CreateRoleOperation createRoleOperation;

	@Autowired
	public GetRoleByNameOperation getRoleByNameOperation;

	@Autowired
	public RoleManagementService roleManagementService;

	@Autowired
	public RoleService roleService;

	@Autowired
	public UpdateRoleOperation updateRoleOperation;

	@Test
	public void createRoleOperationSmokeTest() {
		assertThat(this.createRoleOperation).isNotNull();
	}

	@Test
	public void getRoleByNameOperationSmokeTest() {
		assertThat(this.getRoleByNameOperation).isNotNull();
	}

	@Test
	public void roleManagementServiceSmokeTest() {
		assertThat(this.roleManagementService).isNotNull();
	}

	@Test
	public void roleServiceSmokeTest() {
		assertThat(this.roleService).isNotNull();
	}

	@Test
	public void updateRoleOperationSmokeTest() {
		assertThat(this.updateRoleOperation).isNotNull();
	}

}