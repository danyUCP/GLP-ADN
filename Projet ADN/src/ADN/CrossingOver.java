package ADN;

import java.util.ArrayList;

public class CrossingOver {
	
	/*Brin brin5 = new Brin("TTCAGATC");
	Brin brinComp5 = brin5.getBrinCompl();
	
	Brin brin6 = new Brin("GTACTCAG");
	Brin brinComp6 = brin6.getBrinCompl();
	
	private Brin crossfor5=new Brin("TCGA");
	private Brin crossfor6=new Brin("CTAG");
	
	public CrossingOver() {
		// TODO Auto-generated constructor stub
		this.brin5=brin5;
		this.brinComp5=brinComp5;
		this.brin6=brin6;
		this.brinComp6=brinComp6;
	}

		for(int i=0; i<brin5.length(); i++) {
			brin5.getBrinCompl();
			for(i=5; i<brin5.length(); i++) {
				brin5.
			}
		}*/
	private ArrayList<Nucleotide> nucleotides;
	private Brin crossfor5=new Brin("TCGA");
	private Brin crossfor6=new Brin("CTAG");
	
		public CrossingOver() {
			this.nucleotides = new ArrayList<Nucleotide>();
		}
	
	
		public void ajouterNucl(Nucleotide nuc) {
			this.nucleotides.add(nuc);
		}
	
		public Nucleotide getNuclAt(int index) {
			return this.nucleotides.get(index);
		}
	
		public int getTaille() {
			return this.nucleotides.size();
		}
	
		public void getCrossbrin5() {
			for(int i = 0 ; i < this.nucleotides.size() ; i++) {
				System.out.println(this.nucleotides.get(i) + " ");
			}
			for(int i = 5 ; i < this.nucleotides.size() ; i++) {
				System.out.println(crossfor5);
			}
		}
		
		public void getCrossbrin6() {
			for(int i = 0 ; i < this.nucleotides.size() ; i++) {
				System.out.println(this.nucleotides.get(i) + " ");
			}
			for(int i = 5 ; i < this.nucleotides.size() ; i++) {
				System.out.println(crossfor6);
			}
		}
}
