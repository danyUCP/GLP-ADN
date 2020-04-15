package ADN;

import java.util.ArrayList;

public class Chaine {

	private ArrayList<Polymere> chain;
	
	
	public Chaine() {
		// TODO Auto-generated constructor stub
		this.chain= new ArrayList<Polymere>();
	}
	
	public Chaine(String seq) {
		this.chain = new ArrayList<Polymere>();
		Polymere mono = null;
		
		for(int i = 0 ; i < seq.length() ; i++) {
			
			switch(seq.charAt(i)) {
				case 'A':
					mono= new Alpha();
					break;
				case 'B':
					mono = new Beta();
					break;
				}
			if(mono != null)
				this.ajouterMonomere(mono);
			
		}
	}
	
	public void ajouterMonomere(Polymere mono) {
		this.chain.add(mono);
	}
	
	public String toString() {
		String str = "";
		for(int i = 0 ; i < this.chain.size() ; i++)
				str += this.chain.get(i) + " ";
				
		return str;
	}
	
	public Chaine getComp() {
		Chaine mtcomp = new Chaine();
		
		for(int i = 0 ; i < this.chain.size() ; i++)
			mtcomp.ajouterMonomere(this.chain.get(i).getComp());
		
		return mtcomp;
	}
	

}
