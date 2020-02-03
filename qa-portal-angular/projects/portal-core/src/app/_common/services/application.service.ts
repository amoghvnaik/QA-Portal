import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, combineLatest } from 'rxjs';
import { PortalApplicationProjectsModel } from '../models/portal-application-projects.model';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
import { QaHttpService } from './qa-http.service';

/**
 * ApplicationService provides top-level application services.
 *
 * @export
 */
@Injectable()
export class ApplicationService {
  /** All portal applications available to the current user. */
  public portalApplications$ = new BehaviorSubject<PortalApplicationProjectsModel[]>([]);
  /** The current portal application that the user is currently using. */
  public currentApplication$ = new BehaviorSubject<PortalApplicationProjectsModel>(null);

  constructor(
    private qaHttp: QaHttpService,
    private router: Router) { }

  /**
   * To be called ONCE when the QA Portal application has loaded.
   * This function kicks off various top-level subscriptions to control the state of the application.
   */
  public onApplicationLoaded(): void {
    this.getAllPortalApplications().subscribe(apps => this.portalApplications$.next(apps));

    // Combine emissions from portalApps and router events. We need to react whenever either one changes.
    combineLatest(
      this.portalApplications$,
      this.router.events.pipe(filter(e => e instanceof NavigationEnd)) // Filter out the events we don't care about
    ).subscribe(([apps, routerEvent]: [PortalApplicationProjectsModel[], NavigationEnd]) => {
      this.currentApplication$.next(this.getCurrentApplicationByRoute(apps, routerEvent));
    });
  }

  /** Filters apps and finds which app the user is currently in by comparing the route to each baseUrl. */
  private getCurrentApplicationByRoute(apps: PortalApplicationProjectsModel[], event: NavigationEnd) {
    return apps.find(app => event.urlAfterRedirects.startsWith(app.portalApplication.baseUrl));
  }

  /** Fetches all available portal applications for the current user. */
  private getAllPortalApplications(): Observable<PortalApplicationProjectsModel[]> {
    return this.qaHttp.get<PortalApplicationProjectsModel[]>({ ref: 'PORTAL_APPLICATIONS_API'});
  }
}
