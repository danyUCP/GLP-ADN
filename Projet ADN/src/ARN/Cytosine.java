package ARN;

/**
 * Classe de donnée du nucléotide Cytosine
 * 
 * @author Daniel
 */
public class Cytosine extends Nucleotide
{
	private Nucleotide complem;
	
	public Cytosine() 
	{
		super("C", true);
	}
	
	public Cytosine(boolean bool) 
	{
		super("C", bool);
	}
	
	//Complémentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Guanine();
		return complem;
	}
	
	//Complémentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Guanine();
		return complem;
	}
}
