package ARN;

/**
 * Classe de donn�e du nucl�otide Thymine
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
	
	//Compl�mentaire dans l'ADN
	public Nucleotide getComplementaire()
	{
		this.complem = new Adenine();
		return complem;
	}
	
	//Compl�mentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}
}
