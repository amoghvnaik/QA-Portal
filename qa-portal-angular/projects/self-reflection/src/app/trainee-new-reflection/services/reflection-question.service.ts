import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {QuestionModel} from '../../_common/models/question.model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class ReflectionQuestionService {

  constructor(private qaHttp: QaHttpService) {
  }

  public getQuestionsByFormType(formType: string): Observable<QuestionModel[]> {
    return this.qaHttp.get<QuestionModel[]>({ ref: 'GET_FORM_TYPE_QUESTIONS', params: { formType } });
  }
}
