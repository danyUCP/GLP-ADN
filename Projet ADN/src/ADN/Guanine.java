package ADN;

public class Guanine extends Nucleotide{
	
	private Nucleotide compl;
	
	public Guanine() {
		// TODO Auto-generated constructor stub
		super ("G");
	}

	@Override
	public Nucleotide getCompl() {
		// TODO Auto-generated method stub
		this.compl= new Cytosine();
		return compl;
	}

}
