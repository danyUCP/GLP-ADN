package test;

import ARN.Adenine;
import ARN.BrinADN;
import ARN.Cytosine;
import ARN.Guanine;
import ARN.Thymine;

public class TestDaniel 
{
	public static void main(String[] args) 
	{
		BrinADN brin = new BrinADN("ACTGATGCTccaccaccgt");
		
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Adenine());
		brin.ajouterNucl(new Cytosine());
		brin.ajouterNucl(new Guanine());
		brin.ajouterNucl(new Thymine());
		brin.ajouterNucl(new Adenine());

		
		System.out.println(brin);
		
	}

}
