import { Injectable } from '@angular/core';
import { ApiHelperService } from './api-helper.service';

@Injectable({
  providedIn: 'root'
})
export class GroupmentService {

  constructor(private api: ApiHelperService) { }

  //return the list of groupments
  public getAllGroupments(){
   return this.api.get({endpoint: `/groupment`}); 
  }

  //return groupment by his name or a part of his name
  public getGroupmentByName(name: String){
    return this.api.get({endpoint: `/groupment/${name}`} );

  }
}
