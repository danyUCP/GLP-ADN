package ARN;

import java.util.HashMap;

/**
 * ModelSynthese est la classe regroupant l'ensemble des traitements nécéssaires du noyau pour la synthèse des protéines
 * @author Daniel
 */
public class ModelSynthese 
{
	private BrinADN brinADN, brinComp;
	private BrinARN brinARN, arnMature;
	private ARNm brinMess;
	private ChaineAA chaineAcide;
	
	public ModelSynthese()
	{		
		this.chaineAcide = new ChaineAA();
		//System.out.println(ChaineAA.getCodeGenetique());
	}

	/**
	 * Cette méthode permet de générer aléatoirement un brin d'ADN et de mettre à jour le modèle
	 */
	public void genererBrin()
	{
		String seq = "TAC";
		
		for(int i = 0 ; i < 24 ; i++)
		{
			int n = (int) (Math.random() * 4);
			
			switch(n)
			{
				case 0:
					seq += "A";
					break;
				case 1:
					seq += "T";
					break;
				case 2:
					seq += "G";
					break;
				case 3:
					seq += "C";
					break;
			}
		}
		
		this.setBrinADN(new BrinADN(seq));
	}
	
	/**
	 * Cette méthode permet de mettre à jour le modèle pour la transcription
	 */
	public void transcription()
	{
		this.setBrinComp(this.brinADN.getBrinComplem());
		this.setBrinARN(this.brinADN.transcrire());
		this.arnMature = brinADN.transcrire();
	}
	
	/**
	 * Cette méthode permet de mettre à jour le modèle pour la synthèse
	 */
	public void synthese()
	{
		if(arnMature == null)
			this.arnMature = brinADN.transcrire();
		
		if(!arnMature.isMature())
		{
			this.arnMature.genererIntrons();
			this.arnMature.retirerIntrons();
		}
		
		this.setBrinMess(new ARNm(this.arnMature));
		this.setChaineAcide(new ChaineAA(this.brinMess));
	}
	
	public HashMap<String,AcideAmine> getCodeGenetique()
	{
		return ChaineAA.getCodeGenetique();
	}
	
	public BrinADN getBrinADN() 
	{
		return brinADN;
	}

	public BrinADN getBrinComp() 
	{
		return brinComp;
	}

	public BrinARN getBrinARN() 
	{
		return brinARN;
	}

	public BrinARN getARNmature() 
	{
		return arnMature;
	}

	public ARNm getBrinMess() 
	{
		return brinMess;
	}

	public ChaineAA getChaineAcide() 
	{
		return chaineAcide;
	}

	public void setBrinADN(BrinADN brinADN) 
	{
		this.brinADN = brinADN;
	}

	public void setBrinComp(BrinADN brinComp) 
	{
		this.brinComp = brinComp;
	}

	public void setBrinARN(BrinARN brinARN) 
	{
		this.brinARN = brinARN;
	}
	
	public void setArnMature(BrinARN arnMature) 
	{
		this.arnMature = arnMature;
	}

	public void setBrinMess(ARNm brinMess) 
	{
		this.brinMess = brinMess;
	}

	public void setChaineAcide(ChaineAA chaineAcide) 
	{
		this.chaineAcide = chaineAcide;
	}


	public String toString() 
	{
		String str = "Modèle : \n";
		
		str += "Brin ADN : " + brinADN + "\n";
		str += "Br Compl : " + brinComp + "\n";
		str += "Brin ARN : " + brinARN + "\n";
		str += "ARN matu : " + arnMature + "\n";
		str += "ARN mess : " + brinMess + "\n";
		str += "Chaine A : " + chaineAcide + "\n";
		
		return str;
	}
	
	
	

	
	
	
	
}
