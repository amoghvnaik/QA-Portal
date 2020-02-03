import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCategoryDialogComponent } from './new-category-dialog.component';
import { MockComponent } from 'ng-mocks';
import { SpinnerOverlayComponent } from 'projects/qa-common/src/app/spinner-overlay/spinner-overlay.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule, MatOptionModule, MatSelectModule, MatDialogModule, MatInputModule, MatDialogRef } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QaErrorHandlerService } from 'projects/portal-core/src/app/_common/services/qa-error-handler.service';
import { MockQaErrorHandlerService } from 'projects/portal-core/src/app/_mocks/qa-error-handler.service.mock';
import { MockMatDialogRef } from 'projects/portal-core/src/app/_mocks/mat-dialog-ref.mock';
import { TechnologyService } from '../../_common/technology.service';
import { MockTechnologyService } from '../../_mocks/technology.service.mock';

describe('NewCategoryDialogComponent', () => {
  let component: NewCategoryDialogComponent;
  let fixture: ComponentFixture<NewCategoryDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [NewCategoryDialogComponent, MockComponent(SpinnerOverlayComponent)],
      imports: [
        ReactiveFormsModule,
        MatFormFieldModule,
        MatDialogModule,
        MatInputModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: TechnologyService, useClass: MockTechnologyService },
        { provide: QaErrorHandlerService, useClass: MockQaErrorHandlerService },
        { provide: MatDialogRef, useClass: MockMatDialogRef }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCategoryDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
