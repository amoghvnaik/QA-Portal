import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {SelfReflectionFormModel} from '../../_common/models/self-reflection-form-model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class ReflectionHistoryService {

    constructor(private qaHttp : QaHttpService){}

    public getTraineeReflections(): Observable<SelfReflectionFormModel[]> {
        return this.qaHttp.get<SelfReflectionFormModel[]>({ ref: 'GET_SELF_REFLECTIONS_FOR_TRAINEE_API'});
    }

}
