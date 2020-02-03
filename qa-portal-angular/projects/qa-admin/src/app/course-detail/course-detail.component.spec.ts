import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseDetailComponent } from './course-detail.component';
import { CourseService } from '../_common/services/course.service';
import { MockCourseService } from '../_mocks/course.service.mock';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatOptionModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { QaToastrService } from 'projects/portal-core/src/app/_common/services/qa-toastr.service';
import { MockQaToastrService } from 'projects/portal-core/src/app/_mocks/qa-toastr.service.mock';
import { TechnologyService } from '../_common/technology.service';
import { MockTechnologyService } from '../_mocks/technology.service.mock';

describe('CourseDetailComponent', () => {
  let component: CourseDetailComponent;
  let fixture: ComponentFixture<CourseDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CourseDetailComponent,
        MockComponent(SpinnerOverlayComponent)
      ],
      imports: [
        RouterTestingModule,
        BrowserAnimationsModule,
        MatCardModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatOptionModule
      ],
      providers: [
        { provide: CourseService, useClass: MockCourseService },
        { provide: TechnologyService, useClass: MockTechnologyService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: QaToastrService, useClass: MockQaToastrService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
