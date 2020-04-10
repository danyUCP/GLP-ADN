package ihm;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.Codon;

public class CodonComp extends JLabel implements MouseListener
{
	private NuclComp[] triplet;
	private Codon codon;
	private int posX;
	private int posY;
	private int largeur;
	private int longueur;
	private boolean orientation;
	private float alpha = 1.0f;

	
	public CodonComp(Codon codon, int posX, int posY, boolean orientation)
	{
		this.codon = codon;
		this.triplet = new NuclComp[3];
		
		triplet[0] = new NuclComp(codon.getN(0), 0, -1, orientation);
		triplet[1] = new NuclComp(codon.getN(1), 1, -1, orientation);
		triplet[2] = new NuclComp(codon.getN(2), 2, -1, orientation);
		
		this.orientation = orientation;
		this.posX = posX;
		this.posY = posY;
		this.largeur = 3 * triplet[0].getWidth();
		this.longueur = triplet[0].getHeight();
		
		this.setBounds(posX * largeur, posY + 1, largeur, longueur);
		//System.out.println(this.getBounds());

		for(int i = 0 ; i < 3 ; i++)
		{
			triplet[i].removeMouseListener(triplet[i]);
			this.add(triplet[i]);
		}
		
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d);
		//System.out.println("On repeint");

	}    
	
	public float getAlpha() 
	{
		return alpha;
	}

	public void setAlpha(float alpha) 
	{
		this.alpha = alpha;
		triplet[0].setAlpha(this.alpha);
		triplet[1].setAlpha(this.alpha);
		triplet[2].setAlpha(this.alpha);
		repaint();
	}
	
	public int getPosX() 
	{
		return posX;
	}

	public void setPosX(int posX) 
	{
		this.posX = posX;
	}

	public int getPosY() 
	{
		return posY;
	}

	public void setPosY(int posY) 
	{
		this.posY = posY;
	}

	public Codon getCodon() 
	{
		return codon;
	}

	public void setCodon(Codon codon) 
	{
		this.codon = codon;
	}


	public String toString()
	{
		return "" + triplet[0].getNucl() + triplet[1].getNucl() + triplet[2].getNucl() + "(" + this.posX + " ; " + this.posY + ") " + " -> " + orientation;	
	}
	
	
	
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) 
	{
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
	}

	public void mouseExited(MouseEvent e) 
	{
		this.setBorder(null);
	}

}
