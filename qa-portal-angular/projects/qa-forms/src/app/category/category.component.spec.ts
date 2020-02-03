import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryComponent } from './category.component';
import { MockComponent } from 'ng-mocks';
import { ControlFactoryComponent } from '../control-factory/control-factory.component';
import { MatCardModule } from '@angular/material';
import { IQuestionCategory, ICategoryResponse } from '../_common/models';

describe('CategoryComponent', () => {
  let component: CategoryComponent;
  let fixture: ComponentFixture<CategoryComponent>;

  const mockCategory: IQuestionCategory = {
    categoryName: 'test category',
    commentLabel: 'test comment label',
    displayDirection: 'INLINE',
    hasComment: true,
    id: 123,
    lastUpdatedBy: 'test username',
    lastUpdatedTimestamp: '2020-01-01T00:00:00Z',
    questions: [],
    selectionType: 'RADIO_BUTTON'
  };

  const mockCategoryResponse: ICategoryResponse = {
    comment: {
      id: 789,
      content: 'test comment content'
    },
    id: 123,
    parentId: 456,
    questionCategory: mockCategory,
    questionResponses: []
  };

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CategoryComponent,
        MockComponent(ControlFactoryComponent)
      ],
      imports: [
        MatCardModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryComponent);
    component = fixture.componentInstance;
    component.categoryResponse = mockCategoryResponse;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
