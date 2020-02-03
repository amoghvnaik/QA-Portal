import { TestBed, inject, fakeAsync, tick } from '@angular/core/testing';

import { QaHttpService } from './qa-http.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('QaHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));


  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientTestingModule
    ]
  }));

  it('should be created', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
    expect(service).toBeTruthy();
  }));

  describe('Get request', () => {

    it('should send get request using ref', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {

      service.get({ ref: 'GET_ALL_USERS' }).subscribe(body => {
        expect(body).toEqual('test body');
      });

      const mockGetReq = httpMock.expectOne('cohort-api/manage/users');
      mockGetReq.flush('test body');
      httpMock.verify();
    }));
  });

  describe('Post request', () => {

    it('should send post request using ref', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
      const mockUser = {
        name: 'userTest',
        role: ''
      };

      service.post({ ref: 'CREATE_USER' }, {
        headers: { 'Content-Type': 'application/json' }
      }).subscribe((userData) => {
        expect(userData).toEqual(mockUser);
      });

      const mockGetReq = httpMock.expectOne('cohort-api/manage/user');

      expect(mockGetReq.request.method).toEqual('POST');

      mockGetReq.flush(mockUser);
      httpMock.verify();
    }));
  });
  describe('Put request', () => {

    it('should send put request using ref', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
      const mockUser = {
        name: 'userTest',
        role: ''
      };

      service.put({ ref: 'UPDATE_EVALUATION_FORM' }, {
        headers: { 'Content-Type': 'application/json' }
      }).subscribe((userData) => {
        expect(userData).toEqual(mockUser);
      });
      const mockGetReq = httpMock.expectOne('feedback-api/evaluation');

      expect(mockGetReq.request.method).toEqual('PUT');

      mockGetReq.flush(mockUser);
      httpMock.verify();
    }));
    // No request is using patch yet can't be tested
    // it('should send patch request using ref', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
    //   const mockUser = {
    //     name: 'userTest',
    //     role: ''
    //   };

    //   service.patch({ref: 'UPDATE_USERS'}, {
    //     headers: { 'Content-Type': 'application/json' }
    //   }).subscribe((userData) => {
    //     expect(userData).toEqual(mockUser);
    //   });
    //   const mockGetReq = httpMock.expectOne('cohort-api/manage/user');

    //   expect(mockGetReq.request.method).toEqual('PATCH');

    //   mockGetReq.flush(mockUser);
    //   httpMock.verify();
    // }));
  });
  describe('Delete request', () => {

    it('should send delete request using ref', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
      const mockUser = {
        name: 'userTest',
        role: ''
      };

      service.delete({ ref: 'DELETE_USERS' }, {
        headers: { 'Content-Type': 'application/json' }
      }).subscribe((userData) => {
        expect(userData).toEqual(mockUser);
      });
      const mockGetReq = httpMock.expectOne('cohort-api/manage/users/delete');

      expect(mockGetReq.request.method).toEqual('DELETE');

      mockGetReq.flush(mockUser);
      httpMock.verify();
    }));
  });
  describe('Url Builder Test', () => {

    it('should work using a url instead of an endpoint', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
      service.get('cohort-api/manage/users').subscribe(body => {
        expect(body).toEqual('test body');
      });

      const mockGetReq = httpMock.expectOne('cohort-api/manage/users');
      mockGetReq.flush('test body');
      httpMock.verify();
    }));

    it('should use params', inject([HttpTestingController, QaHttpService], (httpMock: HttpTestingController, service: QaHttpService) => {
      service.get({ ref: 'GET_EVALUATION_FORM_FOR_ID', params: { courseId: 1 } }).subscribe(body => {
        expect(body).toEqual('test body');
      });

      const mockGetReq = httpMock.expectOne('feedback-api/evaluation/1');
      mockGetReq.flush('test body');
      httpMock.verify();
    }));
  });


});