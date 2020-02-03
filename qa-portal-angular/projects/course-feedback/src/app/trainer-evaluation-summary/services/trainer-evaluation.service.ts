import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {TrainerEvaluationSummaryModel} from '../models/trainer-evaluation-summary.model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class TrainerEvaluationService {

  constructor(private qaHttp: QaHttpService) {
  }

  public getTrainerCourseEvaluationSummary(courseId): Observable<TrainerEvaluationSummaryModel> {
    return this.qaHttp.get<TrainerEvaluationSummaryModel>({ ref: 'GET_TRAINER_EVALUATION_SUMMARY', params: { courseId: courseId.toString() } });
  }
}
