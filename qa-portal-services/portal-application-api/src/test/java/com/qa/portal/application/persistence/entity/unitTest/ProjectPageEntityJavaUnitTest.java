package com.qa.portal.application.persistence.entity.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;

@SpringBootTest
public class ProjectPageEntityJavaUnitTest {

	@InjectMocks
	ProjectPageEntity projectPageEntity = new ProjectPageEntity();
	
	@Mock
	ProjectPageEntity projectPageEntityNull = null;
	String projectPageEntityDiffClass = "this is a string";
	ProjectPageEntity projectPageEntityDiffId = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffName = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffUrl = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffTooltip = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffIcon = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffDisplayOnMenu = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffPortalProject = new ProjectPageEntity();
	ProjectPageEntity projectPageEntityDiffRoleProjectPages = new ProjectPageEntity();
	

	
	@Before
	public void setup() {
	this.projectPageEntity.setId(1);
	this.projectPageEntity.setName("test name");
	this.projectPageEntity.setUrl("test url");
	this.projectPageEntity.setTooltip("test tooltip");
	this.projectPageEntity.setIcon("test icon");
	this.projectPageEntity.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
	portalProjectEntity.setId(1);
	this.projectPageEntity.setPortalProject(portalProjectEntity);
	RoleProjectPageEntity roleProjectPageEntity1 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity2 = new RoleProjectPageEntity();
	roleProjectPageEntity1.setId(1);
	roleProjectPageEntity2.setId(1);
	List<RoleProjectPageEntity> roleProjectList = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList.add(roleProjectPageEntity1);
	roleProjectList.add(roleProjectPageEntity2);
	this.projectPageEntity.setRoleProjectPageEntities(roleProjectList);
	
	this.projectPageEntityDiffId.setId(2);
	this.projectPageEntityDiffId.setName("test name");
	this.projectPageEntityDiffId.setUrl("test url");
	this.projectPageEntityDiffId.setTooltip("test tooltip");
	this.projectPageEntityDiffId.setIcon("test icon");
	this.projectPageEntityDiffId.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity1 = new PortalProjectEntity();
	portalProjectEntity1.setId(1);
	this.projectPageEntityDiffId.setPortalProject(portalProjectEntity1);
	RoleProjectPageEntity roleProjectPageEntity3 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity4 = new RoleProjectPageEntity();
	roleProjectPageEntity3.setId(1);
	roleProjectPageEntity4.setId(1);
	List<RoleProjectPageEntity> roleProjectList1 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList1.add(roleProjectPageEntity3);
	roleProjectList1.add(roleProjectPageEntity4);
	this.projectPageEntityDiffId.setRoleProjectPageEntities(roleProjectList1);
	
	this.projectPageEntityDiffName.setId(1);
	this.projectPageEntityDiffName.setName("diff test name");
	this.projectPageEntityDiffName.setUrl("test url");
	this.projectPageEntityDiffName.setTooltip("test tooltip");
	this.projectPageEntityDiffName.setIcon("test icon");
	this.projectPageEntityDiffName.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity2 = new PortalProjectEntity();
	portalProjectEntity2.setId(1);
	this.projectPageEntityDiffName.setPortalProject(portalProjectEntity2);
	RoleProjectPageEntity roleProjectPageEntity5 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity6 = new RoleProjectPageEntity();
	roleProjectPageEntity5.setId(1);
	roleProjectPageEntity6.setId(1);
	List<RoleProjectPageEntity> roleProjectList2 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList2.add(roleProjectPageEntity5);
	roleProjectList2.add(roleProjectPageEntity6);
	this.projectPageEntityDiffName.setRoleProjectPageEntities(roleProjectList2);
	
	this.projectPageEntityDiffUrl.setId(1);
	this.projectPageEntityDiffUrl.setName("test name");
	this.projectPageEntityDiffUrl.setUrl("diff test url");
	this.projectPageEntityDiffUrl.setTooltip("test tooltip");
	this.projectPageEntityDiffUrl.setIcon("test icon");
	this.projectPageEntityDiffUrl.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity3 = new PortalProjectEntity();
	portalProjectEntity3.setId(1);
	this.projectPageEntityDiffUrl.setPortalProject(portalProjectEntity3);
	RoleProjectPageEntity roleProjectPageEntity7 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity8 = new RoleProjectPageEntity();
	roleProjectPageEntity7.setId(1);
	roleProjectPageEntity8.setId(1);
	List<RoleProjectPageEntity> roleProjectList3 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList3.add(roleProjectPageEntity7);
	roleProjectList3.add(roleProjectPageEntity8);
	this.projectPageEntityDiffUrl.setRoleProjectPageEntities(roleProjectList3);
	
	this.projectPageEntityDiffTooltip.setId(1);
	this.projectPageEntityDiffTooltip.setName("test name");
	this.projectPageEntityDiffTooltip.setUrl("test url");
	this.projectPageEntityDiffTooltip.setTooltip("diff test tooltip");
	this.projectPageEntityDiffTooltip.setIcon("test icon");
	this.projectPageEntityDiffTooltip.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity4 = new PortalProjectEntity();
	portalProjectEntity4.setId(1);
	this.projectPageEntityDiffTooltip.setPortalProject(portalProjectEntity4);
	RoleProjectPageEntity roleProjectPageEntity9 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity10 = new RoleProjectPageEntity();
	roleProjectPageEntity9.setId(1);
	roleProjectPageEntity10.setId(1);
	List<RoleProjectPageEntity> roleProjectList4 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList4.add(roleProjectPageEntity9);
	roleProjectList4.add(roleProjectPageEntity10);
	this.projectPageEntityDiffTooltip.setRoleProjectPageEntities(roleProjectList4);
	
	this.projectPageEntityDiffIcon.setId(1);
	this.projectPageEntityDiffIcon.setName("test name");
	this.projectPageEntityDiffIcon.setUrl("test url");
	this.projectPageEntityDiffIcon.setTooltip("test tooltip");
	this.projectPageEntityDiffIcon.setIcon("diff test icon");
	this.projectPageEntityDiffIcon.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity5 = new PortalProjectEntity();
	portalProjectEntity5.setId(1);
	this.projectPageEntityDiffIcon.setPortalProject(portalProjectEntity5);
	RoleProjectPageEntity roleProjectPageEntity11 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity12 = new RoleProjectPageEntity();
	roleProjectPageEntity11.setId(1);
	roleProjectPageEntity12.setId(1);
	List<RoleProjectPageEntity> roleProjectList5 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList5.add(roleProjectPageEntity11);
	roleProjectList5.add(roleProjectPageEntity12);
	this.projectPageEntityDiffIcon.setRoleProjectPageEntities(roleProjectList5);
	
	this.projectPageEntityDiffDisplayOnMenu.setId(1);
	this.projectPageEntityDiffDisplayOnMenu.setName("test name");
	this.projectPageEntityDiffDisplayOnMenu.setUrl("test url");
	this.projectPageEntityDiffDisplayOnMenu.setTooltip("test tooltip");
	this.projectPageEntityDiffDisplayOnMenu.setIcon("test icon");
	this.projectPageEntityDiffDisplayOnMenu.setDisplayOnMenu(false);
	PortalProjectEntity portalProjectEntity6 = new PortalProjectEntity();
	portalProjectEntity6.setId(1);
	this.projectPageEntityDiffDisplayOnMenu.setPortalProject(portalProjectEntity6);
	RoleProjectPageEntity roleProjectPageEntity13 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity14 = new RoleProjectPageEntity();
	roleProjectPageEntity13.setId(1);
	roleProjectPageEntity14.setId(1);
	List<RoleProjectPageEntity> roleProjectList6 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList6.add(roleProjectPageEntity13);
	roleProjectList6.add(roleProjectPageEntity14);
	this.projectPageEntityDiffDisplayOnMenu.setRoleProjectPageEntities(roleProjectList6);
	
	this.projectPageEntityDiffPortalProject.setId(1);
	this.projectPageEntityDiffPortalProject.setName("test name");
	this.projectPageEntityDiffPortalProject.setUrl("test url");
	this.projectPageEntityDiffPortalProject.setTooltip("test tooltip");
	this.projectPageEntityDiffPortalProject.setIcon("test icon");
	this.projectPageEntityDiffPortalProject.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity7 = new PortalProjectEntity();
	portalProjectEntity7.setId(2);
	this.projectPageEntityDiffPortalProject.setPortalProject(portalProjectEntity7);
	RoleProjectPageEntity roleProjectPageEntity15 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity16 = new RoleProjectPageEntity();
	roleProjectPageEntity15.setId(1);
	roleProjectPageEntity16.setId(1);
	List<RoleProjectPageEntity> roleProjectList7 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList7.add(roleProjectPageEntity15);
	roleProjectList7.add(roleProjectPageEntity16);
	this.projectPageEntityDiffPortalProject.setRoleProjectPageEntities(roleProjectList7);
	
	this.projectPageEntityDiffRoleProjectPages.setId(1);
	this.projectPageEntityDiffRoleProjectPages.setName("test name");
	this.projectPageEntityDiffRoleProjectPages.setUrl("test url");
	this.projectPageEntityDiffRoleProjectPages.setTooltip("test tooltip");
	this.projectPageEntityDiffRoleProjectPages.setIcon("test icon");
	this.projectPageEntityDiffRoleProjectPages.setDisplayOnMenu(true);
	PortalProjectEntity portalProjectEntity8 = new PortalProjectEntity();
	portalProjectEntity8.setId(1);
	this.projectPageEntityDiffRoleProjectPages.setPortalProject(portalProjectEntity8);
	RoleProjectPageEntity roleProjectPageEntity17 = new RoleProjectPageEntity();
	RoleProjectPageEntity roleProjectPageEntity18 = new RoleProjectPageEntity();
	roleProjectPageEntity17.setId(2);
	roleProjectPageEntity18.setId(2);
	List<RoleProjectPageEntity> roleProjectList8 = new ArrayList<RoleProjectPageEntity>(0);
	roleProjectList8.add(roleProjectPageEntity17);
	roleProjectList8.add(roleProjectPageEntity18);
	this.projectPageEntityDiffRoleProjectPages.setRoleProjectPageEntities(roleProjectList8);
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.projectPageEntity.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.projectPageEntity.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getUrlTest() {
		assertThat(this.projectPageEntity.getUrl()).isEqualTo("test url"); 
	}
	
	@Test
	public void getTooltipTest() {
		assertThat(this.projectPageEntity.getTooltip()).isEqualTo("test tooltip"); 
	}
	
	@Test
	public void getIconTest() {
		assertThat(this.projectPageEntity.getIcon()).isEqualTo("test icon"); 
	}
	
	@Test
	public void getDisplayOnMenuTest() {
		assertThat(this.projectPageEntity.getDisplayOnMenu()).isEqualTo(true); 
	}
	
	@Test
	public void getPortalProjectTest() {
		assertThat(this.projectPageEntity.getPortalProject().toString()).isEqualTo("ApplicationEntity{id=1, name=\'null\', menuItems=null}"); 
	}
	
	@Test
	public void getRoleProjectPageEntitiesTest() {
		assertThat(this.projectPageEntity.getRoleProjectPageEntities().toString()).isEqualTo("[DeptRoleMenuItem{id=1, departmentRole=null, menuItem=null}, DeptRoleMenuItem{id=1, departmentRole=null, menuItem=null}]"); 
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.projectPageEntity.hashCode()).length()).isEqualTo(9);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.projectPageEntity.equals(projectPageEntity)).isEqualTo(true);
		assertThat(this.projectPageEntity.equals(projectPageEntityNull)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffClass)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffId)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffName)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffUrl)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffTooltip)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffIcon)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffDisplayOnMenu)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffPortalProject)).isEqualTo(false);
		assertThat(this.projectPageEntity.equals(projectPageEntityDiffRoleProjectPages)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat(this.projectPageEntity.toString()).isEqualTo("ProjectPageEntity{id=1, name=\'test name\', url=\'test url\', tooltip=\'test tooltip\', icon=\'test icon\', portalProject=ApplicationEntity{id=1, name=\'null\', menuItems=null}, displayOnMenu=true}");
	}
}
