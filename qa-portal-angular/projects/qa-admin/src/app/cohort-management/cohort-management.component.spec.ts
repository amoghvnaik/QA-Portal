import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CohortManagementComponent } from './cohort-management.component';
import { CohortService } from '../_common/services/cohort.service';
import { MockCohortService } from '../_mocks/cohort.service.mock';
import { MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatDialogModule } from '@angular/material';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';

describe('CohortManagementComponent', () => {
  let component: CohortManagementComponent;
  let fixture: ComponentFixture<CohortManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CohortManagementComponent,
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
        { provide: CohortService, useClass: MockCohortService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CohortManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
