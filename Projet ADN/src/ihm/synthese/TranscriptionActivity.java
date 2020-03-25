package ihm.synthese;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ARN.BrinADN;
import ARN.BrinARN;
import ihm.synthese.MaturationActivity.Animation;
import ihm.synthese.MaturationActivity.PlayListener;

public class TranscriptionActivity extends JPanel
{
	private Dimension dim;
	private JPanel commandes;
	private BrinADN brinCodant;
	private int brVisible;
	private Thread activityThread;
	private JButton play, suivant;
	private boolean stop;
	private JLabel brinL, brinComplL, brinArnL;
	private CommentLabel comment;
	private BrinHelice helice1, helice2;
	private int posADN, posARN, posHelice;

	
	public TranscriptionActivity(JPanel commandes, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		this.stop = true;
		
		this.dim = dim;
		this.setSize(dim);
		
		this.setBackground(Color.WHITE);
		
		transcription();
	}
	

	public void transcription()
	{
		commandes.setBackground(Color.CYAN);
		
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
		

		brinArnL.setSize(brVisible * 36, 88);
			
		System.out.println(brinArnL.getBounds());
		
		comment = new CommentLabel(0, "Début de la Transcription");
		//this.add(comment);

		
		
		play = new JButton("Lancer l'animation");
		play.addActionListener(new PlayListener());
		commandes.add(play);
		
		suivant = new JButton("Suivant");
		suivant.setEnabled(false);
		suivant.addActionListener(new PlayListener());
		commandes.add(suivant);

	}
	
	
	public void paintComponent(Graphics g)
	{
		//Image dbImage = createImage(getWidth(), getHeight());
		//Graphics dbg = dbImage.getGraphics();
		//super.paintComponent(dbg);
		//g.drawImage(dbImage, 0, 0, this);
		super.paintComponent(g);
		g.setColor(new Color(0, 0, 255, 100));
		g.fillOval(7 * 36 + 5, -30, 36 * 13, 88 * 8);
		
		//System.out.println("On repeint");
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
	
	class Animation2 implements Runnable
	{
		public void run() 
		{
			int precision = 8;
			posARN = brinArnL.getX();
			
			while(helice1.getX() > 36 * helice1.getDecalage() - helice1.getWidth())
			{				
				helice1.deplacerGauche(precision);
				helice2.deplacerGauche(precision);
				
				repaint();
				
				//System.out.println(posARN + " " + helice1.getDecalage());
				
				if(helice1.getX() == 17 * 36)
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
				}
				
				if(helice1.getX() < 12 * 36 && brVisible < brinCodant.getTaille())
				{
					brVisible = (posARN - helice1.getX()) / 36;
					brinArnL.setSize(brVisible * 36, 88);
					brinArnL.setLocation(brinArnL.getX() - (36 / precision), brinArnL.getY());
					//System.out.println(brVisible);
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
			System.out.println(posARN);
			
			suivant.setEnabled(true);

			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			while(brinArnL.getX() < 36 / 2)
			{
				//posARN++;
				brinArnL.setLocation(brinArnL.getX() + (36 / 12), brinArnL.getY());				

				try
				{
					Thread.sleep(20);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			while(brinArnL.getY() < 300 + 1 * 75)
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
}
