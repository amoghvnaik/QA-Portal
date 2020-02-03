import { ExpanderDirective } from './expander.directive';
import { ViewContainerRef } from '@angular/core';

describe('ExpanderDirective', () => {
  let directive: ExpanderDirective;
  beforeEach(() => {
    const vcr = { createEmbeddedView: (a, b) => { } } as ViewContainerRef;
    directive = new ExpanderDirective(null, vcr);
  })
  it('should create', () => {
    expect(directive).toBeTruthy();
  });

  it('should call creatEmbeddedView on init', () => {
    spyOn((directive as any).viewContainer, 'createEmbeddedView').and.callThrough();
    directive.ngOnInit();
    expect((directive as any).viewContainer.createEmbeddedView).toHaveBeenCalledTimes(1);
  });
});
