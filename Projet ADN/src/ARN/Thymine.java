package ARN;

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
		this.complem = new Adenine();
		return complem;
	}
	
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}
}
