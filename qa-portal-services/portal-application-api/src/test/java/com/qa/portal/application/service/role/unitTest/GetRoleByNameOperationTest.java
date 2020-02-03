package com.qa.portal.application.service.role.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.role.GetRoleByNameOperation;
import com.qa.portal.common.service.mapper.BaseMapper;

//Throws an exception despite a valid input

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetRoleByNameOperationTest {
	
	@InjectMocks
	GetRoleByNameOperation getRoleByNameOperation;
	
	@Mock
	RoleRepository roleRepository;
	
	@Mock
	BaseMapper baseMapper;
	
	@Mock
	RoleDto roleDto;
	
	@Mock
	RoleEntity roleEntity;
	
	@Test
	public void getRoleByNameTest() {
		
		Mockito.when(roleRepository.findByName("Test Role Name")).thenReturn(Optional.of(roleEntity));
		Mockito.when(baseMapper.mapObject(roleEntity, RoleDto.class)).thenReturn(roleDto);

		assertThat(this.getRoleByNameOperation.getRoleByName("Test Role Name")).isEqualTo(roleDto);
	}

	@Test
	public void getRoleByNameTest2() {
		

		assertThat(this.getRoleByNameOperation.getRoleByName("Test Role Name")).isEqualTo(null);
	}
	
}















