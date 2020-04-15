package ADN;

public abstract class Nucleotide {

	private String letter;
	
	public Nucleotide(String letter) {
		// TODO Auto-generated constructor stub
		this.letter=letter;
	}
	
	public abstract Nucleotide getCompl();
	
	public abstract void setCompl(Nucleotide Compl);
	
	public String toString(){
		return letter;
	}
	
}
