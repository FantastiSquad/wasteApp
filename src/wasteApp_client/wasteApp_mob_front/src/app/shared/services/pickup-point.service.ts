import { Injectable } from '@angular/core';
import { ApiHelperService } from './api-helper.service';
import { PickupPoint } from '../models/pickup-point';
import { GeoLocation } from '../models/geo-location';

@Injectable({
  providedIn: "root",
})
export class PickupPointService {

  private endpoint: string = "/pickups";

  constructor(private api: ApiHelperService) {}

  public getAllPickupPoints(): Promise<any> {
    console.log("PickupPointService.getAllPickupPoints()");
    let promise = new Promise((resolve, reject) => {
      this.api
        .get({ endpoint: this.endpoint })
        .then(
          (res) => { resolve(res); },
          (msg) => { reject(msg); }
        )
        .catch((error) => { console.log("aucun point de collecte disponible."); });
    });
    return promise;
  }

  public getPickupPointById(id: number): Promise<any> {
    let endpoint = this.endpoint + "/${id}";
    let promise = new Promise((resolve, reject) => {
      this.api
        .get({ endpoint: endpoint })
        .then( 
          (res) => { resolve(res); },
          (msg) => { reject(msg); }
        )
        .catch((error) => { console.log("Aucun point de collecte disponible avec l'id : " + id); });
    });
    return promise;
  }

  public getPickupPointByLocality(locality: string): Promise<any>{
    let endpoint = this.endpoint + `/locality/${locality}`;
    let promise = new Promise((resolve, reject) => {
      this.api.get({ endpoint: endpoint})
          .then(
            res => { resolve(res); },
            msg => {  reject(msg); }
          ).catch((error) => { console.log("Aucun point de collecte disponible avec la localité: " + locality); });

    });
    return promise;
  }

  public getPickupPointByGeoLocation(geolocation: GeoLocation): Promise<any>{
    let endpoint = this.endpoint + `/geolocation`;
    let promise = new Promise((resolve, reject) => {
      this.api.get({ 
        endpoint: endpoint,
        queryParams: { lat: geolocation.getLatitude, lon: geolocation.getLongitude }})
          .then(
            res => { resolve(res); },
            msg => {  reject(msg); }
          ).catch((error) => { console.log("Aucun point de collecte disponible avec la geolocation: " + geolocation); });

    });
    return promise;
  }


  public saveOrUpdatecreatePickupPoint(pickupPoint: PickupPoint): Promise<any> {
    let endpoint = this.endpoint;
    //console.log(`avant l'envoi: ${Object.values(city)}`);
    let promise = new Promise((resolve, reject) => {
      this.api
        .post({ endpoint: endpoint, data: pickupPoint })
        .then(
          (res) => {
            resolve(res);
            pickupPoint.getPackagingSet.forEach(function (value, key) {
              console.log(value);
              console.log(key);
            });
            console.log({ ...pickupPoint });
          },
          (msg) => {
            reject(msg);
          }
        )
        .catch((error) => {
          console.log("Impossible de sauver le point de collecte fourni.");
        });
    });
    return promise;
  }

  public deletePickupPointById(id: number): Promise<any>{
    let endpoint = `/city/${id}`;
    let promise = new Promise((resolve, reject) =>{
        this.api.delete({ endpoint: endpoint})
            .then(
              res => { resolve(res); },
              msg => { reject(msg); }
        ).catch((error) => {
          console.log("Impossible d'effacer le point de collecte fourni.");
        });

    });
    return promise;

  }
}
