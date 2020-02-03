import { TestBed } from '@angular/core/testing';

import { FormService } from './form.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';

describe('FormService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: FormService = TestBed.get(FormService);
    expect(service).toBeTruthy();
  });
});
