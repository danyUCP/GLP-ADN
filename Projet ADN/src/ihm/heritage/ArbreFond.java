package ihm.heritage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ArbreFond extends JLabel implements MouseListener {
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private BufferedImage image0;

	/**
	 * @param posX
	 * @param posY
	 */
	public ArbreFond(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
		try {
			image0 = ImageIO.read(new File("ressources/heritage/arbrefond.png"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = 200;
		this.hauteur = 150;
		
		
		this.setBounds(posX , posY, largeur, hauteur);
	}

	public void paintComponent(Graphics g) {
		
		
			g.drawImage(image0, 0, 0,this);
		
		
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
