import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserManagementComponent } from './user-management.component';
import { MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatDialogModule } from '@angular/material';
import { UserService } from '../_common/services/user.service';
import { MockUserService } from '../_mocks/user.service.mock';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';

describe('UserManagementConsoleComponent', () => {
  let component: UserManagementComponent;
  let fixture: ComponentFixture<UserManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        UserManagementComponent,
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
        { provide: UserService, useClass: MockUserService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
