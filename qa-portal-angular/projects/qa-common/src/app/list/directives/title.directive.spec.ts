import { TitleDirective } from './title.directive';
import { ViewContainerRef } from '@angular/core';

describe('ExpanderDirective', () => {
  let directive: TitleDirective;
  beforeEach(() => {
    const vcr = { createEmbeddedView: (a, b) => { } } as ViewContainerRef;
    directive = new TitleDirective(null, vcr);
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
