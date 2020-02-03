import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ReflectionModel} from '../models/dto/reflection.model';
import {take} from 'rxjs/operators';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class TrainerReflectionService {

  constructor(private qaHttp: QaHttpService) {
  }

  public getSelfReflectionsForTraineeDescendingDate(traineeId: number): Observable<ReflectionModel[]> {
    return this.qaHttp.get<ReflectionModel[]>({ ref: 'GET_SELF_REFLECTION_TRAINEE_BY_ID' , params: { traineeId: traineeId.toString()}}).pipe(
      take(1)
    );
  }

  public saveSelfReflectionForm(selfReflectionForm: ReflectionModel): Observable<ReflectionModel> {
    return this.qaHttp.put<ReflectionModel>({ ref: 'SAVE_REFLECTION_FORM'} , selfReflectionForm).pipe(
      take(1)
    );
  }
}
