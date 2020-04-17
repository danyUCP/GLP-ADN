package ADN;

import meiose.Centromere;

public class Chromatide {

	private String name;
	
	/**Constructeur des Chromatides*/
	public Chromatide(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	/**
	 * @return la chromatide
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param le chromatides à modifier
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** return le nom de Chromatide*/
	public String toString () {
		return name;
	}
	

}
