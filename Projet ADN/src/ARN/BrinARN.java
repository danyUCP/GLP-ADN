package ARN;

import java.util.ArrayList;

/**
 * Classe de traitement du brin d'ARN.
 * 
 * BrinARN effectue les traitements sur les nucléotides. Elle permet de générer aléatoirement des introns
 * au sein du brin et de les supprimer pour la maturation.
 * 
 * @author Daniel
 */
public class BrinARN 
{
	private ArrayList<Nucleotide> nucleotides;
	private boolean mature;
	
	public BrinARN()
	{
		this.nucleotides = new ArrayList<Nucleotide>();
		this.mature = false;
	}
	
	
	/**
	 * Cette méthode permet de générer aléatoirement des introns au sein du brin d'ARN
	 */
	public void genererIntrons()
	{
		ArrayList<Integer> introns = new ArrayList<Integer>();
		int nbNucl = getTaille(), nbIntrons = 0;
		
		if(nbNucl > 21)
			nbIntrons = nbNucl - 21;
		else
			nbIntrons = nbNucl % 3; 

		for(int i = 0 ; i < nbIntrons ; i++)
		{
			int n = (int) (Math.random() * (nbNucl - 3) + 3);
			if(!introns.contains(n))
				introns.add(n);
			else
			{
				while(introns.contains(n))
					n = (int) (Math.random() * (nbNucl - 3) + 3);
				
				introns.add(n);
			}
		}
		
		//System.out.println(nbIntrons + " " + introns);
		
		for(int i = 0 ; i < nbIntrons ; i++)
			this.getNuclAt(introns.get(i)).setExonBool(false);
	}
	
	/**
	 * Cette méthode permet de retirer de l'ArrayList tous les nucléotides qui sont des introns
	 */
	public void retirerIntrons()
	{
		for(int i = getTaille() - 1 ; i >= 0 ; i--)
		{
			if(this.getNuclAt(i).estExon() == false)
				this.nucleotides.remove(i);
		}
		this.mature = true;
	}
	
	
	public void ajouterNucl(Nucleotide nucl)
	{
		this.nucleotides.add(nucl);
	}
	
	public Nucleotide getNuclAt(int index)
	{
		return this.nucleotides.get(index);
	}
	
	public boolean isMature() 
	{
		return mature;
	}

	public int getTaille()
	{
		return this.nucleotides.size();
	}
	
	
	public String toString() 
	{
		String str = "";
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			str += this.nucleotides.get(i) + " ";
		
		return str;
	}
}
