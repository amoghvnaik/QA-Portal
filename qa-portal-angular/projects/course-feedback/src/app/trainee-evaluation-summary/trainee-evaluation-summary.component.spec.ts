import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TraineeEvaluationSummaryComponent } from './trainee-evaluation-summary.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatProgressSpinnerModule, MatCardModule, MatTableModule } from '@angular/material';
import { TraineeEvaluationSummaryService } from './services/trainee-evaluation-summary.service';
import { MockTraineeEvaluationSummaryService } from '../_mocks/trainee-evaluation-summary.service.mock';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { of, throwError } from 'rxjs';
import { delay } from 'rxjs/operators';
import { HttpErrorResponse } from '@angular/common/http';

describe('TraineeEvaluationSummaryComponent', () => {
  let component: TraineeEvaluationSummaryComponent;
  let fixture: ComponentFixture<TraineeEvaluationSummaryComponent>;
  let traineeEvaluationSummaryService: TraineeEvaluationSummaryService
  let errorHandlerService: QaErrorHandlerService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TraineeEvaluationSummaryComponent],
      imports: [
        RouterTestingModule,
        MatProgressSpinnerModule,
        MatCardModule,
        MatTableModule
      ],
      providers: [
        {
          provide: TraineeEvaluationSummaryService,
          useClass: MockTraineeEvaluationSummaryService
        },
        {
          provide: QaErrorHandlerService,
          useClass: MockQaErrorHandlerService
        }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TraineeEvaluationSummaryComponent);
    component = fixture.componentInstance;
    traineeEvaluationSummaryService = TestBed.get(TraineeEvaluationSummaryService);
    errorHandlerService = TestBed.get(QaErrorHandlerService);

    // SETUP SERVICE CALLS
    traineeEvaluationSummaryService.getTraineeEvaluationSummary = () => {
      return of({ evaluationSummaryRows: [] });
    };

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should tidy up when destroying the component', () => {
    component.getEvaluationSummarySubscription = of(null).pipe(delay(1000)).subscribe(); // Make a long lived subscription
    spyOn(component.getEvaluationSummarySubscription, 'unsubscribe').and.callThrough();
    component.ngOnDestroy()
    expect(component.getEvaluationSummarySubscription.unsubscribe).toHaveBeenCalledTimes(1);
  });

  it('shouldn\'t fail cleaning up if a subscription doesn\'t exist', () => {
    component.getEvaluationSummarySubscription = of(null).subscribe(); // Make a fake subscription that immediately completes
    spyOn(component.getEvaluationSummarySubscription, 'unsubscribe').and.callThrough();
    component.ngOnDestroy();
    expect(component.getEvaluationSummarySubscription.unsubscribe).not.toHaveBeenCalled();
  });

  it('should return url + id', () => {
    expect(component.getEvaluationUrl("5")).toEqual("/qa/portal/training/feedback/trainee/evaluation/5");
  });

  it('sanity checks', () => {
    expect(component.displayedColumns).toEqual(['course', 'start', 'end', 'courseid', 'status']);
  });

  it('should check error return options', () => {
    expect(component.getEvaluationUrl("5")).toEqual("/qa/portal/training/feedback/trainee/evaluation/5");
  });

  it('should handle errors gracefully on init', done => {
    traineeEvaluationSummaryService.getTraineeEvaluationSummary = () => {
      return throwError(new HttpErrorResponse({error: 'dummy error'}));
    };

    spyOn(errorHandlerService, 'handleError').and.callFake((error: HttpErrorResponse) => {
      expect(error.error).toEqual('dummy error');
      done();
    });
    
    component.ngOnInit();
    expect(errorHandlerService.handleError).toHaveBeenCalledTimes(1);

  });

});
