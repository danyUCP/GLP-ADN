package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

import heritage.Personne;
import heritage.PhenotypePoly;
import heritage.PhenotypeYeux;

public class YeuxLabel extends JLabel {
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private Personne pers;
	private PhenotypeYeux p;
	private PhenotypePoly poly;
		
		public YeuxLabel(Personne pers,int posX,int posY) {
			super();
			this.pers = pers;

			this.posX = posX;
			this.posY = posY;
			this.largeur = 300;
			this.hauteur = 300;
			
			p = new PhenotypeYeux(pers);
			poly=new PhenotypePoly(pers);
			
			this.setBounds(posX * largeur, posY, largeur, hauteur);
			
			
		}
		
		public void paintComponent(Graphics g) {
				//g.setColor(Color.black);
				//g.fillRect(0,350, 300, 300);
				
				g.setColor(Color.white);
				//g.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				g.drawString(p.getYeux(), 0,0);
				
				
				
				
					
					
				}


}
