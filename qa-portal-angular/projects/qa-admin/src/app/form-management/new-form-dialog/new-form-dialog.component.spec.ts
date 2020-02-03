import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewFormDialogComponent } from './new-form-dialog.component';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatDialogModule, MatInputModule, MatDialogRef } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { MockMatDialogRef } from 'projects/portal-core/src/app/_mocks/mat-dialog-ref.mock';
import { FormService } from '../../_common/services/form.service';
import { MockFormService } from '../../_mocks/form.service.mock';

describe('NewFormDialogComponent', () => {
  let component: NewFormDialogComponent;
  let fixture: ComponentFixture<NewFormDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewFormDialogComponent, MockComponent(SpinnerOverlayComponent)],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatDialogModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: FormService, useClass: MockFormService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: MatDialogRef, useClass: MockMatDialogRef }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewFormDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
