import { Component, Input, Output } from '@angular/core';
import { PortalApplicationProjectsModel } from '../_common/models/portal-application-projects.model';
import { EventEmitter } from 'events';
import { QaHelpService } from '../_common/services/qa-help.service';

@Component({
  selector: 'app-header-link',
  templateUrl: './header-link.component.html'
})
export class HeaderLinkComponent {
  @Input() public portalApplicationProjects: PortalApplicationProjectsModel;
}
