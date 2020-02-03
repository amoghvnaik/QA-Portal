import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { FilterModel } from '../models/filter-search-model';
import { FILTERS } from '../models/mock-filters';
import { catchError, map, tap } from 'rxjs/operators';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable()
export class CVSearchFilterService {

    constructor(private qaHttp: QaHttpService) { }

    private filterUrl = 'portal-application-api/referencedata';  // URL to web api

    /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

            // TODO: send the error to remote logging infrastructure
            console.error(error); // log to console instead

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }

    public getFiltersSearches(): Observable<FilterModel> {
        return of(FILTERS)
    }

    /* GET filter dropdowns */
    getFilters(): Observable<FilterModel> {

        return this.qaHttp.get<FilterModel>(`${this.filterUrl}`).pipe(

            catchError(this.handleError<FilterModel>('getFilters', {
                technology: [],
                cvStatus: [],
                cohort: []
            }))
        );
    }
}
