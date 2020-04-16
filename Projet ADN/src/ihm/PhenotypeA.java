package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import heritage.Personne;
import heritage.Phenotype;

public class PhenotypeA extends JLabel {
	
		private Personne pers;
		
		public PhenotypeA(Personne pers) {
			super();
			this.pers = pers;

			
			
			
		}
		
		public void paintComponent(Graphics g) {
				g.setColor(Color.black);
				g.fillRect(0, 0, 350, 500);
				
				g.setColor(Color.white);
				g.drawString("Choisissez la couleur des yeux", 340, 490);
				
					
					
				}
		


}
