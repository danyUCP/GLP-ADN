package ARN;

/**
 * Classe de donn�e du nucl�otide Adenine
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
	
	//Compl�mentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Thymine();
		return complem;
	}
	
	//Compl�mentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Uracile();
		return complem;
	}
}
