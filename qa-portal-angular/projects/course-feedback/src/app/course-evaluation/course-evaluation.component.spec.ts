import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseEvaluationComponent } from './course-evaluation.component';
import { MockComponents } from 'ng-mocks';
import { EvaluationTableComponent } from '../evaluation-table/evaluation-table.component';

describe('CourseEvaluationComponent', () => {
  let component: CourseEvaluationComponent;
  let fixture: ComponentFixture<CourseEvaluationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        CourseEvaluationComponent,
        MockComponents(EvaluationTableComponent)
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseEvaluationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
