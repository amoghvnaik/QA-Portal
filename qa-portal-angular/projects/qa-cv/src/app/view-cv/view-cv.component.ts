import { Component, OnInit, Output, OnDestroy } from '@angular/core';
import { ICvModel, DEFAULT_CV } from '../_common/models/qac-cv-db.model';
import { ViewCvService } from '../_common/services/view-cv.service';
import { CvCardBaseComponent } from '../cv-card-base/cv-card-base.component';
import { IFeedback } from '../_common/models/feedback.model';
import { ActivatedRoute } from '@angular/router';
import { TRAINING_ADMIN_ROLE, TRAINEE_ROLE } from '../../../../portal-core/src/app/_common/models/portal-constants';
import { Observable, Subscription } from 'rxjs';
import { MAT_DATE_LOCALE, MatDialog } from '@angular/material';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SubmitConfirmDialogComponent } from './submit-confirm-dialog/submit-confirm-dialog.component';


@Component({
  selector: 'app-view-cv',
  templateUrl: './view-cv.component.html',
  styleUrls: ['./view-cv.component.scss'],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' },
  ]
})
export class ViewCvComponent implements OnInit, OnDestroy {
  @Output() public canComment: boolean;
  @Output() public canEdit: boolean;
  
  enableButtons: boolean;
  cvs: ICvModel[] = [];
  openThis = false;

  public cvData: ICvModel;
  public workExpFeedback = [];
  workExpFeedbackIndex: number;
  public workExpDrawerOpen = false;

  public qualFeedback = [];
  qualFeedbackIndex: number;
  public qualDrawerOpen = false;

  private cvDataSubscription$: Subscription;

  constructor(
    private cvService: ViewCvService,
    private activatedRoute: ActivatedRoute,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    if (SubmitConfirmDialogComponent)
      this.canComment = this.activatedRoute.snapshot.data.roles[0] === TRAINING_ADMIN_ROLE;
    this.cvDataSubscription$ = this.cvService.getLatestCvForCurrentUser().subscribe(cv => this.cvData = { ...DEFAULT_CV, ...cv });
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(SubmitConfirmDialogComponent, {
      width: '250px'
    });
    dialogRef.componentInstance.canSubmit = false;
    dialogRef.componentInstance.doSubmit.subscribe(() => {
      if (dialogRef.componentInstance.canSubmit === true) {
        this.onSubmit();
      }
    });
    dialogRef.afterClosed().subscribe(() => {
    });

  }
  fileURL: string;

  getPDFService() {
    this.cvService.getPDF(this.cvData).subscribe((response) => {

      let file = new Blob([response], { type: 'application/pdf' });
      console.log(file);
      console.log(this.fileURL + " 1111111111111111111111");
      this.fileURL = URL.createObjectURL(file);
      console.log(this.fileURL + " 22222222222222222");
      window.open(this.fileURL);
      console.log(this.fileURL + " 3333333333333333333");
    })
  }



  ngOnDestroy(): void {
    this.cvDataSubscription$.unsubscribe();
  }

  onSave(): void {
    this.cvData.status = "Saved";
    this.updateCv();

  }

  updateCv(): void {
    this.cvData.versionNumber = this.cvData.versionNumber ? this.cvData.versionNumber + 1 : 1;
    this.cvService.updateCv(this.cvData).subscribe(updatedCv => this.cvData = updatedCv);
  }

  submitCv(): void {
    this.cvService.submitCv(this.cvData).subscribe(updatedCv => this.cvData = updatedCv);
  }

  onApproveCv(): void {
    this.cvService.approveCv(this.cvData).subscribe(updatedCv => this.cvData = updatedCv);
  }

  onFailCv(): void {
    this.cvService.failCv(this.cvData).subscribe(updatedCv => this.cvData = updatedCv);
  }


  onSubmit(): void {

    this.submitCv();

  }

  onWorkExpFeedbackClick({ index }: { index: number }, expCard: CvCardBaseComponent): void {
    this.workExpFeedbackIndex = index;
    this.workExpFeedback = this.cvData.allWorkExperience[index].workExperienceFeedback;
    expCard.drawer.open();
  }

  onWorkExpFeedbackChange(feedback: IFeedback[]): void {
    this.cvData.allWorkExperience[this.workExpFeedbackIndex].workExperienceFeedback = feedback;
  }

  onQualFeedbackClick({ index }: { index: number }, qualCard: CvCardBaseComponent): void {
    this.qualFeedbackIndex = index;
    this.qualFeedback = this.cvData.allQualifications[index].qualificationFeedback;
    qualCard.drawer.open();
  }

  onQualFeedbackChange(feedback: IFeedback[]): void {
    this.cvData.allQualifications[this.qualFeedbackIndex].qualificationFeedback = feedback;
  }

  ngAFterContentInit() {
    if (this.activatedRoute.snapshot.data.roles === TRAINING_ADMIN_ROLE) {
      this.canEdit = true;
    } else {
      this.canComment = false;
      if (this.activatedRoute.snapshot.data.roles === TRAINEE_ROLE && this.cvData.status !== "For Review") {
        this.canEdit = true;
      } else {
        this.canEdit = false;
      }
    }
  }
}
