import { TestBed } from '@angular/core/testing';

import { LocationService } from './location.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';

describe('LocationService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: LocationService = TestBed.get(LocationService);
    expect(service).toBeTruthy();
  });
});
