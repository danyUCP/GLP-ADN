package ADN;

public class Adenine extends Nucleotide{
	
	private Nucleotide compl;
	
	public Adenine() {
		// TODO Auto-generated constructor stub
		super ("A");
	}

	@Override
	public Nucleotide getCompl() {
		// TODO Auto-generated method stub
		this.compl= new Thymine();
		return compl;
	}
	
	public void setCompl(Nucleotide compl) {
		this.compl = compl;
	}


}
