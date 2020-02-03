package com.qa.portal.application.persistence.entity.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.entity.RoleEntity;
import com.qa.portal.application.persistence.entity.RoleProjectPageEntity;

@SpringBootTest
public class RoleEntityJavaUnitTest {

	@InjectMocks
	public RoleEntity roleEntity = new RoleEntity();
	
	@Mock
	public RoleEntity roleEntityNull = null;
	public String roleEntityDiffClass = "this is a string";
	public RoleEntity roleEntityDiffId = new RoleEntity();
	public RoleEntity roleEntityDiffName = new RoleEntity();
	public RoleEntity roleEntityDiffPortalApplication = new RoleEntity();
	
	@Before
	public void setup() {
		this.roleEntity.setId(1);
		this.roleEntity.setName("test name");
		PortalApplicationEntity portalApplicationEntity1 = new PortalApplicationEntity();
		portalApplicationEntity1.setId(1);
		this.roleEntity.setPortalApplication(portalApplicationEntity1);
		RoleProjectPageEntity roleProjectPageEntity1 = new RoleProjectPageEntity();
		RoleProjectPageEntity roleProjectPageEntity2 = new RoleProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPages1 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntity1.setId(1);
		roleProjectPageEntity2.setId(1);
		roleProjectPages1.add(roleProjectPageEntity1);
		roleProjectPages1.add(roleProjectPageEntity2);
		this.roleEntity.setRoleProjectPages(roleProjectPages1);
		
		this.roleEntityDiffId.setId(2);
		this.roleEntityDiffId.setName("test name");
		PortalApplicationEntity portalApplicationEntity2 = new PortalApplicationEntity();
		portalApplicationEntity2.setId(1);
		this.roleEntityDiffId.setPortalApplication(portalApplicationEntity2);
		RoleProjectPageEntity roleProjectPageEntity3 = new RoleProjectPageEntity();
		RoleProjectPageEntity roleProjectPageEntity4 = new RoleProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPages2 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntity3.setId(1);
		roleProjectPageEntity4.setId(1);
		roleProjectPages2.add(roleProjectPageEntity3);
		roleProjectPages2.add(roleProjectPageEntity4);
		this.roleEntityDiffId.setRoleProjectPages(roleProjectPages2);
		
		this.roleEntityDiffName.setId(1);
		this.roleEntityDiffName.setName("diff test name");
		PortalApplicationEntity portalApplicationEntity3 = new PortalApplicationEntity();
		portalApplicationEntity3.setId(1);
		this.roleEntityDiffName.setPortalApplication(portalApplicationEntity3);
		RoleProjectPageEntity roleProjectPageEntity5 = new RoleProjectPageEntity();
		RoleProjectPageEntity roleProjectPageEntity6 = new RoleProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPages3 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntity5.setId(1);
		roleProjectPageEntity6.setId(1);
		roleProjectPages3.add(roleProjectPageEntity5);
		roleProjectPages3.add(roleProjectPageEntity6);
		this.roleEntityDiffName.setRoleProjectPages(roleProjectPages3);
		
		this.roleEntityDiffPortalApplication.setId(1);
		this.roleEntityDiffPortalApplication.setName("test name");
		PortalApplicationEntity portalApplicationEntity4 = new PortalApplicationEntity();
		portalApplicationEntity4.setId(2);
		this.roleEntityDiffPortalApplication.setPortalApplication(portalApplicationEntity4);
		RoleProjectPageEntity roleProjectPageEntity7 = new RoleProjectPageEntity();
		RoleProjectPageEntity roleProjectPageEntity8 = new RoleProjectPageEntity();
		List<RoleProjectPageEntity> roleProjectPages4 = new ArrayList<RoleProjectPageEntity>();
		roleProjectPageEntity7.setId(1);
		roleProjectPageEntity8.setId(1);
		roleProjectPages4.add(roleProjectPageEntity7);
		roleProjectPages4.add(roleProjectPageEntity8);
		this.roleEntityDiffPortalApplication.setRoleProjectPages(roleProjectPages4);
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.roleEntity.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.roleEntity.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getPortalApplicationTest() {
		assertThat(this.roleEntity.getPortalApplication().toString()).isEqualTo("PortalApplicationEntity{id=1, name=\'null\', description=\'null\', displayOrder=null, baseUrl=\'null\'}"); 
	}
	
	@Test
	public void getRoleProjectPagesTest() {
		assertThat(this.roleEntity.getRoleProjectPages().toString()).isEqualTo("[DeptRoleMenuItem{id=1, departmentRole=null, menuItem=null}, DeptRoleMenuItem{id=1, departmentRole=null, menuItem=null}]"); 
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.roleEntity.hashCode()).length()).isEqualTo(9);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.roleEntity.equals(roleEntity)).isEqualTo(true);
		assertThat(this.roleEntity.equals(roleEntityNull)).isEqualTo(false);
		assertThat(this.roleEntity.equals(roleEntityDiffClass)).isEqualTo(false);
		assertThat(this.roleEntity.equals(roleEntityDiffId)).isEqualTo(false);
		assertThat(this.roleEntity.equals(roleEntityDiffName)).isEqualTo(false);
		assertThat(this.roleEntity.equals(roleEntityDiffPortalApplication)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat(this.roleEntity.toString()).isEqualTo("RoleEntity{id=1, name='test name', portalApplication=PortalApplicationEntity{id=1, name='null', description='null', displayOrder=null, baseUrl='null'}}");
	}
}
