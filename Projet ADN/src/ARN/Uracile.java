package ARN;

public class Uracile extends Nucleotide
{
	private Nucleotide complem;
	
	public Uracile() 
	{
		super("U", true);
	}
	
	public Uracile(boolean bool) 
	{
		super("U", bool);
	}
	

	public Nucleotide getComplementaire() 
	{
		return null; 
	}
	
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}

}
