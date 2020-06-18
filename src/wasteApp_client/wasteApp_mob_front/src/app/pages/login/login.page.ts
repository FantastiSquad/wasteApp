import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AlertController} from '@ionic/angular';
import { AuthService } from 'src/app/shared/services/auth.service';
import { DataService } from 'src/app/shared/services/data.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  user = {
    name: 'user',
    pw: 'user'
  };
 
  constructor(private authService : AuthService, private router: Router, private alertCtrl: AlertController, private dataService: DataService) { }

  ngOnInit() {
  }

  loginUser(){
    this.authService.login(this.user.name, this.user.pw)
        .then(success => {
          if (success) {
            console.log(`le role newsPage est:${this.authService.currentUser.role}`);
            let data = this.authService.currentUser.role;
                      
            this.dataService.setData('role', data );
            this.router.navigateByUrl('/tabs/tab-home/role');
          } 
        }).catch(err =>{
          this.presentAlert();
        });
  }

  async presentAlert() {
    const alert = await this.alertCtrl.create({
      cssClass: 'my custom-class',
      header: 'Erreur de Login',
      message: 'Veuillez vérifier vos informations de connexion',
      buttons: ['OK']
    });
    alert.present();
   
  }
}

