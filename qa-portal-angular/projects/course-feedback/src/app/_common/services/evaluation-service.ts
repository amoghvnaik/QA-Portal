import { Injectable } from '@angular/core';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { Observable } from 'rxjs';
import { IFormModel } from 'projects/qa-forms/src/app/_common/models';
import {IFormService} from './iform.service';

@Injectable()
export class EvaluationService implements IFormService {

  constructor(private qaHttp: QaHttpService) { }

  public getForm(cohortCourseId: string): Observable<IFormModel> {
    return this.qaHttp.get<IFormModel>({ ref: 'GET_EVALUATION_FOR_TRAINEE_AND_COURSE', params : {cohortCourseId} });
  }

  public createForm(formModel: IFormModel): Observable<IFormModel> {
    return this.qaHttp.post<IFormModel>({ ref: 'CREATE_EVALUATION_FORM'}, formModel);
  }

  public updateForm(formModel: IFormModel): Observable<IFormModel> {
    return this.qaHttp.put<IFormModel>({ ref: 'UPDATE_EVALUATION_FORM'}, formModel);
  }
}
