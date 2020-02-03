import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TraineeCourseEvaluationComponent } from './trainee-course-evaluation.component';
import { MatIconModule, MatRadioModule, MatProgressSpinnerModule, MatDialogModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from "@angular/common/http/testing";
import { RouterTestingModule } from "@angular/router/testing";
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { EvaluationService } from '../_common/services/evaluation-service';
import { QaErrorHandlerService } from '../../../../portal-core/src/app/_common/services/qa-error-handler.service';
import { QaToastrService } from '../../../../portal-core/src/app/_common/services/qa-toastr.service';
import { ToastrModule } from 'ngx-toastr';

describe('FeedbackPageComponent', () => {
  let component: TraineeCourseEvaluationComponent;
  let fixture: ComponentFixture<TraineeCourseEvaluationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      providers: [ EvaluationService, QaErrorHandlerService, QaToastrService],
      declarations: [ TraineeCourseEvaluationComponent ],
      imports: [
        MatIconModule,
        MatDialogModule,
        MatRadioModule,
        FormsModule,
        MatProgressSpinnerModule, 
        HttpClientTestingModule,
        RouterTestingModule,
        ToastrModule.forRoot(),
      ],
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TraineeCourseEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
