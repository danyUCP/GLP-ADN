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
	
	public String toString() 
	{
		String str = "";
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			str += this.nucleotides.get(i) + " ";
		
		return str;
	}
}
