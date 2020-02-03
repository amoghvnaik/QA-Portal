import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpHeaders} from '@angular/common/http';
import {take} from 'rxjs/operators';
import {UserDetailsModel} from '../../../../../portal-core/src/app/_common/models/user-details.model';
import {UserModel} from '../../../../../portal-core/src/app/_common/models/user.model';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(
    private qaHttp: QaHttpService) {
  }

  getAllUsers(): Observable<UserDetailsModel[]> {
    return this.qaHttp.get<UserDetailsModel[]>({ ref: 'GET_ALL_USERS'}).pipe(
      take(1)
    );
  }

  deleteUsers(users: UserDetailsModel[]): Observable<any> {
    return this.qaHttp.put<any>({ ref: 'DELETE_USERS'}, users).pipe(
      take(1)
    );
  }

  addUser(user: UserModel): Observable<UserModel> {
    const userDetails = new UserDetailsModel();
    user.email = user.userName;
    userDetails.user = user;
    userDetails.roleNames = [user.role];
    return this.qaHttp.post<UserModel>({ ref: 'CREATE_USER'}, userDetails).pipe(
      take(1)
    );
  }

  updateUser(user: UserDetailsModel): Observable<UserDetailsModel> {
    return this.qaHttp.put<UserDetailsModel>({ ref: 'UPDATE_USER'}, user).pipe(
      take(1)
    );
  }

  getUserByUsername(username: string): Observable<UserDetailsModel> {
    return this.qaHttp.get<UserDetailsModel>({ ref: 'GET_USER_BY_USERNAME' , params: { username: username.toString() } }).pipe(take(1));
  }
}
