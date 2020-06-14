import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { PickupPointService } from '../shared/services/pickup-point.service';
import { PickupPoint } from '../shared/models/pickup-point';
import * as Leaflet from 'leaflet';
import { ModalController, PopoverController } from '@ionic/angular';
import { ResearchZoneFormPage } from '../research-zone-form/research-zone-form.page';
import { ResearchZoneFormPopoverComponent } from '../research-zone-form-popover/research-zone-form-popover.component';
import { Geolocation } from '@capacitor/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.page.html',
  styleUrls: ['./map.page.scss'],
})
export class MapPage implements OnInit, OnDestroy {

    
  public pickupPoints : PickupPoint[] = [];
  // public test: PickupPoint;
  //public locality = new FormControl('');
  public locality: string = "Nice";
  @Input() public localities: string[] = ["Nice"];

  public isGeolocated: boolean = false;

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
  marker: Leaflet.marker;
  //overlayMaps: any;

  constructor(
    public pickupPointService: PickupPointService, 
    public modalController: ModalController,
    private popoverController: PopoverController) {
    console.log("MapPage.constructor()");
    // this.getAllPickupPoints();
  }

  ngOnInit() {
    console.log("MapPage.ngOnInit()");
  }
  
  ionViewDidEnter() { 
    this.leafletMap();
    this.localityConfirm();
  }

  ngOnDestroy(): void {
    // Remove map when we have multiple map object
    this.map.remove();
  }

  async getAllPickupPoints(){
    console.log("MapPage.getAllPickupPoints()");
    this.pickupPoints = <PickupPoint[]>await this.pickupPointService.getAllPickupPoints();
    console.log(this.pickupPoints);
  }

  async getPickupPointById(id : number) {
    console.log("MapPage.getPickupPointById("+id+")");
    let point = <PickupPoint>await this.pickupPointService.getPickupPointById(id);
    this.pickupPoints.push(point);
    console.log(this.pickupPoints);
  }

  async getPickupPointsByLocality(locality: string){
    console.log("MapPage.getPickupPointByLocality("+locality+")");
    if (locality) {
      this.pickupPoints= [];
      this.pickupPoints = <PickupPoint[]>await this.pickupPointService.getPickupPointsByLocality(locality);
    // } else {
    //   this.getAllPickupPoints();
    }
    console.log(this.pickupPoints);
  }

  async findPickupPointsByLocality(keyword: string){
    console.log("MapPage.findPickupPointByLocality("+keyword+")");
    if (keyword) {
      this.pickupPoints = <PickupPoint[]>await this.pickupPointService.findPickupPointsByLocality(keyword);
    } else {
      this.getAllPickupPoints();
    }
    console.log(this.pickupPoints);
  }

  async getPickupPointsByLocalities(localities: string[]) {
    console.log(">>> MapPage.getPickupPointsByLocalities("+localities+")");
    if (localities.length != 0) {
      // this.pickupPoints= PickupPoint[];
      while(this.pickupPoints.length > 0) this.pickupPoints.pop();

      // localities.forEach(async locality => {
      // })
      for (let locality of localities) {
        console.log(">>> locality: "+locality);

        // let points = <PickupPoint[]>await this.pickupPointService.getPickupPointByLocality(locality);
        // console.log(">>> points: "+JSON.stringify(points));

        await this.pickupPointService.getPickupPointsByLocality(locality).then(res => {
          let points = res.map((el) => new PickupPoint(el.id, el.location, el.destination, el.packagingSet));
          //console.log(">>> points: "+JSON.stringify(points));

          this.pickupPoints.push(...points);
          console.log(">>> pickupPoints: "); console.log(this.pickupPoints);
        })
      }
    }
  }

  async localityConfirm() {
    console.log("MapPage.localityConfirm("+this.locality+")");
    if (this.locality) {
      this.localities=new Array(this.locality);
      this.localities= this.locality.split(" ");
      console.log("this.localities: "+this.localities);

      // get & wait list of pickup Points by localities
      await this.getPickupPointsByLocalities(this.localities);

      // disable geolocation mode if necessary
      if (this.pickupPoints.length) { this.isGeolocated = false; }
      
      // update pickupPOints LayerGroup
      this.leafletPickupPointsMarkerUpdate();
    }
  }

  leafletPickupPointsMarkerUpdate() {
    console.log("MapPage.leafletPickupPointsMarkerUpdate()");
    console.log("> pickupPoints: ");
    console.log(this.pickupPoints);

    let markerNumber: number = this.pickupPoints.length;
    
    if (markerNumber) {
      console.log("> marker update processing ...");
      
      // remove Layergroups form layerController
      console.log("> overlays cleaning  ...");
      this.layerController.removeLayer(this.layerPickups);
      this.layerController.removeLayer(this.layerRecyclers);

      // clear Layergroups
      console.log("> Layergroups cleaning  ...");
      this.layerPickups.clearLayers(); // clear pickups Layergroup
      this.layerRecyclers.clearLayers(); // clear recyclers LayerGroup

      //overlay Maps - mock locations
      // console.log("> Mock pickupPoints markers  ...");
      // this.layerPickups.addLayer(new Leaflet.marker([43.687414, 7.208046], {icon: this.markerPickup}).bindPopup('pickup01'));
      // this.layerPickups.addLayer(new Leaflet.marker([43.683629, 7.202659], {icon: this.markerPickup}).bindPopup('pickup02'));
      // this.layerRecyclers.addLayer(new Leaflet.marker([43.693798, 7.198906], {icon: this.markerRecycler}).bindPopup('recycler01'));
      // this.layerRecyclers.addLayer(new Leaflet.marker([43.698536, 7.184249], {icon: this.markerRecycler}).bindPopup('recycler02'));

      // scan pickuPoints for new markers
      console.log("> pickupPoints scan for new markers  ...");
      let pickupLat: string;
      let pickupLon: string;
      let locality: string;
      let marker: Leaflet.marker
      let sumLatitude: number = 0;
      let sumLongitude: number = 0;

      this.pickupPoints.forEach(pickup => {
        // console.log("> pickup: "+JSON.stringify(pickup));
        console.log("> pickup: "); console.log(pickup);
        pickupLat = pickup.getLocation.getGeoLocation.getLatitude; sumLatitude += +pickupLat; //+ convert string to number
        pickupLon = pickup.getLocation.getGeoLocation.getLongitude; sumLongitude += +pickupLon; //+ convert string to number
        locality = pickup.getLocation.getLocality;
        switch ( pickup.getDestination) {
          case "CONTAINER" :
            console.log("> CONTAINER: "+locality+" ("+pickupLat+"/"+pickupLon+")");
            marker = Leaflet.marker([pickupLat, pickupLon], {icon: this.markerPickup}).bindPopup("Point de collecte - " + locality);
            this.layerPickups.addLayer(marker);
            break;
          case "DECHETTERIE" :
            console.log("> DECHETTERIE: "+locality+" ("+pickupLat+"/"+pickupLon+")");
            marker = Leaflet.marker([pickupLat, pickupLon], {icon: this.markerRecycler}).bindPopup("Déchetterie - " + locality);
            this.layerRecyclers.addLayer(marker);
            break;
        }
      })

      // push markers to layerController and map
      console.log("> add new markers to layerController and map ...");
      if (this.layerPickups.getLayers().length) {
        this.layerController.addOverlay(this.layerPickups, "Points de collecte");
        this.layerPickups.addTo(this.map);
      }
      if (this.layerRecyclers.getLayers().length) {
        this.layerController.addOverlay(this.layerRecyclers, "Déchetteries");
        this.layerRecyclers.addTo(this.map);
      }

      // recenter maps if not geolocated
      if (!this.isGeolocated) {
        console.log("> Map recentering  ...");
        let centerLat = sumLatitude/markerNumber; console.log("centerLat: " + centerLat.toFixed(6))
        let centerLon = sumLongitude/markerNumber; console.log("centerLon: " + centerLon.toFixed(6))
        // this.map.panTo(sumLatitude/markerNumber,sumLongitude/markerNumber);
        this.map.flyTo([""+centerLat.toFixed(6),""+centerLon.toFixed(6)], this.zoom);
      }
    }
  }


  leafletMap() {
    console.log("MapPage.leafletMap()");
    
    // map previews : https://leaflet-extras.github.io/leaflet-providers/preview/
    // var osm = Leaflet.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    // var Esri_sat = Leaflet.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', { attribution: 'wasty©2020' });
    // var cdn_base = Leaflet.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    // var stadia = Leaflet.tileLayer('https://tiles.stadiamaps.com/tiles/osm_bright/{z}/{x}/{y}{r}.png', { maxZoom: 20, attribution: 'wasty©2020' });
    var cdn_voyager = Leaflet.tileLayer('https://{s}.basemaps.cartocdn.com/rastertiles/voyager/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    var geoportailFrance = Leaflet.tileLayer('https://wxs.ign.fr/{apikey}/geoportail/wmts?REQUEST=GetTile&SERVICE=WMTS&VERSION=1.0.0&STYLE={style}&TILEMATRIXSET=PM&FORMAT={format}&LAYER=ORTHOIMAGERY.ORTHOPHOTOS&TILEMATRIX={z}&TILEROW={y}&TILECOL={x}', {
      attribution: 'wasty©2020',
      bounds: [[-75, -180], [81, 180]],
      minZoom: 2,
      maxZoom: 19,
      apikey: 'choisirgeoportail',
      format: 'image/jpeg',
      style: 'normal'
    });
    // base Maps
    var baseMaps = {
      // "ESRI Satellite": Esri_sat, "OpenStreetMap": osm,  "cartoCDN Base": cdn_base, "stadia": stadia,
      "GeoportailFrance Satellite": geoportailFrance,
      "cartoCDN Voyager": cdn_voyager,
    };

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

    this.layerPickups = Leaflet.layerGroup(),
    this.layerRecyclers = Leaflet.layerGroup();
    // var overlayMaps = {
    //     "Pickups": this.layerPickups,
    //     "Recyclers": this.layerRecyclers,
    // };
    // Leaflet.control.layers(baseMaps, overlayMaps).addTo(this.map);

    this.map = Leaflet.map('mapId', {
      center: [this.latitude, this.longitude], 
      zoom: this.zoom,
      layers: [ cdn_voyager, geoportailFrance ],
      zoomControl: false,
      attributionControl: false
    });
    this.layerController = Leaflet.control.layers(baseMaps).addTo(this.map);
  }

  
  async openResearchZoneModal() { 
    console.log("MapPage.researchZoneModal()");
    
    const modal = await this.modalController.create({
      component: ResearchZoneFormPage,
      // cssClass: 'my-custom-class',
      componentProps: {
        localities: this.localities,
      },
      showBackdrop: true,
    });
    modal.onDidDismiss().then(data=>{
      console.log("MapPage.researchZoneModal().onDidDismiss("+JSON.stringify(data)+")");
      if (data.data) {
        // this.locality=data.data;
        if (data.data.locality) {
          this.locality=data.data.locality;
          this.localityConfirm();
        }
      } else {
        if (data.role) { console.log("Modal registered sequence: " + data.role); }
        console.log("MapPage.researchZoneModal() cancelled");
      }
    })
    return await modal.present();
  }

  async openResearchZonePopover() { 
    console.log("MapPage.openResearchZonePopover()");
    
    const popover = await this.popoverController.create({
      component: ResearchZoneFormPopoverComponent,
      // cssClass: 'my-custom-class',
      componentProps: {
        localities: this.localities,
      },
      animated: true,
      showBackdrop: true,
    });
    popover.onDidDismiss().then(data=>{
      console.log("MapPage.openResearchZonePopover().onDidDismiss("+JSON.stringify(data)+")");
      if (data.data) {
        // this.locality=data.data;
        if (data.data.locality) {
          this.locality=data.data.locality;
          this.localityConfirm();
        }
      } else {
        if (data.role) { console.log("Popover registered sequence: " + data.role); }
        console.log("MapPage.openResearchZonePopover() cancelled");
      }
    })
    return await popover.present();
  }
  
  async findBySquaredGeolocation(latitude: string, longitude: string, side?: string) {
    console.log(">>> MapPage.findBySquaredGeolocation("+latitude+","+longitude+","+side+")");

    // clean pickupPoints
    while(this.pickupPoints.length > 0) this.pickupPoints.pop();

    // get & wait list of pickup Points
    await this.pickupPointService.findBySquaredGeolocation(this.latitude, this.longitude).then(res => {
      let points = res.map((el) => new PickupPoint(el.id, el.location, el.destination, el.packagingSet));
      //console.log(">>> points: "+JSON.stringify(points));
      
      this.pickupPoints.push(...points);
      console.log(">>> pickupPoints: "); console.log(this.pickupPoints);
    })
  }

  async geoLocate() { 
    console.log("MapPage.GeoLocate()");
    Geolocation.getCurrentPosition()
      .then(async (position) => {
        // store geolocation
        this.isGeolocated = true;
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.accuracy = position.coords.accuracy;
        this.timestamp = (new Date(position.timestamp)).toString();
        console.log("lat/lon/acc: " + this.latitude +" "+ this.longitude +" "+ this.accuracy);
        console.log("time: " + this.timestamp);
        
        //this.getGeoencoder(position.coords.latitude, position.coords.longitude);
      
        //clean geolocation marker if any
        if ( this.marker) {this.map.removeLayer(this.marker);}

        // mark down geolocation ...
        this.marker = Leaflet.marker([this.latitude, this.longitude], {icon: this.markerGeoloc}).bindPopup('Position actuelle.'),
        this.map.addLayer(this.marker);

        // recenter maps
        console.log("> Map recentering  ...");
        this.map.flyTo([this.latitude, this.longitude], this.zoom);

        // get & wait list of pickup Points
        await this.findBySquaredGeolocation(this.latitude, this.longitude);
        
        // update pickupPOints LayerGroup
        this.leafletPickupPointsMarkerUpdate();
      })
      .catch((error) => {
        console.log("Error getting location", error);
        // popover to indicate error ????
      });
  }

  tracker() {console.log("MapPage.tracker()");}
}
