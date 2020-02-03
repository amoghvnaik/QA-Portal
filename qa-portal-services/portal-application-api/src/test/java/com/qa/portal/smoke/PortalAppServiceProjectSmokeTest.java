package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.service.project.CreatePortalProjectOperation;
import com.qa.portal.application.service.project.PortalProjectManagementService;
import com.qa.portal.application.service.project.PortalProjectService;
import com.qa.portal.application.service.project.UpdatePortalProjectOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppServiceProjectSmokeTest {

	@Autowired
	public CreatePortalProjectOperation createPortalProjectOperation;

	@Autowired
	public PortalProjectManagementService portalProjectManagementService;

	@Autowired
	public PortalProjectService portalProjectService;

	@Autowired
	public UpdatePortalProjectOperation updatePortalProjectOperation;

	@Test
	public void createPortalProjectOperationSmokeTest() {
		assertThat(this.createPortalProjectOperation).isNotNull();
	}

	@Test
	public void portalProjectManagementServiceSmokeTest() {
		assertThat(this.portalProjectManagementService).isNotNull();
	}

	@Test
	public void portalProjectServiceSmokeTest() {
		assertThat(this.portalProjectService).isNotNull();
	}

	@Test
	public void updatePortalProjectOperationSmokeTest() {
		assertThat(this.updatePortalProjectOperation).isNotNull();
	}

}