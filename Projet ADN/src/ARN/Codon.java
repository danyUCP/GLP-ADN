package ARN;

/**
 * Classe de donn�e d'un codon. 
 * Chaque codon est une composition de 3 nucl�otides
 * 
 * @author Daniel
 */
public class Codon 
{
	private Nucleotide[] triplet;
	
	//Constructeur � partir des nucl�otides
	public Codon(Nucleotide n1, Nucleotide n2, Nucleotide n3)
	{
		this.triplet = new Nucleotide[3];
		
		triplet[0] = n1;
		triplet[1] = n2;
		triplet[2] = n3;
	}
	
	//Constructeur � partir d'une chaine de 3 caract�res
	public Codon(String c)
	{
		this.triplet = new Nucleotide[3];
		
		c = c.toUpperCase();
		for(int i = 0 ; i < 3 ; i++)
		{
			Nucleotide tmp = null;
			
			switch(c.charAt(i))
			{
				case 'A':
					tmp = new Adenine();
					break;
				case 'U':
					tmp = new Uracile();
					break;
				case 'G':
					tmp = new Guanine();
					break;
				case 'C':
					tmp = new Cytosine();
					break;						
			}
			
			triplet[i] = tmp;
		}
	}
	
	public Nucleotide getN(int index)
	{
		if(index > 3 || index < 0)
			return null;
		
		return this.triplet[index];
	}
	
	public Codon getComplementaire()
	{
		return new Codon(triplet[0].getComplementaireARN(), triplet[1].getComplementaireARN(), triplet[2].getComplementaireARN());
	}
	
	
	public String toString()
	{
		return "" + triplet[0] + triplet[1] + triplet[2];
	}
}
