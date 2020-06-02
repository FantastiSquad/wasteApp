import { Packaging } from './packaging';
import { Location } from './location';

export class PickupPoint {

    private id: number;
    private location: Location ;
    private packagingSet: Packaging []; 

    constructor(location: Location, packagingSet: Packaging []){
        
        this.location = location;
        this.packagingSet = packagingSet;
    }

    public get getid(): number { return this.id; }
    public set setid(value: number) { this.id = value; }

	public get getLocation(): Location { return this.location; }
	public set setLocation(location: Location) { this.location = location; }

	public get getPackagingSet(): Packaging [] { return this.packagingSet; }
	public set setPackagingSet(packagingSet: Packaging []) { this.packagingSet = packagingSet; }
}
