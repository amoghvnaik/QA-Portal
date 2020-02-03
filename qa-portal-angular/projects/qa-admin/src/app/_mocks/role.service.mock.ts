import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { RoleModel } from 'projects/portal-core/src/app/_common/models/role.model';

export class MockRoleService {

  public getPortalRoleNames(): Observable<string[]> {
    return of([]);
  }

  public getPortalRoles(): Observable<RoleModel[]> {
    return of([]);
  }

  public getRoleById(id: string | number): Observable<RoleModel> {
    return of(null);
  }

  public saveRole(role: RoleModel): Observable<RoleModel> {
    return of(null);
  }

  public addRole(role: RoleModel): Observable<RoleModel> {
    return of(null);
  }
}
