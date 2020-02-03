package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.service.project.mapper.PortalProjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppServiceProjectMapperSmokeTest {

	@Autowired
	public PortalProjectMapper portalProjectMapper;

	@Test
	public void portalProjectMapperSmokeTest() {
		assertThat(this.portalProjectMapper).isNotNull();
	}

}
