package com.qa.portal.application.service.project.mapper.unitTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.repository.PortalProjectRepository;
import com.qa.portal.application.service.page.mapper.ProjectPageMapper;
import com.qa.portal.application.service.project.mapper.PortalProjectMapper;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProjectMapperUnitTests {

	@InjectMocks
	PortalProjectMapper portalProjectMapper;
	
	@Mock
	public PortalProjectRepository portalProjectRepository;

	@Mock
    public ProjectPageMapper projectPageMapper;

	@Mock
    public BaseMapper baseMapper;
	
	@Test
	public void mapToPortalProjectDtoTest() {
		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		
		Mockito.when(baseMapper.mapObject(portalProjectEntity, PortalProjectDto.class)).thenReturn(portalProjectDto);
		
		assertThat(this.portalProjectMapper.mapToPortalProjectDto(portalProjectEntity)).isEqualTo(portalProjectDto);
	}
	
	@Test
	public void mapToUpdatedPortalProjectEntityTest() {
		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(123);
		List<ProjectPageEntity> projectPages = new ArrayList<ProjectPageEntity>();
		ProjectPageEntity ProjectPageEntity = new ProjectPageEntity();
		projectPages.add(ProjectPageEntity);
		portalProjectEntity.setProjectPages(projectPages );
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		portalProjectDto.setId(123);
		
		
		Mockito.when(portalProjectRepository.findById(portalProjectDto.getId())).thenReturn(Optional.of(portalProjectEntity));
		
		System.out.println(this.portalProjectMapper.mapToUpdatedPortalProjectEntity(portalProjectDto));
		
		assertThat(this.portalProjectMapper.mapToUpdatedPortalProjectEntity(portalProjectDto)).isEqualTo(portalProjectEntity);
	}
	
	@Test
	public void mapToNewPortalProjectEntityTest() {
		PortalProjectDto portalProjectDto = new PortalProjectDto();
		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();

		Mockito.when(baseMapper.mapObject(portalProjectDto, PortalProjectEntity.class)).thenReturn(portalProjectEntity);
		
		assertThat(this.portalProjectMapper.mapToNewPortalProjectEntity(portalProjectDto)).isEqualTo(portalProjectEntity);
	}
	
	
	
	
}








