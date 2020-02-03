import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { MockComponent } from 'ng-mocks';

import { FormManagementComponent } from './form-management.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { MatIconModule, MatDialogModule } from '@angular/material';
import { RouterTestingModule } from '@angular/router/testing';
import { FormService } from '../_common/services/form.service';
import { MockFormService } from '../_mocks/form.service.mock';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';

describe('FormManagementComponent', () => {
  let component: FormManagementComponent;
  let fixture: ComponentFixture<FormManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        FormManagementComponent,
        MockComponent(DataTableComponent)
      ], imports: [
        MatIconModule,
        RouterTestingModule,
        MatDialogModule
      ],
      providers: [
        { provide: FormService, useClass: MockFormService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
