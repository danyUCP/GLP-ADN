package ihm;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ADN.Alpha;
import ADN.Beta;
import ADN.Polymere;


public class Microtubs extends JLabel {
	private static HashMap<String, ImageIcon> iconMap;

	private ImageIcon iconMono;
	private int posX;
	private int posY;
	private int largeur;
	private int hauteur;
	private boolean orientation, orChange;
	private Polymere mono;
	private float alpha = 1.0f;
	
	
	public Microtubs(Polymere mono, int posX, int posY) {		
		super();
		
		if(iconMap == null)
			initMap();
		
		this.mono = mono;
		this.iconMono = iconMap.get(mono.getName());
		this.orientation = true;
		this.orChange = false;
		
		if(orientation == false)
			rotationImage(180, this);
		
		this.setIcon(iconMono);
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = ParaADN.LARGEUR_NUCL;
		this.hauteur = ParaADN.HAUTEUR_NUCL;
		
		this.setBounds(posX * largeur, posY, largeur, hauteur);
	}
	
	/**constructeur instanciant les position, les monomere et l'orientation
	 * @see initMap()
	 */
	public Microtubs(Polymere mono, int posX, int posY, boolean orientation) {		
		super();
		
		if(iconMap == null)
			initMap();
		
		this.mono = mono;
		this.iconMono = iconMap.get(mono.getName());
		this.orientation = orientation;
		this.orChange = false;

		
		if(orientation == false)
			rotationImage(180, this);
		
		this.setIcon(iconMono);
		
		this.posX = posX;
		this.posY = posY;
		this.largeur = ParaADN.LARGEUR_NUCL;
		this.hauteur = ParaADN.HAUTEUR_NUCL;
		
		this.setBounds(posX * largeur, (posY + 1) * (hauteur - 13), largeur, hauteur);	
	}

	/**associe à chaque monomere une image via hashmap*/
	private void initMap() {
		iconMap = new HashMap<String, ImageIcon>();
		
		iconMap.put((new Alpha()).toString(), new ImageIcon("alpha.png"));
		iconMap.put((new Beta()).toString(), new ImageIcon("beta.png"));

		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		super.paintComponent(g2d);
		g2d.drawString(mono.getName(), 14, 48);
		//System.out.println("On repeint");

	}    
	
	
	public void rotationImage(double degre, ImageObserver o) {
		Image img = iconMono.getImage();
		BufferedImage rectangle = new BufferedImage(iconMono.getIconWidth(), iconMono.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)rectangle.getGraphics();
		g2.rotate(Math.toRadians(degre), iconMono.getIconWidth() / 2, iconMono.getIconHeight() / 2);
		g2.drawImage(img, 0, 0, o);
		img = rectangle;
		iconMono = new ImageIcon(img);
	}
	
	
	public void rotation() {
		if(orChange)
			rotationImage(180, this);
		
		this.setIcon(iconMono);	
	}
	
	/**@return orientation*/
	public boolean getOrientation() {
		return orientation;
	}

	/**change the orientation*/
	public void setOrientation(boolean o) {
		if(this.orientation != o)
			orChange = true;
		else
			this.orChange = false;

		this.orientation = o;		
	}

	/**@return posX*/
	public int getPosX() {
		return posX;
	}
	
	/**change the posX*/
	public int getPosY() {
		return posY;
	}

	/**change the posY*/
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**@return posY*/
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**Place chaque monomere à sa position selon la chaine de polymere*/
	public void placer(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
		
		this.setLocation(posX * largeur, (posY + 1) * (hauteur - 13));
	}
	
	/**@return largeur*/
	public int getLargeur() {
		return largeur;
	}
	
	/**@return hauteur*/
	public int gethauteur() {
		return hauteur;
	}

	/**@return le monomere en question*/
	public Polymere getMon() {
		return mono;
	}

	/**modifie la largeur du label*/
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**modifie la hauteur du label*/
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	
	/**@return monom.getName() et position et orientation de la pile (du label)
	 */
	public String toString() {
		return mono.getName() + "(" + this.posX + " ; " + this.posY + ") " + " -> " + orientation;
	}

}
