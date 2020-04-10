package ihm.synthese;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.AcideAmine;
import ARN.Codon;
import ihm.CodonComp;
import ihm.ParaADN;

public class ARNtManager extends Thread
{
	private Codon codon;
	private AcideAmine aciAmi;
	private CodonComp codonLu, codonComplem;
	private AcideComp acide;
	private ARNTComp ARNtLabel;
	private Graphics2D g2d;
	
	
	public ARNtManager(CodonComp codonLu, AcideAmine aciAmi)
	{
		super();
		
		this.codonLu = codonLu;
		
		this.codon = codonLu.getCodon();

		this.codonComplem = new CodonComp(codon.getComplementaire(), 0, 0, true);

		
		this.aciAmi = aciAmi;
		this.acide = new AcideComp(aciAmi, 0, 0);
		
		this.ARNtLabel = new ARNTComp();
		g2d = (Graphics2D)(ARNtLabel.getGraphics());

	}
	
	private void placerComposants()
	{
		acide.setLocation(ParaADN.LARGEUR_ARNT / 2 - ParaADN.LARGEUR_ACIDE / 2, 0);
		codonComplem.setLocation(0, ParaADN.HAUTEUR_ARNT - ParaADN.HAUTEUR_NUCL);
	}
	
	
	public ARNTComp creerARNt(int x, int y)
	{
		this.ARNtLabel.setLayout(null);
		this.ARNtLabel.setSize(ParaADN.LARGEUR_ARNT, ParaADN.HAUTEUR_ARNT);
		
		//this.ARNtLabel.setLocation(x * ParaADN.LARGEUR_ARNT, 100 + (y * (ParaADN.HAUTEUR_ARNT)));
		//this.ARNtLabel.setLocation(codonLu.getX(), 65);
		//this.ARNtLabel.setLocation(ParaADN.LARGEUR_ARNT * 5 + codonLu.getX(), 65);
		this.ARNtLabel.setLocation(1000, -300);
		placerComposants();
		
		//this.ARNtLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

		this.ARNtLabel.add(codonComplem);
		this.ARNtLabel.add(acide);
		
		
		System.out.println(this.codonComplem);
		
		return ARNtLabel;
	}
		
	public ARNTComp getARNtLabel() 
	{
		return ARNtLabel;
	}

	
	public void run()
	{	
		float alpha = 0.0f;
		int pX = ARNtLabel.getX();
		int pY = ARNtLabel.getY();

		ARNtLabel.setAlpha(alpha);		
		
		//-------------------- PAUSE ARNt -----------------------//
		try 
		{
			pause();
		} 
		catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		
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
	
	
	private class ARNTComp extends JLabel
	{
		private float alpha = 1.0f;

		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

			super.paintComponent(g2d);


		}
		
		public float getAlpha() 
		{
			return alpha;
		}

		public void setAlpha(float alpha) 
		{
			this.alpha = alpha;
			codonComplem.setAlpha(this.alpha);
			repaint();
		}
	}
	
	public String toString()
	{
		return this.codon + "(" + codonLu.getPosX() + ") " + " -> " + this.aciAmi;
	}

}
