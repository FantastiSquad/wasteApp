import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
private data = [];
isLogged = false;
  constructor() { }

  setData(role: string, data){
    this.data[role] = data;
  }
  getData(role){
    return this.data[role];
  }

  
    
}
