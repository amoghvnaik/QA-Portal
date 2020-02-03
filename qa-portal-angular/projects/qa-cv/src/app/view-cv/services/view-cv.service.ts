import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ICvModel} from '../../_common/models/qac-cv-db.model';
import {
  APPLICATION_PDF_CONTENT_TYPE
} from '../../_common/models/cv.constants';
import {take} from 'rxjs/operators';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class ViewCvService {


  constructor(private qaHttp: QaHttpService) {
  }

  /** GET cv by id. Will 404 if id not found */
  getCvForId(id: string): Observable<ICvModel> {
    return this.qaHttp.get<ICvModel>({ ref: 'GET_CV_FOR_ID', params: { id: id.toString() }}).pipe(
      take(1)
    );
  }

  getSkillsForTrainee(): Observable<any> {
    return this.qaHttp.get<any>({ ref: 'GET_SKILLS_FOR_TRAINEE'}).pipe(
      take(1)
    );
  }

  getCurrentCvForTrainee(): Observable<ICvModel> {
    return this.qaHttp.get<ICvModel>({ ref: 'GET_CURRENT_CV'}).pipe(
      take(1)
    );
  }

  displayPdf(cv: ICvModel) {
    return this.qaHttp.post<any>({ ref: 'GENERATE_CV'}, cv).subscribe((response) => {
      const file = new Blob([response], {type: APPLICATION_PDF_CONTENT_TYPE});
      const fileURL = URL.createObjectURL(file);
      window.open(fileURL, '_blank');
    });
  }

  // /** POST: add a new cv to the server */
  createCv(cv: ICvModel): Observable<ICvModel> {
    return this.qaHttp.post<ICvModel>({ ref: 'SAVE_CV_DATA'}, cv).pipe(
      take(1)
    );
  }

  /** PUT: update the cv on the server */
  updateCv(cv: ICvModel): Observable<ICvModel> {
    return this.qaHttp.put<ICvModel>({ ref: 'SAVE_CV_DATA'}, cv).pipe(
      take(1)
    );
  }
}
