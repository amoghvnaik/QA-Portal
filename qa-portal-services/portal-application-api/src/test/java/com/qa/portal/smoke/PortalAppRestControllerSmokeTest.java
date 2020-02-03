package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.rest.PortalApplicationController;
import com.qa.portal.application.rest.PortalApplicationManagementController;
import com.qa.portal.application.rest.PortalProjectController;
import com.qa.portal.application.rest.PortalProjectManagementController;
import com.qa.portal.application.rest.ProjectPageController;
import com.qa.portal.application.rest.ProjectPageManagementController;
import com.qa.portal.application.rest.ReferenceDataController;
import com.qa.portal.application.rest.RoleController;
import com.qa.portal.application.rest.RoleManagementController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppRestControllerSmokeTest {

	@Autowired
	public PortalApplicationController portalApplicationController;

	@Autowired
	public PortalApplicationManagementController portalApplicationManagementController;

	@Autowired
	public PortalProjectController portalProjectController;

	@Autowired
	public PortalProjectManagementController portalProjectManagementController;

	@Autowired
	private ProjectPageController projectPageController;

	@Autowired
	private ProjectPageManagementController projectPageManagementController;

	@Autowired
	private ReferenceDataController referenceDataController;

	@Autowired
	private RoleController roleController;

	@Autowired
	private RoleManagementController roleManagementController;

	@Test
	public void portalApplicationControllerSmokeTest() {
		assertThat(this.portalApplicationController).isNotNull();
	}

	@Test
	public void portalApplicationManagementControllerSmokeTest() {
		assertThat(this.portalApplicationManagementController).isNotNull();
	}

	@Test
	public void portalProjectControllerSmokeTest() {
		assertThat(this.portalProjectController).isNotNull();
	}

	@Test
	public void portalProjectManagementControllerSmokeTest() {
		assertThat(this.portalProjectManagementController).isNotNull();
	}

	@Test
	public void projectPageControllerSmokeTest() {
		assertThat(this.projectPageController).isNotNull();
	}

	@Test
	public void projectPageManagementControllerSmokeTest() {
		assertThat(this.projectPageManagementController).isNotNull();
	}

	@Test
	public void ReferenceDataControllerSmokeTest() {
		assertThat(this.referenceDataController).isNotNull();
	}

	@Test
	public void roleControllerSmokeTest() {
		assertThat(this.roleController).isNotNull();
	}

	@Test
	public void roleManagementControllerSmokeTest() {
		assertThat(this.roleManagementController).isNotNull();
	}

}
