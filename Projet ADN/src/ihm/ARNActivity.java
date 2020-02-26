package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ARN.BrinADN;
import ARN.BrinARN;

public class ARNActivity extends JPanel
{
	private Dimension dim;
	private JPanel commandes;
	private BrinADN brinCodant;
	private int brVisible;
	private Thread activityThread;
	private JButton play;
	private boolean stop;
	private JLabel brinL, brinComplL, brinArnL;
	private BrinHelice helice1, helice2;
	private int posADN, posARN, posHelice;

	
	public ARNActivity(JPanel commandes, int activity, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		this.stop = true;
		
		this.dim = dim;
		this.setSize(dim);

		this.setBackground(Color.WHITE);
		
		switch(activity)
		{
			case 1:
				transcription();
				break;
		}

	}
	

	public void transcription()
	{
		commandes.setBackground(Color.CYAN);
		
		//TACTGATGCTccaccagccgtGATAACGTA
		this.brinCodant = new BrinADN("TACTGATGCTccaccagccgtGATAACG");
		posHelice = 20;
		
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
		
		
		play = new JButton("Play");
		play.addActionListener(new PlayListener());
		play.setLocation(10, 10);
		commandes.add(play);



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
	

	
	class PlayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(stop)
			{
				//helice1.deplacerGauche(1);
				//helice2.deplacerGauche(1);

				
				stop = false;
				activityThread = new Thread(new Animation2());
				activityThread.start();
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
			while(posARN < 36 / 2)
			{
				posARN++;
				brinArnL.setLocation(posARN + (36 / 2), brinArnL.getY());				

				try
				{
					Thread.sleep(80 / precision);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			posARN = brinArnL.getY();
			while(posARN < 300 + 1 * 75)
			{
				posARN++;
				brinArnL.setLocation(brinArnL.getX(), posARN);

				try
				{
					Thread.sleep(80 / precision);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
		
	
	

}
