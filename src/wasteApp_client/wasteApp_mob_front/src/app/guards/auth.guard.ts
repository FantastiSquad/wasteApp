import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AlertController } from '@ionic/angular';

import { StateService } from '../shared/services/state.service';
import { AuthService } from '../shared/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private stateService: StateService, private alertCtrl: AlertController){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if (this.stateService.getConnectionState()){
        return true;
      } else {
        this.showAlert();
        return false;
      }    
  }  

  async showAlert() {
    let alert = await this.alertCtrl.create({
      cssClass: 'my-custom-class',
      header: ':( - Accès non autorisé !',
      message: 'Identifiez-vous pour avoir accès aux fonctionnalités du panier.',
      buttons: ['Fermer']
    });
    alert.present();
  }
}

