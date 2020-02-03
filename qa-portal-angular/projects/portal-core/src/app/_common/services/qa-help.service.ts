import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { helpModel } from '../models/help-model';
import { filter, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class QaHelpService {

  private messageSource = new BehaviorSubject("Welcome to QA Portal! \n\n Kindly click any of the buttons displayed to navigate the portal");
  currentMessage = this.messageSource.asObservable();
  private helpContent;
  private userType;

  constructor(private router: Router, private http: HttpClient) { }

  getUserType(roleBool){
    if (roleBool == true){
      this.userType = "USER";
    } else {
      this.userType = "ADMIN";
    }
    return this.userType;
  }


  accessFile(): Observable <helpModel>{
    return this.http.get<helpModel>('../assets/Textfiles/homeHelp.json', {responseType: 'json'});
  }

  accessToolTipFile(): Observable <helpModel>{
    return this.http.get<helpModel>('../assets/Textfiles/toolTips.json', {responseType: 'json'});
  }

changeMessage(data, tag){
  data.subscribe(data => this.messageSource.next((data.filter(help => help.Tag == tag || help.Tag + String(tag).match(/[0-9]+/) == tag))[0].Help.split("\n").join("\n")));
  };

  tooltipMaker(data){
    if (data == "Training"){
      return "Training at the academy";
    } else if (data == "Home") {
      return "Home Page";
    } else if (data == "Trainee Evaluation History") {
      return "View and edit your current evaluations of your courses at the academy, providing feedback to your trainer to help them improve in the future.";
    } else if (data == "Trainee Current CV") {
      return "Update and view your current CV which should include everything learnt at the academy.";
    } else if (data == "Trainee Reflections") {
      return "For viewing the history of your reflections at the academy";
    } else if (data == "Current Trainee Reflection") {
      return "A form to reflect over your progress at the academy at the current date";
    } else {
      return ""
    }
  }

  // tooltipMaker(data){
  //   if (data == "Training"){
  //     return "Training at the academy";
  //   } else if (data == "Home") {
  //     return "Home Page";
  //   } else if (data == "Trainee Evaluation History") {
  //     return "View and edit your current evaluations of your courses at the academy, providing feedback to your trainer to help them improve in the future.";
  //   } else if (data == "Trainee Current CV") {
  //     return "Update and view your current CV which should include everything learnt at the academy.";
  //   } else if (data == "Trainee Reflections") {
  //     return "For viewing the history of your reflections at the academy";
  //   } else if (data == "Current Trainee Reflection") {
  //     return "A form to reflect over your progress at the academy at the current date";
  //   } else {
  //     return ""
  //   }
  // }

}
