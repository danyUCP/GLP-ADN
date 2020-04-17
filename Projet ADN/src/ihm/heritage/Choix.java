package ihm.heritage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import heritage.GametesU;
import heritage.Personne;

public class Choix extends JLabel implements MouseListener {
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private String nom;
	private Personne resultat;
	private JButton yeux,marron,O,A,B,P,p,AL,al,homo;
	
	
	public Choix (int posX, int posY,String nom) {	
		super();
		this.nom=nom;
		this.posX = posX;
		this.posY = posY;
		this.largeur = 350;
		this.hauteur = 500;
		this.yeux=new JButton("bleu");
		this.marron=new JButton("marron");
		this.homo=new JButton("homo");
		this.O=new JButton("groupe O");
		this.A=new JButton("groupe A");
		this.B= new JButton("groupe B");
		 this.setLayout(new GridLayout(4, 4));
		    //On ajoute le bouton au content pane de la JFrame
		    this.add(yeux);
		    this.add(marron);
		    this.add(homo);
		    this.add(O);
		    this.add(A);
		    this.add(B);
		
		
		
		this.setBounds(posX , posY, largeur, hauteur);
		
		
		
		}
	
public void paintComponent(Graphics g) {
	g.setColor(Color.black);
	g.fillRect(0, 0, 350, 500);
	
	g.setColor(Color.white);
	g.drawString("Choisissez la couleur des yeux", 340, 490);
	
		
		
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
