package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.dto.ProjectPageDto;

@SpringBootTest
public class ProjectPageDtoJavaUnitTest {

	
	@InjectMocks
	public ProjectPageDto projectPageDto = new ProjectPageDto();
	
	@Mock
	public ProjectPageDto projectPageDtoNull = null;
	public String projectPageDtoDiffClass = "this is a string";
	public ProjectPageDto projectPageDtoDiffId = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffName = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffURL = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffTooltip = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffLevel = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffDisplayOnMenu = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffIcon = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffPortalProjectName = new ProjectPageDto();
	public ProjectPageDto projectPageDtoDiffRoles = new ProjectPageDto();



	
	@Before
	public void setup() {
		this.projectPageDto.setDisplayOnMenu(true);
		this.projectPageDto.setIcon("test icon");
		this.projectPageDto.setId(1);
		this.projectPageDto.setLevel(1);
		this.projectPageDto.setName("test name");
		this.projectPageDto.setPortalProjectName("test project name");
		List<String> testList = new ArrayList<String>();
		testList.add("testRole1");
		testList.add("testRole2");
		this.projectPageDto.setRoles(testList);
		this.projectPageDto.setTooltip("test tooltip");
		this.projectPageDto.setUrl("test url");
		
		this.projectPageDtoDiffId.setDisplayOnMenu(true);
		this.projectPageDtoDiffId.setIcon("test icon");
		this.projectPageDtoDiffId.setId(2);
		this.projectPageDtoDiffId.setLevel(1);
		this.projectPageDtoDiffId.setName("test name");
		this.projectPageDtoDiffId.setPortalProjectName("test project name");
		List<String> testListId = new ArrayList<String>();
		testListId.add("testRole1");
		testListId.add("testRole2");
		this.projectPageDtoDiffId.setRoles(testListId);
		this.projectPageDtoDiffId.setTooltip("test tooltip");
		this.projectPageDtoDiffId.setUrl("test url");
		
		this.projectPageDtoDiffName.setDisplayOnMenu(true);
		this.projectPageDtoDiffName.setIcon("test icon");
		this.projectPageDtoDiffName.setId(1);
		this.projectPageDtoDiffName.setLevel(1);
		this.projectPageDtoDiffName.setName("diff test name");
		this.projectPageDtoDiffName.setPortalProjectName("test project name");
		List<String> testListName = new ArrayList<String>();
		testListName.add("testRole1");
		testListName.add("testRole2");
		this.projectPageDtoDiffName.setRoles(testListName);
		this.projectPageDtoDiffName.setTooltip("test tooltip");
		this.projectPageDtoDiffName.setUrl("test url");
		
		this.projectPageDtoDiffURL.setDisplayOnMenu(true);
		this.projectPageDtoDiffURL.setIcon("test icon");
		this.projectPageDtoDiffURL.setId(1);
		this.projectPageDtoDiffURL.setLevel(1);
		this.projectPageDtoDiffURL.setName("test name");
		this.projectPageDtoDiffURL.setPortalProjectName("test project name");
		List<String> testListURL = new ArrayList<String>();
		testListURL.add("testRole1");
		testListURL.add("testRole2");
		this.projectPageDtoDiffURL.setRoles(testListURL);
		this.projectPageDtoDiffURL.setTooltip("test tooltip");
		this.projectPageDtoDiffURL.setUrl("diff test url");
		
		this.projectPageDtoDiffTooltip.setDisplayOnMenu(true);
		this.projectPageDtoDiffTooltip.setIcon("test icon");
		this.projectPageDtoDiffTooltip.setId(1);
		this.projectPageDtoDiffTooltip.setLevel(1);
		this.projectPageDtoDiffTooltip.setName("test name");
		this.projectPageDtoDiffTooltip.setPortalProjectName("test project name");
		List<String> testListTooltip = new ArrayList<String>();
		testListTooltip.add("testRole1");
		testListTooltip.add("testRole2");
		this.projectPageDtoDiffTooltip.setRoles(testListTooltip);
		this.projectPageDtoDiffTooltip.setTooltip("diff test tooltip");
		this.projectPageDtoDiffTooltip.setUrl("test url");
		
		this.projectPageDtoDiffLevel.setDisplayOnMenu(true);
		this.projectPageDtoDiffLevel.setIcon("test icon");
		this.projectPageDtoDiffLevel.setId(1);
		this.projectPageDtoDiffLevel.setLevel(2);
		this.projectPageDtoDiffLevel.setName("test name");
		this.projectPageDtoDiffLevel.setPortalProjectName("test project name");
		List<String> testListLevel = new ArrayList<String>();
		testListLevel.add("testRole1");
		testListLevel.add("testRole2");
		this.projectPageDtoDiffLevel.setRoles(testListLevel);
		this.projectPageDtoDiffLevel.setTooltip("test tooltip");
		this.projectPageDtoDiffLevel.setUrl("test url");
		
		this.projectPageDtoDiffDisplayOnMenu.setDisplayOnMenu(false);
		this.projectPageDtoDiffDisplayOnMenu.setIcon("test icon");
		this.projectPageDtoDiffDisplayOnMenu.setId(1);
		this.projectPageDtoDiffDisplayOnMenu.setLevel(1);
		this.projectPageDtoDiffDisplayOnMenu.setName("test name");
		this.projectPageDtoDiffDisplayOnMenu.setPortalProjectName("test project name");
		List<String> testListDisplayOnMenu = new ArrayList<String>();
		testListDisplayOnMenu.add("testRole1");
		testListDisplayOnMenu.add("testRole2");
		this.projectPageDtoDiffDisplayOnMenu.setRoles(testListDisplayOnMenu);
		this.projectPageDtoDiffDisplayOnMenu.setTooltip("test tooltip");
		this.projectPageDtoDiffDisplayOnMenu.setUrl("test url");
		
		this.projectPageDtoDiffIcon.setDisplayOnMenu(true);
		this.projectPageDtoDiffIcon.setIcon("diff test icon");
		this.projectPageDtoDiffIcon.setId(1);
		this.projectPageDtoDiffIcon.setLevel(1);
		this.projectPageDtoDiffIcon.setName("test name");
		this.projectPageDtoDiffIcon.setPortalProjectName("test project name");
		List<String> testListIcon = new ArrayList<String>();
		testListIcon.add("testRole1");
		testListIcon.add("testRole2");
		this.projectPageDtoDiffIcon.setRoles(testListIcon);
		this.projectPageDtoDiffIcon.setTooltip("test tooltip");
		this.projectPageDtoDiffIcon.setUrl("test url");
		
		this.projectPageDtoDiffPortalProjectName.setDisplayOnMenu(true);
		this.projectPageDtoDiffPortalProjectName.setIcon("test icon");
		this.projectPageDtoDiffPortalProjectName.setId(1);
		this.projectPageDtoDiffPortalProjectName.setLevel(1);
		this.projectPageDtoDiffPortalProjectName.setName("test name");
		this.projectPageDtoDiffPortalProjectName.setPortalProjectName("diff test project name");
		List<String> testListPortalProjectName = new ArrayList<String>();
		testListPortalProjectName.add("testRole1");
		testListPortalProjectName.add("testRole2");
		this.projectPageDtoDiffPortalProjectName.setRoles(testListPortalProjectName);
		this.projectPageDtoDiffPortalProjectName.setTooltip("test tooltip");
		this.projectPageDtoDiffPortalProjectName.setUrl("test url");
		
		this.projectPageDtoDiffRoles.setDisplayOnMenu(true);
		this.projectPageDtoDiffRoles.setIcon("test icon");
		this.projectPageDtoDiffRoles.setId(1);
		this.projectPageDtoDiffRoles.setLevel(1);
		this.projectPageDtoDiffRoles.setName("test name");
		this.projectPageDtoDiffRoles.setPortalProjectName("test project name");
		List<String> testListRoles = new ArrayList<String>();
		testListRoles.add("diff testRole1");
		testListRoles.add("diff testRole2");
		this.projectPageDtoDiffRoles.setRoles(testListRoles);
		this.projectPageDtoDiffRoles.setTooltip("test tooltip");
		this.projectPageDtoDiffRoles.setUrl("test url");
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.projectPageDto.getId()).isEqualTo(1); 
		
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.projectPageDto.getName()).isEqualTo("test name"); 		
	}
	
	@Test
	public void getUrlTest() {
		assertThat(this.projectPageDto.getUrl()).isEqualTo("test url"); 		
	}
	
	@Test
	public void getToolTipTest() {
		assertThat(this.projectPageDto.getTooltip()).isEqualTo("test tooltip"); 		
	}

	@Test
	public void getLevelTest() {
		assertThat(this.projectPageDto.getLevel()).isEqualTo(1); 		
	}
	
	@Test
	public void getDisplayOnMenuTest() {
		assertThat(this.projectPageDto.getDisplayOnMenu()).isEqualTo(true); 		
	}
	
	@Test
	public void getIconTest() {
		assertThat(this.projectPageDto.getIcon()).isEqualTo("test icon"); 		
	}
	
	@Test
	public void getPortalProjectNameTest() {
		assertThat(this.projectPageDto.getPortalProjectName()).isEqualTo("test project name"); 		
	}
	
	@Test
	public void getRolesTest() {
		List<String> testResultList = new ArrayList<String>();
		testResultList.add("testRole1");
		testResultList.add("testRole2");
		assertThat(this.projectPageDto.getRoles()).isEqualTo(testResultList); 		
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.projectPageDto.equals(projectPageDto)).isEqualTo(true);
		assertThat(this.projectPageDto.equals(projectPageDtoNull)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffClass)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffId)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffName)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffURL)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffTooltip)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffLevel)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffDisplayOnMenu)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffIcon)).isEqualTo(false);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffPortalProjectName)).isEqualTo(true);
		assertThat(this.projectPageDto.equals(projectPageDtoDiffRoles)).isEqualTo(true);

	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.projectPageDto.hashCode()).length()).isEqualTo(10);
	}
}
