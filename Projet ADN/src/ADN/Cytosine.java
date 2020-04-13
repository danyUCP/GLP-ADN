package ADN;

public class Cytosine extends Nucleotide{
	
	private Nucleotide compl;
	
	public Cytosine() {
		// TODO Auto-generated constructor stub
		super ("C");
	}

	@Override
	public Nucleotide getCompl() {
		// TODO Auto-generated method stub
		this.compl= new Guanine();
		return compl;
	}

	public void setCompl(Nucleotide compl) {
		this.compl = compl;
	}
	
	

}
