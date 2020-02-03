import { Observable, of } from 'rxjs';
import { CourseModel } from 'projects/portal-core/src/app/_common/models/course.model';

export class MockCourseService {
  public getAllCourses(): Observable<CourseModel[]> {
    return of([]);
  }

  public getCourseById(id: string | number): Observable<CourseModel> {
    return of(null);
  }

  public saveCourse(course: CourseModel): Observable<CourseModel> {
    return of(null);
  }

  public getColorForCourse(course: CourseModel): { primary: string, secondary: string } {
    return {
      primary: '#ffffffff',
      secondary: '#ffffffff'
    };
  }
}
