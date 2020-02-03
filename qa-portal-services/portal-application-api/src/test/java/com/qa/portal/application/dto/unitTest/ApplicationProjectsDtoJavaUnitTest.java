package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.ApplicationProjectsDto;
import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.dto.PortalProjectDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationProjectsDtoJavaUnitTest {

	@InjectMocks
	ApplicationProjectsDto applicationProjectsDto = new ApplicationProjectsDto(null, null);
	
	@Mock
	ApplicationProjectsDto applicationProjectsDtoNull = null;
	String applicationProjectsDtoDiffClass = "this is a string";
	ApplicationProjectsDto applicationProjectsDtoDiffPortalApplication = new ApplicationProjectsDto(null, null);
	ApplicationProjectsDto applicationProjectsDtoDiffPortalProjects = new ApplicationProjectsDto(null, null);
	
	@Before
	public void setup() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setId(1);
		this.applicationProjectsDto.setPortalApplication(portalApplicationDto);
		PortalProjectDto portalProjectDto1 = new PortalProjectDto();
		PortalProjectDto portalProjectDto2 = new PortalProjectDto();
		portalProjectDto1.setId(1);
		portalProjectDto2.setId(2);
		Set<PortalProjectDto> portalProjectSet = new HashSet<PortalProjectDto>();
		portalProjectSet.add(portalProjectDto1);
		portalProjectSet.add(portalProjectDto2);
		this.applicationProjectsDto.setPortalProjects(portalProjectSet);
		
		PortalApplicationDto portalApplicationDtoDiffPortalApplication = new PortalApplicationDto();
		portalApplicationDtoDiffPortalApplication.setId(2);
		this.applicationProjectsDtoDiffPortalApplication.setPortalApplication(portalApplicationDtoDiffPortalApplication);
		PortalProjectDto portalProjectDtoDiffPortalApplication1 = new PortalProjectDto();
		PortalProjectDto portalProjectDtoDiffPortalApplication2 = new PortalProjectDto();
		portalProjectDtoDiffPortalApplication1.setId(1);
		portalProjectDtoDiffPortalApplication2.setId(2);
		Set<PortalProjectDto> portalProjectSetDiffPortalApplication = new HashSet<PortalProjectDto>();
		portalProjectSetDiffPortalApplication.add(portalProjectDtoDiffPortalApplication1);
		portalProjectSetDiffPortalApplication.add(portalProjectDtoDiffPortalApplication2);
		this.applicationProjectsDtoDiffPortalApplication.setPortalProjects(portalProjectSetDiffPortalApplication);
		
		PortalApplicationDto portalApplicationDtoDiffPortalProjects = new PortalApplicationDto();
		portalApplicationDtoDiffPortalProjects.setId(1);
		this.applicationProjectsDtoDiffPortalProjects.setPortalApplication(portalApplicationDtoDiffPortalProjects);
		PortalProjectDto portalProjectDtoDiffPortalProjects1 = new PortalProjectDto();
		PortalProjectDto portalProjectDtoDiffPortalProjects2 = new PortalProjectDto();
		portalProjectDtoDiffPortalProjects1.setId(3);
		portalProjectDtoDiffPortalProjects2.setId(4);
		Set<PortalProjectDto> portalProjectSetDiffPortalProjects = new HashSet<PortalProjectDto>();
		portalProjectSetDiffPortalProjects.add(portalProjectDtoDiffPortalProjects1);
		portalProjectSetDiffPortalProjects.add(portalProjectDtoDiffPortalProjects2);
		this.applicationProjectsDtoDiffPortalProjects.setPortalProjects(portalProjectSetDiffPortalProjects);
	}
	
		
	
	
	
	@Test
	public void getPortalApplicationTest() {
		assertThat(String.valueOf(this.applicationProjectsDto.getPortalApplication())).isEqualTo("PortalApplicationDto{id=1, name=\'null\', description=\'null\', displayOrder=null, baseUrl=\'null\'}"); 
	}
	
	@Test
	public void getPortalProjectsTest() {
		assertThat(String.valueOf(this.applicationProjectsDto.getPortalProjects())).isEqualTo("[com.qa.portal.application.dto.PortalProjectDto@f003f, com.qa.portal.application.dto.PortalProjectDto@e8be0]"); 
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.applicationProjectsDto.hashCode()).length()).isEqualTo(9);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.applicationProjectsDto.equals(applicationProjectsDto)).isEqualTo(true);
		assertThat(this.applicationProjectsDto.equals(applicationProjectsDtoNull)).isEqualTo(false);
		assertThat(this.applicationProjectsDto.equals(applicationProjectsDtoDiffClass)).isEqualTo(false);
		assertThat(this.applicationProjectsDto.equals(applicationProjectsDtoDiffPortalApplication)).isEqualTo(false);
		assertThat(this.applicationProjectsDto.equals(applicationProjectsDtoDiffPortalProjects)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat((this.applicationProjectsDto.toString())).isEqualTo("DepartmentApplicationsDto{department=PortalApplicationDto{id=1, name=\'null\', description=\'null\', displayOrder=null, baseUrl=\'null\'}, applications=[com.qa.portal.application.dto.PortalProjectDto@f003f, com.qa.portal.application.dto.PortalProjectDto@e8be0]}");
	}
}
