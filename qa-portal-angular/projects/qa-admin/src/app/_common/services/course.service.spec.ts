import { TestBed } from '@angular/core/testing';

import { CourseService } from './course.service';
import { QaHttpService } from 'projects/portal-core/src/app/_common/services/qa-http.service';
import { MockQaHttpService } from 'projects/portal-core/src/app/_mocks/qa-http.service.mock';

describe('CourseService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      { provide: QaHttpService, useClass: MockQaHttpService }
    ]
  }));

  it('should be created', () => {
    const service: CourseService = TestBed.get(CourseService);
    expect(service).toBeTruthy();
  });
});
