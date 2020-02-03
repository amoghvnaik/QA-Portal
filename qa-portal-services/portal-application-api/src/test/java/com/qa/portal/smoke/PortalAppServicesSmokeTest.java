package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.service.CreatePortalApplicationOperation;
import com.qa.portal.application.service.GetAllPortalApplicationOperation;
import com.qa.portal.application.service.GetPortalApplicationByIdOperation;
import com.qa.portal.application.service.PortalApplicationManagementService;
import com.qa.portal.application.service.PortalApplicationService;
import com.qa.portal.application.service.UpdatePortalApplicationOperation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppServicesSmokeTest {

	@Autowired
	public CreatePortalApplicationOperation createPortalApplicationOperation;

	@Autowired
	public GetAllPortalApplicationOperation getAllPortalApplicationOperation;

	@Autowired
	public GetPortalApplicationByIdOperation getPortalApplicationByIdOperation;

	@Autowired
	public PortalApplicationManagementService portalApplicationManagementService;

	@Autowired
	private PortalApplicationService portalAppService;

	@Autowired
	public UpdatePortalApplicationOperation updatePortalApplicationOperation;

	@Test
	public void createPortalAppOpSmokeTest() {
		assertThat(this.createPortalApplicationOperation).isNotNull();
	}

	@Test
	public void getAllPortalAppOpSmokeTest() {
		assertThat(this.getAllPortalApplicationOperation).isNotNull();
	}

	@Test
	public void getPortalAppByIdOpSmokeTest() {
		assertThat(this.getPortalApplicationByIdOperation).isNotNull();
	}

	@Test
	public void portalAppManagementServiceSmokeTest() {
		assertThat(this.portalApplicationManagementService).isNotNull();
	}

	@Test
	public void portalAppServiceSmokeTest() {
		assertThat(this.portalAppService).isNotNull();
	}

	@Test
	public void updatePortalAppOpSmokeTest() {
		assertThat(this.updatePortalApplicationOperation).isNotNull();
	}

}
