package ADN;

public class Adenine extends Nucleotide
{
	private Nucleotide complem;
	
	public Adenine() 
	{
		super("A", true);
	}
	
	public Adenine(boolean bool) 
	{
		super("A", bool);
	}
	
	
	public Nucleotide getComplementaire()
	{
		this.complem = new Thymine(true);
		return complem;
	}
}
