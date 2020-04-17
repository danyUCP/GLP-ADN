package ARN;

/**
 * Classe de donn�e du nucl�otide Cytosine
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
	
	//Compl�mentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Guanine();
		return complem;
	}
	
	//Compl�mentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Guanine();
		return complem;
	}
}
