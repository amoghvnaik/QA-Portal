import { Component, OnInit, Input } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { QaHelpService } from '../../_common/services/qa-help.service';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-portal-help-content',
  templateUrl: './portal-help-content.component.html',
  styleUrls: ['./portal-help-content.component.css']
})
export class PortalHelpContentComponent implements OnInit {
  @Input() currentUrl: string;
  message: string;
  

  constructor(private helpService: QaHelpService, private router: Router){
    this.helpService.currentMessage.subscribe(message => this.message = message);
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd){
        let file = this.helpService.accessFile();
        this.helpService.changeMessage(file, this.router.url);
      }
    })
  }

  ngOnInit() {
    this.helpService.currentMessage.subscribe(message => this.message = message);
  }

}
