package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalApplicationDto;
import com.qa.portal.application.persistence.entity.PortalApplicationEntity;
import com.qa.portal.application.persistence.repository.PortalApplicationRepository;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatePortalApplicationOperationUnitTests {

	@InjectMocks
	UpdatePortalApplicationOperation updatePortalApplicationOperation;
	
	@Mock
    public PortalApplicationRepository portalApplicationRepository;

	@Mock
    public BaseMapper baseMapper;
	
	@Test
	public void updatePortalApplicationTest() {
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		portalApplicationDto.setId(123);
		PortalApplicationEntity portalApplicationEntity = new PortalApplicationEntity();
		portalApplicationEntity.setId(123);
		
		Mockito.when(portalApplicationRepository.findById(123)).thenReturn(Optional.of(portalApplicationEntity));
		Mockito.when(baseMapper.mapObject(portalApplicationEntity, PortalApplicationDto.class)).thenReturn(portalApplicationDto);
		
		System.out.println(this.updatePortalApplicationOperation.updatePortalApplication(portalApplicationDto));
		
		assertThat(this.updatePortalApplicationOperation.updatePortalApplication(portalApplicationDto)).isEqualTo(portalApplicationDto);
	}
}
