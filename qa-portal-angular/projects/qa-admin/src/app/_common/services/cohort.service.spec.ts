import { TestBed } from '@angular/core/testing';

import { CohortService } from './cohort.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('CohortService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ],
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: CohortService = TestBed.get(CohortService);
    expect(service).toBeTruthy();
  });
});
