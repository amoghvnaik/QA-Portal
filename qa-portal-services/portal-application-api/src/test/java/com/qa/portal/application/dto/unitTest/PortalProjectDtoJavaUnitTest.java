package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.dto.ProjectPageDto;

@SpringBootTest
public class PortalProjectDtoJavaUnitTest {
	
	@InjectMocks
	public PortalProjectDto portalProjectDto = new PortalProjectDto();
	
	@Mock
	public PortalProjectDto portalProjectDtoNull = null;
	public String portalProjectDtoDiffClass = "this is a string";
	public PortalProjectDto portalProjectDtoDiffId = new PortalProjectDto();
	public PortalProjectDto portalProjectDtoDiffName = new PortalProjectDto();
	public PortalProjectDto portalProjectDtoDiffURL = new PortalProjectDto();
	public PortalProjectDto portalProjectDtoDiffProjectPages = new PortalProjectDto();
	
	@Before
	public void setup() {
		this.portalProjectDto.setId(1);
		this.portalProjectDto.setName("test name");
		this.portalProjectDto.setUrl("test url");
		ProjectPageDto projectPageDto1 = new ProjectPageDto();
		ProjectPageDto projectPageDto2 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageList = new ArrayList<ProjectPageDto>();
		projectPageDto1.setDisplayOnMenu(true);
		projectPageDto1.setIcon("test icon");
		projectPageDto1.setId(1);
		projectPageDto1.setLevel(1);
		projectPageDto1.setName("test name");
		projectPageDto1.setPortalProjectName("test project name");
		List<String> testList1 = new ArrayList<String>();
		testList1.add("testRole11");
		testList1.add("testRole12");
		projectPageDto1.setRoles(testList1);
		projectPageDto1.setTooltip("test tooltip");
		projectPageDto1.setUrl("test url");
		projectPageDto2.setDisplayOnMenu(true);
		projectPageDto2.setIcon("test icon");
		projectPageDto2.setId(1);
		projectPageDto2.setLevel(1);
		projectPageDto2.setName("test name");
		projectPageDto2.setPortalProjectName("test project name");
		List<String> testList2 = new ArrayList<String>();
		testList2.add("testRole21");
		testList2.add("testRole22");
		projectPageDto2.setRoles(testList2);
		projectPageDto2.setTooltip("test tooltip");
		projectPageDto2.setUrl("test url");
		testProjectPageList.add(projectPageDto1);
		testProjectPageList.add(projectPageDto2);
		this.portalProjectDto.setProjectPages(testProjectPageList);
		
		this.portalProjectDtoDiffId.setId(2);
		this.portalProjectDtoDiffId.setName("test name");
		this.portalProjectDtoDiffId.setUrl("test url");
		ProjectPageDto projectPageDto3 = new ProjectPageDto();
		ProjectPageDto projectPageDto4 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageList1 = new ArrayList<ProjectPageDto>();
		projectPageDto3.setDisplayOnMenu(true);
		projectPageDto3.setIcon("test icon");
		projectPageDto3.setId(1);
		projectPageDto3.setLevel(1);
		projectPageDto3.setName("test name");
		projectPageDto3.setPortalProjectName("test project name");
		List<String> testList3 = new ArrayList<String>();
		testList3.add("testRole11");
		testList3.add("testRole12");
		projectPageDto3.setRoles(testList3);
		projectPageDto3.setTooltip("test tooltip");
		projectPageDto3.setUrl("test url");
		projectPageDto4.setDisplayOnMenu(true);
		projectPageDto4.setIcon("test icon");
		projectPageDto4.setId(1);
		projectPageDto4.setLevel(1);
		projectPageDto4.setName("test name");
		projectPageDto4.setPortalProjectName("test project name");
		List<String> testList4 = new ArrayList<String>();
		testList4.add("testRole21");
		testList4.add("testRole22");
		projectPageDto4.setRoles(testList4);
		projectPageDto4.setTooltip("test tooltip");
		projectPageDto4.setUrl("test url");
		testProjectPageList1.add(projectPageDto3);
		testProjectPageList1.add(projectPageDto4);
		this.portalProjectDtoDiffId.setProjectPages(testProjectPageList1);
		
		this.portalProjectDtoDiffName.setId(1);
		this.portalProjectDtoDiffName.setName("diff test name");
		this.portalProjectDtoDiffName.setUrl("test url");
		ProjectPageDto projectPageDto5 = new ProjectPageDto();
		ProjectPageDto projectPageDto6 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageList2 = new ArrayList<ProjectPageDto>();
		projectPageDto5.setDisplayOnMenu(true);
		projectPageDto5.setIcon("test icon");
		projectPageDto5.setId(1);
		projectPageDto5.setLevel(1);
		projectPageDto5.setName("test name");
		projectPageDto5.setPortalProjectName("test project name");
		List<String> testList5 = new ArrayList<String>();
		testList5.add("testRole11");
		testList5.add("testRole12");
		projectPageDto5.setRoles(testList5);
		projectPageDto5.setTooltip("test tooltip");
		projectPageDto5.setUrl("test url");
		projectPageDto6.setDisplayOnMenu(true);
		projectPageDto6.setIcon("test icon");
		projectPageDto6.setId(1);
		projectPageDto6.setLevel(1);
		projectPageDto6.setName("test name");
		projectPageDto6.setPortalProjectName("test project name");
		List<String> testList6 = new ArrayList<String>();
		testList6.add("testRole21");
		testList6.add("testRole22");
		projectPageDto6.setRoles(testList6);
		projectPageDto6.setTooltip("test tooltip");
		projectPageDto6.setUrl("test url");
		testProjectPageList2.add(projectPageDto5);
		testProjectPageList2.add(projectPageDto6);
		this.portalProjectDtoDiffName.setProjectPages(testProjectPageList2);
		
		this.portalProjectDtoDiffURL.setId(1);
		this.portalProjectDtoDiffURL.setName("test name");
		this.portalProjectDtoDiffURL.setUrl("diff test url");
		ProjectPageDto projectPageDto7 = new ProjectPageDto();
		ProjectPageDto projectPageDto8 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageList3 = new ArrayList<ProjectPageDto>();
		projectPageDto7.setDisplayOnMenu(true);
		projectPageDto7.setIcon("test icon");
		projectPageDto7.setId(1);
		projectPageDto7.setLevel(1);
		projectPageDto7.setName("test name");
		projectPageDto7.setPortalProjectName("test project name");
		List<String> testList7 = new ArrayList<String>();
		testList7.add("testRole11");
		testList7.add("testRole12");
		projectPageDto7.setRoles(testList7);
		projectPageDto7.setTooltip("test tooltip");
		projectPageDto7.setUrl("test url");
		projectPageDto8.setDisplayOnMenu(true);
		projectPageDto8.setIcon("test icon");
		projectPageDto8.setId(1);
		projectPageDto8.setLevel(1);
		projectPageDto8.setName("test name");
		projectPageDto8.setPortalProjectName("test project name");
		List<String> testList8 = new ArrayList<String>();
		testList8.add("testRole21");
		testList8.add("testRole22");
		projectPageDto8.setRoles(testList8);
		projectPageDto8.setTooltip("test tooltip");
		projectPageDto8.setUrl("test url");
		testProjectPageList3.add(projectPageDto7);
		testProjectPageList3.add(projectPageDto8);
		this.portalProjectDtoDiffURL.setProjectPages(testProjectPageList3);
		
		this.portalProjectDtoDiffProjectPages.setId(1);
		this.portalProjectDtoDiffURL.setName("test name");
		this.portalProjectDtoDiffURL.setUrl("test url");
		ProjectPageDto projectPageDto9 = new ProjectPageDto();
		ProjectPageDto projectPageDto10 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageList4 = new ArrayList<ProjectPageDto>();
		projectPageDto9.setDisplayOnMenu(false);
		projectPageDto9.setIcon("diff test icon");
		projectPageDto9.setId(2);
		projectPageDto9.setLevel(2);
		projectPageDto9.setName("diff test name");
		projectPageDto9.setPortalProjectName("diff test project name");
		List<String> testList9 = new ArrayList<String>();
		testList9.add("diff testRole11");
		testList9.add("diff testRole12");
		projectPageDto9.setRoles(testList9);
		projectPageDto9.setTooltip("diff test tooltip");
		projectPageDto9.setUrl("diff test url");
		projectPageDto10.setDisplayOnMenu(false);
		projectPageDto10.setIcon("diff test icon");
		projectPageDto10.setId(2);
		projectPageDto10.setLevel(2);
		projectPageDto10.setName("diff test name");
		projectPageDto10.setPortalProjectName("diff test project name");
		List<String> testList10 = new ArrayList<String>();
		testList10.add("diff testRole21");
		testList10.add("diff testRole22");
		projectPageDto10.setRoles(testList10);
		projectPageDto10.setTooltip("diff test tooltip");
		projectPageDto10.setUrl("diff test url");
		testProjectPageList4.add(projectPageDto9);
		testProjectPageList4.add(projectPageDto10);
		this.portalProjectDtoDiffURL.setProjectPages(testProjectPageList4);
	}
	
	
	@Test
	public void getIdTest() {
		assertThat(this.portalProjectDto.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.portalProjectDto.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getUrlTest() {
		assertThat(this.portalProjectDto.getUrl()).isEqualTo("test url"); 
	}
	
	@Test
	public void getProjectPagesTest() {
		ProjectPageDto projectPageDtoResult1 = new ProjectPageDto();
		ProjectPageDto projectPageDtoResult2 = new ProjectPageDto();
		List<ProjectPageDto> testProjectPageListResult = new ArrayList<ProjectPageDto>();
		projectPageDtoResult1.setDisplayOnMenu(true);
		projectPageDtoResult1.setIcon("test icon");
		projectPageDtoResult1.setId(1);
		projectPageDtoResult1.setLevel(1);
		projectPageDtoResult1.setName("test name");
		projectPageDtoResult1.setPortalProjectName("test project name");
		List<String> testList1 = new ArrayList<String>();
		testList1.add("testRole11");
		testList1.add("testRole12");
		projectPageDtoResult2.setRoles(testList1);
		projectPageDtoResult2.setTooltip("test tooltip");
		projectPageDtoResult2.setUrl("test url");
		projectPageDtoResult2.setDisplayOnMenu(true);
		projectPageDtoResult2.setIcon("test icon");
		projectPageDtoResult2.setId(1);
		projectPageDtoResult2.setLevel(1);
		projectPageDtoResult2.setName("test name");
		projectPageDtoResult2.setPortalProjectName("test project name");
		List<String> testList2 = new ArrayList<String>();
		testList2.add("testRole21");
		testList2.add("testRole22");
		projectPageDtoResult2.setRoles(testList2);
		projectPageDtoResult2.setTooltip("test tooltip");
		projectPageDtoResult2.setUrl("test url");
		testProjectPageListResult.add(projectPageDtoResult1);
		testProjectPageListResult.add(projectPageDtoResult2);
		this.portalProjectDto.setProjectPages(testProjectPageListResult);
		assertThat(this.portalProjectDto.getProjectPages()).isEqualTo(testProjectPageListResult); 
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.portalProjectDto.equals(portalProjectDto)).isEqualTo(true);
		assertThat(this.portalProjectDto.equals(portalProjectDtoNull)).isEqualTo(false);
		assertThat(this.portalProjectDto.equals(portalProjectDtoDiffClass)).isEqualTo(false);
		assertThat(this.portalProjectDto.equals(portalProjectDtoDiffId)).isEqualTo(false);
		assertThat(this.portalProjectDto.equals(portalProjectDtoDiffName)).isEqualTo(false);
		assertThat(this.portalProjectDto.equals(portalProjectDtoDiffURL)).isEqualTo(false);
		assertThat(this.portalProjectDto.equals(portalProjectDtoDiffProjectPages)).isEqualTo(false);
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.portalProjectDto.hashCode()).length()).isEqualTo(9);
	}
}


