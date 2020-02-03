import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataTableComponent } from './data-table.component';
import { MatProgressBarModule, MatTableModule, MatCheckboxModule, MatCardModule, MatTableDataSource, MatCheckboxChange, MatColumnDef } from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';
import { DragDropModule } from '@angular/cdk/drag-drop';


describe('DataTableComponent', () => {
  let component: DataTableComponent<any>;
  let fixture: ComponentFixture<DataTableComponent<any>>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DataTableComponent],
      imports: [
        MatProgressBarModule,
        MatTableModule,
        CdkTableModule,
        DragDropModule,
        MatCheckboxModule,
        MatCardModule
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should create column', () => {
    component.columns = [];

    for (let i = 0; i < 10; i++) {
      const col = new MatColumnDef();
      col.name = 'testcol_' + i;
      component.columns.push(col);
    }

    const colNames = []; // History of previously added column names
    spyOn(component.matTable, 'addColumnDef').and.callFake((col: MatColumnDef) => {
      expect(col).toBeDefined();
      expect(colNames.some(n => n === col.name)).toBeFalsy(); // Check if col has been added before
      colNames.push(col.name); // Add name to array to be checked next time
    });

    component.ngAfterContentInit();

    expect(component.matTable.addColumnDef).toHaveBeenCalledTimes(10);

  });

  it('should emit a rowClick event when called', done => {
    const testIndex = 1;
    const testData = 'test data';
    const testEvent = new MouseEvent('click');

    component.rowClick.subscribe(data => {
      expect(data.index).toEqual(testIndex);
      expect(data.data).toEqual(testData);
      expect(data.event).toEqual(testEvent);


      done();
    });

    component.onRowClicked(testIndex, testData, testEvent);
  });

  it('should update state when a row is selected', done => {
    component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);

    component.rowSelectionChange.subscribe(data => {
      expect(data.length).toEqual(component.rowSelection.length);

      done();
    })
    component.updateRowSelectedState();

  });

  it('should toggle all checkboxes or none when clicked', done => {
    component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);
    const checked = new MatCheckboxChange

    component.rowSelectionChange.subscribe(data => {
      expect(data).toEqual(component.rowSelection)

      done();
    });
    component.onSelectAllCheckboxChange({ checked: true } as MatCheckboxChange);
    component.onSelectAllCheckboxChange({ checked: false } as MatCheckboxChange);

  });

  it('should deselect all rows', done => {
    component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);

    component.rowSelectionChange.subscribe(data => {
      expect(data).toEqual(component.rowSelection);

      done();
    });

    component.deselectAllRows();
  });

  describe('onRowCheckboxClicked', () => {

    it('should allow user to select and deselect multipal checkboxes ', done => {
      component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);
      const testIndex = 1;
      const testEvent = new MouseEvent('click');

      component.rowSelectionChange.subscribe(data => {
        expect(data).toEqual(component.rowSelection);
        data.forEach((el, i) => {
          if (i === testIndex) {
            expect(el).toBeTruthy();
          } else {
            expect(el).toBeFalsy();
          }
        });
        done();
      });

      component.onRowCheckboxClicked(testEvent, testIndex);

    });

    it('should select a range if shift key is held during a checkbox click', () => {
      const startIndex = 3;
      const endIndex = 6;
      const event = new MouseEvent('click', { shiftKey: true });
      component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);
      component.lastSelectionIndex = startIndex;
      component.rowSelection = [];


      component.onRowCheckboxClicked(event, endIndex);

      expect(component.lastSelectionIndex).toEqual(startIndex);
      for (let i = 0; i < component.dataSource.data.length; i++) {
        const selected = component.rowSelection[i];
        if (selected) {
          expect(i >= startIndex && i <= endIndex).toBeTruthy();
        } else {
          expect(i >= startIndex && i <= endIndex).toBeFalsy();
        }
      }
    });

    it('should select a range and not clear current selection if ctrl+shift key is held during a checkbox click', () => {
      const startIndex = 3;
      const firstEndIndex = 1;
      const secondEndIndex = 6;
      const event = new MouseEvent('click', { shiftKey: true, ctrlKey: true });
      component.dataSource = new MatTableDataSource<any>([1, 2, 3, 4, 5, 6, 7, 8, 9]);
      component.lastSelectionIndex = startIndex;
      component.rowSelection = [];


      component.onRowCheckboxClicked(event, firstEndIndex);
      component.onRowCheckboxClicked(event, secondEndIndex);

      expect(component.lastSelectionIndex).toEqual(startIndex);
      for (let i = 0; i < component.dataSource.data.length; i++) {
        const selected = component.rowSelection[i];
        if (selected) {
          expect(i >= firstEndIndex && i <= secondEndIndex).toBeTruthy();
        } else {
          expect(i >= firstEndIndex && i <= secondEndIndex).toBeFalsy();
        }
      }
    });

  });

  it('should get data for the rows selected', () => {
    component.dataSource = new MatTableDataSource<any>([1,2,3,4,5,6,7,8,9]);
    let t = true;
    let f = false;
    component.rowSelection = [f, t, f, f, f, f, t, f, f];
    let result = component.getSelectedRowsData();
    for(let i= 0; i< component.rowSelection.length-1; i++)
    {
      if(component.rowSelection[i]== true)
      {
      expect(result).toContain(component.dataSource[i]);
      }
    }

  });


});
