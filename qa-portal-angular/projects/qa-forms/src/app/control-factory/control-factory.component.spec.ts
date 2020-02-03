import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlFactoryComponent } from './control-factory.component';
import { IQuestion, IQuestionResponse } from '../_common/models';
import { MockComponent, MockDirective } from 'ng-mocks';
import { RadioButtonComponent } from '../controls';
import { BrowserDynamicTestingModule } from '@angular/platform-browser-dynamic/testing';
import { ComponentFactoryResolver } from '@angular/core';
import { ControlHostDirective } from './control-host.directive';
import { of } from 'rxjs';


class MockCompFactResolver {
  resolveComponentFactory(comp: any) { }
}

describe('ControlFactoryComponent', () => {
  let component: ControlFactoryComponent;
  let fixture: ComponentFixture<ControlFactoryComponent>;
  let componentFactoryResolver: ComponentFactoryResolver;

  const mockRadioButtonComponent = MockComponent(RadioButtonComponent);

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

  const mockControlHost = {
    viewContainerRef: {
      createComponent: () => ({
        instance: {
          questionResponseChange: of(null)
        }
      }),
      clear: () => { }
    }
  };

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ControlFactoryComponent],
      providers: [{ provide: ComponentFactoryResolver, useClass: MockCompFactResolver }]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControlFactoryComponent);
    component = fixture.componentInstance;
    (component.controlHost as any) = mockControlHost;
    component.question = mockQuestion;
    component.questionResponse = mockQuestionResponse;
    componentFactoryResolver = TestBed.get(ComponentFactoryResolver);

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should destroy', () => {
    component.ngOnDestroy();
    expect((component as any).keepAlive).toEqual(false);
  });
});
