package ARN;

public abstract class Nucleotide 
{
	private String lettre;
	private boolean estExon;
	
	public Nucleotide(String lettre, boolean bool)
	{
		this.lettre = lettre;
		this.estExon = bool;
	}

	
	public void setExonBool(boolean bool)
	{
		this.estExon = bool;
	}
	
	public abstract Nucleotide getComplementaire();
	public abstract Nucleotide getComplementaireARN();
	
	
	public String toString() 
	{
		return lettre;
	}
}
