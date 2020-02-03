import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SearchBarComponent } from './search-bar.component';
import { MatIconModule, MatRadioModule, MatCardModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { OverlayModule } from '@angular/cdk/overlay';
import { SearchBarBackdropComponent } from '../search-bar-backdrop/search-bar-backdrop.component';

describe('SearchBarComponent', () => {
  let component: SearchBarComponent;
  let fixture: ComponentFixture<SearchBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SearchBarComponent],
      imports: [
        MatIconModule,
        MatRadioModule,
        FormsModule,
        MatCardModule,
        OverlayModule
      ],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBarComponent);
    component = fixture.componentInstance;

    component.backdropRef = {
      show: false,
      onBackdropClick: null
    } as SearchBarBackdropComponent;

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should set backdropClick on init', () => {
    expect(component.backdropRef.onBackdropClick).toBeDefined();
  });

  it('should not set backdropClick on init if backdropRef is falsy', () => {
    component.backdropRef = null;
    component.ngOnInit();
    expect(component.backdropRef).toBeFalsy();
  });

  it('should update filterOpen when backdropRef.onBackdropClick is called', () => {
    component.filterOpen = true;
    component.backdropRef.onBackdropClick();
    expect(component.filterOpen).toBeFalsy();
  })

  it('should emit on value change', () => {
    spyOn(component.valueChange, 'emit');
    component.value = 'search';

    expect(component.valueChange.emit).toHaveBeenCalledWith('search');
    expect(component.value).toEqual('search');
  });

  it('should emit on open filter', () => {
    component.filterOpenChange.emit(false);
    spyOn(component.filterOpenChange, 'emit');
    component.filterOpen = true;

    expect(component.backdropRef.show).toBeTruthy();
    expect(component.filterOpenChange.emit).toHaveBeenCalledWith(true);
  });

  it('should not update backdropRef.show if backdropRef is null on open filter', () => {
    component.backdropRef = null;
    component.filterOpenChange.emit(false);
    spyOn(component.filterOpenChange, 'emit');
    component.filterOpen = true;

    expect(component.backdropRef).toBeNull();
    expect(component.filterOpenChange.emit).toHaveBeenCalledWith(true);
  });

  it('should emit on perform search', () => {
    spyOn(component.search, 'emit');
    component.announceSearch();

    expect(component.filterOpen).toBeFalsy();
    expect(component.search.emit).toHaveBeenCalledWith(component.value);
  });

  it('should emit on filter applied', () => {
    component.filterApply.emit('false');
    spyOn(component.filterApply, 'emit');
    component.announceFilterApply();
    expect(component.filterApply.emit).toHaveBeenCalledWith(component.value);
  });

  it('should emit on filter reset', () => {
    component.filterReset.emit('false');
    spyOn(component.filterReset, 'emit');
    component.announceFilterReset();
    expect(component.filterReset.emit).toHaveBeenCalledWith(component.value);
  });


});
