package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.dto.ApplicationProjectDto;
import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.PortalProjectDto;

@SpringBootTest
public class ApplicationProjectDtoJavaUnitTest {
	
	@InjectMocks
	ApplicationProjectDto applicationProjectDto;
	
	@Test
	public void getPortalApplicationNameTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setId(1);
		portalApplicationDto.setName("test name");
		ApplicationProjectDto applicationProjectDto = new ApplicationProjectDto(portalApplicationDto, null);
		assertThat(String.valueOf(applicationProjectDto.getPortalApplicationName())).isEqualTo("test name"); 
	}
	
	@Test
	public void getPortalApplicationTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setId(1);
		portalApplicationDto.setName("test name");
		ApplicationProjectDto applicationProjectDto = new ApplicationProjectDto(portalApplicationDto, null);
		assertThat(String.valueOf(applicationProjectDto.getPortalApplication())).isEqualTo(String.valueOf(portalApplicationDto)); 
	}
	
	@Test
	public void getPortalProjectDtoTest() {
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		portalProjectDto.setId(2);
		portalProjectDto.setName("test name");
		ApplicationProjectDto applicationProjectDto = new ApplicationProjectDto(null, portalProjectDto);
		assertThat(String.valueOf(applicationProjectDto.getPortalProjectDto())).isEqualTo(String.valueOf(portalProjectDto)); 
	}

}
