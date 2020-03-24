package ihm.synthese;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ARN.BrinADN;
import ARN.BrinARN;
import ihm.NuclComp;

public class MaturationActivity extends JPanel
{
	private BrinARN brinArn;
	private Dimension dim;
	private JPanel commandes;
	private JLabel brin;
	private JButton play, suivant;
	private boolean mature, stop;
	private Thread activityThread;
	private ARNmBuilder builder;

	
	public MaturationActivity(JPanel commandes, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		
		this.mature = false;
		this.stop = true;
		

		this.dim = dim;
		this.setSize(dim);
		System.out.println(this.getBounds());

		System.out.println(dim);


		this.setBackground(Color.WHITE);
		
		
		maturation();

	}
	
	public void maturation()
	{
		commandes.setBackground(Color.RED);
		
		
		brinArn = new BrinADN("TACTGATGCTccaccagccgtGATAACG").transcrire();
		
		builder = new ARNmBuilder(brinArn, false);
		
		brin = builder.creerARN(1, 2);
		this.add(brin);
		
		
		play = new JButton("Lancer l'animation");
		play.addActionListener(new PlayListener());
		commandes.add(play);
		
		suivant = new JButton("Suivant");
		suivant.setEnabled(false);
		suivant.addActionListener(new PlayListener());
		commandes.add(suivant);
		
		
	}
	
	class PlayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == play)
			{
				if(stop)
				{				
					stop = false;
					activityThread = new Thread(new Animation());
					activityThread.start();
				}
			}
			else if(e.getSource() == suivant)
			{
				try {
					relancer();
					suivant.setEnabled(false);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	public void excision()
	{
		float alpha = 1.0f;
		
		if(!mature)
		{
			brinArn.genererIntrons();
			System.out.println(brinArn);
			mature = true;
		}

		while(alpha > 0.0)
		{
			alpha = alpha - 0.05f;
			if(alpha < 0.01)
				alpha = 0;
			//System.out.println(alpha);

			for(int i = 0 ; i < brinArn.getTaille() ; i++)
			{
				if(!builder.getNuclCpAt(i).getNucl().estExon())
					builder.getNuclCpAt(i).setAlpha(alpha);
			}
			
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void epissage()
	{
		System.out.println(brinArn);
		brinArn.retirerIntrons();
		System.out.println(brinArn);

		int echelleX = ((dim.width / 2 - brinArn.getTaille()*36 / 2) - brin.getX()) / 12;
		int echelleY = (brin.getY() - 330) / 10;
		
		/*
		System.out.println(brin.getX());
		System.out.println(dim.width / 2 - brinArn.getTaille()*36 / 2);
		System.out.println(brinArn.getTaille());
		System.out.println(echelleX);

		System.out.println(brin.getY());
		System.out.println(echelleY);
		*/
		Thread t = new Thread(new LigatureAnimation());
		t.start();

		while(brin.getY() > 330)
		{
			brin.setLocation(brin.getX() + echelleX / 2, brin.getY() - echelleY / 2);
			
			try
			{
				Thread.sleep(50);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	class Animation implements Runnable
	{
		public synchronized void run()
		{
			excision();

			suivant.setEnabled(true);

			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			epissage();
		}
	}
	
	class LigatureAnimation implements Runnable
	{
		public void run() 
		{
			System.out.println(builder.getTaille());
			builder.retirerNuclCp();
			
			while(builder.getNuclCpAt(builder.getTaille() - 1).getX() > builder.getTaille() * 36)
			{
				for(int i = 0 ; i < builder.getTaille() ; i++)
				{
					NuclComp tmp = builder.getNuclCpAt(i);
					int echelleX = (i * 36 - tmp.getX()) / 12;
					
					
					tmp.setLocation(tmp.getX() + echelleX, tmp.getY());
				}
				
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			System.out.println(builder);

			for(int i = 0 ; i < builder.getTaille() ; i++)
			{
				NuclComp tmp = builder.getNuclCpAt(i);
				
				tmp.setLocation(i * 36, tmp.getY());
			}
			
		}	
	}

}
