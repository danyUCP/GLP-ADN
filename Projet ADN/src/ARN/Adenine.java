package ARN;

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
		this.complem = new Thymine();
		return complem;
	}
	
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Uracile();
		return complem;
	}
}
