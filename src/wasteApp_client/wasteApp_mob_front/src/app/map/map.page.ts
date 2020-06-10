import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { PickupPointService } from '../shared/services/pickup-point.service';
import { PickupPoint } from '../shared/models/pickup-point';
import * as Leaflet from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.page.html',
  styleUrls: ['./map.page.scss'],
})
export class MapPage implements OnInit, OnDestroy {

    
  public pickupPoints : PickupPoint[];
  //public locality = new FormControl('');
  public locality: string = "";
  @Input() public localities: string[] = ["Nice"];

  // Location coordinates : default : Nice / Colline du château / point de vue
  //marker: any;
  latitude: any ="43.695939";
  longitude: any ="7.279748";
  accuracy: number;
  timestamp: any ="none";

  // Leaflet Map
  map: Leaflet.Map;
  zoom: number = 13;
  layerController: Leaflet.control;
  layerPickups: Leaflet.layerGroup;
  layerRecyclers: Leaflet.layerGroup;
  markerGeoloc: Leaflet.icon;
  markerPickup: Leaflet.icon;
  markerRecycler: Leaflet.icon;
  //marker: Leaflet.marker;
  //overlayMaps: any;

  constructor(public pickupPointService: PickupPointService) {
    console.log("MapPage.constructor()");
    // this.getAllPickupPoints();
  }

  ngOnInit() {
    console.log("MapPage.ngOnInit()");
    //this.localityConfirm();
    // this.getPickupPointsByLocalities(this.localities);
  }

  ionViewDidEnter() { 
    this.leafletMap();
    // this.leafletPickupPointsMarkerUpdate();
  }

  ngOnDestroy(): void {
    // Remove map when we have multiple map object
    this.map.remove();
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
      this.pickupPoints= [];
      this.pickupPoints = await this.pickupPointService.getPickupPointByLocality(locality);
    // } else {
    //   this.getAllPickupPoints();
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

  async getPickupPointsByLocalities(localities: string[]) {
    console.log(">>> MapPage.getPickupPointsByLocalities("+localities+")");
    if (localities.length != 0) {
      this.pickupPoints= [];

      // localities.forEach(async locality => {
      //   console.log("> locality: "+locality);
      //   let points = await this.pickupPointService.getPickupPointByLocality(locality);
      //   console.log("> points: "+points);
      //   this.pickupPoints.push(points);
      //   console.log("> pickupPoints: "+this.pickupPoints);
      // })
      for (let locality of localities) {
        console.log(">>> locality: "+locality);
        let points = await this.pickupPointService.getPickupPointByLocality(locality);
        console.log(">>> points: "+JSON.stringify(points));
        this.pickupPoints.push(points);
        console.log(">>> pickupPoints: "+this.pickupPoints.toString());
      }
    }
  }

  localityConfirm() {
    console.log("MapPage.localityConfirm("+this.locality+")");
    // this.findPickupPointByLocality(this.locality);
    // this.getPickupPointByLocality(this.locality);
    this.localities=new Array(this.locality);
    this.localities= this.locality.split(" ");
    console.log("this.localities: "+this.localities);
    // await this.getPickupPointsByLocalities(this.localities);
    // update pickupPOints LayerGroup
    this.leafletPickupPointsMarkerUpdate();
  }

  leafletMap() {
    console.log("MapPage.leafletMap()");
    // this.map = Leaflet.map('mapId').setView([this.latitude, this.longitude], this.zoom);
    // Leaflet.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: 'wasty©2020' }).addTo(this.map);
    
    // https://leaflet-extras.github.io/leaflet-providers/preview/
    // var osm = Leaflet.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    // var Esri_sat = Leaflet.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', { attribution: 'wasty©2020' });
    var cdn_base = Leaflet.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    var cdn_voyager = Leaflet.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    var GeoportailFrance = Leaflet.tileLayer('https://wxs.ign.fr/{apikey}/geoportail/wmts?REQUEST=GetTile&SERVICE=WMTS&VERSION=1.0.0&STYLE={style}&TILEMATRIXSET=PM&FORMAT={format}&LAYER=ORTHOIMAGERY.ORTHOPHOTOS&TILEMATRIX={z}&TILEROW={y}&TILECOL={x}', {
      attribution: 'wasty©2020',
      bounds: [[-75, -180], [81, 180]],
      minZoom: 2,
      maxZoom: 19,
      apikey: 'choisirgeoportail',
      format: 'image/jpeg',
      style: 'normal'
    });

    this.map = Leaflet.map('mapId', {
      center: [this.latitude, this.longitude], 
      zoom: this.zoom, 
      layers: [ cdn_base, cdn_voyager, GeoportailFrance ],
      attributionControl: false
    });

    // base Maps
    var baseMaps = {
      // "ESRI Satellite": Esri_sat,
      // "OpenStreetMap": osm,
      "GeoportailFrance Satellite": GeoportailFrance,
      "cartoCDN Base": cdn_base,
      "cartoCDN Voyager": cdn_voyager,
    };
    // Leaflet.control.layers(baseMaps).addTo(this.map);
    
    // Marker iconing : geolocation, recycler and pickup points
    this.markerGeoloc = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-base-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });
    this.markerPickup = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-green-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });
    this.markerRecycler = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-yellow-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });

    //overlay Maps - mock locations
    // var pickup01 = Leaflet.marker([43.687414, 7.208046], {icon: this.markerPickup}).bindPopup('pickup01'),
    // pickup02    = Leaflet.marker([43.683629, 7.202659], {icon: this.markerPickup}).bindPopup('pickup02'),
    // recycler01    = Leaflet.marker([43.693798, 7.198906], {icon: this.markerRecycler}).bindPopup('recycler01'),
    // recycler02    = Leaflet.marker([43.698536, 7.184249], {icon: this.markerRecycler}).bindPopup('recycler02');
    
    this.layerPickups = Leaflet.layerGroup(),
    this.layerRecyclers = Leaflet.layerGroup();

    // var overlayMaps = {
    //     "Pickups": this.layerPickups,
    //     "Recyclers": this.layerRecyclers,
    // };

    // Leaflet.control.layers(baseMaps, overlayMaps).addTo(this.map);
    this.layerController = Leaflet.control.layers(baseMaps).addTo(this.map);
    this.leafletPickupPointsMarkerUpdate();
  }

  leafletPickupPointsMarkerUpdate() {
    console.log("MapPage.leafletPickupPointsMarkerUpdate()");
    this.getPickupPointsByLocalities(this.localities);

    console.log("> marker update processing ...");
    var sumLatitude = 0;
    var sumLongitude = 0;
    // var markerNumber= this.pickupPoints.length;
    var markerNumber= 4;

    if (markerNumber != 0) {

      console.log("> overlays cleaning  ...");
      // remove Layergroups form map or control  ??
      this.layerController.removeLayer(this.layerPickups);
      this.layerController.removeLayer(this.layerRecyclers);
      // or
      // this.map.removeLayer(this.layerPickups);
      // this.map.removeLayer(this.layerRecyclers);
      //or
      // this.layerPickups.onRemove(this.map);
      // this.layerRecyclers.onRemove(this.map);
      // clear Layergroups
      console.log("> Layergroups cleaning  ...");
      this.layerPickups.clearLayers(); // clear pickups Layergroup
      this.layerRecyclers.clearLayers(); // clear recyclers LayerGroup
      
      console.log("> pickupPoints scan for new markers  ...");
      this.pickupPoints.forEach(pickup => {
        var pickupLat = pickup.getLocation.getGeoLocation.getLatitude; sumLatitude += +pickupLat;
        var pickupLon = pickup.getLocation.getGeoLocation.getLongitude; sumLongitude += +pickupLon;
        var locality = pickup.getLocation.getLocality;
        console.log("> "+locality+" ("+pickupLat+"/"+pickupLon+")");
        switch ( pickup.getDestination) {
          case "CONTAINER" :
            console.log("> CONTAINER");
            var marker = Leaflet.marker([pickupLat, pickupLon], {icon: this.markerPickup}).bindPopup("Point de collecte - " + locality);
            this.layerPickups.addLayer(marker);
            break;
          case "DECHETTERIE" :
            console.log("> DECHETTERIE");
            var marker = Leaflet.marker([pickupLat, pickupLon], {icon: this.markerRecycler}).bindPopup("Déchetterie - " + locality);
            this.layerRecyclers.addLayer(marker);
            break;
        }
      })

      console.log("> Mock pickupPoints markers  ...");
      //overlay Maps - mock locations
      this.layerPickups.addLayer(new Leaflet.marker([43.687414, 7.208046], {icon: this.markerPickup}).bindPopup('pickup01'));
      this.layerPickups.addLayer(new Leaflet.marker([43.683629, 7.202659], {icon: this.markerPickup}).bindPopup('pickup02'));
      this.layerRecyclers.addLayer(new Leaflet.marker([43.693798, 7.198906], {icon: this.markerRecycler}).bindPopup('recycler01'));
      this.layerRecyclers.addLayer(new Leaflet.marker([43.698536, 7.184249], {icon: this.markerRecycler}).bindPopup('recycler02'));

      console.log("> add new markers to layerController  ...");
      if (this.layerPickups.getLayers().length) this.layerController.addOverlay(this.layerPickups, "Pickups");
      if (this.layerRecyclers.getLayers().length) this.layerController.addOverlay(this.layerRecyclers, "Recyclers");

      // recenter maps
      // this.map.panTo(sumLatitude/markerNumber,sumLongitude/markerNumber);
      // this.map.flyTo(sumLatitude/markerNumber,sumLongitude/markerNumber);
    }
  }
}
