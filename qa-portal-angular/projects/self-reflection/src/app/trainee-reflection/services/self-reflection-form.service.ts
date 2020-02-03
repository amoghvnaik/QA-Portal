import {Injectable} from '@angular/core';
import {SelfReflectionFormModel} from '../../_common/models/self-reflection-form-model';
import {Observable} from 'rxjs';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class SelfReflectionFormService {

  constructor(private qaHttp: QaHttpService) { }

  public createSelfReflectionForm(form: SelfReflectionFormModel): Observable<SelfReflectionFormModel> {
    return this.qaHttp.post<SelfReflectionFormModel>({ ref: 'CREATE_SELF_REFLECTION_API'} , form);
  }

  public getSelfReflectionForm(formId: string): Observable<SelfReflectionFormModel> {
    return this.qaHttp.get<SelfReflectionFormModel>({ ref: 'GET_SELF_REFLECTION_API_BY_ID', params: { formId: formId.toString() } });
  }

  public getAllReflectionFormsForUser(): Observable<Set<SelfReflectionFormModel>> {
    return this.qaHttp.get<Set<SelfReflectionFormModel>>({ref: 'GET_SELF_REFLECTIONS_FOR_TRAINEE_API'});
  }

  public updateSelfReflectionForm(form: SelfReflectionFormModel): Observable<SelfReflectionFormModel> {
    return this.qaHttp.put<SelfReflectionFormModel>({ ref: 'UPDATE_SELF_REFLECTION_API'}, form);
  }
}
