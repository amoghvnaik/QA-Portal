import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAppDialogComponent } from './new-app-dialog.component';
import { MockApplicationService } from '../../_mocks/application.service.mock';
import { ApplicationService } from '../../_common/services/application.service';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatDialogModule, MatInputModule, MatDialogRef } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { MockMatDialogRef } from 'projects/portal-core/src/app/_mocks/mat-dialog-ref.mock';

describe('NewAppDialogComponent', () => {
  let component: NewAppDialogComponent;
  let fixture: ComponentFixture<NewAppDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        NewAppDialogComponent,
        MockComponent(SpinnerOverlayComponent)
      ],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatDialogModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: ApplicationService, useClass: MockApplicationService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: MatDialogRef, useClass: MockMatDialogRef }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewAppDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
