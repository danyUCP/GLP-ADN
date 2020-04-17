package ARN;

/**
 * Classe de donn�e du nucl�otide Uracile
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
	
	//Compl�mentaire dans l'ADN
	public Nucleotide getComplementaire() 
	{
		return null; 
	}
	
	//Compl�mentaire dans l'ARN
	public Nucleotide getComplementaireARN()
	{
		this.complem = new Adenine();
		return complem;
	}

}
