package ARN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe de traitement de la chaine d'acides aminés.
 * 
 * ChaineAA effectue les traitements sur les acides aminés. Elle permet de traduire, selon le code génétique,
 * chacun des codons d'un brin d'ARNm en acide aminé et de d'ordonner l'ensemble de ces acides dans une ArrayList.
 * 
 * @author Daniel
 */
public class ChaineAA 
{
	//Code génétique issu d'un fichier externe
	private static HashMap<String, AcideAmine> codeGenetique;
	
	private ArrayList<AcideAmine> chaine;
	
	
	public ChaineAA()
	{
		if(codeGenetique == null)
			remplirCodeMap();
	}
	
	/**
	 * Le constructeur traduit chaque codon de l'ARN messager en acide et ajoute cet acide dans l'ArrayList
	 */
	public ChaineAA(ARNm messager)
	{		
		if(codeGenetique == null)
			remplirCodeMap();
		
		this.chaine = new ArrayList<AcideAmine>();
		
		for(int i = 0 ; i < messager.getTaille() ; i++)
		{
			AcideAmine tmp = codeGenetique.get(messager.getCodonAt(i).toString());
			this.ajouterAcide(tmp);
		}
	}
	
	
	/**
	 * Cette méthode permet d'extraire les couples codon/acide d'un fichier externe et de stocker
	 * ces couples dans la HashMap statique codeGenetique
	 */
	public void remplirCodeMap()
	{
		BufferedReader br = null;
		String line = "";
		String[] donnee = new String[2];
		codeGenetique = new HashMap<String, AcideAmine>();

		
		try
		{
			br = new BufferedReader(new FileReader("codeGen.dany"));
			
			while((line = br.readLine()) != null)
			{
				donnee = line.split(";");

				codeGenetique.put(donnee[0], new AcideAmine(donnee[1], new Codon(donnee[0])));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
				
			} 
			catch (Exception e) 
			{
				System.err.println("Aucun fichier selectionné");
			}
		}
	}
	
	
	public static HashMap<String, AcideAmine> getCodeGenetique()
	{
		return ChaineAA.codeGenetique;
	}
	
	public void ajouterAcide(AcideAmine acide)
	{
		this.chaine.add(acide);
	}
	
	public AcideAmine getAcideAt(int index)
	{
		return this.chaine.get(index);
	}

	public int getTaille()
	{
		return this.chaine.size();
	}
	
	public String toString() 
	{
		String str = "";
		
		for(int i = 0 ; i < this.chaine.size() ; i++)
			str += this.chaine.get(i) + " - ";
		
		str = str.substring(0, str.length()-3);
		return str;
	}
	
}
