package com.qa.portal.application.persistence.entity.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;

@SpringBootTest
public class RoleProjectPageEntityJavaUnitTest {
	
	@InjectMocks
	public RoleProjectPageEntity roleProjectPageEntity = new RoleProjectPageEntity();
	
	@Mock
	public RoleProjectPageEntity roleProjectPageEntityNull = null;
	public String roleProjectPageEntityDiffClass = "this is a string";
	public RoleProjectPageEntity roleProjectPageEntityDiffId = new RoleProjectPageEntity();
	public RoleProjectPageEntity roleProjectPageEntityDiffRole = new RoleProjectPageEntity();
	public RoleProjectPageEntity roleProjectPageEntityDiffProjectPage = new RoleProjectPageEntity();
	
	@Before
	public void setup() {
		this.roleProjectPageEntity.setId(1);
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(1);
		roleEntity.setName("test name");
		this.roleProjectPageEntity.setRole(roleEntity);
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		projectPageEntity.setId(1);
		this.roleProjectPageEntity.setProjectPage(projectPageEntity);
		
		this.roleProjectPageEntityDiffId.setId(2);
		RoleEntity roleEntity1 = new RoleEntity();
		roleEntity1.setId(1);
		roleEntity1.setName("test name");
		this.roleProjectPageEntityDiffId.setRole(roleEntity1);
		ProjectPageEntity projectPageEntity1 = new ProjectPageEntity();
		projectPageEntity1.setId(1);
		this.roleProjectPageEntityDiffId.setProjectPage(projectPageEntity1);
		
		this.roleProjectPageEntityDiffRole.setId(1);
		RoleEntity roleEntity2 = new RoleEntity();
		roleEntity1.setId(2);
		roleEntity1.setName("diff test name");
		this.roleProjectPageEntityDiffRole.setRole(roleEntity2);
		ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
		projectPageEntity2.setId(1);
		this.roleProjectPageEntityDiffRole.setProjectPage(projectPageEntity2);
		
		this.roleProjectPageEntityDiffProjectPage.setId(1);
		RoleEntity roleEntity3 = new RoleEntity();
		roleEntity3.setId(1);
		roleEntity3.setName("test name");
		this.roleProjectPageEntityDiffProjectPage.setRole(roleEntity3);
		ProjectPageEntity projectPageEntity3 = new ProjectPageEntity();
		projectPageEntity3.setId(2);
		this.roleProjectPageEntityDiffProjectPage.setProjectPage(projectPageEntity3);
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.roleProjectPageEntity.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getRoleTest() {
		assertThat(this.roleProjectPageEntity.getRole().toString()).isEqualTo("RoleEntity{id=1, name=\'test name\', portalApplication=null}");
	}
	
	@Test
	public void getProjectPageTest() {
		assertThat(this.roleProjectPageEntity.getProjectPage().toString()).isEqualTo("ProjectPageEntity{id=1, name=\'null\', url=\'null\', tooltip=\'null\', icon=\'null\', portalProject=null, displayOnMenu=null}");
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.roleProjectPageEntity.hashCode()).length()).isEqualTo(10);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntity)).isEqualTo(true);
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntityNull)).isEqualTo(false);
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntityDiffClass)).isEqualTo(false);
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntityDiffId)).isEqualTo(false);
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntityDiffRole)).isEqualTo(false);
		assertThat(this.roleProjectPageEntity.equals(roleProjectPageEntityDiffProjectPage)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat(this.roleProjectPageEntity.toString()).isEqualTo("DeptRoleMenuItem{id=1, departmentRole=RoleEntity{id=1, name=\'test name\', portalApplication=null}, menuItem=ProjectPageEntity{id=1, name=\'null\', url=\'null\', tooltip=\'null\', icon=\'null\', portalProject=null, displayOnMenu=null}}");
	}

}
