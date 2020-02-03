package com.qa.portal.application.keycloak.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.qa.portal.application.keycloak.KeycloakRoleResourceManager;
import com.qa.portal.application.keycloak.KeycloakRoleValidator;
import com.qa.portal.common.keycloak.KeycloakAdminClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeycloakRoleResourceManagerTests {

	
	@InjectMocks
	KeycloakRoleResourceManager keycloakRoleResourceManager;
	
	@Mock
	public KeycloakRoleValidator keycloakRoleValidator;

	@Mock
    public KeycloakRoleFactory keycloakRoleFactory;

	@Mock
    public KeycloakAdminClient keycloakAdminClient;
	
	@Mock
	public RealmResource realmResource;
	
	@Mock
	public RolesResource rolesResource;
    
	@Mock
	public RoleRepresentation roleRepresentation;
	
    @Test
    public void createRoleTest() {
    	roleRepresentation.setName("Test Role Name");
    	List<RoleRepresentation> roleRepresentationList = new ArrayList<RoleRepresentation>();
    	roleRepresentationList.add(roleRepresentation);

    	Mockito.when(keycloakRoleFactory.createKeycloakRole("Test Role Name")).thenReturn(roleRepresentation);
    	Mockito.when(keycloakAdminClient.getRealm()).thenReturn(realmResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles()).thenReturn(rolesResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles().list()).thenReturn(roleRepresentationList);
    	Mockito.when(roleRepresentation.getName()).thenReturn("Test Role Name");
    	
    	assertThat(this.keycloakRoleResourceManager.createRole("Test Role Name")).isEqualTo(roleRepresentation);
    }
    
    @Test
    public void getPortalRolesTest() {
    	roleRepresentation.setName("Test Role Name");
    	List<RoleRepresentation> roleRepresentationList = new ArrayList<RoleRepresentation>();
    	roleRepresentationList.add(roleRepresentation);
    	List<String> rolesList = new ArrayList<String>();
    	rolesList.add("Test Role Name");
    	
    	Mockito.when(keycloakAdminClient.getRealm()).thenReturn(realmResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles()).thenReturn(rolesResource);
    	Mockito.when(keycloakAdminClient.getRealm().roles().list()).thenReturn(roleRepresentationList);
    	Mockito.when(roleRepresentation.getName()).thenReturn("Test Role Name");
    	
    	assertThat(this.keycloakRoleResourceManager.getPortalRoles()).isEqualTo(rolesList);
    }
    
    
    
    
    
    
    
    
    
    
}
