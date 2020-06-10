import { Component, OnInit, Input } from '@angular/core';
import { PickupPointService } from '../shared/services/pickup-point.service';
import { PickupPoint } from '../shared/models/pickup-point';

@Component({
  selector: 'app-map',
  templateUrl: './map.page.html',
  styleUrls: ['./map.page.scss'],
})
export class MapPage implements OnInit {

  public pickupPoints : PickupPoint[];
  //public locality = new FormControl('');
  public locality: string = "";
  @Input() public localities: string[] = [];

  constructor(public pickupPointService: PickupPointService) {
    console.log("MapPage.constructor()");
    // this.getAllPickupPoints();
  }

  ngOnInit() {
    console.log("MapPage.ngOnInit()");
    this.getPickupPointsByLocalities(this.localities);
  }


  async getAllPickupPoints(){
    console.log("MapPage.getAllPickupPoints()");
    this.pickupPoints = await this.pickupPointService.getAllPickupPoints();
    console.log(this.pickupPoints);
  }

  async getPickupPointById(id : number){
    console.log("MapPage.getPickupPointById("+id+")");
    this.pickupPoints = await this.pickupPointService.getPickupPointById(id);
    console.log(this.pickupPoints);
  }

  async getPickupPointByLocality(locality: string){
    console.log("MapPage.getPickupPointByLocality("+locality+")");
    if (locality) {
      this.pickupPoints = await this.pickupPointService.getPickupPointByLocality(locality);
    } else {
      this.getAllPickupPoints();
    }
    console.log(this.pickupPoints);
  }

  async findPickupPointByLocality(keyword: string){
    console.log("MapPage.findPickupPointByLocality("+keyword+")");
    if (keyword) {
      this.pickupPoints = await this.pickupPointService.findPickupPointByLocality(keyword);
    } else {
      this.getAllPickupPoints();
    }
    console.log(this.pickupPoints);
  }

  getPickupPointsByLocalities(localities: string[]) {
    console.log("MapPage.getPickupPointsByLocalities("+localities+")");
    if (localities.length != 0) {
      this.pickupPoints= [];

      localities.forEach(async locality => {
        console.log("> locality: "+locality);
        let points = await this.pickupPointService.getPickupPointByLocality(locality);
        console.log("> points: "+points);
        this.pickupPoints.push(points);
        console.log("> pickupPoints: "+this.pickupPoints);
      })
    }
  }
  
  localityConfirm() {
    console.log("MapPage.localityConfirm("+this.locality+")");
    // this.findPickupPointByLocality(this.locality);
    // this.getPickupPointByLocality(this.locality);
    this.localities=new Array(this.locality);
    this.localities= this.locality.split(" ");
    console.log("this.localities: "+this.localities);
    this.getPickupPointsByLocalities(this.localities);
  }
}
