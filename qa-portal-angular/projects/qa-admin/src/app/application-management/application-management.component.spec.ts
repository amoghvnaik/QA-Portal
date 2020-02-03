import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationManagementComponent } from './application-management.component';
import { ApplicationService } from '../_common/services/application.service';
import { MockApplicationService } from '../_mocks/application.service.mock';
import { MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatDialogModule } from '@angular/material';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';

describe('ApplicationManagementComponent', () => {
  let component: ApplicationManagementComponent;
  let fixture: ComponentFixture<ApplicationManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ApplicationManagementComponent,
        MockComponents(
          SpinnerOverlayComponent,
          DataTableComponent
        )
      ],
      imports: [
        RouterTestingModule,
        MatIconModule,
        MatDialogModule
      ],
      providers: [
        { provide: ApplicationService, useClass: MockApplicationService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
