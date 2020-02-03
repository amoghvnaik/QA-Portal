import { Component, Input, Output, EventEmitter, ContentChild } from '@angular/core';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { TitleDirective } from './directives/title.directive';
import { ExpanderDirective } from './directives/expander.directive';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class ListComponent<T> {
  @Input() listDataSource: T[] = [];
  @Output() listDataSourceChange = new EventEmitter<T[]>();
  @Input() dragDrop = false;
  @ContentChild(TitleDirective, { static: true }) title: TitleDirective;
  @ContentChild(ExpanderDirective, { static: true }) expander: ExpanderDirective;

  public expandedElement: T = null;

  /**
   * Handle drop events from the drag drop list items
   * @param event Drag drop event
   */
  drop(event: CdkDragDrop<T[]>) {
    moveItemInArray(this.listDataSource, event.previousIndex, event.currentIndex);
    this.announceDataSourceChange();
  }

  /**
   * Handles list item click events. Updates expanded element.
   * @param item The item that's been clicked
   */
  onListItemClicked(item: T): void {
    if (this.expander) {
      this.expandedElement = this.expandedElement === item ? null : item;
    }
  }

  /**
   * Emits the list data source when changed
   */
  private announceDataSourceChange(): void {
    this.listDataSourceChange.emit(this.listDataSource);
  }
}
