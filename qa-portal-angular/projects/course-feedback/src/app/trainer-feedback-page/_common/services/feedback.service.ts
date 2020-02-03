import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {IFormModel} from 'projects/qa-forms/src/app/_common/models';
import {IFormService} from '../../../_common/services/iform.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class FeedbackService implements IFormService {

  constructor(private qaHttp: QaHttpService) {
  }

  public getForm(courseId: string): Observable<IFormModel> {
    return this.qaHttp.get<IFormModel>({ ref: 'GET_FEEDBACK_FOR_COURSE', params: { courseId: courseId.toString() }});
  }

  public createForm(feedbackForm: IFormModel): Observable<IFormModel> {
    return this.qaHttp.post<IFormModel>({ ref: 'CREATE_FEEDBACK_FORM'}, feedbackForm);
  }

  public updateForm(feedbackForm: IFormModel): Observable<IFormModel> {
    return this.qaHttp.put<IFormModel>({ref: 'UPDATE_FEEDBACK_FORM'}, feedbackForm);
  }
}
