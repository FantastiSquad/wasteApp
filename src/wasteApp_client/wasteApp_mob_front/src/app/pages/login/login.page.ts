import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AlertController} from '@ionic/angular';
import { AuthService } from 'src/app/shared/services/auth.service';
import { DataService } from 'src/app/shared/services/data.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  user = {
    email: 'user',
    password: 'user'
  };
  isSubmitted = false;
  loginForm: FormGroup;
 
  constructor(private authService : AuthService, private router: Router, private alertCtrl: AlertController, private dataService: DataService, public formBuilder: FormBuilder) { }

  ngOnInit() {
    this.buildLoginForm();
  }

  loginUser(){
    this.isSubmitted = true;
    console.log(this.loginForm.value);
    this.authService.login(this.loginForm.value.email, this.loginForm.value.password)
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

  buildLoginForm(){
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.minLength(2)]],
      password: ['', [Validators.required]],
    });
  }

  get errorControl(){
    return this.loginForm.controls;
  }
}

