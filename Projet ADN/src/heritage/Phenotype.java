package heritage;

import java.util.ArrayList;

public class Phenotype {
	private Allele g ;
	

	/**
	 * @param g
	 */
	public Phenotype(Allele g) {
		super();
		this.g=g;
		
		
		
	}


	@Override
	public String toString() {
		if(g.getDominance()==50) {
			
			return "co-dominant";
		}
		else if(g.getDominance()<50) {
			
			return "récessif";
		}
		else {
			
			return "dominant";
		}
	}
	

}
