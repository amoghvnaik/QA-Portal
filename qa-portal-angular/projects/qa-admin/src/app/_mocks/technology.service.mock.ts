import { Observable, of } from 'rxjs';
import { TechnologyCategoryModel } from 'projects/portal-core/src/app/_common/models/technology-category.model';


export class MockTechnologyService {
  public getAllCategories(): Observable<TechnologyCategoryModel[]> {
    return of([]);
  }

  public getCategoryById(id: string | number): Observable<TechnologyCategoryModel> {
    return of(null);
  }

  public saveCategory(category: TechnologyCategoryModel): Observable<TechnologyCategoryModel> {
    return of(null);
  }

  public addCategory(category: TechnologyCategoryModel): Observable<TechnologyCategoryModel> {
    return of(null);
  }
}
