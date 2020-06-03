import { City } from './city';

export class Groupment {
    private id: number;
    private name: String;
    private cities: City [];
    
    
    constructor(name: String,cities: City[] ) {
        this.name = name;
        this.cities = cities;
    }
    
    
    /**
     * Getter $id
     * @return {number}
     */
	public get getId(): number {
		return this.id;
	}

    /**
     * Getter $name
     * @return {String}
     */
	public get getName(): String {
		return this.name;
	}


    /**
     * Getter $cities
     * @return {City []}
     */
	public get getCities(): City [] {
		return this.cities;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set setId(value: number) {
		this.id = value;
	}

    /**
     * Setter $name
     * @param {String} value
     */
	public set setName(value: String) {
		this.name = value;
	}

    /**
     * Setter $cities
     * @param {City []} value
     */
	public set setCities(value: City []) {
		this.cities = value;
	}


}
