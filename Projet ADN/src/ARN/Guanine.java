package ARN;

/**
 * Classe de donnée du nucléotide Guanine
 * 
 * @author Daniel
 */
public class Guanine extends Nucleotide
{
	private Nucleotide complem;
	
	public Guanine() 
	{
		super("G", true);
	}
	
	public Guanine(boolean bool) 
	{
		super("G", bool);
	}
	
	//Complémentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Cytosine();
		return complem;
	}
	
	//Complémentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Cytosine();
		return complem;
	}
}
