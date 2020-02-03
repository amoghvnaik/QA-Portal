import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatedQuestionComponent } from './rated-question.component';
import { MatRadioModule } from '@angular/material';

describe('RatedQuestionComponent', () => {
  let component: RatedQuestionComponent;
  let fixture: ComponentFixture<RatedQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RatedQuestionComponent],
      imports: [MatRadioModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatedQuestionComponent);
    component = fixture.componentInstance;

    component.selectedRating = { response: null };

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should check if setModel correctly sets response value', () => {
    const testData = '1';
    component.setModel(testData);
    expect(component.selectedRating.response).toEqual(testData);
  });

  it('should check if radio button has the same value as its label', () => {
    const testData = '1';
    component.setModel(testData);
    expect(component.matchedValue(JSON.stringify(testData))).toBeTruthy();
  });

  it('should check if radio button does not have the same value as its label as a false input value', () => {
    const testData = '1';
    const testDataFalse = '2'
    component.setModel(testData);
    expect(component.matchedValue(JSON.stringify(testDataFalse))).toBeFalsy();
  });
});
