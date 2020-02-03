import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RadioButtonComponent } from './radio-button.component';
import { MatRadioModule, MatFormFieldModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { IQuestion, IQuestionResponse } from '../../_common/models';

describe('RadioButtonComponent', () => {
  let component: RadioButtonComponent;
  let fixture: ComponentFixture<RadioButtonComponent>;

  const mockQuestion: IQuestion = {
    id: 123,
    body: 'test body',
    hasComment: false,
    commentLabel: 'test comment label',
    selectionType: 'RADIO_BUTTON',
    selectionOptionsList: ['a', 'b', 'c']
  };

  const mockQuestionResponse: IQuestionResponse = {
    id: 456,
    comment: {
      id: 789,
      content: 'test comment content'
    },
    question: mockQuestion,
    responseValues: []
  };


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RadioButtonComponent],
      imports: [
        MatRadioModule,
        FormsModule,
        MatFormFieldModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RadioButtonComponent);
    component = fixture.componentInstance;
    component.question = mockQuestion;
    component.questionResponse = mockQuestionResponse;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
  it('should run setRadioResponse', () => {
    let input: string = "Fly on the Wall";
    component.setRadioResponse(input)
    expect(component.questionResponse.responseValues).toEqual([input]);
  });

});
