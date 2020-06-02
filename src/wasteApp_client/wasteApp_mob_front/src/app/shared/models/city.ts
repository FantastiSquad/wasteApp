import { BinTarget } from './bin-target';

export class City {
    private id: number; 
    private name: String;
    private citycode: String;
    private binTarget: BinTarget [];
    
    constructor(name: String, citycode: String, binTarget: BinTarget []){
        
        this.name = name;
        this.citycode = citycode;
        this.binTarget = binTarget;
    }
    /*Getters and Setters */
    
    public get getid(): number {
        return this.id;
    }
    public set setid(value: number) {
        this.id = value;
    }
    
    /**
     * Getter name
     * @return {String}
     */
	public get getname(): String {
		return this.name;
	}

    /**
     * Getter cityCode
     * @return {String}
     */
	public get getcitycode(): String {
		return this.citycode;
	}

    /**
     * Getter binTarget
     * @return {Object []}
     */
	public get getbinTarget(): BinTarget [] {
		return this.binTarget;
	}

    /**
     * Setter name
     * @param {String} value
     */
	public set setname(value: String) {
		this.name = value;
	}

    /**
     * Setter cityCode
     * @param {String} value
     */
	public set setcitycode(value: String) {
		this.citycode = value;
	}

    /**
     * Setter binTarget
     * @param {Object []} value
     */
	public set setbinTarget(value: BinTarget []) {
		this.binTarget = value;
	}   

}

