package ADN;

public class Thymine extends Nucleotide
{
	private Nucleotide complem;
	
	public Thymine() 
	{
		super("T", true);
	}
	
	public Thymine(boolean bool) 
	{
		super("T", bool);
	}

	
	public Nucleotide getComplementaire()
	{
		this.complem = new Adenine(true);
		return complem;
	}
}
