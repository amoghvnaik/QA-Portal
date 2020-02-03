import { Observable, of } from 'rxjs';
import { LocationModel } from 'projects/portal-core/src/app/_common/models/location.model';

export class MockLocationService {
  public getAllLocations(): Observable<LocationModel[]> {
    return of([]);
  }

  public getLocationById(id: string | number): Observable<LocationModel> {
    return of(null);
  }

  public saveLocation(location: LocationModel): Observable<LocationModel> {
    return of(null);
  }

  public addLocation(location: LocationModel): Observable<LocationModel> {
    return of(null);
  }
}
