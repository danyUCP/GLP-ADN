package ihm;

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
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ARN.Adenine;
import ARN.Cytosine;
import ARN.Guanine;
import ARN.Nucleotide;
import ARN.Thymine;
import ARN.Uracile;

@SuppressWarnings("serial")
public class NuclComp extends JLabel implements MouseListener
{
	private static HashMap<String, ImageIcon> iconMap;

	private ImageIcon iconNucl;
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private boolean orientation, orChange;
	private Nucleotide nucl;
	private float alpha = 1.0f;
	
	
	public NuclComp(Nucleotide nucl, int posX, int posY) 
	{		
		super();
		
		if(iconMap == null)
			initMap();
		
		this.nucl = nucl;
		this.iconNucl = iconMap.get(nucl.getLettre());
		this.orientation = true;
		this.orChange = false;
		
		if(orientation == false)
			rotationImage(180, this);
		
		this.setIcon(iconNucl);
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = ParaADN.LARGEUR_NUCL;
		this.hauteur = ParaADN.HAUTEUR_NUCL;
		
		this.setBounds(posX * largeur, posY, largeur, hauteur);
	}
	
	public NuclComp(Nucleotide nucl, int posX, int posY, boolean orientation) 
	{		
		super();
		
		if(iconMap == null)
			initMap();
		
		this.nucl = nucl;
		this.iconNucl = iconMap.get(nucl.getLettre());
		this.orientation = orientation;
		this.orChange = false;

		
		if(orientation == false)
			rotationImage(180, this);
		
		this.setIcon(iconNucl);
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = ParaADN.LARGEUR_NUCL;
		this.hauteur = ParaADN.HAUTEUR_NUCL;
		
		this.setBounds(posX * largeur, (posY + 1) * (hauteur - 13), largeur, hauteur);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		this.addMouseListener(this);
		
	}

	
	private void initMap()
	{
		iconMap = new HashMap<String, ImageIcon>();
		
		iconMap.put((new Adenine()).toString(), new ImageIcon("ressources/nucleotides/adenine.png"));
		iconMap.put((new Thymine()).toString(), new ImageIcon("ressources/nucleotides/thymine.png"));
		iconMap.put((new Guanine()).toString(), new ImageIcon("ressources/nucleotides/guanine.png"));
		iconMap.put((new Cytosine()).toString(), new ImageIcon("ressources/nucleotides/cytosine.png"));
		iconMap.put((new Uracile()).toString(), new ImageIcon("ressources/nucleotides/uracile.png"));
		
		System.out.println("IconMap initialisée");	
		System.out.println(iconMap);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d);
		g2d.drawString(nucl.getLettre(), 14, 48);
		//System.out.println("On repeint");

	}    
	
	
	public void rotationImage(double degre, ImageObserver o)
	{
		Image img = iconNucl.getImage();
		BufferedImage rectangle = new BufferedImage(iconNucl.getIconWidth(), iconNucl.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)rectangle.getGraphics();
		g2.rotate(Math.toRadians(degre), iconNucl.getIconWidth() / 2, iconNucl.getIconHeight() / 2);
		g2.drawImage(img, 0, 0, o);
		img = rectangle;
		iconNucl = new ImageIcon(img);
	}
	
	
	public void rotation()
	{
		if(orChange)
			rotationImage(180, this);
		
		this.setIcon(iconNucl);	
	}
	
	public boolean getOrientation() 
	{
		return orientation;
	}

	public void setOrientation(boolean o) 
	{
		if(this.orientation != o)
			orChange = true;
		else
			this.orChange = false;

		this.orientation = o;		
	}
	

	public float getAlpha() 
	{
		return alpha;
	}

	public void setAlpha(float alpha) 
	{
		this.alpha = alpha;
		repaint();
	}

	public int getPosX()
	{
		return posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosX(int posX) 
	{
		this.posX = posX;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	public void placer(int x, int y)
	{
		this.setPosX(x);
		this.setPosY(y);
		
		this.setLocation(posX * largeur, (posY + 1) * (hauteur - 13));
	}

	public int getLargeur() 
	{
		return largeur;
	}

	public int getLongueur() 
	{
		return hauteur;
	}

	public Nucleotide getNucl() 
	{
		return nucl;
	}

	public void setLargeur(int largeur) 
	{
		this.largeur = largeur;
	}

	public void setLongueur(int longueur) 
	{
		this.hauteur = longueur;
	}

	public void setNucl(Nucleotide nucl) 
	{
		this.nucl = nucl;
	}
	
	
	public String toString()
	{
		return nucl.getLettre() + "(" + this.posX + " ; " + this.posY + ") " + " -> " + orientation;
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
