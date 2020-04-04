package ihm.synthese;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JLabel;

import ARN.BrinADN;
import ihm.NuclComp;
import ihm.ParaADN;

public class BrinHelice extends JLabel
{
	private ArrayList<NuclComp> nuclList;
	private BrinADN brin;
	private boolean orientation;
	private int o = 1;
	
	private int pos, hauteur = 2;
	private int decalage;
	private int ecart;
	
	public BrinHelice(BrinADN brin)
	{
		this.brin = brin;
		this.orientation = true;
		
		initList();
	}
	
	public BrinHelice(BrinADN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		if(this.orientation == false)
			o = -1;
		
		initList();		
	}
	
	private void initList()
	{
		this.nuclList = new ArrayList<NuclComp>();
		
		for(int i = 0 ; i < brin.getTaille() ; i++)
			this.nuclList.add(new NuclComp(brin.getNuclAt(i), i, -1, orientation));
		
		System.out.println("Liste de nucléotides composantes initialisée");	
		
		//System.out.println(nuclList);

	}
	
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
			//this.nuclList.add(new NuclComp(brin.getNuclAt(i), j, k + hauteur -  (hauteur / 2) - 1, k < 0 ? true : false));
			
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
			
			/*
			if(pos > 21)
				ecart = 4;
			else if(pos > 18)
				ecart = 3;
			else if(pos > 6)
				ecart = 2;
			else if(pos > 3)
				ecart = 1;
			else if(pos >= 0)
				ecart = 0;
			else if(pos > -4)
				ecart = -1;
			else if(pos > -7)
				ecart = -2;
			*/
			
			this.getNuclCpAt(i).placer(j + ecart, k + hauteur -  (hauteur / 2) - 1);


			//if(orientation == true)
				//this.getNuclCpAt(i).setOrientation(k < 0 ? true : false);
			//else
			this.getNuclCpAt(i).setOrientation(k < 0 ? true : false);
			
			//System.out.println(this.getNuclCpAt(i).getOrientation());
			
			this.getNuclCpAt(i).rotation();
			
			this.add(this.nuclList.get(i));

			j++;
		}
		
		//System.out.println(this.getTaille() + " + " + decalage);

	}
	
	public void creerHelice(int x, int y)
	{	
		placerNucleotides(x);
		
		this.setLayout(null);
		this.setSize((nuclList.size() + decalage) * ParaADN.LARGEUR_NUCL, hauteur * ParaADN.HAUTEUR_NUCL);
		
		this.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + ((y - (hauteur / 2)) * (ParaADN.HAUTEUR_NUCL - 13)));
				
		//for(int i = 0 ; i < nuclList.size() ; i++)
			//this.add(this.nuclList.get(i));
		
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		System.out.println(this.getBounds());
		
	}
	
	public void deplacerDroite()
	{
		int echelle = 36;
		int position = this.getX() / echelle;
		//pos = this.getX() / 36;
		
		System.out.println("Position de l'hélice : " + position);
		
		pos = position + 1;
		System.out.println("Position : " + pos);

		
		this.setLocation(position * echelle, getY());
		
		
		placerNucleotides(pos);
		
	}
	
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
		//getX() - precision
		
		placerNucleotides(getX() / echelle);
		
	}
	
	public void paintComponent(Graphics g1)
	{	
		Graphics2D g = (Graphics2D)g1;
		
		g.setColor(new Color(185, 122, 87));
		g.setStroke(new BasicStroke(3.0f));
		
		super.paintComponent(g);
		int x1, y1, x2, y2;
		int i = 0;
		int nbBlocs = getTaille() / 3;
		NuclComp n1, n2;
		
		if(this.nuclList == null)
			return;
		
		for(i = 0 ; i < getTaille() - 3 ; i += 3)
		{
			if(pos >= -i && (pos < (6 - i) || pos >= (15 - i)))
			{
				
				n1 = getNuclCpAt((i + 3) - ((i + pos) % 3) - 1);
				n2 = getNuclCpAt((i + 3) - ((i + pos) % 3));
				
				//System.out.println("Dessine lien " + ((i + 3) - ((i + pos) % 3)) + "/" + getTaille() + " : " + n1 + " --- " + n2);

				
				x1 = n1.getX() + ParaADN.LARGEUR_NUCL;
				y1 = n1.getY() + (n1.getOrientation() ? 3 : 85);
				x2 = n2.getX();
				y2 = n2.getY() + (n2.getOrientation() ? 3 : 85);
				
				//g.drawArc(x1 - (x1+x2) / 2, y1 - 88, (x1+x2) / 2, (y1+y2) / 2, 36, 88);
				g.drawLine(x1, y1, x2, y2);
			}	
		}
		/*
		if(orientation == true)
		{
			
			if(pos >= 0 && (pos < 6 || pos >= 15))
			{
				x1 = getNuclCpAt(3 - ((3 + pos) % 3) - 1).getX() + 36;
				y1 = getNuclCpAt(3 - ((3 + pos) % 3) - 1).getY() + ((pos < 3) || (pos >= 15 && pos % 6 >= 3) ? 3 : 85);
				x2 = getNuclCpAt(3 - ((3 + pos) % 3)).getX();
				y2 = getNuclCpAt(3 - ((3 + pos) % 3)).getY() + ((pos < 3) || (pos >= 15 && pos % 6 >= 3) ? 85 : 3);
				g.drawLine(x1, y1, x2, y2);
				System.out.println("Dessine lien 1 : " + pos + " : " + (9 - ((6 + pos) % 3) - 1));

			}
			
			if(pos >= -3 && (pos < 3 || pos >= 12))
			{
				x1 = getNuclCpAt(6 - ((3 + pos) % 3) - 1).getX() + 36;
				y1 = getNuclCpAt(6 - ((3 + pos) % 3) - 1).getY() + ((pos < 0) || (pos >= 12 && pos % 6 < 3) ? 3 : 85);
				x2 = getNuclCpAt(6 - ((3 + pos) % 3)).getX();
				y2 = getNuclCpAt(6 - ((3 + pos) % 3)).getY() + ((pos < 0) || (pos >= 12 && pos % 6 < 3) ? 85 : 3);
				g.drawLine(x1, y1, x2, y2);
				//g.drawArc(x1, y1, x2, y2, 50, 50);
				//6 - Math.abs(pos % 3) - (pos < 0 ? 2 : 1)
				// - (pos < 0 ? 1 : 0)
				System.out.println("Dessine lien 2 : " + pos + " : " + (6 - ((3 + pos) % 3) - 1));

			}
			
			if(pos >= -6 && (pos < 0 || pos >= 9))
			{
				x1 = getNuclCpAt(9 - ((6 + pos) % 3) - 1).getX() + 36;
				y1 = getNuclCpAt(9 - ((6 + pos) % 3) - 1).getY() + ((pos < -3) || (pos >= 9 && pos % 6 >= 3) ? 3 : 85);
				x2 = getNuclCpAt(9 - ((6 + pos) % 3)).getX();
				y2 = getNuclCpAt(9 - ((6 + pos) % 3)).getY() + ((pos < -3) || (pos >= 9 && (pos % 6) >= 3) ? 85 : 3);
				g.drawLine(x1, y1, x2, y2);
				System.out.println("Dessine lien 3 : " + pos + " : " + (9 - ((6 + pos) % 3) - 1));

			}
			
			
			if(pos >= -9 && (pos < -3 || pos >= 6))
			{
				x1 = getNuclCpAt(12 - ((9 + pos) % 3) - 1).getX() + 36;
				y1 = getNuclCpAt(12 - ((9 + pos) % 3) - 1).getY() + ((pos < -6) || (pos >= 6 && pos % 6 < 3) ? 3 : 85);
				x2 = getNuclCpAt(12 - ((9 + pos) % 3)).getX();
				y2 = getNuclCpAt(12 - ((9 + pos) % 3)).getY() + ((pos < -6) || (pos >= 6 && pos % 6 < 3) ? 85 : 3);
				g.drawLine(x1, y1, x2, y2);
				System.out.println("Dessine lien 4 : " + pos + " : " + (12 - ((6 + pos) % 3) - 1));

			}
			/*
			//version 1
			if((pos < -3 || pos >= 6))
			{
				x1 = getNuclCpAt(12 - (pos % 3) - 1).getX() + 36;
				y1 = getNuclCpAt(12 - (pos % 3) - 1).getY() + ((pos < -3 && Math.abs(pos % 6) < 3) || (pos >= 6 && Math.abs(pos % 6) >= 3) ? 88 : 0);
				x2 = getNuclCpAt(12 - (pos % 3)).getX();
				y2 = getNuclCpAt(12 - (pos % 3)).getY() + ((pos < -3 && Math.abs(pos % 6) < 3) || (pos >= 6 && Math.abs(pos % 6) >= 3) ? 0 : 88);
				g.drawLine(x1, y1, x2, y2);
				System.out.println("Dessine lien 4");

			}
			
		}
		*/
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
