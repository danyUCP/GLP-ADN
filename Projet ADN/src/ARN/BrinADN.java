package ARN;

import java.util.ArrayList;

public class BrinADN 
{
	private ArrayList<Nucleotide> nucleotides;
	
	public BrinADN()
	{
		this.nucleotides = new ArrayList<Nucleotide>();
	}
	
	public BrinADN(String seq)
	{
		this.nucleotides = new ArrayList<Nucleotide>();
		
		seq = seq.toUpperCase();
		for(int i = 0 ; i < seq.length() ; i++)
		{
			Nucleotide tmp = null;
			
			switch(seq.charAt(i))
			{
				case 'A':
					tmp = new Adenine();
					break;
				case 'T':
					tmp = new Thymine();
					break;
				case 'G':
					tmp = new Guanine();
					break;
				case 'C':
					tmp = new Cytosine();
					break;						
			}
			
			if(tmp != null)
				this.ajouterNucl(tmp);
		}
	}
	
	
	public void ajouterNucl(Nucleotide nucl)
	{
		this.nucleotides.add(nucl);
	}


	public String toString() 
	{
		String str = "Brin ADN : ";
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			str += this.nucleotides.get(i) + " ";
		
		return str;
	}
	

}
