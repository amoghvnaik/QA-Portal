import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRoleDialogComponent } from './new-role-dialog.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatOptionModule, MatSelectModule, MatDialogModule, MatDialogRef, MatInputModule } from '@angular/material';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { RoleService } from '../../_common/services/role.service';
import { MockRoleService } from '../../_mocks/role.service.mock';
import { ApplicationService } from '../../_common/services/application.service';
import { MockApplicationService } from '../../_mocks/application.service.mock';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { MockMatDialogRef } from 'projects/portal-core/src/app/_mocks/mat-dialog-ref.mock';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('NewRoleDialogComponent', () => {
  let component: NewRoleDialogComponent;
  let fixture: ComponentFixture<NewRoleDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewRoleDialogComponent, MockComponent(SpinnerOverlayComponent)],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatOptionModule,
        MatSelectModule,
        MatDialogModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: RoleService, useClass: MockRoleService },
        { provide: ApplicationService, useClass: MockApplicationService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: MatDialogRef, useClass: MockMatDialogRef}
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRoleDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
