package ihm.heritage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import heritage.Personne;
import heritage.Phenotype;
import heritage.PhenotypeAlbi;
import heritage.PhenotypeGroupe;
import heritage.PhenotypeNez;
import heritage.PhenotypePoly;
import heritage.PhenotypeYeux;

public class PhenotypeA extends JLabel implements MouseListener {
	
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private Personne pers;
	private PhenotypeYeux p;
	private PhenotypePoly poly;
	private PhenotypeNez nez;
	private PhenotypeGroupe groupe;
	private PhenotypeAlbi albi;
		
		public PhenotypeA(Personne pers,int posX,int posY) {
			super();
			this.pers = pers;

			this.posX = posX;
			this.posY = posY;
			this.largeur = 800;
			this.hauteur = 800;
			
			p = new PhenotypeYeux(pers);
			poly=new PhenotypePoly(pers);
			nez=new PhenotypeNez(pers);
			groupe=new PhenotypeGroupe(pers);
			albi=new PhenotypeAlbi(pers);
		
			
			this.setBounds(posX * largeur, posY, largeur, hauteur);
			
			
		}
		
		public void paintComponent(Graphics g) {
				
				g.drawRect(0,300, 700, 350);
				g.setColor(Color.white);
				g.fillRect(2, 298, 698, 348);
				g.setColor(Color.black);
				g.drawString(albi.getPoly(), 4, 360);
				g.drawString(albi.getSuite(), 4, 380);
				
				g.drawString(groupe.getPoly(), 4, 420);
				g.drawString(groupe.getSuite(),4,440);
				
				g.drawString(p.getYeux(), 4,480);
				g.drawString(p.getSuite(), 4, 500);
			
				g.drawString(poly.getPoly(), 4, 540);
				g.drawString(poly.getSuite(), 4, 560);
				
				g.drawString(nez.getPoly(),4,600);
				g.drawString(nez.getSuite(), 4, 620);
				
				g.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				g.drawString("Couleur des yeux", 0, 460);
				g.drawString("Polydactylie", 0, 520);
				g.drawString("Forme du nez", 0, 580);
				g.drawString("Groupe Sanguin", 0, 400);
				g.drawString("Albinisme", 0, 340);
					
				
					
				}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		


}
