package com.qa.portal.application.persistence.entity.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.persistence.entity.PortalApplicationEntity;

@SpringBootTest
public class PortalApplicationEntityJavaUnitTest {
	
	@InjectMocks
	public PortalApplicationEntity portalApplicationEntity = new PortalApplicationEntity();
	
	@Mock
	public PortalApplicationEntity portalApplicationEntityNull = null;
	public String portalApplicationEntityDiffClass = "this is a string";
	public PortalApplicationEntity portalApplicationEntityDiffId = new PortalApplicationEntity();
	public PortalApplicationEntity portalApplicationEntityDiffName = new PortalApplicationEntity();
	public PortalApplicationEntity portalApplicationEntityDiffDescription = new PortalApplicationEntity();
	public PortalApplicationEntity portalApplicationEntityDiffDisplayOrder = new PortalApplicationEntity();
	public PortalApplicationEntity portalApplicationEntityDiffBaseUrl = new PortalApplicationEntity();

	@Before
	public void setup() {
		this.portalApplicationEntity.setId(1);
		this.portalApplicationEntity.setName("test name");
		this.portalApplicationEntity.setDescription("test description");
		this.portalApplicationEntity.setDisplayOrder(1);
		this.portalApplicationEntity.setBaseUrl("test url");
		
		this.portalApplicationEntityDiffId.setId(2);
		this.portalApplicationEntityDiffId.setName("test name");
		this.portalApplicationEntityDiffId.setDescription("test description");
		this.portalApplicationEntityDiffId.setDisplayOrder(1);
		this.portalApplicationEntityDiffId.setBaseUrl("test url");
		
		this.portalApplicationEntityDiffName.setId(1);
		this.portalApplicationEntityDiffName.setName("diff test name");
		this.portalApplicationEntityDiffName.setDescription("test description");
		this.portalApplicationEntityDiffName.setDisplayOrder(1);
		this.portalApplicationEntityDiffName.setBaseUrl("test url");
		
		this.portalApplicationEntityDiffDescription.setId(1);
		this.portalApplicationEntityDiffDescription.setName("test name");
		this.portalApplicationEntityDiffDescription.setDescription("diff test description");
		this.portalApplicationEntityDiffDescription.setDisplayOrder(1);
		this.portalApplicationEntityDiffDescription.setBaseUrl("test url");
		
		this.portalApplicationEntityDiffDisplayOrder.setId(1);
		this.portalApplicationEntityDiffDisplayOrder.setName("test name");
		this.portalApplicationEntityDiffDisplayOrder.setDescription("test description");
		this.portalApplicationEntityDiffDisplayOrder.setDisplayOrder(2);
		this.portalApplicationEntityDiffDisplayOrder.setBaseUrl("test url");
		
		this.portalApplicationEntityDiffBaseUrl.setId(1);
		this.portalApplicationEntityDiffBaseUrl.setName("test name");
		this.portalApplicationEntityDiffBaseUrl.setDescription("test description");
		this.portalApplicationEntityDiffBaseUrl.setDisplayOrder(1);
		this.portalApplicationEntityDiffBaseUrl.setBaseUrl("diff test url");
	}
	
	@Test
	public void getIdTest() {
		assertThat(this.portalApplicationEntity.getId()).isEqualTo(1); 
	}
	
	@Test
	public void getNameTest() {
		assertThat(this.portalApplicationEntity.getName()).isEqualTo("test name"); 
	}
	
	@Test
	public void getDescriptionTest() {
		assertThat(this.portalApplicationEntity.getDescription()).isEqualTo("test description"); 
	}
	
	@Test
	public void getDisplayOrderTest() {
		assertThat(this.portalApplicationEntity.getDisplayOrder()).isEqualTo(1); 
	}
	
	@Test
	public void getBaseUrlTest() {
		assertThat(this.portalApplicationEntity.getBaseUrl()).isEqualTo("test url"); 
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.portalApplicationEntity.hashCode()).length()).isEqualTo(11);
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntity)).isEqualTo(true);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityNull)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffClass)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffId)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffName)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffDescription)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffDisplayOrder)).isEqualTo(false);
		assertThat(this.portalApplicationEntity.equals(portalApplicationEntityDiffBaseUrl)).isEqualTo(false);
	}
	
	@Test
	public void toStringTest() {
		assertThat(this.portalApplicationEntity.toString()).isEqualTo("PortalApplicationEntity{id=1, name=\'test name\', description=\'test description\', displayOrder=1, baseUrl=\'test url\'}");
	}

}
