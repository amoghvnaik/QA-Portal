import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleManagementComponent } from './role-management.component';
import { MockComponent, MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { MatIconModule, MatDialogRef, MatDialogModule } from '@angular/material';
import { RoleService } from '../_common/services/role.service';
import { MockRoleService } from '../_mocks/role.service.mock';
import { RouterTestingModule } from '@angular/router/testing';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';

describe('RoleManagementComponent', () => {
  let component: RoleManagementComponent;
  let fixture: ComponentFixture<RoleManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        RoleManagementComponent,
        MockComponents(
          SpinnerOverlayComponent,
          DataTableComponent,
        )
      ],
      imports: [
        RouterTestingModule,
        MatIconModule,
        MatDialogModule
      ],
      providers: [
        { provide: RoleService, useClass: MockRoleService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoleManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
