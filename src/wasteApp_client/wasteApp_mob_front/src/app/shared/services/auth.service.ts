import { Injectable } from '@angular/core';
import { StateService } from './state.service';
import { Router } from '@angular/router';

export interface User {
  name: string;
  role: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  currentUser: User;
  
  constructor(private stateService: StateService, private router: Router) { }

  login(name: string, pw: string) : Promise<boolean> {
    return new Promise((resolve,reject) => {
      if(name==='user' && pw === 'user'){
        this.currentUser = {
          name: name,
          role: 'user'
        };
        this.stateService.setConnectionState(true);
        resolve(true);
      } else if (name==='admin' && pw === 'admin'){
        this.currentUser = {
          name: name,
          role: 'admin'
      };
      this.stateService.setConnectionState(true);
         resolve(true);
      } else {
        
        reject(false);
      }
    })
  }


  isAdmin(){
    return this.currentUser.role === 'admin';
  }

  hasRole(roles: string[]): boolean {
    for(const oneRole of roles){
      if(!this.currentUser || !this.currentUser.role)
      return false;
    }
    return true;
  }

  signOut() {
    this.stateService.setConnectionState(false);
    this.router.navigateByUrl('/tabs/tab-home/home');
  }
}

