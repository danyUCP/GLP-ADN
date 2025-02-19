package ihm.synthese;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.AcideAmine;
import ihm.ParaADN;

@SuppressWarnings("serial")
public class AcideComp extends JLabel implements MouseListener
{
	//R�pertoire d'images
	private static HashMap<String, Image> acideMap;
	
	//Fichier image
	private Image imageAA;

	//Position et dimension
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	
	//Donn�es de l'acide amin� � repr�senter
	private AcideAmine acide;

	
	/**
	 * Contructeur de la classe AcideComp.
	 * 
	 * A la construction d'un objet AcideComp, un JLabel est cr�e et contient l'image correspondant � l'acide amin� 
	 * avec sa position et ses dimensions
	 */
	public AcideComp(AcideAmine acide, int posX, int posY)
	{
		super();
		
		if(acideMap == null)
			initMap();
		
		this.acide = acide;
		this.imageAA = acideMap.get(acide.getNom());
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = ParaADN.LARGEUR_ACIDE;
		this.hauteur = ParaADN.HAUTEUR_ACIDE;
		
		this.setBounds(posX * largeur, posY, largeur, hauteur);
		this.addMouseListener(this);
	}
	
	/**
	 * Cette m�thode permet d'initialiser le r�pertoire d'images
	 */
	private void initMap()
	{
		acideMap = new HashMap<String, Image>();
		
		try 
		{
			acideMap.put("Phe", ImageIO.read(new File("ressources/acides/phe.png")));
			acideMap.put("Leu", ImageIO.read(new File("ressources/acides/leu.png")));
			acideMap.put("Ile", ImageIO.read(new File("ressources/acides/ile.png")));
			acideMap.put("Met", ImageIO.read(new File("ressources/acides/met.png")));
			acideMap.put("Val", ImageIO.read(new File("ressources/acides/val.png")));
			acideMap.put("Ser", ImageIO.read(new File("ressources/acides/ser.png")));
			acideMap.put("Pro", ImageIO.read(new File("ressources/acides/pro.png")));
			acideMap.put("Thr", ImageIO.read(new File("ressources/acides/thr.png")));
			acideMap.put("Ala", ImageIO.read(new File("ressources/acides/ala.png")));
			acideMap.put("Tyr", ImageIO.read(new File("ressources/acides/tyr.png")));
			acideMap.put("Stp", ImageIO.read(new File("ressources/acides/stp.png")));
			acideMap.put("His", ImageIO.read(new File("ressources/acides/his.png")));
			acideMap.put("Gln", ImageIO.read(new File("ressources/acides/gln.png")));
			acideMap.put("Asn", ImageIO.read(new File("ressources/acides/asn.png")));
			acideMap.put("Lys", ImageIO.read(new File("ressources/acides/lys.png")));
			acideMap.put("Asp", ImageIO.read(new File("ressources/acides/asp.png")));
			acideMap.put("Glu", ImageIO.read(new File("ressources/acides/glu.png")));
			acideMap.put("Cys", ImageIO.read(new File("ressources/acides/cys.png")));
			acideMap.put("Trp", ImageIO.read(new File("ressources/acides/trp.png")));
			acideMap.put("Arg", ImageIO.read(new File("ressources/acides/arg.png")));
			acideMap.put("Gly", ImageIO.read(new File("ressources/acides/gly.png")));
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//System.out.println("AcideMap initialis�e");	
		//System.out.println(acideMap);
	}
	
	/**
	 * Dessine l'acide amin� avec la transparence souhait�e et le nom correspondant en son centre;
	 */
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		super.paintComponent(g2d);
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 14));
		g2d.drawImage(imageAA, 0, 0, this);
		g2d.drawString(acide.getNom(), 25, 40);
		//System.out.println("On repeint");
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
	
	public int getLargeur() 
	{
		return largeur;
	}

	public int getHauteur() 
	{
		return hauteur;
	}
	public void setLargeur(int largeur) 
	{
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) 
	{
		this.hauteur = hauteur;
	}
	
	public AcideAmine getAcide() 
	{
		return acide;
	}
	
	public void setAcide(AcideAmine acide) 
	{
		this.acide = acide;
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
