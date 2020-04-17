package ihm.synthese;

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
import ihm.ParaADN;

/**
 * CodonComp est la classe gère la représentation des codons sous forme triplet de NuclComp
 * 
 * @author Daniel
 */
/**
 * @author danie
 *
 */
@SuppressWarnings("serial")
public class CodonComp extends JLabel implements MouseListener
{
	//Triplet de NuclComp correspondant 
	private NuclComp[] triplet;
	
	//Position,dimension et orientation
	private int posX;
	private int posY;
	private int largeur;
	private int longueur;
	private boolean orientation;
	private float alpha = 1.0f;

	//Données du codon à représenter
	private Codon codon;

	/**
	 * Contructeur de la classe CodonComp.
	 * 
	 * A la construction d'un objet CodonComp, un JLabel est crée et contient trois NuclComp correspondant
	 * aux trois nucléotides que contient le codon
	 */
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
		this.largeur = 3 * ParaADN.LARGEUR_NUCL;
		this.longueur = ParaADN.HAUTEUR_NUCL;
		
		this.setBounds(posX * largeur, posY + 1, largeur, longueur);
		//System.out.println(this.getBounds());

		for(int i = 0 ; i < 3 ; i++)
		{
			triplet[i].removeMouseListener(triplet[i]);
			this.add(triplet[i]);
		}
		
		this.addMouseListener(this);
	}
	
	/**
	 * Dessine le codon avec la transparence souhaitée
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d); 
	}    

	/**
	 * Mise à jour de la transparence
	 */
	public void setAlpha(float alpha) 
	{
		this.alpha = alpha;
		triplet[0].setAlpha(this.alpha);
		triplet[1].setAlpha(this.alpha);
		triplet[2].setAlpha(this.alpha);
		repaint();
	}
	
	public float getAlpha() 
	{
		return alpha;
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
