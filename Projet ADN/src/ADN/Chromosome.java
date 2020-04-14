package ADN;

import meiose.Centromere;

public class Chromosome {

	private String name;
	public Chromosome(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString () {
		return name;
	}
	

}
