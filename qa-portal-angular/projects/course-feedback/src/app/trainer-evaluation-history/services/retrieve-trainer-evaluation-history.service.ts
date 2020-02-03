import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {TrainerCourseHistoryModel} from '../models/trainer-course.history.model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class RetrieveTrainerEvaluationHistoryService {

  constructor(private qaHttp: QaHttpService) { }

  getEvalHistory(): Observable<TrainerCourseHistoryModel> {
    return this.qaHttp.get<TrainerCourseHistoryModel>({ref: 'GET_COHORT_COURSES_FOR_TRAINER'});
  }
}
