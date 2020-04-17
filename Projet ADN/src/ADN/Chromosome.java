package ADN;

import meiose.Centromere;

public class Chromosome {

	private String name;
	
	/**Constructeur des Chromosome*/
	public Chromosome(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	/**
	 * @return le chromosome
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param le chromosome à modifier
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** return le nom de Chromosome*/
	public String toString () {
		return name;
	}
	

}
