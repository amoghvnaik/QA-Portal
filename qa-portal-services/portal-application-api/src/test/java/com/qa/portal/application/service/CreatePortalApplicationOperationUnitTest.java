package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePortalApplicationOperationUnitTest {

	@InjectMocks
	CreatePortalApplicationOperation createPortalApplicationOperationl;
	
	@Mock
    public PortalApplicationRepository portalApplicationRepository;

	@Mock
    public BaseMapper baseMapper;
	
	@Test
	public void createPortalApplicationTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		
		
		
		assertThat(this.createPortalApplicationOperationl.createPortalApplication(portalApplicationDto)).isEqualTo(null);
	}
}
