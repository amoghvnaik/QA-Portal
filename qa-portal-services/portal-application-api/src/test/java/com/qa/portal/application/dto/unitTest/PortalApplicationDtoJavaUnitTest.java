package com.qa.portal.application.dto.unitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.portal.application.dto.PortalApplicationDto;

@SpringBootTest
public class PortalApplicationDtoJavaUnitTest {
	
	@InjectMocks
	public PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
	
	@Mock
	public PortalApplicationDto portalApplicationDtoNull = null;
	public String portalApplicationDtoDiffClass = "This is a string";
	public PortalApplicationDto portalApplicationDtoDiffId = new PortalApplicationDto();
	public PortalApplicationDto portalApplicationDtoDiffName = new PortalApplicationDto();
	public PortalApplicationDto portalApplicationDtoDiffDescription = new PortalApplicationDto();
	public PortalApplicationDto portalApplicationDtoDiffDisplayOrder = new PortalApplicationDto();
	public PortalApplicationDto portalApplicationDtoDiffBaseURL = new PortalApplicationDto();
	
	@Before
	public void setup() {
		this.portalApplicationDto.setName("test Name");
		this.portalApplicationDto.setId(1);
		this.portalApplicationDto.setDisplayOrder(1);
		this.portalApplicationDto.setDescription("test Description");
		this.portalApplicationDto.setBaseUrl("test URL");
		
		this.portalApplicationDtoDiffBaseURL.setName("test Name");
		this.portalApplicationDtoDiffBaseURL.setId(1);
		this.portalApplicationDtoDiffBaseURL.setDisplayOrder(1);
		this.portalApplicationDtoDiffBaseURL.setDescription("test Description");
		this.portalApplicationDtoDiffBaseURL.setBaseUrl("diff test URL");
		
		this.portalApplicationDtoDiffId.setName("test Name");
		this.portalApplicationDtoDiffId.setId(2);
		this.portalApplicationDtoDiffId.setDisplayOrder(1);
		this.portalApplicationDtoDiffId.setDescription("test Description");
		this.portalApplicationDtoDiffId.setBaseUrl("test URL");
		
		this.portalApplicationDtoDiffName.setName("diff test Name");
		this.portalApplicationDtoDiffName.setId(1);
		this.portalApplicationDtoDiffName.setDisplayOrder(1);
		this.portalApplicationDtoDiffName.setDescription("test Description");
		this.portalApplicationDtoDiffName.setBaseUrl("test URL");
		
		this.portalApplicationDtoDiffDisplayOrder.setName("test Name");
		this.portalApplicationDtoDiffDisplayOrder.setId(1);
		this.portalApplicationDtoDiffDisplayOrder.setDisplayOrder(2);
		this.portalApplicationDtoDiffDisplayOrder.setDescription("test Description");
		this.portalApplicationDtoDiffDisplayOrder.setBaseUrl("test URL");
		
		this.portalApplicationDtoDiffDescription.setName("test Name");
		this.portalApplicationDtoDiffDescription.setId(1);
		this.portalApplicationDtoDiffDescription.setDisplayOrder(1);
		this.portalApplicationDtoDiffDescription.setDescription("diff test Description");
		this.portalApplicationDtoDiffDescription.setBaseUrl("test URL");
	}
	
	
	@Test
	public void getIdTest() {
		assertThat(this.portalApplicationDto.getId()).isEqualTo(1); 
		
	}

	@Test
	public void getNameTest() {
		assertThat(this.portalApplicationDto.getName()).isEqualTo("test Name"); 
		
	}
	
	@Test
	public void getDisplayOrderTest() {
		assertThat(this.portalApplicationDto.getDisplayOrder()).isEqualTo(1); 
		
	}

	@Test
	public void getDescriptionTest() {
		assertThat(this.portalApplicationDto.getDescription()).isEqualTo("test Description"); 
		
	}

	@Test
	public void getBaseURLTest() {
		assertThat(this.portalApplicationDto.getBaseUrl()).isEqualTo("test URL"); 
		
	}
	
	@Test
	public void hashTest() {
		assertThat(String.valueOf(this.portalApplicationDto.hashCode()).length()).isEqualTo(9);
	}

	@Test
	public void ToStringTest() {
		assertThat(this.portalApplicationDto.toString()).isEqualTo("PortalApplicationDto{id=1, name=\'test Name\', description=\'test Description\', displayOrder=1, baseUrl=\'test URL\'}");
	}
	
	@Test
	public void equalsTest() {
		assertThat(this.portalApplicationDto.equals(portalApplicationDto)).isEqualTo(true);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoNull)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffClass)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffId)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffName)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffDescription)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffDisplayOrder)).isEqualTo(false);
		assertThat(this.portalApplicationDto.equals(portalApplicationDtoDiffBaseURL)).isEqualTo(false);
	}

	
}
