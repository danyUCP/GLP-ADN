package ARN;

/**
 * Classe de donnée de l'ensemble des nucléotides. 
 * Chaque nucléotide a une lettre, un booléen pour savoir si c'est un exon ainsi qu'un complémentaire
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
