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

import heritage.GametesU;

public class GametesA extends JLabel implements MouseListener {
	
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private GametesU gam;
	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	
	
	
	public GametesA (GametesU gam, int posX, int posY) 
	{		
		super();
		
		
		try {
			image0 = ImageIO.read(new File("c0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image1 = ImageIO.read(new File("c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			image2 = ImageIO.read(new File("c2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image3 = ImageIO.read(new File("c3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.gam=gam;
		
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = 200;
		this.hauteur = 150;
		
		
		this.setBounds(posX , posY, largeur, hauteur);
	}



	public void paintComponent(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillOval(0, 0, 200, 150);	
		
			g.drawImage(image0, 0, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(53, 40, 15, 9);
		g.drawString(this.gam.getN1().getG1().toString(), 43, 50);
		g.fillRect(53, 100, 15, 9);
		g.drawString(this.gam.getN1().getG2().toString(), 38, 110);
		
			g.drawImage(image1, 40, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(93, 100, 15, 9);
		g.drawString(this.gam.getN2().getG1().toString(), 85, 110);
			
				
			g.drawImage(image2, 70, 4,this);
		g.setColor(Color.BLACK);
		g.fillRect(123, 24, 15, 9);
		g.drawString(this.gam.getN3().getG1().toString(), 110, 35);
			
		
			g.drawImage(image3, 100, 20,this);
		g.setColor(Color.BLACK);
		g.fillRect(153, 40, 15, 9);
		g.drawString(this.gam.getN4().getG1().toString(), 143, 50);
			
		
		
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
