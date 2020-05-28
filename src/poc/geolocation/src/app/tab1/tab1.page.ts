import { Component, OnInit, OnDestroy } from '@angular/core';
import { Geolocation } from '@capacitor/core';
import { NativeGeocoder, NativeGeocoderOptions, NativeGeocoderResult } from '@ionic-native/native-geocoder/ngx';
import * as Leaflet from 'leaflet';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit, OnDestroy {

    // Location coordinates : default : Nice / Colline du château / point de vue
  //marker: any;
  latitude: any ="43.695939";
  longitude: any ="7.279748";
  accuracy: number;
  timestamp: any ="none";

  // GoogleMap plugin
  // map: any;

  // Leaflet Map
  map: Leaflet.Map;
  zoom: number = 13;
  marker: Leaflet.marker;
  markerBase: Leaflet.icon;
  markerYellow: Leaflet.icon;
  markerGreen: Leaflet.icon;

  //Geocoder configuration
  geoencoderOptions: NativeGeocoderOptions = {
    useLocale: true,
    maxResults: 5
  };
  // Readable Address
  address: string;

  constructor(private nativeGeocoder: NativeGeocoder) {}

  ngOnInit(): void {}
  ionViewDidEnter() { this.leafletMap(); }

  ngOnDestroy(): void {
    // Remove map when we have multiple map object
    this.map.remove();
  }
  async getGeoLocation() {
    Geolocation.getCurrentPosition()
      .then((position) => {
        // store geolocation
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.accuracy = position.coords.accuracy;
        this.timestamp = (new Date(position.timestamp)).toString();
        console.log("lat/lon/acc: " + this.latitude +" "+ this.longitude +" "+ this.accuracy);
        console.log("time: " + this.timestamp);
        
        this.getGeoencoder(position.coords.latitude, position.coords.longitude);

        //clean geolocation marker if any
        if ( this.marker) {this.map.removeLayer(this.marker);}

        // mark down geolocation 
        // Leaflet.marker([this.latitude, this.longitude], {icon: this.markerIcon}).addTo(this.map).bindPopup('myLocation').openPopup();
        this.marker = Leaflet.marker([this.latitude, this.longitude], {icon: this.markerBase}).bindPopup('myLocation'),
        this.map.addLayer(this.marker);
        this.map.flyTo([this.latitude, this.longitude], this.zoom);
        // this.map.flyToBounds([this.latitude, this.longitude]);
      })
      .catch((error) => {
        console.log("Error getting location", error);
      });
  }

  //geocoder method to fetch address from coordinates passed as arguments
  getGeoencoder(latitude, longitude) {
    this.nativeGeocoder.reverseGeocode(latitude, longitude, this.geoencoderOptions)
      .then((result: NativeGeocoderResult[]) => {
        this.address = this.generateAddress(result[0]);
      })
      .catch((error: any) => {
        alert('Error getting location' + JSON.stringify(error));
      });
  }

  //Return Comma saperated address
  generateAddress(addressObj) {
    let obj = [];
    let address = "";
    for (let key in addressObj) {
      switch (key) {
        case "areasOfInterest" :
        case "latitude" :
        case "longitude" :
          { break;}
        default:
          { obj.push(addressObj[key]); break; }
      }
    }
    obj.reverse();
    for (let val in obj) {
      if (obj[val].length)
      // address += obj[val];
        address = (address.length ? address + ', ' : '') + obj[val];
    }
    // return address.slice(0, -2);
    return address;
  }

  leafletMap() {
    // this.map = Leaflet.map('mapId').setView([this.latitude, this.longitude], this.zoom);
    // Leaflet.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: 'wasty©2020' }).addTo(this.map);
    
    var osm = Leaflet.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    var cdn = Leaflet.tileLayer('https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png', { attribution: 'wasty©2020' })
    
    this.map = Leaflet.map('mapId', {
      center: [this.latitude, this.longitude], 
      zoom: this.zoom, 
      layers: [osm, cdn]
    });

    // base Maps
    var baseMaps = {
        "OpenStreetMap": osm,
        "cartoCDN": cdn
    };
    // Leaflet.control.layers(baseMaps).addTo(this.map);
    
    // Marker iconing
    this.markerBase = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-base-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });
    this.markerYellow = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-yellow-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });
    this.markerGreen = new Leaflet.icon({
      iconUrl: 'assets/marker/marker-green-icon.png',
      shadowUrl: 'assets/marker/marker-shadow.png',
      iconSize: [ 25, 40 ],
      iconAnchor: [ 13, 40 ],
    });

    //overlay Maps - mock locations
    var pickup01 = Leaflet.marker([43.687414, 7.208046], {icon: this.markerGreen}).bindPopup('pickup01'),
    pickup02    = Leaflet.marker([43.683629, 7.202659], {icon: this.markerGreen}).bindPopup('pickup02'),
    recycler01    = Leaflet.marker([43.693798, 7.198906], {icon: this.markerYellow}).bindPopup('recycler01'),
    recycler02    = Leaflet.marker([43.698536, 7.184249], {icon: this.markerYellow}).bindPopup('recycler02');

    var pickups = Leaflet.layerGroup([pickup01, pickup02]),
    recyclers = Leaflet.layerGroup([recycler01, recycler02]);

    var overlayMaps = {
        "Pickups": pickups,
        "Recyclers": recyclers,
    };

    Leaflet.control.layers(baseMaps, overlayMaps).addTo(this.map);

    // antPath([[28.644800, 77.216721], [34.1526, 77.5771]],
    //   { color: '#FF0000', weight: 5, opacity: 0.6 })
    //   .addTo(this.map);
  }
}
