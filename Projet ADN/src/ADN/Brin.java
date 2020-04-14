package ADN;

import java.util.ArrayList;

public class Brin {
	private ArrayList<Nucleotide> brin;
	public static StringBuilder ch = new StringBuilder();
	
	public Brin() {
		this.brin = new ArrayList<Nucleotide>();
	}
	
	public Brin (String seq) {
		this.brin = new ArrayList<Nucleotide>();
		Nucleotide nuc = null;
		
		for(int i = 0 ; i < seq.length() ; i++) {
			
			switch(seq.charAt(i)) {
				case 'A':
					nuc= new Adenine();
					break;
				case 'T':
					nuc = new Thymine();
					break;
				case 'G':
					nuc = new Guanine();
					break;
				case 'C':
					nuc = new Cytosine();
					break;	
			}
		if(nuc != null)
			this.ajouterNucl(nuc);
		}	
		
	}
	
	public void ajouterNucl(Nucleotide nucl) {
		this.brin.add(nucl);
	}
	
	
	public String toString() {
		String str = "";
		for(int i = 0 ; i < this.brin.size() ; i++)
				str += this.brin.get(i) + "-";
				
		return str;
	}
	
	public Brin getBrinCompl() {
		Brin brCompl = new Brin();
		
		for(int i = 0 ; i < this.brin.size() ; i++)
			brCompl.ajouterNucl(this.brin.get(i).getCompl());
		
		return brCompl;
	}
	
	
}
