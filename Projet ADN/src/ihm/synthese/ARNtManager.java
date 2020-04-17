package ihm.synthese;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ARN.AcideAmine;
import ARN.Codon;
import ihm.ParaADN;

/**
 * ARNtManager est la classe de gestion des ARN de transfert 
 * 
 * @author Daniel
 */
public class ARNtManager extends Thread
{
	private Codon codon;
	private AcideAmine aciAmi;
	
	private CodonComp codonLu, codonComplem;
	private JLabel corps;
	private AcideComp acide;
	
	private ARNTComp ARNtLabel;
	
	private boolean acidePresent;
	
	/**
	 * Contructeur de la classe ARNtManager.
	 * 
	 * A la construction d'un thread ARNtManager, le codon et l'acide aminé de l'ARNt sont créés en fonction du codon lu
	 * et un JLabel est prêt à accueillir l'acide, le codon et le corps de l'ARNt 
	 */
	public ARNtManager(CodonComp codonLu, AcideAmine aciAmi)
	{
		super();
		
		this.codonLu = codonLu;
		
		this.codon = codonLu.getCodon();

		this.codonComplem = new CodonComp(codon.getComplementaire(), 0, 0, true);
		this.codonComplem.removeMouseListener(codonComplem);
		
		this.aciAmi = aciAmi;
		this.acide = new AcideComp(aciAmi, 0, 0);
		this.acidePresent = true;
		
		this.corps = new JLabel(new ImageIcon("ressources/synthese/arnt2.png"));
		this.ARNtLabel = new ARNTComp();
		this.ARNtLabel.addMouseListener(ARNtLabel);
	}
	
	/**
	 * Cette méthode place les composants de l'ARNt dans son JLabel dédié
	 */
	private void placerComposants()
	{
		acide.setLocation(ParaADN.LARGEUR_ARNT / 2 - ParaADN.LARGEUR_ACIDE / 2, 0);
		corps.setBounds(0, 55, ParaADN.LARGEUR_ARNT, 150);
		codonComplem.setLocation(0, ARNtLabel.getHeight() - ParaADN.HAUTEUR_NUCL);
	}
	
	/**
	 * Cette méthode renvoie le JLabel du brin dimensionné et positionné sur la ligne de départ en haut à droite 
	 * et contenant tous les composants
	 */
	public ARNTComp creerARNt(int x, int y)
	{
		this.ARNtLabel.setLayout(null);
		this.ARNtLabel.setSize(ParaADN.LARGEUR_ARNT, ParaADN.HAUTEUR_ARNT);
		
		this.ARNtLabel.setLocation(1000, -300);
		placerComposants();
		
		this.ARNtLabel.add(acide);
		this.ARNtLabel.add(corps);
		this.ARNtLabel.add(codonComplem);
				
		//this.ARNtLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

		return ARNtLabel;
	}
	
	/**
	 * Cette méthode permet au thread de transférer l'AcideComp dans la chaine d'acides aminés
	 */
	public void transfererAcide(ChaineLabel chaine)
	{
		chaine.ajouterAcide(this.acide);
		chaine.setLocation(ARNtLabel.getX() + 16 - (chaine.getWidth() - ParaADN.LARGEUR_ACIDE), ARNtLabel.getY());

		this.acidePresent = false;
	}
		
	
	public ARNTComp getARNtLabel() 
	{
		return ARNtLabel;
	}
	
	public boolean isAcidePresent() 
	{
		return acidePresent;
	}

	
	/**
	 * Ensemble des traitements liés à l'animation de l'ARNt
	 */
	public void run()
	{	
		float alpha = 0.0f;
		int pX = ARNtLabel.getX();
		int pY = ARNtLabel.getY();

		ARNtLabel.setAlpha(alpha);		
		
		//-------------------- PAUSE ARNt -----------------------//
		/*
		 * Etape 1 : l'ARNt est sur la ligne de départ en haut à droite, totalement transparent, 
		 * et attend le signal du thread de SyntheseActivity
		 */
		try 
		{
			pause();
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
		
		/*
		 * Etape 2 : Lorsqu'il reçoit le signal, le thread déplace le JLabel de l'ARNt vers le codon lu 
		 * par le ribosome tout en apparaissant progressivement puis se remet en attente
		 */
		while(alpha < 1.0 || pX > ParaADN.LARGEUR_ARNT * 5 || pY < 153)
		{
			if(alpha < 1.0)
				alpha = alpha + 0.02f;
			if(alpha > 0.99)
				alpha = 1.0f;
			
			this.ARNtLabel.setAlpha(alpha);
			
			if(pX > ParaADN.LARGEUR_ARNT * 5)
				pX-=10;
			if(pX < ParaADN.LARGEUR_ARNT * 5)
				pX = ParaADN.LARGEUR_ARNT * 5;
			
			if(pY < 153)
				pY+=8;
			if(pY > 153)
				pY = 153;

			//System.out.println(pX + " " + pY);

			ARNtLabel.setLocation(pX, pY);
			ARNtLabel.repaint();

			try
			{
				Thread.sleep(30);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//-------------------- PAUSE ARNt -----------------------//
		try 
		{
			pause();
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
		
		pX = ARNtLabel.getX();
		pY = ARNtLabel.getY();
		
		/*
		 * Etape 3 : Lorsqu'il reçoit de nouveau un signal, le thread déplace le JLabel de l'ARNt vers le coin en 
		 * haut à gauche tout en disparaissant progressivement puis se termine
		 */
		while(alpha > 0.0)
		{
			if(alpha > 0.0)
				alpha = alpha - 0.04f;
			if(alpha < 0.01)
				alpha = 0.0f;
			
			this.ARNtLabel.setAlpha(alpha);
			
			pX-=10;
			pY-=8;

			//System.out.println(pX + " " + pY);

			ARNtLabel.setLocation(pX, pY);
			ARNtLabel.repaint();

			try
			{
				Thread.sleep(30);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void relancer() throws InterruptedException
	{
		notify();
	}
	
	public synchronized void pause() throws InterruptedException
	{
		wait();
	}
	
	
	/**
	 * Cette classe interne gère la personnalisation du JLabel de l'ARNt
	 */
	@SuppressWarnings("serial")
	private class ARNTComp extends JLabel implements MouseListener
	{
		private float alpha = 1.0f;

		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

			super.paintComponent(g2d);
		}

		public void setAlpha(float alpha) 
		{
			this.alpha = alpha;
			codonComplem.setAlpha(this.alpha);
			repaint();
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
	
	public String toString()
	{
		return this.codon + "(" + codonLu.getPosX() + ") " + " -> " + this.aciAmi;
	}

}
