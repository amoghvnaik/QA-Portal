package com.qa.portal.application.scheduler.unitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.portal.application.scheduler.QaEmailScheduler;
import com.qa.portal.common.email.QaEmailClient;
import com.qa.portal.common.persistence.entity.CohortCourseEntity;
import com.qa.portal.common.persistence.entity.CourseEntity;
import com.qa.portal.common.persistence.entity.LocationEntity;
import com.qa.portal.common.persistence.entity.QaCohortEntity;
import com.qa.portal.common.persistence.entity.TraineeEntity;
import com.qa.portal.common.persistence.entity.TrainerEntity;
import com.qa.portal.common.persistence.repository.CohortCourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationSchedulerUnitTests {
	
	@InjectMocks
	public QaEmailScheduler qaEmailScheduler;
	
	@Mock
	public QaEmailClient qec;
	
	@Mock
	public CohortCourseEntity cce;
	
	@Test
	public void sendEvaluationFormEmailReminderTest() {
		CohortCourseRepository ccr = mock(CohortCourseRepository.class);
		
		Date startDate = new Date(15739060);
		Date endDate = new Date(15778404);
		LocalDate currentDate = LocalDate.now();
		
		CohortCourseEntity cce = new CohortCourseEntity();
		CourseEntity ce = new CourseEntity();
		TrainerEntity te = new TrainerEntity();
		QaCohortEntity qce = new QaCohortEntity();
		LocationEntity le = new LocationEntity();
		TraineeEntity tre = new TraineeEntity();
		TraineeEntity tre2 = mock(TraineeEntity.class);
		
		Set<QaCohortEntity> cohorts = new HashSet<QaCohortEntity>();
		Set<TraineeEntity> trainees = new HashSet<TraineeEntity>();
		
		ce.setId(2345);
		ce.setCourseName("Java99");
		ce.setCourseCode("J99ABC");
		ce.setDuration(600);
		ce.setCourseTechnologies(null);
		
		te.setCohorts(cohorts);
		
		qce.setId(391049);
		qce.setName("Software20");
		qce.setTrainees(trainees);
		qce.setTrainer(te);
		qce.addCohortCourse(cce);
		qce.setStartDate(startDate);
		
		le.setId(23141);
		le.setName("Address Test");
		le.setAddress("123 Street Street");
		
		cce.setId(12345);
		cce.setStartDate(startDate);
		cce.setEndDate(endDate);
		cce.setCourse(ce);
		cce.setTrainer(te);
		cce.setLocation(le);
		cce.setCohort(qce);
		
		tre.setId(12314);
		tre.setCohort(qce);
		tre.setFirstName("John");
		tre.setLastName("Smith");
		tre.setUserName("JohnnyBoy");
		
		trainees.add(tre);
		
		assertThat(tre.getUserName().equals("JohnnyBoy"));
		
		doThrow(IllegalArgumentException.class).when(tre2).setUserName(null);
		qec.sendEmail(null, "Course Evaluation", "Please fill in your course evaluation");
		
		qec.sendEmail(tre.getUserName(), "Course Evaluation", "Please fill in your course evaluation");
		
		assertThat(ccr.findByEndDate(Date.valueOf(currentDate)).equals(null));

	}

}
