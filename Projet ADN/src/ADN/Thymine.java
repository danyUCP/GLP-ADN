package ADN;

public class Thymine extends Nucleotide{
	
	private Nucleotide compl;
	
	public Thymine() {
		// TODO Auto-generated constructor stub
		super ("T");
	}
	
	public Nucleotide getCompl() {
		this.compl= new Adenine();
		return compl;
	}

	public void setCompl(Nucleotide compl) {
		this.compl = compl;
	}
	
	

}
