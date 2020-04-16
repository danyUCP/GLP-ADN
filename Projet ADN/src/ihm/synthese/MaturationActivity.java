package ihm.synthese;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.SwingUtilities;

import ARN.ARNm;
import ARN.BrinADN;
import ARN.BrinARN;
import ARN.ModelSynthese;
import ihm.NuclComp;
import ihm.ParaADN;

@SuppressWarnings("serial")
public class MaturationActivity extends JPanel
{
	private BrinARN brinArn;
	private Dimension dim;
	private JPanel commandes;
	private JLabel brin;
	private CommentLabel comment;
	private JButton play, suivant, recommencer;
	private boolean mature, stop;
	private Thread activityThread;
	private ARNmBuilder builder, builder2;
	private Image noyau;
	private int noyX = -300;
	private ModelSynthese modele;

	
	public MaturationActivity(ModelSynthese modele, JPanel commandes)
	{
		super(null);
		this.modele = modele;
		this.commandes = commandes;
		
		this.mature = false;
		this.stop = true;
		
		this.setBounds(0, 0, ParaADN.LARGEUR_CONTENU, ParaADN.HAUTEUR_CONTENU);
		this.setBackground(Color.WHITE);
		
		try
		{
			noyau = ImageIO.read(new File("ressources/synthese/noyau.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		this.modele.transcription();
		maturation();
	}
	
	public void maturation()
	{
		commandes.setBackground(new Color(204, 204, 255));
		
		
		brinArn = modele.getARNmature();
		
		builder = new ARNmBuilder(brinArn, false);
		brin = builder.creerARN(1, 2);
		this.add(brin);
		
		comment = new CommentLabel("<html>2ème étape : La Maturation</html>", 0);
		this.add(comment);
		
		play = new JButton("Lancer l'animation");
		play.addActionListener(new PlayListener());
		commandes.add(play);
		
		suivant = new JButton("Suivant");
		suivant.setEnabled(false);
		suivant.addActionListener(new PlayListener());
		commandes.add(suivant);
		
		recommencer = new JButton("Recommencer");
		recommencer.setEnabled(false);
		recommencer.addActionListener(new PlayListener());
		commandes.add(recommencer);
		
	}
	
	private class PlayListener implements ActionListener
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
				try 
				{
					relancer();
					suivant.setEnabled(false);
				} 
				catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == recommencer)
			{
				recommencer.setEnabled(false);
				stop = true;
				resetPanel();
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
			//modele.maturation();

			//brinArn = modele.getARNmature();
			brinArn.genererIntrons();
			mature = true;
			System.out.println(brinArn);

		}
		
		comment.setComment("<html>La maturation est l'étape au cours de laquelle l'ARN devient ARNm, le brin est alors amputé de ses introns</html>", 1);


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
		brinArn.retirerIntrons();

		comment.setComment("<html>Les séquences non-codantes (les introns) sont retirées pour ne garder que les séquences codantes (les exons)</html>", 1);

		int echelleX = ((ParaADN.LARGEUR_CONTENU / 2 - brinArn.getTaille() * ParaADN.LARGEUR_NUCL / 2) - brin.getX()) / 12;
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
		
		int bx = brin.getX();
		int by = brin.getY();

		
		builder2 = new ARNmBuilder(new ARNm(brinArn), false);
		remove(brin);
		brin = builder2.creerARNmessager(0, 0);
		brin.setLocation(bx, by);
		add(brin);
		repaint();

	}
	
	private class Animation implements Runnable
	{
		public synchronized void run()
		{
			recommencer.setEnabled(true);
			
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
			
			suivant.setEnabled(true);
			
			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			comment.setComment("<html>Maintenant qu'il est mature, l'ARNm peut quitter le noyau</html>", 0);

			while(noyX > -720)
			{
				brin.setLocation(brin.getX() + (ParaADN.LARGEUR_NUCL / 4), brin.getY());
				noyX -= 9;
				
				repaint();

				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			while(brin.getX() < ParaADN.LARGEUR_CONTENU)
			{
				brin.setLocation(brin.getX() + (ParaADN.LARGEUR_NUCL / 4), brin.getY());
				repaint();

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
	}
	
	private class LigatureAnimation implements Runnable
	{
		public void run() 
		{
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
		g2d.setColor(new Color(255, 255, 255, 200));
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 20));
		
		g2d.drawImage(noyau, noyX, -520, 1800, 1800, this);
		g2d.drawString("Noyau", 10, 30);

		g2d.setColor(new Color(0, 0, 255, 100));
	}
	
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		System.out.println(parent);
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new MaturationActivity(modele, commandes));
		
		parent.revalidate();
		parent.repaint();
	}
	

}
