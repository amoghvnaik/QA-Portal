import { Observable, of } from 'rxjs';
import { FormModel } from 'projects/portal-core/src/app/_common/models/form.model';

export class MockFormService {

    public getAllForms(): Observable<FormModel[]> {
        return of(null);
    }

    public addForm(form: any): Observable<FormModel> {
        return of(null);
    }

    public getFormById(id: string | number): Observable<FormModel> {
        return of(null);
    }

    public saveForm(form: FormModel): Observable<FormModel> {
        return of(null);
    }
}
