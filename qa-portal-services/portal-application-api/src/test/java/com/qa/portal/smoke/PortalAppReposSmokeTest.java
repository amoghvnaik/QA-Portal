package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.application.persistence.repository.PortalProjectRepository;
import com.qa.portal.application.persistence.repository.ProjectPageRepository;
import com.qa.portal.application.persistence.repository.RoleProjectPageRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppReposSmokeTest {

	@Autowired
	public PortalApplicationRepository portalApplicationRepository;

	@Autowired
	public PortalProjectRepository portalProjectRepository;

	@Autowired
	public ProjectPageRepository projectPageRepository;

	@Autowired
	public RoleProjectPageRepository roleProjectPageRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void portalApplicationRepositorySmokeTest() {
		assertThat(this.portalApplicationRepository).isNotNull();
	}

	@Test
	public void portalProjectRepositorySmokeTest() {
		assertThat(this.portalProjectRepository).isNotNull();
	}

	@Test
	public void projectPageRepositorySmokeTest() {
		assertThat(this.projectPageRepository).isNotNull();
	}

	@Test
	public void roleProjectPageRepositorySmokeTest() {
		assertThat(this.roleProjectPageRepository).isNotNull();
	}

	@Test
	public void roleRepositorySmokeTest() {
		assertThat(this.roleRepository).isNotNull();
	}

}
