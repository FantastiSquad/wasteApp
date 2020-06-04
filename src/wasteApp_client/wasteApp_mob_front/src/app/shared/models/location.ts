import { GeoLocation } from './geo-location';

export class Location {

    private geolocation: GeoLocation ;
    private streetNumber: string ; //  subThoroughfare
    private streetName: string ; // thoroughfare
    private postalCode: string ;
    private locality: string ; // City

    constructor(geolocation: GeoLocation, streetNumber: string, streetName: string, postalCode: string, locality: string){
        this.geolocation = geolocation;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public get getGeoLocation(): GeoLocation { return this.geolocation; }
    public set setGeoLocation(geolocation: GeoLocation) { this.geolocation = geolocation; }
    
    public get getStreetNumber(): string { return this.streetNumber; }
    public set setStreetNumber(streetNumber: string) { this.streetNumber = streetNumber; }
    
	public get getStreetName(): string { return this.streetName; }
    public set setStreetName(streetName: string) { this.streetName = streetName; }

    public get getPostalCode(): string { return this.postalCode; }
    public set setPostalCode(postalCode: string) { this.postalCode = postalCode; }
    
	public get getLocality(): string { return this.locality; }
    public set setLocality(locality: string) { this.locality = locality; }
}
