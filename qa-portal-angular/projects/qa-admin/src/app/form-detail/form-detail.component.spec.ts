import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDetailComponent } from './form-detail.component';
import { FormService } from '../_common/services/form.service';
import { MockFormService } from '../_mocks/form.service.mock';
import { MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatOptionModule, MatChipsModule, MatCheckboxModule, MatIconModule } from '@angular/material';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { QaToastrService } from 'projects/portal-core/src/app/_common/services/qa-toastr.service';
import { MockQaToastrService } from 'projects/portal-core/src/app/_mocks/qa-toastr.service.mock';
import { ListComponent } from 'projects/qa-common/src/app/list/list.component';
import { ApplicationService } from '../_common/services/application.service';
import { MockApplicationService } from '../_mocks/application.service.mock';

describe('FormDetailComponent', () => {
  let component: FormDetailComponent;
  let fixture: ComponentFixture<FormDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormDetailComponent,
        MockComponents(SpinnerOverlayComponent, ListComponent)
      ],
      imports: [
        RouterTestingModule,
        FormsModule,
        BrowserAnimationsModule,
        MatCardModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatChipsModule,
        MatCheckboxModule,
        MatSelectModule,
        MatOptionModule,
        MatIconModule
      ],
      providers: [
        { provide: FormService, useClass: MockFormService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: QaToastrService, useClass: MockQaToastrService }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
