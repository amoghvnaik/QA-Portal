import { TestBed } from '@angular/core/testing';

import { QaHelpService } from './qa-help.service';

describe('QaHelpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QaHelpService = TestBed.get(QaHelpService);
    expect(service).toBeTruthy();
  });
});
