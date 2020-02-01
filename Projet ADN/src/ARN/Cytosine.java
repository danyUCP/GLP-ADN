package ARN;

public class Cytosine extends Nucleotide
{
	private Nucleotide complem;
	
	public Cytosine() 
	{
		super("C", true);
	}
	
	public Cytosine(boolean bool) 
	{
		super("C", bool);
	}
	
	public Nucleotide getComplementaire()
	{
		this.complem = new Guanine(true);
		return complem;
	}
}
