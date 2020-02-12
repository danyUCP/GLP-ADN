package heritage;

import java.util.ArrayList;

public class Gametes {
	private ArrayList<Chromatide> liste1;
	
	private String nom;
	
	/**
	 * 
	 */
	public Gametes() {
		this.liste1 = new ArrayList<Chromatide>();
	}
	
	public void construire (Chromatide c) {
		this.liste1.add(c);
	}
	
	
	@Override
	public String toString() {
		return "Gametes [" + liste1 + "]";
	}
	

	
	
}
