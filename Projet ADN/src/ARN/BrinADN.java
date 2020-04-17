package ARN;

import java.util.ArrayList;

/**
 * Classe de traitement du brin d'ADN
 * 
 * BrinADN effectue les traitements sur les nucléotides. Elle permet de les trier, de les ordonner dans une
 * ArrayList, de les ajouter ou les supprimer ainsi que de déduire le brin complémentaire et le brin d'ARN
 * 
 * @author Daniel
 */
public class BrinADN 
{
	private ArrayList<Nucleotide> nucleotides;
	
	public BrinADN()
	{
		this.nucleotides = new ArrayList<Nucleotide>();
	}
	
	//Constructeur d'un brin selon une chaine de caractère
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

	
	/**
	 * Cette méthode permet de générer et retourner le brin complementaire
	 */
	public BrinADN getBrinComplem()
	{
		BrinADN brCompl = new BrinADN();
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			brCompl.ajouterNucl(this.nucleotides.get(i).getComplementaire());
		
		return brCompl;
	}
	
	/**
	 * Cette méthode permet de générer et retourner le brin d'ARN
	 */
	public BrinARN transcrire()
	{
		BrinARN brARN = new BrinARN();
		
		for(int i = 0 ; i < this.nucleotides.size() ; i++)
			brARN.ajouterNucl(this.nucleotides.get(i).getComplementaireARN());
		
		return brARN;
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
