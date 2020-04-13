package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import heritage.GametesU;
import heritage.Personne;

public class Choix extends JLabel implements MouseListener {
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private String nom;
	private Personne resultat;
	
	public Choix (int posX, int posY,String nom) {	
		super();
		this.nom=nom;
		this.posX = posX;
		this.posY = posY;
		this.largeur = 350;
		this.hauteur = 500;
		
		
		this.setBounds(posX , posY, largeur, hauteur);
		
		}
	
public void paintComponent(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 350, 500);				
		
		
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
