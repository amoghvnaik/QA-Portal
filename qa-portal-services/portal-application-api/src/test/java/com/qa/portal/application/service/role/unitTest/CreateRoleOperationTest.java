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

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.RoleDto;
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.application.persistence.repository.RoleRepository;
import com.qa.portal.application.service.role.CreateRoleOperation;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateRoleOperationTest {
	
	@InjectMocks
	CreateRoleOperation createRoleOperation;
	
	@Mock
	RoleRepository roleRepository;
	
	@Mock
	PortalApplicationRepository portalApplicationRepository;
	
	@Mock
	BaseMapper baseMapper;
	
	@Test
	public void createRoleTest() {
		RoleDto rd = new RoleDto();
		PortalApplicationDto pad = new PortalApplicationDto();
		
		pad.setId(234);
		pad.setName("Test");
		pad.setBaseUrl("Testurl");
		pad.setDescription("Testing testing 123");
		pad.setDisplayOrder(1);
		
		rd.setId(123);
		rd.setName("UserJohn");
		rd.setPortalApplication(pad);
		
		RoleEntity roleEntity = baseMapper.mapObject(rd, RoleEntity.class);
		RoleEntity savedRole = roleRepository.save(roleEntity);
		
		RoleDto finalRole = baseMapper.mapObject(savedRole, RoleDto.class);
		
		assertThat(this.createRoleOperation.createRole(rd)).isEqualTo(finalRole);
	}

}
