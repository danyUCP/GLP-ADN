package ARN;

/**
 * Classe de donn�e de l'ensemble des nucl�otides. 
 * Chaque nucl�otide a une lettre, un bool�en pour savoir si c'est un exon ainsi qu'un compl�mentaire
 * dans l'ADN et l'ARN
 * 
 * @author Daniel
 */
public abstract class Nucleotide 
{
	private String lettre;
	private boolean estExon;
	
	public Nucleotide(String lettre, boolean bool)
	{
		this.lettre = lettre;
		this.estExon = bool;
	}

	public String getLettre() 
	{
		return this.lettre;
	}
	
	public void setExonBool(boolean bool)
	{
		this.estExon = bool;
	}
	
	public boolean estExon() 
	{
		return estExon;
	}

	public abstract Nucleotide getComplementaire();
	public abstract Nucleotide getComplementaireARN();
	
	
	public String toString() 
	{
		return lettre;
	}
}
