import { Component, OnInit, ViewChild } from '@angular/core';
import { RouterOutlet, Router, ActivatedRoute, ActivationStart } from '@angular/router';
import { AuthService } from '../shared/services/auth.service';
import { DataService } from '../shared/services/data.service';
import { StateService } from '../shared/services/state.service';
import { MenuController } from '@ionic/angular';

@Component({
  selector: 'app-tab-home',
  templateUrl: './tab-home.page.html',
  styleUrls: ['./tab-home.page.scss'],
})
export class TabHomePage implements OnInit {

  @ViewChild(RouterOutlet) outlet: RouterOutlet;

  authenticated = false;
  data: any;
  connectionState: boolean;
  
  constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute, private dataService: DataService, private stateService: StateService, private menuCtrl: MenuController) {
    let snapshot = route.snapshot;
    this.connectionState = stateService.getConnectionState(); 
        
    
  }

  ngOnInit() {
    let connectionState = this.stateService.getConnectionState(); 
     
    this.router.events.subscribe(e => {
      if (e instanceof ActivationStart && e.snapshot.outlet === "tab"){
        this.outlet.deactivate();
      }
    }
      )
    if (this.route.data['role']){
      this.data = this.route.data['role'];
    }
    console.log(`la connection dans init est ${connectionState}`);
    return this.connectionState;
  }
  

  logout(){
    this.authService.signOut();
    
  }

}

