package ihm.synthese;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ARN.BrinADN;
import ARN.BrinARN;
import ihm.NuclComp;
import ihm.ParaADN;

@SuppressWarnings("serial")
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
	private Image noyau;

	
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
		
		try
		{
			noyau = ImageIO.read(new File("noyau.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
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

		int echelleX = ((dim.width / 2 - brinArn.getTaille() * ParaADN.LARGEUR_NUCL / 2) - brin.getX()) / 12;
		int echelleY = (brin.getY() - 330) / 10;
		
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
			
			while(builder.getNuclCpAt(builder.getTaille() - 1).getX() > builder.getTaille() * ParaADN.LARGEUR_NUCL)
			{
				for(int i = 0 ; i < builder.getTaille() ; i++)
				{
					NuclComp tmp = builder.getNuclCpAt(i);
					int echelleX = (i * ParaADN.LARGEUR_NUCL - tmp.getX()) / 12;
					
					
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
				
				tmp.setLocation(i * ParaADN.LARGEUR_NUCL, tmp.getY());
			}
			
		}	
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		super.paintComponent(g2d);
		
		g2d.drawImage(noyau, -300, -520 + 150, 1800, 1800, this);
		
		g2d.setColor(new Color(0, 0, 255, 100));
	}

}
