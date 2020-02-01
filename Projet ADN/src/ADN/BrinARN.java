package ADN;

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

}
