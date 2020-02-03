import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {QaCohortModel} from '../models/qa-cohort.model';
import {TraineeModel} from '../models/trainee.model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class CohortTraineesService {

  constructor(private qaHttp: QaHttpService) {
  }

  getCohort(): Observable<QaCohortModel> {
    return this.qaHttp.get<QaCohortModel>({ ref: 'GET_TRAINEE_COHORT'});
  }

  getCohorts(): Observable<QaCohortModel[]> {
    return this.qaHttp.get<QaCohortModel[]>({ ref: 'GET_USER_API_COHORTS'});
  }

  getTrainees(id: number): Observable<TraineeModel[]> {
    return this.qaHttp.get<TraineeModel[]>({ref: 'GET_USER_API_TRAINEES' , params: { id : id.toString() } });
  }

  getTraineesForReview(cohortId: number): Observable<TraineeModel[]> {
    return this.qaHttp.get<TraineeModel[]>({ref: 'GET_USER_API_TRAINEES_FOR_REVIEW' , params: { cohortId : cohortId.toString() }});
  }
}
