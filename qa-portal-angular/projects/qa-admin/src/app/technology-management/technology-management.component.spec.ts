import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnologyManagementComponent } from './technology-management.component';
import { MockComponents } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatDialogModule } from '@angular/material';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { TechnologyService } from '../_common/technology.service';
import { MockTechnologyService } from '../_mocks/technology.service.mock';

describe('TechnologyManagementComponent', () => {
  let component: TechnologyManagementComponent;
  let fixture: ComponentFixture<TechnologyManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        TechnologyManagementComponent,
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
        { provide: TechnologyService, useClass: MockTechnologyService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnologyManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
