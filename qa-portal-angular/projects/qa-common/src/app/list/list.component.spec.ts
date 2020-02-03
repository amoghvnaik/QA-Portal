import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ListComponent } from './list.component';
import { DragDropModule, CdkDragDrop } from '@angular/cdk/drag-drop';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('ListComponent', () => {
  let component: ListComponent<any>;
  let fixture: ComponentFixture<ListComponent<any>>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListComponent],
      imports: [
        BrowserAnimationsModule,
        DragDropModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should use drop and check listDataSourceChange', (done) => {
    component.listDataSource = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

    const e = {
      previousIndex: 1,
      currentIndex: 3
    };

    component.listDataSourceChange.subscribe(data => {
      expect(data).toEqual(component.listDataSource);
      done();
    });

    component.drop(e as CdkDragDrop<any>);

  });

  it('should not update expandedElement if expander is falsy', () => {
    component.expander = null;
    const testData = '12345';
    component.onListItemClicked(testData);
    expect(component.expandedElement).toEqual(null);
  });

  it('should set expandedElement to input if not already expanded', () => {
    (component as any).expander = true;
    const testData = '12345';
    component.onListItemClicked(testData);
    expect(component.expandedElement).toEqual(testData);
  });

  it('should set expandedElement to null if input is already expanded', () => {
    (component as any).expander = true;
    const testData = '12345';
    component.expandedElement = testData;
    component.onListItemClicked(testData);
    expect(component.expandedElement).toEqual(null);
  });




});
