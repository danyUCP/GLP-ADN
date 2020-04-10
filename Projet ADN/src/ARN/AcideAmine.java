package ARN;

public class AcideAmine 
{
	private String nom;
	private Codon codonAssocie;
	
	public AcideAmine(String nom, Codon codon) 
	{
		this.nom = nom;
		this.codonAssocie = codon;
	}
	
	
	public String getNom() 
	{
		return nom;
	}

	public Codon getCodonAssocie()
	{
		return this.codonAssocie;
	}
	
	
	public String toString()
	{
		return this.nom;
	}
}
