import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluationTableComponent } from './evaluation-table.component';
import { MatTableModule } from '@angular/material';

describe('EvaluationTableComponent', () => {
  let component: EvaluationTableComponent;
  let fixture: ComponentFixture<EvaluationTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvaluationTableComponent ],
      imports: [
        MatTableModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvaluationTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('sanity checks', () => {
    expect(component.displayedColumns).toEqual(['course', 'start', 'end', 'courseid', 'pin', 'status']);
  });

});
