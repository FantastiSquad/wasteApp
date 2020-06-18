import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  isSubmitted = false;
  private _emailRegex = '^(([^<>()\\[\\]\\\\.,;:\\s@"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@"]+)*)|(".+"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$';
  registerForm: FormGroup;
 
 

  constructor(public formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    //Initialisation à vide du formulaire
    this.buildRegisterForm();
  }
  submitRegisterForm(){
    
    this.isSubmitted = true;
    if(!this.registerForm.valid){
      console.log("Veuillez renseigner tous les champs");
      // this.router.navigateByUrl('/login');
    } else {
      console.log(this.registerForm.value);
    }
  }

  buildRegisterForm(){
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.minLength(2)]],
      password: ['', [Validators.required]],
      passwordConfirmation: ['', [Validators.required]]

   });
  }

  get errorControl(){
    return this.registerForm.controls;
  }
}
