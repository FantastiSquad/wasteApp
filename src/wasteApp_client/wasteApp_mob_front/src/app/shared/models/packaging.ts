import { PickupPoint } from './pickup-point';

export class Packaging {

    private id: number;
    private pickupPointSet: PickupPoint[];

    constructor(pickupPointSet: PickupPoint []){
        
        this.pickupPointSet = pickupPointSet;
    }

    public get getid(): number { return this.id; }
    public set setid(value: number) { this.id = value; }

	public get getPickupPointSet(): PickupPoint [] { return this.pickupPointSet; }
	public set setPickupPointSet(pickupPointSet: PickupPoint []) { this.pickupPointSet = pickupPointSet; }
}
