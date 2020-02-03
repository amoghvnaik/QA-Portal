package com.qa.portal.cohort.keycloak;

import static com.qa.portal.common.keycloak.KeycloakUserConstants.COHORT_ROLE_PREFIX;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qa.portal.common.dto.QaCohortDto;
import com.qa.portal.common.exception.QaPortalBusinessException;
import com.qa.portal.common.keycloak.KeycloakAdminClient;

import static com.qa.portal.common.keycloak.KeycloakUserConstants.*;

@Component
public class KeycloakUserCohortManager {
	private final Logger LOGGER = LoggerFactory.getLogger(KeycloakUserCohortManager.class);
	
	private KeycloakAdminClient keycloakAdminClient;
	
	private KeycloakUserRoleManager keycloakUserRoleManager;
	
	public KeycloakUserCohortManager(KeycloakAdminClient keycloakAdminClient) {
		this.keycloakAdminClient = keycloakAdminClient;
	}
	
	public void updateCohortMembers(QaCohortDto cohortDto) {
        RoleRepresentation cohortRole = getCohortRole(cohortDto.getName());
        LOGGER.info("Cohort role is " + cohortRole);
        List<UserRepresentation> existingCohortMembers = getKeycloakUsersForCohort(cohortDto.getName());
        List<String> existingCohortMemberNames = existingCohortMembers.stream()
                .map(u -> u.getUsername())
                .collect(Collectors.toList());
        existingCohortMembers.stream()
                .filter(u -> !(cohortDto.getTraineeNames().contains(u.getUsername()) ||
                        cohortDto.getTrainerUserName().equals(u.getUsername())))
                .forEach(u -> removeMemberFromCohort(u, cohortRole));

        List<UserRepresentation> newCohortMembers = getNewCohortMembers(cohortDto);
        newCohortMembers.stream()
                .filter(u -> !existingCohortMemberNames.contains(u.getUsername()))
                .forEach(u -> keycloakUserRoleManager.assignRoleToUser(u, cohortRole.getName()));
    }

    private List<UserRepresentation> getKeycloakUsersForCohort(String cohortName) {
        return keycloakAdminClient.getRealm().users().list().stream()
                .filter(u -> userInCohort(u, getCohortRoleName(cohortName)))
                .collect(Collectors.toList());
    }

    private List<UserRepresentation> getNewCohortMembers(QaCohortDto cohortDto) {
        return Stream.concat(getTraineeNames(cohortDto).stream(), Stream.of(cohortDto.getTrainerUserName()))
                .map(t -> getUserRepresentation(t))
                .filter(t -> t.isPresent())
                .map(t -> t.get())
                .collect(Collectors.toList());
    }

    private List<String> getTraineeNames(QaCohortDto cohortDto) {
        return Optional.ofNullable(cohortDto.getTraineeNames())
                .orElseGet(() -> Collections.emptyList());
    }

    public Optional<UserRepresentation> getUserRepresentation(String userName) {
        return keycloakAdminClient.getRealm().users().list().stream()
                .filter(u -> u.getUsername().equals(userName))
                .findFirst();
    }

    private boolean userInCohort(UserRepresentation userRepresentation, String cohortName) {
        return keycloakAdminClient.getRealm().users().get(userRepresentation.getId())
                .roles().realmLevel().listAll().stream()
                .filter(r -> cohortName.equals(r.getName()))
                .findAny()
                .map(r -> true)
                .orElseGet(() -> false);
    }

    private void removeMemberFromCohort(UserRepresentation userRepresentation, RoleRepresentation cohort) {
        keycloakAdminClient.getRealm().users().get(userRepresentation.getId())
                .roles().realmLevel()
                .remove(Stream.of(cohort).collect(Collectors.toList()));
    }

    private RoleRepresentation getCohortRole(String cohortName) {
        return keycloakAdminClient.getRealm().roles().list().stream()
                .filter(r -> r.getName().equals(getCohortRoleName(cohortName)))
                .findFirst()
                .orElseThrow(() -> new QaPortalBusinessException("No Cohort on Keycloak for supplied name"));
    }

    private String getCohortRoleName(String cohortName) {
        return COHORT_ROLE_PREFIX + cohortName.replace(' ', '_');
    }
}
