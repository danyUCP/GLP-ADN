package ihm.synthese;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JLabel;

import ARN.BrinADN;
import ihm.ParaADN;

/**
 * BrinHelice est la classe gère la représentation d'un brin d'ADN sous forme d'une hélice
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class BrinHelice extends JLabel
{
	private ArrayList<NuclComp> nuclList;
	private BrinADN brin;
	private boolean orientation;
	private int o = 1;
	
	private int pos, hauteur = 2;
	private int decalage;
	private int ecart;
	
	
	/**
	 * Contructeur de la classe BrinHelice.
	 * 
	 * A la construction d'un objet BrinHelice, la liste de NuclComp est créée en fonction de 
	 * chaque nucléotide contenu dans le brin d'ADN
	 */
	public BrinHelice(BrinADN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		if(this.orientation == false)
			o = -1;
		
		initList();		
	}
	
	/**
	 * Cette méthode permet d'initialiser la liste de NuclComp correspondant aux nucléotides que contient le brin
	 */
	private void initList()
	{
		this.nuclList = new ArrayList<NuclComp>();
		
		for(int i = 0 ; i < brin.getTaille() ; i++)
			this.nuclList.add(new NuclComp(brin.getNuclAt(i), i, -1, orientation));
	}
	
	/**
	 * Cette méthode contient l'algorithme permettant de placer chaque nucléotide de l'hélice en fonction de la position de celle-ci
	 */
	private void placerNucleotides(int x)
	{
		int i = 0, j = 0, k = 0;
		this.pos = x;
		decalage = 0;
		ecart = 0;
		hauteur = 8;
		
		for(i = 0 ; i < brin.getTaille() ; i++)
		{			
			if(i + pos < 6)
			{
				if((i + pos) % 3 == 0 && i != 0)
				{
					j++;
					decalage++;
				}
				
				if((i + pos) % 6 < 3)
					k = -o;
				else
					k = o;
			}
			else if(i + pos > 17)
			{
				if((i + pos) % 3 == 0)
				{
					j++;
					decalage++;
				}
				
				if((i + pos) % 6 < 3)
					k = o;
				else
					k = -o;
			}
			else
			{
				if(i + pos == 6)
				{
					j++;
					decalage++;
				}
				
				k = -o * (hauteur / 2);
			}
			
			if(k > 0)
				k--;
			
			//System.out.println(i + " ; " + j + " ; " + k + " ; " + decalage);
			
			if(pos > 18)
				ecart = (pos - 13) / 3 + 1;
			else if(pos > 6)
				ecart = 2;
			else if(pos == 6)
				ecart = 1;
			else if(pos >= 0)
				ecart = pos / 3;
			else
				ecart = (pos - 2) / 3;
			
			
			this.getNuclCpAt(i).placer(j + ecart, k + hauteur -  (hauteur / 2) - 1);
			this.getNuclCpAt(i).setOrientation(k < 0 ? true : false);			
			this.getNuclCpAt(i).rotation();
			
			this.add(this.nuclList.get(i));

			j++;
		}
		
		//System.out.println(this.getTaille() + " + " + decalage);

	}
	
	/**
	 * Cette méthode renvoie le JLabel du brin dimensionné et positionné et contenant tous les NuclComp
	 */
	public void creerHelice(int x, int y)
	{			
		this.setLayout(null);
		
		placerNucleotides(x);
		
		this.setSize((nuclList.size() + decalage) * ParaADN.LARGEUR_NUCL, hauteur * ParaADN.HAUTEUR_NUCL);
		this.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + ((y - (hauteur / 2)) * (ParaADN.HAUTEUR_NUCL - 13)));
		
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
	}
	
	
	/**
	 * Cette méthode permet de déplacer l'hélice et de repositionner ses nucléotides selon sa position
	 */
	public void deplacerGauche(int fluidite)
	{
		int echelle = 36;
		int precision = echelle / fluidite;
		int position = this.getX() / echelle;
		
		
		//System.out.println("Position de l'hélice : " + position);
		
		pos = position - 1;
		//System.out.println("Position : " + pos);
		//System.out.println(this.getLocation());

		
		this.setLocation(getX() - precision, getY());
		placerNucleotides(getX() / echelle);
	}
	
	/**
	 * Dessine les liens entre chaque bloc de nucléotides de l'hélice
	 */
	public void paintComponent(Graphics g)
	{	
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(new Color(185, 122, 87));
		g2d.setStroke(new BasicStroke(3.0f));
		
		super.paintComponent(g2d);
		int x1, y1, x2, y2;
		int i = 0;
		NuclComp n1, n2;
		
		if(this.nuclList == null)
			return;
		
		for(i = 0 ; i < getTaille() - 1 ; i += 3)
		{
			if(pos >= -i && (pos < (6 - i) || pos >= (15 - i)))
			{
				
				n1 = getNuclCpAt((i + 3) - ((i + pos) % 3) - 1);
				n2 = getNuclCpAt((i + 3) - ((i + pos) % 3) < getTaille() ? (i + 3) - ((i + pos) % 3) : (i + 3) - ((i + pos) % 3) - 1);
				
				//System.out.println("Dessine lien " + ((i + 3) - ((i + pos) % 3)) + "/" + getTaille() + " : " + n1 + " --- " + n2);

				
				x1 = n1.getX() + ParaADN.LARGEUR_NUCL + 12;
				y1 = n1.getY() + (n1.getOrientation() ? 3 + 12 : 85 - 12);
				x2 = n2.getX() - 12;
				y2 = n2.getY() + (n2.getOrientation() ? 3 + 12 : 85 - 12);
				
				/*
				if(n1.getOrientation())
				{
					g2d.drawArc(x1 - 18, y1 - 1, x2 - x1, y2 - y1, 0, 90);
					g2d.drawArc(x1 + 18, y1 + 1, x2 - x1, y2 - y1, 180, 90);
				}
				if(!n1.getOrientation())
				{
					g2d.drawArc(x1 - 18, y2 + 1, x2 - x1, y1 - y2, 270, 90);
					g2d.drawArc(x1 + 18, y2 - 1, x2 - x1, y1 - y2, 90, 90);
				}
				*/
				if(n2 != n1)
				{
					
					if(n1.getOrientation())
					{
						g2d.drawArc(x1 - 24, y1 - 13, 24, 24, 0, 90);
						g2d.drawArc(x2, y2 - 11, 24, 24, 180, 90);
					}
					if(!n1.getOrientation())
					{
						g2d.drawArc(x1 - 24, y1 - 11, 24, 24, 270, 90);
						g2d.drawArc(x2, y2 - 13, 24, 24, 90, 90);
					}
					
					g2d.drawLine(x1, y1, x2, y2);
				}
			}	
		}
		
	}
	
	public NuclComp getNuclCpAt(int index)
	{
		return this.nuclList.get(index);
	}
	
	public void viderHelice()
	{
		this.nuclList.clear();
	}
	
	public int getTaille()
	{
		return this.nuclList.size();
	}

	public ArrayList<NuclComp> getNuclList() {
		return nuclList;
	}

	public BrinADN getBrin() 
	{
		return brin;
	}

	public boolean getOrientation() 
	{
		return orientation;
	}

	public int getPos() 
	{
		return pos;
	}

	public int getHauteur() 
	{
		return hauteur;
	}

	public int getDecalage() 
	{
		return decalage;
	}

	public int getEcart() 
	{
		return ecart;
	}

	public void setPos(int pos) 
	{
		this.pos = pos;
	}

	public void setHauteur(int hauteur) 
	{
		this.hauteur = hauteur;
	}
	
	

}
