package ARN;

/**
 * Classe de donnée du nucléotide Adenine
 * 
 * @author Daniel
 */
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
	
	//Complémentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Thymine();
		return complem;
	}
	
	//Complémentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Uracile();
		return complem;
	}
}
