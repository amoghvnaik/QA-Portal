
import {Observable, of} from 'rxjs';
import { TraineeEvaluationSummaryModel } from '../trainee-evaluation-summary/models/trainee-evaluation-summary.model';


export class MockTraineeEvaluationSummaryService {
  public getTraineeEvaluationSummary(): Observable<TraineeEvaluationSummaryModel> {
    return of(null);
  }
}
