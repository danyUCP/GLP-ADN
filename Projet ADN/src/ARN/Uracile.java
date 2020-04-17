package ARN;

/**
 * Classe de donnée du nucléotide Uracile
 * 
 * @author Daniel
 */
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
	
	//Complémentaire dans l'ADN
	public Nucleotide getComplementaire() 
	{
		return null; 
	}
	
	//Complémentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}

}
