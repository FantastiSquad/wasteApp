import { Component, OnInit } from '@angular/core';
import { StateService } from '../shared/services/state.service';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.page.html',
  styleUrls: ['./tabs.page.scss'],
})
export class TabsPage implements OnInit {
  connectionState: boolean;

  constructor(private stateService: StateService) {
    this.stateService.getConnectionState();
  }

  ngOnInit() {
    let connectionState = this.stateService.getConnectionState();  
    return connectionState;
  }
  
}

