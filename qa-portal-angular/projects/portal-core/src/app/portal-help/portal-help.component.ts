import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-portal-help',
  templateUrl: './portal-help.component.html',
  styleUrls: ['./portal-help.component.css']
})
export class PortalHelpComponent implements OnInit {
  panelOpenState = false;
  helptext = "Test";
  currentUrl = window.location.href;
  constructor() { }

  ngOnInit() {
  }
}



