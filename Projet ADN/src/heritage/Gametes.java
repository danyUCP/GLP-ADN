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
	
	
	
	/**
	 * @return the liste1
	 */
	public ArrayList<Chromatide> getListe1() {
		return liste1;
	}

	/**
	 * @param liste1 the liste1 to set
	 */
	public void setListe1(ArrayList<Chromatide> liste1) {
		this.liste1 = liste1;
	}

	@Override
	public String toString() {
		return "Gametes [" + liste1 + "]";
	}
	

	
	
}
