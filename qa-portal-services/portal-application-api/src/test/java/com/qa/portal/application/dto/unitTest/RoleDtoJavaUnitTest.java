package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.RoleDto;

@SpringBootTest
public class RoleDtoJavaUnitTest {
	
	@InjectMocks
	public RoleDto roleDto = new RoleDto();
	
	@Mock
	public RoleDto roleDtoNull = null;
	public String roleDtoDiffClass = "this is a string";
	public RoleDto roleDtoDiffId = new RoleDto();
	public RoleDto roleDtoDiffName = new RoleDto();
	public RoleDto roleDtoDiffPortalApplication = new RoleDto();

	
	
	@Before
	public void setup() {
		this.roleDto.setId(1);
		this.roleDto.setName("test name");
		PortalApplicationDto portalApplication = new PortalApplicationDto();
		portalApplication.setName("test Name");
		portalApplication.setId(1);
		portalApplication.setDisplayOrder(1);
		portalApplication.setDescription("test Description");
		portalApplication.setBaseUrl("test URL");
		this.roleDto.setPortalApplication(portalApplication);
		
		this.roleDtoDiffId.setId(2);
		this.roleDtoDiffId.setName("test name");
		PortalApplicationDto portalApplicationId = new PortalApplicationDto();
		portalApplicationId.setName("test Name");
		portalApplicationId.setId(1);
		portalApplicationId.setDisplayOrder(1);
		portalApplicationId.setDescription("test Description");
		portalApplicationId.setBaseUrl("test URL");
		this.roleDtoDiffId.setPortalApplication(portalApplicationId);
		
		this.roleDtoDiffName.setId(1);
		this.roleDtoDiffName.setName("diff test name");
		PortalApplicationDto portalApplicationName = new PortalApplicationDto();
		portalApplicationName.setName("test Name");
		portalApplicationName.setId(1);
		portalApplicationName.setDisplayOrder(1);
		portalApplicationName.setDescription("test Description");
		portalApplicationName.setBaseUrl("test URL");
		this.roleDtoDiffName.setPortalApplication(portalApplicationName);
		
		this.roleDtoDiffPortalApplication.setId(1);
		this.roleDtoDiffPortalApplication.setName("test name");
		PortalApplicationDto portalApplicationDiff = new PortalApplicationDto();
		portalApplicationDiff.setName("diff test Name");
		portalApplicationDiff.setId(2);
		portalApplicationDiff.setDisplayOrder(2);
		portalApplicationDiff.setDescription("diff test Description");
		portalApplicationDiff.setBaseUrl("diff test URL");
		this.roleDtoDiffPortalApplication.setPortalApplication(portalApplicationDiff);
	}

	
	@Test
	public void getIdTest() {
		assertThat(this.roleDto.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.roleDto.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getPortalApplicationTest() {
		PortalApplicationDto portalApplicationResult = new PortalApplicationDto();
		portalApplicationResult.setName("test Name");
		portalApplicationResult.setId(1);
		portalApplicationResult.setDisplayOrder(1);
		portalApplicationResult.setDescription("test Description");
		portalApplicationResult.setBaseUrl("test URL");
		assertThat(this.roleDto.getPortalApplication()).isEqualTo(portalApplicationResult); 
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.roleDto.equals(roleDto)).isEqualTo(true);
		assertThat(this.roleDto.equals(roleDtoNull)).isEqualTo(false);
		assertThat(this.roleDto.equals(roleDtoDiffClass)).isEqualTo(false);
		assertThat(this.roleDto.equals(roleDtoDiffId)).isEqualTo(false);
		assertThat(this.roleDto.equals(roleDtoDiffName)).isEqualTo(false);
		assertThat(this.roleDto.equals(roleDtoDiffPortalApplication)).isEqualTo(false);
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.roleDto.hashCode()).length()).isEqualTo(9);
	}
}
