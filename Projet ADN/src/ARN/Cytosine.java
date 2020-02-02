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
		this.complem = new Guanine();
		return complem;
	}
	
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Guanine();
		return complem;
	}
}
