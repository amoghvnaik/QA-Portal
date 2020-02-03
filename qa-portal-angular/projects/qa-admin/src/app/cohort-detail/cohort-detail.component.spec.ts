import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CohortDetailComponent } from './cohort-detail.component';
import { CohortService } from '../_common/services/cohort.service';
import { MockCohortService } from '../_mocks/cohort.service.mock';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatIconModule, MatListModule, DateAdapter, MatDatepickerModule, MatOptionModule, MatSelectModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { QaToastrService } from 'projects/portal-core/src/app/_common/services/qa-toastr.service';
import { MockQaToastrService } from 'projects/portal-core/src/app/_mocks/qa-toastr.service.mock';
import { CalendarModule } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { CourseService } from '../_common/services/course.service';
import { MockCourseService } from '../_mocks/course.service.mock';
import { LocationService } from '../_common/services/location.service';
import { MockLocationService } from '../_mocks/location.service.mock';

describe('CohortDetailComponent', () => {
  let component: CohortDetailComponent;
  let fixture: ComponentFixture<CohortDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CohortDetailComponent,
        MockComponent(SpinnerOverlayComponent)
      ],
      imports: [
        RouterTestingModule,
        BrowserAnimationsModule,
        MatCardModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        MatOptionModule,
        MatSelectModule,
        CalendarModule.forRoot({
          provide: DateAdapter,
          useFactory: adapterFactory
        })
      ],
      providers: [
        { provide: CohortService, useClass: MockCohortService },
        { provide: CourseService, useClass: MockCourseService },
        { provide: LocationService, useClass: MockLocationService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: QaToastrService, useClass: MockQaToastrService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CohortDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
