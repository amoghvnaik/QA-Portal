package com.qa.portal.application.persistence.entity.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;

@SpringBootTest
public class PortalProjectEntityJavaUnitTest {

	@InjectMocks
	PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
	
	@Mock
	PortalProjectEntity portalProjectEntityNull = null;
	String portalProjectEntityDiffClass = "this is a string";
	PortalProjectEntity portalProjectEntityDiffId = new PortalProjectEntity();
	PortalProjectEntity portalProjectEntityDiffName = new PortalProjectEntity();
	PortalProjectEntity portalProjectEntityDiffProjectPages = new PortalProjectEntity();

	
	@Before
	public void setup() {
	this.portalProjectEntity.setId(1);
	this.portalProjectEntity.setName("test name");
	ProjectPageEntity projectPageEntity = new ProjectPageEntity();
	projectPageEntity.setId(1);
	List<ProjectPageEntity> projectPageList = new ArrayList<ProjectPageEntity>();
	projectPageList.add(projectPageEntity);
	this.portalProjectEntity.setProjectPages(projectPageList);
	
	this.portalProjectEntityDiffId.setId(2);
	this.portalProjectEntityDiffId.setName("test name");
	ProjectPageEntity projectPageEntity1 = new ProjectPageEntity();
	projectPageEntity1.setId(1);
	List<ProjectPageEntity> projectPageList1 = new ArrayList<ProjectPageEntity>();
	projectPageList1.add(projectPageEntity1);
	this.portalProjectEntityDiffId.setProjectPages(projectPageList1);
	
	this.portalProjectEntityDiffName.setId(1);
	this.portalProjectEntityDiffName.setName("diff test name");
	ProjectPageEntity projectPageEntity2 = new ProjectPageEntity();
	projectPageEntity2.setId(1);
	List<ProjectPageEntity> projectPageList2 = new ArrayList<ProjectPageEntity>();
	projectPageList2.add(projectPageEntity2);
	this.portalProjectEntityDiffName.setProjectPages(projectPageList2);
	
	this.portalProjectEntityDiffProjectPages.setId(1);
	this.portalProjectEntityDiffProjectPages.setName("test name");
	ProjectPageEntity projectPageEntity3 = new ProjectPageEntity();
	projectPageEntity3.setId(2);
	List<ProjectPageEntity> projectPageList3 = new ArrayList<ProjectPageEntity>();
	projectPageList3.add(projectPageEntity3);
	this.portalProjectEntityDiffProjectPages.setProjectPages(projectPageList3);
	
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.portalProjectEntity.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.portalProjectEntity.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getProjectPagesTest() {
		assertThat(String.valueOf(this.portalProjectEntity.getProjectPages())).isEqualTo("[ProjectPageEntity{id=1, name=\'null\', url=\'null\', tooltip=\'null\', icon=\'null\', portalProject=null, displayOnMenu=null}]"); 
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.portalProjectEntity.hashCode()).length()).isEqualTo(9);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.portalProjectEntity.equals(portalProjectEntity)).isEqualTo(true);
		assertThat(this.portalProjectEntity.equals(portalProjectEntityNull)).isEqualTo(false);
		assertThat(this.portalProjectEntity.equals(portalProjectEntityDiffClass)).isEqualTo(false);
		assertThat(this.portalProjectEntity.equals(portalProjectEntityDiffId)).isEqualTo(false);
		assertThat(this.portalProjectEntity.equals(portalProjectEntityDiffName)).isEqualTo(false);
		assertThat(this.portalProjectEntity.equals(portalProjectEntityDiffProjectPages)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat(String.valueOf(this.portalProjectEntity.toString())).isEqualTo("ApplicationEntity{id=1, name=\'test name\', menuItems=[ProjectPageEntity{id=1, name=\'null\', url=\'null\', tooltip=\'null\', icon=\'null\', portalProject=null, displayOnMenu=null}]}");
	}
}
