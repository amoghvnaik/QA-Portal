package com.qa.portal.application.service.project.unitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.dto.PortalProjectDto;
import com.qa.portal.application.dto.ProjectPageDto;
import com.qa.portal.application.persistence.entity.PortalProjectEntity;
import com.qa.portal.application.persistence.entity.ProjectPageEntity;
import com.qa.portal.application.persistence.repository.PortalProjectRepository;
import com.qa.portal.application.service.page.mapper.ProjectPageMapper;
import com.qa.portal.application.service.project.CreatePortalProjectOperation;
import com.qa.portal.application.service.project.mapper.PortalProjectMapper;
import com.qa.portal.common.service.mapper.BaseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePortalProjectOperationTest {
	
	@InjectMocks
	public CreatePortalProjectOperation createPortalProjectOperation;

	@Mock
	public PortalProjectRepository portalProjectRepository;

	@Mock
	public PortalProjectMapper portalProjectMapper;
	
	@Mock
	public BaseMapper baseMapper;
	@Mock
	public ProjectPageMapper projectPageMapper;

	
	@Test
	public void createPortalProjectTest() {
		ProjectPageDto pageDto = new ProjectPageDto();
		pageDto.setDisplayOnMenu(true);
		pageDto.setIcon("icon");
		pageDto.setId(1);
		pageDto.setLevel(1);
		pageDto.setName("pname");
		pageDto.setPortalProjectName("p-p-name");
		List<String> dummyData = new ArrayList<String>();
		dummyData.add("a");
		dummyData.add("b");
		dummyData.add("c");
		pageDto.setRoles(dummyData);
		pageDto.setTooltip("tooltip");
		pageDto.setUrl("www.test.co.uk");
		
		PortalProjectDto portalDto = new PortalProjectDto();
		portalDto.setId(1);
		portalDto.setName("name");
		portalDto.setUrl("url");
		List<ProjectPageDto> pageDtoList = new ArrayList<ProjectPageDto>();
		pageDtoList.add(pageDto);
		portalDto.setProjectPages(pageDtoList);
		
		ProjectPageEntity projectPageEntity = new ProjectPageEntity();
		

		PortalProjectEntity portalProjectEntity = new PortalProjectEntity();
		portalProjectEntity.setId(1);
		portalProjectEntity.setName("ppname");
		List<ProjectPageEntity> projectPageEntityList = new ArrayList<ProjectPageEntity>();
		projectPageEntityList.add(projectPageEntity);
		portalProjectEntity.setProjectPages(projectPageEntityList);
		
		Mockito.when(portalProjectMapper.mapToNewPortalProjectEntity(portalDto)).thenReturn(portalProjectEntity);
		Mockito.when(portalProjectRepository.save(portalProjectEntity)).thenReturn(portalProjectEntity);
		Mockito.when(portalProjectMapper.mapToPortalProjectDto(portalProjectEntity)).thenReturn(portalDto);
		assertThat(createPortalProjectOperation.createPortalProject(portalDto)).isEqualTo(portalDto);
	}
	
}
