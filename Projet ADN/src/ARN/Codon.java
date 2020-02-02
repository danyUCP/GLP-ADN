package ARN;

public class Codon 
{
	private Nucleotide[] triplet;
	
	public Codon(Nucleotide n1, Nucleotide n2, Nucleotide n3)
	{
		this.triplet = new Nucleotide[3];
		
		triplet[0] = n1;
		triplet[1] = n2;
		triplet[2] = n3;
	}
	
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
	
	
	public String toString()
	{
		return "" + triplet[0] + triplet[1] + triplet[2];
	}
}
