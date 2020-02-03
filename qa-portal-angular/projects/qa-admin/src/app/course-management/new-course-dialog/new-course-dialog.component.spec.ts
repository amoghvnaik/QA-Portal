import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCourseDialogComponent } from './new-course-dialog.component';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatDialogModule, MatInputModule, MatDialogRef, MatSelectModule, MatOptionModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { MockMatDialogRef } from 'projects/portal-core/src/app/_mocks/mat-dialog-ref.mock';
import { MockCourseService } from '../../_mocks/course.service.mock';
import { CourseService } from '../../_common/services/course.service';
import { TechnologyService } from '../../_common/technology.service';
import { MockTechnologyService } from '../../_mocks/technology.service.mock';

describe('NewCourseDialogComponent', () => {
  let component: NewCourseDialogComponent;
  let fixture: ComponentFixture<NewCourseDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        NewCourseDialogComponent,
        MockComponent(SpinnerOverlayComponent)
      ],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatDialogModule,
        MatInputModule,
        MatSelectModule,
        MatOptionModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: CourseService, useClass: MockCourseService },
        { provide: TechnologyService, useClass: MockTechnologyService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: MatDialogRef, useClass: MockMatDialogRef }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCourseDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
