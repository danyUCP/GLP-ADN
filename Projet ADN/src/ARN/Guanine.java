package ARN;

/**
 * Classe de donn�e du nucl�otide Guanine
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
	
	//Compl�mentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Cytosine();
		return complem;
	}
	
	//Compl�mentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Cytosine();
		return complem;
	}
}
