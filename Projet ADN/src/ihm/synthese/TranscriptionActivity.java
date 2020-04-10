package ihm.synthese;

import java.awt.AlphaComposite;
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

import ARN.BrinADN;
import ARN.BrinARN;
import ihm.ParaADN;

@SuppressWarnings("serial")
public class TranscriptionActivity extends JPanel
{
	private Dimension dim;
	private JPanel commandes;
	private BrinADN brinCodant;
	private int brVisible;
	private Thread activityThread;
	private JButton play, suivant, recommencer;
	private boolean stop;
	private JLabel brinL, brinComplL, brinArnL;
	private CommentLabel comment;
	private BrinHelice helice1, helice2;
	private int posADN, posARN, posHelice;
	private Image noyau, polymerase;
	private float alpha;
	private TranscriptionActivity pan = this;

	
	public TranscriptionActivity(JPanel commandes, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		this.stop = true;
		this.alpha = 0.0f;
		
		this.dim = dim;
		this.setSize(dim);

		this.setBackground(Color.WHITE);
		
		try
		{
			noyau = ImageIO.read(new File("noyau.png"));
			polymerase = ImageIO.read(new File("poly.png"));

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		transcription();
	}
	

	public void transcription()
	{
		commandes.setBackground(new Color(204, 204, 255));
		
		//TACTGATGCTccaccagccgtGATAACGTA
		this.brinCodant = new BrinADN("TACTGATGCTccaccagccgtGATAACG");
		posHelice = 24;
		
		helice1 = new BrinHelice(brinCodant, true);
		helice1.creerHelice(posHelice, 0);
		this.add(helice1);
		
		helice2 = new BrinHelice(brinCodant.getBrinComplem(), false);
		helice2.creerHelice(posHelice, 0);	
		this.add(helice2);
		

		/*
		BrinBuilder builder = new BrinBuilder(brinCodant);
		brinL = builder.creerBrin(3, -2);
		this.add(brinL);
		
		builder = new BrinBuilder(brinCodant.getBrinComplem(), false);
		brinComplL = builder.creerBrin(3, 1);
		this.add(brinComplL);
		*/
		BrinARN brinArn = brinCodant.transcrire();
		
		ARNmBuilder builder2 = new ARNmBuilder(brinArn, false);
		brinArnL = builder2.creerARN(14, -3);
		this.add(brinArnL);

		brinArnL.setSize(brVisible * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
			
		System.out.println("ARN visible : " + brinArnL.getBounds());
		
		comment = new CommentLabel("<html>1ère étape : La Transcription</html>", 0);
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
	
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		super.paintComponent(g2d);
		
		g2d.setColor(new Color(255, 255, 255, 200));
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 20));

		g2d.drawImage(noyau, -270, -800, 1670, 1670, this);
		g2d.drawString("Noyau", 10, 30);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(polymerase, 6 * 36 + 5, -30, 36 * 16, 88 * 8, this);
		g2d.drawString("ARN Polymérase", 12 * 36, 4 * 88);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));


		

		//g2d.fillOval(7 * 36 + 5, -30, 36 * 13, 88 * 8);
		
	}
	
	public synchronized void relancer() throws InterruptedException
	{
		notify();
	}
	
	public synchronized void pause() throws InterruptedException
	{
		wait();
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
					activityThread = new Thread(new Animation2());
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
	
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		System.out.println(parent);
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new TranscriptionActivity(commandes, dim));
		
		parent.revalidate();
		parent.repaint();
	}

	
	
	class Animation2 implements Runnable
	{
		public void run() 
		{
			int precision = 8;
			posARN = brinArnL.getX();
			
			comment.setComment("<html>La transcription commence avec un ARN polymérase qui vient diviser les deux brins d'ADN</html>", 1);
			recommencer.setEnabled(true);
			
			while(helice1.getX() > ParaADN.LARGEUR_NUCL * helice1.getDecalage() - helice1.getWidth())
			{				
				helice1.deplacerGauche(precision);
				helice2.deplacerGauche(precision);
				
				if(alpha < 0.9f)
					alpha += 0.02f;
				
				repaint();
				
				//System.out.println(posARN + " " + helice1.getDecalage());
				
				if(helice1.getX() == 17 * ParaADN.LARGEUR_NUCL)
				{
					suivant.setEnabled(true);					
					
					try 
					{
						pause();
					} 
					catch (InterruptedException e1) 
					{
						e1.printStackTrace();
					}
					
					comment.setComment("<html>Le polymérase joint un à un les nucléotides de l'ARN à un brin d'ADN...</html>", 1);
				}
				
				if(helice1.getX() < 12 * ParaADN.LARGEUR_NUCL && brVisible < brinCodant.getTaille())
				{
					brVisible = (posARN - helice1.getX()) / ParaADN.LARGEUR_NUCL;
					brinArnL.setSize(brVisible * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
					brinArnL.setLocation(brinArnL.getX() - (ParaADN.LARGEUR_NUCL / precision), brinArnL.getY());
					//System.out.println(brVisible);
					
					if(brVisible == brinCodant.getTaille())
						comment.setComment("<html>... afin de former le brin d'ARN messager correspondant au gène transcrit</html>", 1);
				}
				
				
				
				try
				{
					Thread.sleep(20);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			posARN = brinArnL.getX();
			System.out.println(alpha);
			
			suivant.setEnabled(true);

			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			comment.setComment("<html>Le brin d'ARN formé n'est pas encore prêt à quitter le noyau</html>", 0);
			
			while(brinArnL.getX() < ParaADN.LARGEUR_NUCL / 2)
			{
				//posARN++;
				brinArnL.setLocation(brinArnL.getX() + (ParaADN.LARGEUR_NUCL / 12), brinArnL.getY());				

				if(alpha > 0.02f)
					alpha -= 0.02f;
				else
					alpha = 0.0f;
				
				repaint();
				
				try
				{
					Thread.sleep(30);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			comment.setComment("<html>Il doit passer par une étape appelée la maturation</html>", 0);
			
			while(brinArnL.getY() < ParaADN.POS_MEDIANE + 1 * 75)
			{
				brinArnL.setLocation(brinArnL.getX(), brinArnL.getY() + 5);

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
	
	/*
	class Animation implements Runnable
	{
		public void run() 
		{
			int precision = 18;
			posADN = 29 * precision;
			posARN = 20 * precision;
			
			while(posADN > (-(brinCodant.getTaille() - 3) * precision))
			{
				posADN--;
				brinL.setLocation(posADN * (36 / precision), 330 + (-2 * 75));
				brinComplL.setLocation(posADN * (36 / precision), 330 + (1 * 75));
				
				if(posADN < 20 * precision && brVisible < (brinCodant.getTaille()) * precision)
				{
					posARN = posADN;
					brVisible++;
					brinArnL.setSize(brVisible * (36 / precision), 88);
					brinArnL.setLocation(posARN * (36 / precision), 330 + (-1 * 75));
					System.out.println(posARN);
				}

				try
				{
					Thread.sleep(120 / precision);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			while(posARN < 3 * precision)
			{
				posARN++;
				brinArnL.setLocation(posARN * (36 / precision), 330 + (-1 * 75));
				System.out.println(posARN);
				
				if(posARN > -3 * precision)
				{
					posADN--;
					brinL.setLocation(posADN * (36 / precision), 330 + (-2 * 75));
					brinComplL.setLocation(posADN * (36 / precision), 330 + (1 * 75));
				}

				try
				{
					Thread.sleep(120 / precision);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	*/
	
}
