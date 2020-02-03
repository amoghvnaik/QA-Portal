import { TestBed } from '@angular/core/testing';

import { ApplicationService } from './application.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';

describe('ApplicationService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: ApplicationService = TestBed.get(ApplicationService);
    expect(service).toBeTruthy();
  });
});
