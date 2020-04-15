package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import heritage.Personne;
import heritage.Phenotype;

public class PhenotypeA extends JLabel {
	
		private Personne pers;
		private Phenotype pa;
		private Phenotype pb;
		private Phenotype pc;
		private Phenotype pd;
		private Phenotype pe,pf,pg,ph,pi,pj;
		/**
		 * @param pers
		 * @param pe
		 */
		public PhenotypeA(Personne pers) {
			super();
			this.pers = pers;

			pa= new Phenotype(pers.getPaire1().getPart1().getG1());
			pb= new Phenotype(pers.getPaire1().getPart2().getG1());
			pc= new Phenotype(pers.getPaire1().getPart1().getG2());
			pd= new Phenotype(pers.getPaire1().getPart2().getG2());
			
			pe= new Phenotype(pers.getPaire2().getPart1().getG1());
			pf= new Phenotype(pers.getPaire2().getPart2().getG1());
			
			pg= new Phenotype(pers.getPaire3().getPart1().getG1());
			ph= new Phenotype(pers.getPaire3().getPart2().getG1());
			
			pi= new Phenotype(pers.getPaire4().getPart1().getG1());
			pj= new Phenotype(pers.getPaire4().getPart2().getG1());
			
			
		}
		
		public void paintComponent(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(0, 0, 350, 500);
				
				g.setColor(Color.white);
				g.drawString("Choisissez la couleur des yeux", 340, 490);
				
					
					
				}
		


}
