package ARN;

import java.util.ArrayList;

/**
 * Classe de traitement du brin d'ARN messager
 * 
 * ARNm effectue les traitements sur les codons. Elle permet d'ajouter et d'ordonner dans une
 * ArrayList de codons les nucléotides d'un brin d'ARN
 * 
 * @author Daniel
 */
public class ARNm 
{
	private ArrayList<Codon> codons;
	
	public ARNm(BrinARN br)
	{
		this.codons = new ArrayList<Codon>();
		
		for(int i = 0 ; i < br.getTaille() - 2; i += 3)
		{
			Codon tmp = new Codon(br.getNuclAt(i), br.getNuclAt(i + 1), br.getNuclAt(i + 2));
			this.ajouterCodon(tmp);
		}
	}
	
	
	public void ajouterCodon(Codon cd)
	{
		this.codons.add(cd);
	}
	
	public Codon getCodonAt(int index)
	{
		return this.codons.get(index);
	}
	
	public int getTaille()
	{
		return this.codons.size();
	}
	

	public String toString() 
	{
		String str = "";
		
		for(int i = 0 ; i < this.codons.size() ; i++)
			str += this.getCodonAt(i) + " - ";
		
		str = str.substring(0, str.length()-3);
		return str;
	}
}
