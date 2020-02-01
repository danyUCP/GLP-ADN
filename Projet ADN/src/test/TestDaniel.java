package test;

import ADN.Adenine;
import ADN.BrinADN;
import ADN.Cytosine;
import ADN.Guanine;
import ADN.Thymine;

public class TestDaniel 
{
	public static void main(String[] args) 
	{
		BrinADN brin = new BrinADN("ACTGATGCTcccccc");
		
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Cytosine());
		brin.ajouterNucl(new Guanine());
		brin.ajouterNucl(new Thymine());
		brin.ajouterNucl(new Adenine());

		
		System.out.println(brin);
		

	}

}
