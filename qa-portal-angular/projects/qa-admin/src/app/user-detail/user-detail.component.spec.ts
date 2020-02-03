import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDetailComponent } from './user-detail.component';
import { UserService } from '../_common/services/user.service';
import { MockUserService } from '../_mocks/user.service.mock';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatIconModule, MatListModule, MatSelectModule, MatOptionModule } from '@angular/material';
import { ReactiveFormsModule } from '@angular/forms';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { QaToastrService } from 'projects/portal-core/src/app/_common/services/qa-toastr.service';
import { MockQaToastrService } from 'projects/portal-core/src/app/_mocks/qa-toastr.service.mock';
import { RoleService } from '../_common/services/role.service';
import { MockRoleService } from '../_mocks/role.service.mock';

describe('UserDetailComponent', () => {
  let component: UserDetailComponent;
  let fixture: ComponentFixture<UserDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UserDetailComponent,
        MockComponent(SpinnerOverlayComponent)
      ],
      imports: [
        RouterTestingModule,
        BrowserAnimationsModule,
        MatCardModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        ReactiveFormsModule,
        MatSelectModule,
        MatOptionModule
      ],
      providers: [
        { provide: UserService, useClass: MockUserService },
        { provide: RoleService, useClass: MockRoleService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: QaToastrService, useClass: MockQaToastrService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
