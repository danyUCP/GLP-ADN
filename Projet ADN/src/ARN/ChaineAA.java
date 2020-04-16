package ARN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ChaineAA 
{
	private static HashMap<String, AcideAmine> codeGenetique;
	private ArrayList<AcideAmine> chaine;
	
	public ChaineAA()
	{
		if(codeGenetique == null)
			remplirCodeMap();
	}
	
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
