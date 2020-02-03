import { Observable, of } from 'rxjs';
import { TrainerModel } from 'projects/portal-core/src/app/_common/models/trainer.model';
import { UserModel } from 'projects/portal-core/src/app/_common/models/user.model';
import { CohortModel } from 'projects/portal-core/src/app/_common/models/cohort.model';

export class MockCohortService {
  public searchCohorts(search: string): Observable<CohortModel[]> {
    return of([]);
  }

  public getCohortById(id: string | number): Observable<CohortModel> {
    return of(null);
  }

  public getAvailableTrainersForCohort(): Observable<TrainerModel[]> {
    return of([]);
  }

  public saveCohort(cohort: CohortModel): Observable<CohortModel> {
    return of(null);
  }

  public addCohort(cohort: CohortModel): Observable<CohortModel> {
    return of(null);
  }

  public getAvailableTraineesByCohortId(id): Observable<UserModel[]> {
    return of([]);
  }
}
