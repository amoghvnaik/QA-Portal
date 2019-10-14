import { MatButtonModule, MatCheckboxModule } from '@angular/material';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule, MatIconRegistry } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NgModule } from '@angular/core';

import { RatedQuestionComponent } from './rated-question/rated-question.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { DomSanitizer } from '@angular/platform-browser';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { SearchBarBackdropComponent } from './search-bar-backdrop/search-bar-backdrop.component';
import { CommonModule } from '@angular/common';
import { DataTableComponent } from './data-table/data-table.component';
import { SpinnerOverlayComponent } from './spinner-overlay/spinner-overlay.component';
import { MatMomentDateModule } from '@angular/material-moment-adapter';

const iconsMap = [
  { name: 'qa-logo', path: 'assets/qa.svg' },
  { name: 'qa-manage-apps', path: 'assets/icons/qa_manage_apps_48px.svg' },
  { name: 'qa-manage-cohorts', path: 'assets/icons/qa_manage_cohorts_48px.svg' },
  { name: 'qa-manage-courses', path: 'assets/icons/qa_manage_courses_48px.svg' },
  { name: 'qa-manage-users', path: 'assets/icons/qa_manage_users_48px.svg' },
  { name: 'qa-manage-roles', path: 'assets/icons/qa_manage_roles_48px.svg' },
  { name: 'qa-manage-technology', path: 'assets/icons/qa_manage_technology_48px.svg' },
  { name: 'qa-manage-form', path: 'assets/icons/qa_manage_form_48px.svg' },
  { name: 'qa-manage-question', path: 'assets/icons/qa_manage_question_48px.svg' },
  { name: 'qa-manage-question-category', path: 'assets/icons/qa_manage_question_category_48px.svg' },
  { name: 'qa-role', path: 'assets/icons/qa_roles_48px.svg' },
  { name: 'qa-course', path: 'assets/icons/qa_course_48px.svg' },
  { name: 'qa-cohort', path: 'assets/icons/qa_cohort_48px.svg' },
  { name: 'qa-technology', path: 'assets/icons/qa_technology_48px.svg' },
  { name: 'qa-form', path: 'assets/icons/qa_form_48px.svg' },
  { name: 'qa-question', path: 'assets/icons/qa_question_48px.svg' },
  { name: 'qa-question-category', path: 'assets/icons/qa_question_category_48px.svg' }
];

const materialModules = [
  MatCheckboxModule,
  MatCheckboxModule,
  MatButtonModule,
  MatInputModule,
  MatAutocompleteModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatRadioModule,
  MatSelectModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatMenuModule,
  MatSidenavModule,
  MatToolbarModule,
  MatListModule,
  MatGridListModule,
  MatCardModule,
  MatStepperModule,
  MatTabsModule,
  MatExpansionModule,
  MatButtonToggleModule,
  MatChipsModule,
  MatIconModule,
  MatProgressSpinnerModule,
  MatProgressBarModule,
  MatDialogModule,
  MatTooltipModule,
  MatSnackBarModule,
  MatTableModule,
  MatSortModule,
  MatPaginatorModule,
  MatMomentDateModule
];

@NgModule({
  declarations: [
    RatedQuestionComponent,
    SearchBarComponent,
    SearchBarBackdropComponent,
    DataTableComponent,
    SpinnerOverlayComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ...materialModules,
    ReactiveFormsModule,
    ToastrModule.forRoot(
      {
        positionClass: 'toast-bottom-right',
        closeButton: true,
        timeOut: 7000
      }
    )
  ],
  providers: [],
  exports: [
    CommonModule,
    FormsModule,
    ...materialModules,
    RatedQuestionComponent,
    ReactiveFormsModule,
    SearchBarComponent,
    SearchBarBackdropComponent,
    DataTableComponent,
    SpinnerOverlayComponent
  ]
})
export class QaCommonModule {
  constructor(
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer
  ) {
    for (const icon of iconsMap) {
      this.matIconRegistry.addSvgIcon(icon.name, this.domSanitizer.bypassSecurityTrustResourceUrl(icon.path));
    }
  }
}
