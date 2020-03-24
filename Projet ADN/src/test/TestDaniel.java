package test;

import ARN.ARNm;
import ARN.Adenine;
import ARN.BrinADN;
import ARN.BrinARN;
import ARN.ChaineAA;
import ARN.Cytosine;
import ARN.Guanine;
import ARN.Thymine;
import ihm.Fenetre;

public class TestDaniel 
{
	public static void main(String[] args) 
	{
		BrinADN brin = new BrinADN("TACTGATGCTccaccagccgtGATTACTGGATC");
		
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Cytosine());
		brin.ajouterNucl(new Guanine());
		brin.ajouterNucl(new Thymine());
		brin.ajouterNucl(new Adenine());

		BrinADN brinComp = brin.getBrinComplem();
		
		BrinARN brinARN = brin.transcrire();
		brinARN.genererIntrons();
		brinARN.retirerIntrons();
		
		ARNm messager = new ARNm(brinARN);
				
		ChaineAA chaine = new ChaineAA(messager);
		
		System.out.println("Brin ADN : " + brin);
		System.out.println("Br Compl : " + brinComp + "\n");
		System.out.println("Brin ARN : " + brinARN + "\n");
		System.out.println("ARN mess : " + messager);
		System.out.println("Chaine A : " + chaine);
		
		Fenetre fen = new Fenetre();

	}

}
