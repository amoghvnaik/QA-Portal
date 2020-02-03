import { Observable, of } from 'rxjs';
import { PortalApplicationModel } from 'projects/portal-core/src/app/_common/models/portal-application.model';
import { PortalApplicationProjectsModel } from 'projects/portal-core/src/app/_common/models/portal-application-projects.model';
import { PortalProjectModel } from 'projects/portal-core/src/app/_common/models/portal-project.model';

export class MockApplicationService {
  public getAllApplications(): Observable<PortalApplicationModel[]> {
    return of([]);
  }

  public addApplication(app: PortalApplicationModel): Observable<PortalApplicationModel> {
    return of(null);
  }

  public getApplicationById(id: string | number): Observable<PortalApplicationProjectsModel> {
    return of(null);
  }

  public saveApplication(app: PortalApplicationModel): Observable<PortalApplicationModel> {
    return of(null);
  }

  public getAllProjects(): Observable<PortalProjectModel[]> {
    return of([]);
  }

  public addProject(project: PortalProjectModel): Observable<PortalProjectModel> {
    return of(null);
  }

  public getProjectById(id: string | number): Observable<PortalProjectModel> {
    return of(null);
  }

  public saveProject(project: PortalProjectModel): Observable<PortalProjectModel> {
    return of(null);
  }
}
