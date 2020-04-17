package ARN;

/**
 * Classe de donnée du nucléotide Thymine
 * 
 * @author Daniel
 */
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
	
	//Complémentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Adenine();
		return complem;
	}
	
	//Complémentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}
}
