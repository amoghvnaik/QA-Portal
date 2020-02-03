package com.qa.portal.application.rest.unitTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.rest.ReferenceDataController;
import com.qa.portal.application.service.refdata.ReferenceDataService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceDataControllerUnitTest {

	@InjectMocks
	public ReferenceDataController referenceDataController;

	@Mock
	public ReferenceDataService referenceDataService;

	@Test
	public void getReferenceDataForCategoriesTest() {
		
	       Map<String, List<String>> testResult = new HashMap<String, List<String>>();

	        ArrayList<String> testlist1 = new ArrayList<String>();
	        testlist1.add("a1");
	        testlist1.add("a2");
	        testlist1.add("a3");

	        testResult.put("test list 1", testlist1);

	        ArrayList<String> testlist2 = new ArrayList<String>();
	        testlist2.add("b1");
	        testlist2.add("b2");

	        testResult.put("test list 1", testlist2 );

		Mockito.when(this.referenceDataService.getReferenceDataForCategories()).thenReturn(testResult); //Map<String, List<String>>

		assertThat(this.referenceDataController.getReferenceDataForCategories().getBody()).isEqualTo(testResult);//Map<String, List<String>>
		assertThat(this.referenceDataController.getReferenceDataForCategories().getStatusCodeValue()).isEqualTo(200);

	}

}
