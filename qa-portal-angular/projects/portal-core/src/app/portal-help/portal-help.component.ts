import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { QaHelpService } from '../_common/services/qa-help.service';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-portal-help',
  templateUrl: './portal-help.component.html',
  styleUrls: ['./portal-help.component.css']
})
export class PortalHelpComponent{
  panelOpenState = false;
  helptext = "Test";
  currentUrl = window.location.href;
  userRole: boolean;
  constructor(private keycloak: KeycloakService, public helpService: QaHelpService, private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd){
      this.userRole = this.keycloak.isUserInRole("training-user");
   };
  });
};
};



