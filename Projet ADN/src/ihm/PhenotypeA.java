package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import heritage.Personne;
import heritage.Phenotype;
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
		
			
			this.setBounds(posX * largeur, posY, largeur, hauteur);
			
			
		}
		
		public void paintComponent(Graphics g) {
				//g.setColor(Color.black);
				//g.fillRect(0,350, 300, 300);
				
				g.drawString(p.getYeux(), 0,480);
				g.drawString(p.getSuite(), 0, 500);
			
				g.drawString(poly.getPoly(), 0, 540);
				g.drawString(poly.getSuite(), 0, 560);
				
				g.drawString(nez.getPoly(),0,600);
				g.drawString(nez.getSuite(), 0, 620);
				
				g.setFont(new Font("Comic sans MS", Font.BOLD, 20));
				g.drawString("Couleur des yeux", 0, 460);
				g.drawString("Polydactylie", 0, 520);
				g.drawString("Forme du nez", 0, 580);
					
					
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
