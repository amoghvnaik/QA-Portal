import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericControlComponent } from './generic-control.component';
import { IQuestion, IQuestionResponse } from '../../_common/models';

describe('GenericControlComponent', () => {
  let component: GenericControlComponent;
  let fixture: ComponentFixture<GenericControlComponent>;

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
      declarations: [ GenericControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericControlComponent);
    component = fixture.componentInstance;
    component.question = mockQuestion;
    component.questionResponse = mockQuestionResponse;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should run setResponseValues', () => {

    let input: string[] = ["Horatio", "Gibbs", "Henrietta"];
    component.setResponseValues(input);

    expect(component.questionResponse.responseValues).toEqual(input);
  });

  describe('setComment tests', () => {

    it('input true, comment null', () => {
      let input = "not null";
      component.questionResponse.comment = null;
      component.setComment(input);
      expect(component.questionResponse.comment).toEqual({id: null, content: input});
    });

    it('input true, comment null', () => {
      let input = "not null";
      component.questionResponse.comment = {id: null, content: "Hello World"};
      component.setComment(input);
      expect(component.questionResponse.comment).toEqual({id: null, content: input});
    });

    it('input false, comment true', () => {
      let input = null;
      component.questionResponse.comment = {id: null, content: "Hello World"};
      component.setComment(input);
      expect(component.questionResponse.comment).toEqual({id: null, content: input});
    });

  });
  


});
