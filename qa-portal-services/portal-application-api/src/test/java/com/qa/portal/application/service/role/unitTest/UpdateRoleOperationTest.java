package com.qa.portal.application.service.role.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.hibernate.validator.constraints.Mod10Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.role.UpdateRoleOperation;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateRoleOperationTest {
	
	@InjectMocks
	UpdateRoleOperation updateRoleOperation;
	
	@Mock
	RoleRepository roleRepository;
	
	@Mock
	PortalApplicationRepository portalApplicationRepository;
	
	@Mock
	BaseMapper baseMapper;
	
	@Mock
	RoleDto roleDto;
	
	@Mock
	RoleEntity roleEntity;
	
	@Mock
	PortalApplicationDto portalApplicationDto;
	
	@Mock
	PortalApplicationEntity portalApplicationEntity;
	
	@Test
	public void updateRoleTest() {
		
		
		
		Mockito.when(roleRepository.findByName(roleDto.getName())).thenReturn(Optional.of(roleEntity));
		Mockito.when(roleDto.getPortalApplication()).thenReturn(portalApplicationDto);
		Mockito.when(roleDto.getPortalApplication().getName()).thenReturn("Test Application Name");
		Mockito.when(portalApplicationRepository.findByName(roleDto.getPortalApplication().getName())).thenReturn(Optional.of(portalApplicationEntity));
		Mockito.when(baseMapper.mapObject(roleEntity, RoleDto.class)).thenReturn(roleDto);
		
		assertThat(this.updateRoleOperation.updateRole(roleDto)).isEqualTo(roleDto);
	}

}



















