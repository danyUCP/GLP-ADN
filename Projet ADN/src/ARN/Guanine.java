package ARN;

public class Guanine extends Nucleotide
{
	private Nucleotide complem;
	
	public Guanine() 
	{
		super("G", true);
	}
	
	public Guanine(boolean bool) 
	{
		super("G", bool);
	}
	
	
	public Nucleotide getComplementaire()
	{
		this.complem = new Cytosine();
		return complem;
	}
	
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Cytosine();
		return complem;
	}
}
