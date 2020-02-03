import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCourseDialogComponent } from './add-course-dialog.component';
import { MatFormFieldModule, MatDialogModule, MatInputModule, MatOptionModule, MatSelectModule, MAT_DIALOG_DATA } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const mockDialogData = {};

describe('AddCourseDialogComponent', () => {
  let component: AddCourseDialogComponent;
  let fixture: ComponentFixture<AddCourseDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AddCourseDialogComponent],
      imports: [
        FormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatOptionModule,
        MatSelectModule,
        MatDialogModule,
        BrowserAnimationsModule
      ],
      providers: [
        { provide: MAT_DIALOG_DATA, useValue: mockDialogData }
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCourseDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
