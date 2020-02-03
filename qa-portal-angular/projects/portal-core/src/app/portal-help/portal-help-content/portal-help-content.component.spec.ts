import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortalHelpContentComponent } from './portal-help-content.component';

describe('PortalHelpContentComponent', () => {
  let component: PortalHelpContentComponent;
  let fixture: ComponentFixture<PortalHelpContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortalHelpContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortalHelpContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
