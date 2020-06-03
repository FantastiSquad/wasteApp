import { Packaging } from './packaging';
import { Location } from './location';

export class PickupPoint {

    private id: number;
    private location: Location ;
    private destination : string;
    private packagingSet: Packaging []; 

    constructor(location: Location, destination : string, packagingSet: Packaging []){
        
        this.location = location;
        this.destination = destination;
        this.packagingSet = packagingSet;
    }

    public get getid(): number { return this.id; }
    public set setid(value: number) { this.id = value; }

	public get getLocation(): Location { return this.location; }
    public set setLocation(location: Location) { this.location = location; }
    
    public get getDestination(): string { return this.destination; }
    public set setDestination(destination: string) { this.destination = destination; }

	public get getPackagingSet(): Packaging [] { return this.packagingSet; }
	public set setPackagingSet(packagingSet: Packaging []) { this.packagingSet = packagingSet; }
}
