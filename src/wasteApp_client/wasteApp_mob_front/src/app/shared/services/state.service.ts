import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class StateService {
 connectionState = false;

  constructor() { }

  public setConnectionState(value: boolean): void{
     this.connectionState = true; 
    
  }

  public getConnectionState(){
    return this.connectionState;
  }


}

