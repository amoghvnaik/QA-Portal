package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.service.page.CreateProjectPageOperation;
import com.qa.portal.application.service.page.ProjectPageManagementService;
import com.qa.portal.application.service.page.ProjectPageService;
import com.qa.portal.application.service.page.UpdateProjectPageOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppServicePageSmokeTest {

	@Autowired
	public CreateProjectPageOperation createProjectPageOperation;

	@Autowired
	public ProjectPageManagementService projectPageManagementService;

	@Autowired
	public ProjectPageService projectPageService;

	@Autowired
	public UpdateProjectPageOperation updateProjectPageOperation;

	@Test
	public void createProjectPageOperationSmokeTest() {
		assertThat(this.createProjectPageOperation).isNotNull();
	}

	@Test
	public void projectPageManagementServiceSmokeTest() {
		assertThat(this.projectPageManagementService).isNotNull();
	}

	@Test
	public void projectPageServiceSmokeTest() {
		assertThat(this.projectPageService).isNotNull();
	}

	@Test
	public void updateProjectPageOperationSmokeTest() {
		assertThat(this.updateProjectPageOperation).isNotNull();
	}

}