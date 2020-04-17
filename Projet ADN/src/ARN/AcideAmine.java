package ARN;

/**
 * Classe de donnée d'un acide aminé. 
 * Chaque acide aminé a un nom abrégé et un codon associé 
 * 
 * @author Daniel
 */
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
