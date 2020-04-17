package ihm.heritage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Dictionnaire extends JLabel implements MouseListener {
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	

	/**
	 * @param posX
	 * @param posY
	 */
	public Dictionnaire(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.largeur = 300;
		this.hauteur = 400;
		
		
		this.setBounds(posX , posY, largeur, hauteur);
		
	}
	
public void paintComponent(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 300, 400);
		g.setColor(Color.white);
		g.fillRect(2, 2, 296, 396);	
		
		g.setColor(Color.BLUE);
		g.drawString("Lexique", 120, 20);
		
		g.setColor(Color.red);
		g.drawString("Nucléotide", 4, 40);
		g.drawString("ADN", 4, 78);
		g.drawString("Gène", 4, 114);
		g.drawString("Allèle", 4, 162);
		g.drawString("Chromatide" , 4, 186);
		g.drawString("Chromosome" , 4, 222);
		g.drawString("Homozygote" , 4, 258);
		g.drawString("Hétérozygote" , 4, 306);
		
		
		g.setColor(Color.black);
		g.drawString(": molécule organique qui est l'élément ", 70, 40);
		g.drawString("de base d'un acide nucléique tel que l'ADN ", 50, 54);
		
		g.drawString(": L'Acide Désoxyribo-Nucléique il contient" , 30, 78);
		g.drawString("de l'information génétique." , 50, 90);
		
		g.drawString(": élément constitué d'ADN et conditionnant " , 40, 114);
		g.drawString("la transmission et l'expression d'un " , 50, 126);
		g.drawString("caractère héréditaire déterminé." , 50, 138);
		
		g.drawString(": version d'un gène", 40, 162);
		
		g.drawString(": molécule ayant une forme de batonnet " , 70, 186);
		g.drawString("composé de plusieurs gènes" , 50, 198);
		
		g.drawString(": molécule d'ADN composé de deux " , 80, 222);
		g.drawString("chromatides" , 50, 234);
		
		g.drawString(": se dit d'un individu qui possède la " , 80, 258);
		g.drawString("même version d'un gène (allèle) sur les " , 50, 270);
		g.drawString("chromatides d'une même paire" , 50, 282);
		
		g.drawString(": se dit d'un individu qui possède des " , 90, 306);
		g.drawString("versions différentes d'un gène (allèle) " , 50, 318);
		g.drawString("sur les chromatides d'une même paire" , 50, 330);
		
		
		
		
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
