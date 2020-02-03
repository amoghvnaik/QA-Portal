import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortalHelpComponent } from './portal-help.component';

describe('PortalHelpComponent', () => {
  let component: PortalHelpComponent;
  let fixture: ComponentFixture<PortalHelpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortalHelpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortalHelpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
