import { TestBed } from '@angular/core/testing';

import { TechnologyService } from './technology.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';

describe('TechnologyService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: TechnologyService = TestBed.get(TechnologyService);
    expect(service).toBeTruthy();
  });
});
