import { HttpErrorResponse } from '@angular/common/http';

export class MockQaErrorHandlerService {
    public handleError(error: HttpErrorResponse): void { }
    public showError(error: string): void { }
}
