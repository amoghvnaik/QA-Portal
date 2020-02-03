import { Observable, of } from 'rxjs';
import { HttpUrlDefinition, HttpOptions } from '../_common/services/qa-http.service';


export class MockQaHttpService {
  public get<T>(url: string | HttpUrlDefinition, options?: HttpOptions): Observable<T> {
    return of(null);
  }

  public post<T>(url: string | HttpUrlDefinition, body: any, options?: HttpOptions): Observable<T> {
    return of(null);
  }

  public put<T>(url: string | HttpUrlDefinition, body: any, options?: HttpOptions): Observable<T> {
    return of(null);
  }

  public patch<T>(url: string | HttpUrlDefinition, body: any, options?: HttpOptions): Observable<T> {
    return of(null);
  }

  public delete<T>(url: string | HttpUrlDefinition, options?: HttpOptions): Observable<T> {
    return of(null);
  }
}
