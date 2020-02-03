
import {Observable, of} from 'rxjs';
import { UserDetailsModel } from 'projects/portal-core/src/app/_common/models/user-details.model';
import { UserModel } from 'projects/portal-core/src/app/_common/models/user.model';

export class MockUserService {

  getAllUsers(): Observable<UserDetailsModel[]> {
    return of([]);
  }

  deleteUsers(users: UserDetailsModel[]): Observable<any> {
    return of([]);
  }

  addUser(user: UserModel): Observable<UserModel> {
    return of(null);
  }

  updateUser(user: UserDetailsModel): Observable<UserDetailsModel> {
    return of(null);
  }

  getUserByUsername(username: string): Observable<UserDetailsModel> {
    return of(null);
  }
}
