import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerFeedbackPageComponent } from './trainer-feedback-page.component';
import { MatProgressSpinnerModule } from '@angular/material';
import { MockComponents } from 'ng-mocks';
import { FormComponent } from 'projects/qa-forms';
import { FeedbackService } from './_common/services/feedback.service';
import { MockFeedbackService } from '../_mocks/feedback.service.mock';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { RouterTestingModule } from '@angular/router/testing';

describe('TrainerFeedbackPageComponent', () => {
  let component: TrainerFeedbackPageComponent;
  let fixture: ComponentFixture<TrainerFeedbackPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TrainerFeedbackPageComponent,
      MockComponents(FormComponent)],
      imports: [MatProgressSpinnerModule, RouterTestingModule],
      providers: [{ provide: FeedbackService, useClass: MockFeedbackService }, { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerFeedbackPageComponent);
    component = fixture.componentInstance;
    spyOn(component as any, 'initialiseForm').and.callFake(() => {});
    spyOn(component as any, 'clearSubscriptions').and.callFake(() => {});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect((component as any).initialiseForm).toHaveBeenCalled();
  });

  it('should clear subscriptions on ngOnDestroy', () => {
    component.ngOnDestroy();
    expect((component as any).clearSubscriptions).toHaveBeenCalled();
  });
});
