import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class DataResolverService implements Resolve<any>{

  constructor(private dataService: DataService) { }
  
  resolve(route: ActivatedRouteSnapshot){
    let role = route.paramMap.get('role');
    return this.dataService.getData(role);
  }
}

