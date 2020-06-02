import { Component, OnInit } from '@angular/core';
import { CityService } from '../../shared/services/city.service';
import { City } from '../../shared/models/city';
import { BinTarget } from '../../shared/models/bin-target';

@Component({
  selector: 'app-tabcity',
  templateUrl: './tabcity.page.html',
  styleUrls: ['./tabcity.page.scss'],
})
export class TabcityPage implements OnInit {
  public cityList : City[];
  public binTarget : BinTarget[] = new Array<BinTarget>();  
  public cityToCreate : City;

  constructor(public cityService: CityService ) {
    this.cityList = [];  
    this.binTarget.push(new BinTarget("category", "vert", "MENAGER", "verre"));
    this.binTarget.push(new BinTarget("category", "marron", "MENAGER", "ordinaire"));
    this.cityToCreate = new City("Juan-les-pins", "06160", this.binTarget);

   }

  ngOnInit() {
    this.getAllCities();
    this.createCity(this.cityToCreate);
  }
  async getAllCities(){
    this.cityList = await this.cityService.getAllCities();
    console.log(this.cityList);
  }

  async getCityById(id : number){
    this.cityList = await this.cityService.getCityById(id);
    console.log(this.cityList);
  }

  async getCityByName(name: string){
    this.cityList =  await this.cityService.getCityByName(name);
    console.log(this.cityList);
  }

  async deleteCityById(id: number){
    await this.cityService.deleteCity(id);
    console.log(`ville id ${id} bien supprimée!`);

  }

  async createCity(city: City){
    console.log("Avant l'appel au service" + Object.values(city));
    await this.cityService.createCity(city);
  
  }
}
