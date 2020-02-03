import {Observable, of} from 'rxjs';
import {IFormModel} from 'projects/qa-forms/src/app/_common/models';

export class MockFeedbackService {

  public getForm(courseId: string): Observable<IFormModel> {
    return of(null);
  }
  public createForm(feedbackForm: IFormModel): Observable<IFormModel> {
    return of(null);
  }

  public updateForm(feedbackForm: IFormModel): Observable<IFormModel> {
    return of(null);
  }
}
