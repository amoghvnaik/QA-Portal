import { BehaviorSubject } from 'rxjs';
import { PortalApplicationProjectsModel } from '../_common/models/portal-application-projects.model';

export class MockApplicationService {
  public portalApplications$ = new BehaviorSubject<PortalApplicationProjectsModel[]>([]);
  public currentApplication$ = new BehaviorSubject<PortalApplicationProjectsModel>(null);

  public onApplicationLoaded(): void { }
}
