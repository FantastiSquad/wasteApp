export class GeoLocation {

    private latitude: string ;
    private longitude: string ;
    private roadDistance: string ;
    private roadDuration: string ;

    constructor(latitude: string, longitude: string, roadDistance?: string, roadDuration?: string){
        this.latitude = latitude;
        this.longitude = longitude;
        this.roadDistance = roadDistance;
        this.roadDuration = roadDuration;
    }

    public get getLatitude(): string { return this.latitude; }
    public set setLatitude(latitude: string) { this.latitude = latitude; }
    
	public get getLongitude(): string { return this.longitude; }
    public set setLongitude(longitude: string) { this.longitude = longitude; }
    
    public get getRoadDistance(): string { return this.roadDistance; }
    public set setRoadDistance(roadDistance: string) { this.roadDistance = roadDistance; }

    public get getRoadDuration(): string { return this.roadDuration; }
    public set setRoadDuration(roadDuration: string) { this.roadDuration = roadDuration; }

}
