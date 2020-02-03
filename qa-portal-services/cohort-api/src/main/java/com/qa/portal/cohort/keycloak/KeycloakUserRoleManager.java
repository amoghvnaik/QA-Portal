package com.qa.portal.cohort.keycloak;

import static com.qa.portal.common.keycloak.KeycloakUserConstants.COHORT_ROLE_PREFIX;
import static com.qa.portal.common.keycloak.KeycloakUserConstants.OFFLINE_ACCESS_ROLE;
import static com.qa.portal.common.keycloak.KeycloakUserConstants.UMA_AUTH_ROLE;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qa.portal.cohort.keycloak.mapper.KeycloakUserMapper;
import com.qa.portal.common.dto.QaUserDetailsDto;
import com.qa.portal.common.exception.QaMultiStepCommitContext;
import com.qa.portal.common.exception.QaPortalBusinessException;
import com.qa.portal.common.exception.QaPortalMultiStepCommitException;
import com.qa.portal.common.keycloak.KeycloakAdminClient;

import static com.qa.portal.common.keycloak.KeycloakUserConstants.*;

@Component
public class KeycloakUserRoleManager {
	private final Logger LOGGER = LoggerFactory.getLogger(KeycloakUserRoleManager.class);
	
	 private KeycloakAdminClient keycloakAdminClient;
	 
	 private KeycloakUserValidator keycloakUserValidator;
	 
	 private KeycloakUserMapper keycloakUserMapper;
	 
	 private KeycloakUserFactory keycloakUserFactory;
	 
	 private KeycloakEmailManager keycloakEmailManager;
	 
	 private KeycloakUserCohortManager keycloakUserCohortManager;
	
	public KeycloakUserRoleManager(KeycloakAdminClient keycloakAdminClient, KeycloakUserValidator keycloakUserValidator, KeycloakUserMapper keycloakUserMapper, KeycloakUserFactory keycloakUserFactory, KeycloakEmailManager keycloakEmailManager, KeycloakUserCohortManager keycloakUserCohortManager) {
		this.keycloakAdminClient = keycloakAdminClient;
		this.keycloakUserValidator = keycloakUserValidator;
		this.keycloakUserMapper = keycloakUserMapper;
		this.keycloakUserFactory = keycloakUserFactory;
		this.keycloakEmailManager = keycloakEmailManager;
		this.keycloakUserCohortManager = keycloakUserCohortManager;
		
	}
	
	 public QaUserDetailsDto getUser(String userName) {
	        return keycloakAdminClient.getRealm().users().search(userName)
	                .stream()
	                .filter(u -> u.getUsername().equals(userName))
	                .findFirst()
	                .map(u -> keycloakUserMapper.mapToUserDetailsDto(keycloakAdminClient.getRealm().users().get(u.getId())))
	                .orElseThrow(() -> new QaPortalBusinessException("No user found for supplied username"));

	    }

	    public List<QaUserDetailsDto> getAllUsers() {
	        return keycloakAdminClient.getRealm().users().list().stream()
	                .map(u -> keycloakUserMapper.mapToUserDetailsDto(keycloakAdminClient.getRealm().users().get(u.getId())))
	                .collect(Collectors.toList());
	    }

	    public void createUserAndRoles(QaUserDetailsDto qaUserDetailsDto) {
	        try {
	            UserRepresentation userRepresentation = createUser(qaUserDetailsDto);
	            qaUserDetailsDto.getRoleNames().stream()
	                    .forEach(roleName -> assignRoleToUser(userRepresentation, roleName));
	        } catch (Exception e) {
	            LOGGER.error("Exception creating user is " + e.getMessage(), e);
	            throw new QaPortalMultiStepCommitException(new QaMultiStepCommitContext(this.getClass().getName(),
	                    qaUserDetailsDto,
	                    QaUserDetailsDto.class,
	                    2), e.getMessage());
	        }
	    }

	    public UserRepresentation createUser(QaUserDetailsDto userDetails) {
	        keycloakUserValidator.validateUser(userDetails, true);
	        UserRepresentation userRepresentation = keycloakUserFactory.createKeycloakUser(userDetails.getUser());
	        keycloakAdminClient.getRealm().users().create(userRepresentation);
	        keycloakEmailManager.sendEmail(userRepresentation);
	        return getUserRepresentation(userRepresentation).orElseGet(() -> userRepresentation);
	    }

	    public UserRepresentation updateUser(QaUserDetailsDto userDetails) {
	        keycloakUserValidator.validateUser(userDetails, false);
	        UserRepresentation userRepresentation = keycloakUserCohortManager.getUserRepresentation(userDetails.getUser().getUserName())
	                .orElseThrow(() -> new QaPortalBusinessException("User not found in keycloak for username"));
	        List<RoleRepresentation> currentUserRoles = getUserRoles(userRepresentation);
	        userRepresentation.setEmail(userDetails.getUser().getEmail());
	        userRepresentation.setFirstName(userDetails.getUser().getFirstName());
	        userRepresentation.setLastName(userDetails.getUser().getLastName());
	        updateUserRoles(userRepresentation, currentUserRoles, userDetails);
	        keycloakAdminClient.getRealm().users().get(userRepresentation.getId()).update(userRepresentation);
	        return userRepresentation;
	    }

	    public void deleteUsers(List<QaUserDetailsDto> users) {
	        users.stream()
	                .filter(u -> u != null)  // Workaround for issue in angular - Ian to fix
	                .forEach(u -> deleteUser(u.getUser().getUserName()));
	    }

	    public void assignRoleToUser(UserRepresentation userRepresentation, String roleName) {
	        RoleRepresentation roleRepresentation = getRoleRepresentation(roleName);
	        UserResource userResource = keycloakAdminClient.getRealm().users().get(userRepresentation.getId());
	        userResource.roles().realmLevel().add(Arrays.asList(roleRepresentation));
	    }

	    private List<RoleRepresentation> getUserRoles(UserRepresentation userRepresentation) {
	        return keycloakAdminClient.getRealm().users().get(userRepresentation.getId()).roles().getAll().getRealmMappings()
	                .stream()
	                .map(r -> getRoleRepresentation(r.getName()))
	                .collect(Collectors.toList());
	    }

	    private void deleteUser(String userName) {
	        String id = keycloakAdminClient.getRealm().users().list().stream()
	                .filter(u -> u.getUsername().equals(userName))
	                .findFirst()
	                .map(u -> u.getId())
	                .orElseThrow(() -> new QaPortalBusinessException("No user found for supplied username"));
	        Response response = keycloakAdminClient.getRealm().users().delete(id);
	        if (response.getStatus() >= HttpStatus.BAD_REQUEST.value()) {
	            throw new QaPortalBusinessException("Error deleting user");
	        }
	    }

	    private void updateUserRoles(UserRepresentation userRepresentation,
	                                 List<RoleRepresentation> currentUserRoles,
	                                 QaUserDetailsDto userDetailsDto) {
	        List<RoleRepresentation> currentPortalRoles = currentUserRoles.stream()
	                .filter(r -> isPortalRole(r.getName()))
	                .collect(Collectors.toList());
	        updateRolesForUser(userRepresentation, currentPortalRoles, userDetailsDto.getRoleNames());
	    }

	    private boolean isPortalRole(String roleName) {
	        return !roleName.equals(UMA_AUTH_ROLE) &&
	                !roleName.equals(OFFLINE_ACCESS_ROLE) &&
	                !roleName.startsWith((COHORT_ROLE_PREFIX));
	    }

	    private void updateRolesForUser(UserRepresentation userRepresentation,
	                                    List<RoleRepresentation> existingPortalRoles,
	                                    List<String> newPortalRoles) {
	        UserResource userResource = keycloakAdminClient.getRealm().users().get(userRepresentation.getId());
	        if (!existingPortalRoles.equals(newPortalRoles)) {
	            // Delete old roles
	            deleteRolesFromUser(userResource, existingPortalRoles);

	            // Assign new roles
	            newPortalRoles.stream()
	                    .forEach(r -> addRoleToUser(userResource, r));
	        }
	    }

	    private void deleteRolesFromUser(UserResource userResource, List<RoleRepresentation> rolesToDelete) {
	        userResource.roles().realmLevel().remove(rolesToDelete);
	    }

	    private void addRoleToUser(UserResource userResource, String roleName) {
	        List<RoleRepresentation> rolesToAdd = convertToRoleRepresentationList(roleName);
	        userResource.roles().realmLevel().add(rolesToAdd);
	    }

	    private List<RoleRepresentation> convertToRoleRepresentationList(String s) {
	        return Stream.of(s)
	                .map(r -> getRoleRepresentation(r))
	                .collect(Collectors.toList());
	    }

	    private Optional<UserRepresentation> getUserRepresentation(UserRepresentation userRepresentation) {
	        return keycloakAdminClient.getRealm().users().list().stream()
	                .filter(u -> u.getUsername().equals(userRepresentation.getUsername()))
	                .findFirst();
	    }

	    private RoleRepresentation getRoleRepresentation(String roleName) {
	        return keycloakAdminClient.getRealm().roles().list().stream()
	                .filter(r -> r.getName().equals(roleName))
	                .findFirst()
	                .orElseThrow(() -> new QaPortalBusinessException("No role found for supplied role name"));
	    }
}
