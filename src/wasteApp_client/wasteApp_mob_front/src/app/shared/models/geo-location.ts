export class GeoLocation {

    private latitude: string ;
    private longitude: string ;

    constructor(latitude: string, longitude: string){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public get getLatitude(): string { return this.latitude; }
    public set setLatitude(latitude: string) { this.latitude = latitude; }
    
	public get getLongitude(): string { return this.longitude; }
    public set setLongitude(longitude: string) { this.longitude = longitude; }
}
