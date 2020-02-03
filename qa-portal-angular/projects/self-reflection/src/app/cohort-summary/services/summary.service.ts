import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class SummaryService {
  constructor(private qaHttp: QaHttpService) {
  }

  getSummary(): Observable<any> {
    return this.qaHttp.get({ref: 'GET_SELF_REFLECTION_SUMMARY'});
  }
}
