package ihm;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;

import heritage.Personne;

public class PersonneIcon {
	private ArrayList<ChromosomeIcon> listeCellule;
	private Personne p;
	
	/**
	 * @param p
	 */
	public PersonneIcon(Personne p) {
		this.p = p;
		initList();
		
	}
	
	private void initList()
	{
		this.listeCellule = new ArrayList<ChromosomeIcon>();
		
			ChromosomeIcon p1= new ChromosomeIcon(this.p.getPaire1());
			ChromosomeIcon p2= new ChromosomeIcon(this.p.getPaire2());
			ChromosomeIcon p3= new ChromosomeIcon(this.p.getPaire3());
			ChromosomeIcon p4= new ChromosomeIcon(this.p.getPaire4());
			
			listeCellule.add(p1);
			listeCellule.add(p2);
			listeCellule.add(p3);
			listeCellule.add(p4);
		
		
		System.out.println("Génome");	
		System.out.println(listeCellule);

	}
	

}
