import { Component, OnInit } from '@angular/core';
import { PickupPoint } from '../../shared/models/pickup-point';
import { PickupPointService } from '../../shared/services/pickup-point.service';
import { GeoLocation } from '../../shared/models/geo-location';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-tab-pickup-points',
  templateUrl: './tab-pickup-points.page.html',
  styleUrls: ['./tab-pickup-points.page.scss'],
})
export class TabPickupPointsPage implements OnInit {

  public pickupPoints : PickupPoint[];
  //public locality = new FormControl('');
  public locality: string ="";

  constructor(public pickupPointService: PickupPointService) {
    console.log("TabPickupPointsPage.constructor()");
    // this.getAllPickupPoints();
  }

  ngOnInit() {
    console.log("TabPickupPointsPage.ngOnInit()");
    this.getPickupPointByLocality(this.locality);
  }

  async getAllPickupPoints(){
    console.log("TabPickupPointsPage.getAllPickupPoints()");
    this.pickupPoints = await this.pickupPointService.getAllPickupPoints();
    console.log(this.pickupPoints);
  }

  async getPickupPointById(id : number){
    this.pickupPoints = await this.pickupPointService.getPickupPointById(id);
    console.log(this.pickupPoints);
  }

  async getPickupPointByLocality(locality: string){
    if (locality) {
      this.pickupPoints = await this.pickupPointService.getPickupPointByLocality(locality);
    } else {
      this.getAllPickupPoints();
    }
    console.log(this.pickupPoints);
  }

  async getPickupPointByGeoLocation(geolocation: GeoLocation){
    this.pickupPoints = await this.pickupPointService.getPickupPointByGeoLocation(geolocation);
    console.log(this.pickupPoints);
  }

  async saveOrUpdatecreatePickupPoint(pickupPoint: PickupPoint){
    console.log("Avant l'appel au service" + Object.values(pickupPoint));
    await this.pickupPointService.saveOrUpdatecreatePickupPoint(pickupPoint);
  
  }

  async deletePickupPointById(id : number){
    this.pickupPoints = await this.pickupPointService.deletePickupPointById(id);
    console.log(this.pickupPoints);
  }

  logForm() {
    console.log(this.locality);
    this.getPickupPointByLocality(this.locality);
  }
}
