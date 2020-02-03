import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormComponent } from './form.component';
import { MockComponent } from 'ng-mocks';
import { CategoryComponent } from '../category/category.component';
import { IFormModel } from '../_common/models';

describe('FormComponent', () => {
  let component: FormComponent;
  let fixture: ComponentFixture<FormComponent>;

  const mockFormModel: IFormModel = {
    categoryResponses: [],
    status: 'SAVED',
    id: 123,
    cohortCourse: null,
    trainee: null
  };

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        FormComponent,
        MockComponent(CategoryComponent)
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormComponent);
    component = fixture.componentInstance;
    component.model = mockFormModel;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should update category responses', () => {
    let body: any = {
      name: "David Jones"
    }
    component.onCategoryChange(body, 0)

    expect(component.model.categoryResponses[0]).toEqual(body);
  });

});
