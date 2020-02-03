package com.qa.portal.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.keycloak.KeycloakRoleFactory;
import com.qa.portal.application.keycloak.KeycloakRoleResourceManager;
import com.qa.portal.application.keycloak.KeycloakRoleValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalAppKeycloakSmokeTest {

	@Autowired
	public KeycloakRoleFactory keycloakRoleFactory;

	@Autowired
	public KeycloakRoleResourceManager keycloakRoleResourceManager;

	@Autowired
	public KeycloakRoleValidator keycloakRoleValidator;

	@Test
	public void keycloakRoleFactorySmokeTest() {
		assertThat(this.keycloakRoleFactory).isNotNull();
	}

	@Test
	public void keycloakRoleResourceManagerSmokeTest() {
		assertThat(this.keycloakRoleResourceManager).isNotNull();
	}

	@Test
	public void keycloakRoleValidatorSmokeTest() {
		assertThat(this.keycloakRoleValidator).isNotNull();
	}

}