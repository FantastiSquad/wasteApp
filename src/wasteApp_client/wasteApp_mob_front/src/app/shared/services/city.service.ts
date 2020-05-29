import { Injectable } from '@angular/core';
import {City} from '../models/city';
import { ApiHelperService } from './api-helper.service';


@Injectable({
  providedIn: 'root'
})
export class CityService {
  public cities: City[];

  constructor(private api: ApiHelperService) {} 

  public getCityById(id: number): Promise<any>{
    let endpoint = `/city/${id}`;
    let promise = new Promise((resolve, reject) => {
      this.api.get({ endpoint: endpoint})
          .then( 
            res => {
            resolve(res); 
          },
            msg => {
              reject(msg);
          }            
        ).catch((error) => {});
    });
    return promise;
  }

  public getAllCities(): Promise<any>{
    let promise = new Promise((resolve, reject) => {
      this.api.get({endpoint: `/city`})
          .then(
            res => {
              resolve(res);
            },
            msg => {
              reject(msg);
            }
          ).catch((error) => {

          });
    });
    return promise;
  }

  public deleteCity(id: number): Promise<any>{
    let endpoint = `/city/${id}`;
    let promise = new Promise((resolve, reject) =>{
        this.api.delete({ endpoint: endpoint})
            .then(
              res => {
                resolve(res);
              },
              
                msg => {
                  reject(msg);
              }
        ).catch((error) => {
          console.log("Impossible d'avoir la ville par id");
        });

    });
    return promise;

  }

  public getCityByName(name: string): Promise<any>{
    let endpoint = `/city/searchCity/${name}`;
    let promise = new Promise((resolve, reject) => {
      this.api.get({ endpoint: endpoint})
          .then(
            res => {
              resolve(res);
            },
            msg => {
               reject(msg);
            }
          ).catch((error) => {
            console.log("impossible d'avoir la ville par nom!");
          });

    });
    return promise;
  }

  public createCity(city: City): Promise<any>{
    let endpoint = `/city`;
    console.log(`avant l'envoi: ${Object.values(city)}`);
    let promise = new Promise((resolve, reject) => {
      this.api.post({ endpoint : endpoint, data : city})
          .then(
             res => { 
               resolve(res);
               city.getbinTarget.forEach(function(value,key){ 
                 console.log(value); console.log(key); console.log({...city});
                });
               
             },
             msg => {
               reject(msg);
             }
          ).catch((error) => {
            console.log("create city ne fonctionne pas");
          });
    });
    return promise;
  }
}

