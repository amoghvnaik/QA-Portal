import { Component, Input, Output, OnChanges, EventEmitter, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { CohortSummaryModel } from '../../_common/models/cohort-summary.model';
import { __values } from 'tslib';
import { DataTableComponent } from 'projects/qa-common/src/app/data-table/data-table.component';

@Component({
  selector: 'app-cohort-table',
  templateUrl: './cohort-table.component.html',
  styleUrls: ['./cohort-table.component.css']
})
export class CohortTableComponent implements OnChanges {
  @ViewChild('dataTable', { static: false }) dataTable: DataTableComponent<CohortSummaryModel>;

  @Input() cohortSummaryData: CohortSummaryModel[];
  @Output() shownCohortsChange = new EventEmitter();
  cohortsToShow: CohortSummaryModel[] = this.cohortSummaryData;

  dataSource: MatTableDataSource<CohortSummaryModel>;

  selectChange(){
    
    this.cohortsToShow = this.dataTable.getSelectedRowsData();
    this.shownCohortsChange.emit(this.cohortsToShow);

  }

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['select', 'cohortName', 'week1', 'week2', 'week3', 'week4', 'week5', 'week6', 'week7', 'week8', 'week9', 'week10', 'week11', 'week12'];

  ngOnChanges(): void {
    this.dataSource = new MatTableDataSource<CohortSummaryModel>(this.cohortSummaryData);
  }

}
