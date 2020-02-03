package com.qa.portal.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
public class GetAllPortalApplicationOperationUnitTest {

	@InjectMocks
	GetAllPortalApplicationOperation getAllPortalApplicationOperation;

	@Mock
	public PortalApplicationRepository portalApplicationRepository;

	@Mock
	public BaseMapper baseMapper;

	@Test
	public void getAllPortalApplicationsTest(){
		List<PortalApplicationEntity> portalApplicationEntitys = new ArrayList<PortalApplicationEntity>();
		PortalApplicationEntity portalApplicationEntity = new PortalApplicationEntity();
		portalApplicationEntitys.add(portalApplicationEntity);
		List<PortalApplicationDto> PortalApplicationDtos = new ArrayList<PortalApplicationDto>();
		PortalApplicationDto portalApplicationDto = new PortalApplicationDto();
		PortalApplicationDtos.add(portalApplicationDto);
		
		Mockito.when(portalApplicationRepository.findAll()).thenReturn(portalApplicationEntitys);
		Mockito.when(baseMapper.mapObject(portalApplicationEntity, PortalApplicationDto.class)).thenReturn(portalApplicationDto);
		
		assertThat(this.getAllPortalApplicationOperation.getAllPortalApplications()).isEqualTo(PortalApplicationDtos);
	}
	
}










