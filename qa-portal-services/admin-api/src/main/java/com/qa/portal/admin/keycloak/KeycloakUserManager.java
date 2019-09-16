package com.qa.portal.admin.keycloak;

import com.qa.portal.admin.dto.QaUserAndRoleDto;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class KeycloakUserManager {

    private final Logger LOGGER = LoggerFactory.getLogger(KeycloakUserManager.class);

    private KeycloakUserValidator keycloakUserValidator;

    private KeycloakRoleValidator keycloakRoleValidator;

    private KeycloakUserFactory keycloakUserFactory;

    private KeycloakRoleFactory keycloakRoleFactory;

    private KeycloakAdminClient keycloakAdminClient;

    public KeycloakUserManager(KeycloakUserValidator keycloakUserValidator,
                               KeycloakRoleValidator keycloakRoleValidator,
                               KeycloakUserFactory keycloakUserFactory,
                               KeycloakRoleFactory keycloakRoleFactory,
                               KeycloakAdminClient keycloakAdminClient) {
        this.keycloakUserValidator = keycloakUserValidator;
        this.keycloakRoleValidator = keycloakRoleValidator;
        this.keycloakUserFactory = keycloakUserFactory;
        this.keycloakRoleFactory = keycloakRoleFactory;
        this.keycloakAdminClient = keycloakAdminClient;
    }

    public void createUserAndRole(QaUserAndRoleDto qaUserAndRoleDto) {
        UserRepresentation userRepresentation = createUser(qaUserAndRoleDto);
        RoleRepresentation roleRepresentation = createRole(qaUserAndRoleDto.getRoleName());
        addRoleToUser(userRepresentation, roleRepresentation);
    }

    public UserRepresentation createUser(QaUserAndRoleDto userDetails) {
        keycloakUserValidator.validateUser(userDetails);
        UserRepresentation userRepresentation = keycloakUserFactory.createKeycloakUser(userDetails.getUser());
        keycloakAdminClient.getRealm().users().create(userRepresentation);
        return refreshUserRepresentation(userRepresentation).orElseGet(() -> userRepresentation);
    }

    public RoleRepresentation createRole(String roleName) {
        keycloakRoleValidator.validateRole(roleName);
        RoleRepresentation roleRepresentation = keycloakRoleFactory.createKeycloakRole(roleName);
        keycloakAdminClient.getRealm().roles().create(roleRepresentation);
        return refreshRoleRepresentation(roleName).orElseGet(() -> roleRepresentation);
    }

    public void addRoleToUser(UserRepresentation userRepresentation, RoleRepresentation roleRepresentation) {
        UserResource userResource = keycloakAdminClient.getRealm().users().get(userRepresentation.getId());
        userResource.roles().realmLevel().add(Arrays.asList(roleRepresentation));
    }

    private Optional<UserRepresentation> refreshUserRepresentation(UserRepresentation userRepresentation) {
        return keycloakAdminClient.getRealm().users().list().stream()
                .filter(u -> u.getUsername().equals(userRepresentation.getUsername()))
                .findFirst();
    }

    private Optional<RoleRepresentation> refreshRoleRepresentation(String roleName) {
        return keycloakAdminClient.getRealm().roles().list().stream()
                .filter(r -> r.getName().equals(roleName))
                .findFirst();
    }
}
