export class BinTarget {
    private category : String;
    private material : String;
    private destination : String;
    private color : String;


	constructor(category: String, material: String, destination: String, color: String) {
		this.category = category;
		this.material = material;
		this.destination = destination;
		this.color = color;
	}

    /**
     * Getter category
     * @return {String}
     */
	public get getcategory(): String {
		return this.category;
	}

    /**
     * Getter material
     * @return {String}
     */
	public get getmaterial(): String {
		return this.material;
	}

    /**
     * Getter destination
     * @return {String}
     */
	public get getdestination(): String {
		return this.destination;
	}

    /**
     * Getter color
     * @return {String}
     */
	public get getcolor(): String {
		return this.color;
	}

    /**
     * Setter category
     * @param {String} value
     */
	public set getcategory(value: String) {
		this.category = value;
	}

    /**
     * Setter material
     * @param {String} value
     */
	public set setmaterial(value: String) {
		this.material = value;
	}

    /**
     * Setter destination
     * @param {String} value
     */
	public set setdestination(value: String) {
		this.destination = value;
	}

    /**
     * Setter color
     * @param {String} value
     */
	public set setcolor(value: String) {
		this.color = value;
	}

    

}

