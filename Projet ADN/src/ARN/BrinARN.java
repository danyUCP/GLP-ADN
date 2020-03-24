package ARN;

import java.util.ArrayList;

public class BrinARN 
{
	private ArrayList<Nucleotide> nucleotides;
	
	public BrinARN()
	{
		this.nucleotides = new ArrayList<Nucleotide>();
	}
	
	
	public void ajouterNucl(Nucleotide nucl)
	{
		this.nucleotides.add(nucl);
	}
	
	public Nucleotide getNuclAt(int index)
	{
		return this.nucleotides.get(index);
	}
	
	public int getTaille()
	{
		return this.nucleotides.size();
	}
	
	public void retirerIntrons()
	{
		for(int i = getTaille() - 1 ; i >= 0 ; i--)
		{
			if(this.getNuclAt(i).estExon() == false)
				this.nucleotides.remove(i);
		}
	}
	
	public void genererIntrons()
	{
		ArrayList<Integer> introns = new ArrayList<Integer>();
		int nbNucl = getTaille(), nbIntrons = 0;
		
		if(nbNucl > 18)
			nbIntrons = nbNucl - 18;
		else
			nbIntrons = nbNucl % 3;

		for(int i = 0 ; i < nbIntrons ; i++)
		{
			int n = (int) (Math.random() * (nbNucl ));
			if(!introns.contains(n))
				introns.add(n);
			else
			{
				while(introns.contains(n))
					n = (int) (Math.random() * (nbNucl));
				
				introns.add(n);
			}
		}
		
		System.out.println(nbIntrons + " " + introns);
		
		for(int i = 0 ; i < nbIntrons ; i++)
			this.getNuclAt(introns.get(i)).setExonBool(false);
	}
	
	public String toString() 
	{
		String str = "";
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			str += this.nucleotides.get(i) + " ";
		
		return str;
	}
}
