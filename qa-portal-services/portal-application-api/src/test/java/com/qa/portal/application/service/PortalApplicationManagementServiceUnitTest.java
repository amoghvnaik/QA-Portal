package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.ApplicationProjectsDto;
import com.qa.portal.application.dto.PortalApplicationDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationManagementServiceUnitTest {

	@InjectMocks
	PortalApplicationManagementService portalApplicationManagementService;
	
	@Mock
	public CreatePortalApplicationOperation createPortalApplicationOperation;

	@Mock
	public UpdatePortalApplicationOperation updatePortalApplicationOperation;

	@Mock
	public GetAllPortalApplicationOperation getAllPortalApplicationOperation;

	@Mock
	public GetPortalApplicationByIdOperation getPortalApplicationByIdOperation;
	
	@Test
	public void getAllPortalApplicationsTest() {
		List<PortalApplicationDto> portalApplicationDtos = new ArrayList<PortalApplicationDto>();
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDtos.add(portalApplicationDto);
		
		Mockito.when(getAllPortalApplicationOperation.getAllPortalApplications()).thenReturn(portalApplicationDtos);
		
		assertThat(this.portalApplicationManagementService.getAllPortalApplications()).isEqualTo(portalApplicationDtos);
	}
	
	@Test
	public void getPortalApplicationByIdTest() {
		ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(null, null);
		
		Mockito.when(getPortalApplicationByIdOperation.getPortalApplicationById(123)).thenReturn(applicationProjectsDto);
		
		assertThat(this.portalApplicationManagementService.getPortalApplicationById(123)).isEqualTo(applicationProjectsDto);
	}
	
	@Test
	public void createPortalApplicationTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		
		Mockito.when(createPortalApplicationOperation.createPortalApplication(portalApplicationDto)).thenReturn(portalApplicationDto);
		
		assertThat(this.portalApplicationManagementService.createPortalApplication(portalApplicationDto)).isEqualTo(portalApplicationDto);
	}
	
	
	@Test
	public void updatePortalApplicationTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		
		Mockito.when(updatePortalApplicationOperation.updatePortalApplication(portalApplicationDto)).thenReturn(portalApplicationDto);
		
		assertThat(this.portalApplicationManagementService.updatePortalApplication(portalApplicationDto)).isEqualTo(portalApplicationDto);
	}
	
	
	
	
	
}
