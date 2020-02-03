import {Injectable} from '@angular/core';
import {TraineeEvaluationSummaryModel} from '../models/trainee-evaluation-summary.model';
import {Observable} from 'rxjs';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class TraineeEvaluationSummaryService {

  constructor(private qaHttp: QaHttpService) {}

  public getTraineeEvaluationSummary(): Observable<TraineeEvaluationSummaryModel> {
    return this.qaHttp.get<TraineeEvaluationSummaryModel>({ ref: 'GET_TRAINEE_EVALUATION_SUMMARY'});
  }
}
