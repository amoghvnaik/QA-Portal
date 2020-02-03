package com.qa.portal.cohort.services.user;

import com.qa.portal.cohort.keycloak.KeycloakUserRoleManager;
import com.qa.portal.common.dto.QaUserDetailsDto;
import com.qa.portal.common.exception.QaPortalBusinessException;
import com.qa.portal.common.persistence.entity.CohortCourseEntity;
import com.qa.portal.common.persistence.entity.QaCohortEntity;
import com.qa.portal.common.persistence.repository.QaCohortRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.qa.portal.common.keycloak.KeycloakUserConstants.TRAINEE_USER_ROLE;
import static com.qa.portal.common.keycloak.KeycloakUserConstants.TRAINER_USER_ROLE;

@Service
public class UserManagementService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserManagementService.class);

    private static final Long COHORT_DURATION = 84L;  // TODO - Assumption is 12 weeks - can calculate from courses when this is added

    private QaCohortRepository cohortRepository;

    private GetTrainerCohortsOperation getTrainerCohortsOperation;

    private CreateUserOperation createUserOperation;

    private UpdateUserOperation updateUserOperation;

    private DeleteUserOperation deleteUserOperation;
    
    private KeycloakUserRoleManager keycloakUserRoleManager;

    public UserManagementService(CreateUserOperation createUserOperation,
                                 UpdateUserOperation updateUserOperation,
                                 DeleteUserOperation deleteUserOperation,
                                 GetTrainerCohortsOperation getTrainerCohortsOperation,
                                 KeycloakUserRoleManager keycloakUserRoleManager,
                                 QaCohortRepository cohortRepository) {
        this.createUserOperation = createUserOperation;
        this.updateUserOperation = updateUserOperation;
        this.deleteUserOperation = deleteUserOperation;
        this.getTrainerCohortsOperation = getTrainerCohortsOperation;
        this.cohortRepository = cohortRepository;
        this.keycloakUserRoleManager = keycloakUserRoleManager;
    }

    public QaUserDetailsDto getUserFromKeycloak(String userName) {
        return keycloakUserRoleManager.getUser(userName);
    }

    public List<QaUserDetailsDto> getAllUsersFromKeycloak() {
        return keycloakUserRoleManager.getAllUsers();
    }

    public List<QaUserDetailsDto> getTraineesWithoutCohort() {
        return getTrainees().stream()
                .filter(t -> StringUtils.isEmpty(t.getCohortNames()))
                .collect(Collectors.toList());
    }

    public List<QaUserDetailsDto> getTraineesAvailableForCohort(Integer cohortId) {
        QaCohortEntity cohortEntity = cohortRepository.findById(cohortId)
                .orElseThrow(() -> new QaPortalBusinessException("No cohort found for supplied id"));
        return getTrainees().stream()
                .filter(t ->traineeAvailableForCohort(t, cohortEntity))
                .collect(Collectors.toList());
    }

    public List<QaUserDetailsDto> getAvailableTrainersForCohort(String cohortName) {
        return getTrainers().stream()
                .filter(t -> isAvailableForCohort(cohortName, t.getUser().getUserName()))
                .collect(Collectors.toList());
    }

    public List<QaUserDetailsDto> getTrainees() {
        return keycloakUserRoleManager.getAllUsers().stream()
                .filter(u -> u.getRoleNames().contains(TRAINEE_USER_ROLE))
                .collect(Collectors.toList());
    }

    public List<QaUserDetailsDto> getTrainers() {
        return keycloakUserRoleManager.getAllUsers().stream()
                .filter(u -> u.getRoleNames().contains(TRAINER_USER_ROLE))
                .collect(Collectors.toList());
    }

    public QaUserDetailsDto createUserDetails(QaUserDetailsDto userDetails) {
        createUserOperation.createUserDetails(userDetails);
        keycloakUserRoleManager.createUserAndRoles(userDetails);
        return userDetails;
    }

    public List<QaUserDetailsDto> updateUsers(List<QaUserDetailsDto> users) {
        users.stream()
                .forEach(u -> updateUserDetails(u));
        return users;
    }

    public QaUserDetailsDto updateUserDetails(QaUserDetailsDto userDetails) {
        updateUserOperation.updateUserDetails(userDetails);
        keycloakUserRoleManager.updateUser(userDetails);
        return userDetails;
    }

    public void deleteUsers(List<QaUserDetailsDto> users) {
        deleteUserOperation.deleteUsers(users);
        keycloakUserRoleManager.deleteUsers(users);
    }

    private boolean traineeAvailableForCohort(QaUserDetailsDto userDetailsDto, QaCohortEntity cohortEntity) {
        return CollectionUtils.isEmpty(userDetailsDto.getCohortNames()) ||
                cohortEntity.getName().equals(userDetailsDto.getCohortNames().get(0));
    }

    private boolean isAvailableForCohort(String cohortName, String trainerName) {
        Optional<QaCohortEntity> cohortEntity = cohortRepository.findByName(cohortName);
        return cohortEntity.map(e -> trainerAvailableForCohort(e, trainerName)).orElseGet(() -> false);
    }

    private boolean trainerAvailableForCohort(QaCohortEntity cohortEntity, String trainerName) {
        LocalDate cohortStart = cohortEntity.getStartDate().toLocalDate();
        LocalDate cohortEnd = cohortStart.plusDays(COHORT_DURATION);
        return getTrainerCohortsOperation.getCohortsForTrainer(trainerName).stream()
                .filter(c -> cohortStart.isBefore(c.getStartDate()) && cohortEnd.isAfter(c.getStartDate()))
                .findAny()
                .map(c -> false)
                .orElseGet(() -> true);
    }
}
