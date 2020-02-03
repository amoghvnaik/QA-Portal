package com.qa.portal.application.keycloak.unitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.theInstance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.keycloak.KeycloakRoleFactory;
import com.qa.portal.application.keycloak.KeycloakRoleValidator;
import com.qa.portal.common.keycloak.KeycloakAdminClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeycloakRoleValidatorTest {

	@InjectMocks
	KeycloakRoleValidator keycloakRoleValidator;
	
	@Mock
	public KeycloakAdminClient keycloakAdminClient;
	
	@Mock
    public KeycloakRoleFactory keycloakRoleFactory;
	
	@Mock
	public RealmResource realmResource;
	
	@Mock
	public RolesResource rolesResource;
    
	@Mock
	public RoleRepresentation roleRepresentation;
	
	@Test
	public void roleExistsTest() {
    	roleRepresentation.setName("Test Role");
    	List<RoleRepresentation> roleRepresentationList = new ArrayList<RoleRepresentation>();
    	roleRepresentationList.add(roleRepresentation);

    	Mockito.when(keycloakAdminClient.getRealm()).thenReturn(realmResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles()).thenReturn(rolesResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles().list()).thenReturn(roleRepresentationList);
    	Mockito.when(roleRepresentation.getName()).thenReturn("Test Role");
    			
		assertThat(this.keycloakRoleValidator.roleExists("Test Role")).isEqualTo(true);
	}
	
	@Test
	public void roleExistsTest2() {
    	roleRepresentation.setName("Test Role");
    	List<RoleRepresentation> roleRepresentationList = new ArrayList<RoleRepresentation>();
    	roleRepresentationList.add(roleRepresentation);

    	Mockito.when(keycloakAdminClient.getRealm()).thenReturn(realmResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles()).thenReturn(rolesResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles().list()).thenReturn(roleRepresentationList);
    	Mockito.when(roleRepresentation.getName()).thenReturn("Test Role2");
    			
		assertThat(this.keycloakRoleValidator.roleExists("Test Role")).isEqualTo(false);
	}
	
	
	
	
}
