package ihm.heritage;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import heritage.Personne;



public class PersonneA extends JLabel implements MouseListener{
	
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private Personne pers;
	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	
	public PersonneA (Personne perso, int posX, int posY) 
	{		
		super();
		
		
		try {
			image0 = ImageIO.read(new File("ressources/heritage/c0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image1 = ImageIO.read(new File("ressources/heritage/c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			image2 = ImageIO.read(new File("ressources/heritage/c2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image3 = ImageIO.read(new File("ressources/heritage/c3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.pers = perso;
		
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = 300;
		this.hauteur = 300;
		
		
		this.setBounds(posX * largeur, posY, largeur, hauteur);
	}



	public void paintComponent(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillOval(0, 0, 300, 300);	
		
			g.drawImage(image0, 20, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(73, 40, 15, 9);
		g.drawString(this.pers.getPaire1().getPart1().getG1().toString(), 63, 50);
		g.fillRect(73, 100, 15, 9);
		g.drawString(this.pers.getPaire1().getPart1().getG2().toString(), 60, 110);
			g.drawImage(image0, 50, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(103, 40, 15, 9);
		g.drawString(this.pers.getPaire1().getPart2().getG1().toString(), 120, 50);
		g.fillRect(103, 100, 15, 9);
		g.drawString(this.pers.getPaire1().getPart2().getG2().toString(), 120, 110);
		
			g.drawImage(image1, 140, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(193, 100, 15, 9);
		g.drawString(this.pers.getPaire2().getPart1().getG1().toString(), 183, 110);
			g.drawImage(image1, 170, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(223, 100, 15, 9);
		g.drawString(this.pers.getPaire2().getPart2().getG1().toString(), 240, 110);
				
			g.drawImage(image2, 20, 150,this);
		g.setColor(Color.BLACK);
		g.fillRect(73, 170, 15, 9);
		g.drawString(this.pers.getPaire3().getPart1().getG1().toString(), 63, 180);
			g.drawImage(image2, 50, 150,this);
		g.setColor(Color.BLACK);
		g.fillRect(103, 170, 15, 9);
		g.drawString(this.pers.getPaire3().getPart2().getG1().toString(), 123, 180);
		
			g.drawImage(image3, 140, 150,this);
		g.setColor(Color.BLACK);
		g.fillRect(193, 170, 15, 9);
		g.drawString(this.pers.getPaire4().getPart1().getG1().toString(), 183, 180);
			g.drawImage(image3, 170, 150,this);
		g.setColor(Color.BLACK);
		g.fillRect(223, 170, 15, 9);
		g.drawString(this.pers.getPaire4().getPart2().getG1().toString(), 240, 180);
		
		g.drawString(pers.getNom(), 135, 285);
		
		
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
