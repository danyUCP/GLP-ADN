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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ARN.ARNm;
import ARN.BrinADN;
import ARN.BrinARN;
import ARN.ChaineAA;
import ihm.ParaADN;

public class SyntheseActivity extends JPanel
{
	private BrinARN brinArn;
	private ARNm brinMess;
	private ChaineAA chaine;
	private Dimension dim;
	private JPanel commandes;
	private JLabel brinARNM, ARNt;
	private JButton play, suivant, recommencer;
	private boolean stop;
	private Thread activityThread;
	private ARNmBuilder builder;
	private Image cellule, ribosome;
	private ArrayList<ARNtManager> managerList;
	private float alpha;


	public SyntheseActivity(JPanel commandes, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		
		this.stop = true;
		this.alpha = 0.0f;


		this.dim = dim;
		this.setSize(dim);
		
		System.out.println(this.getBounds());

		System.out.println(dim);


		this.setBackground(Color.WHITE);
		
		try
		{
			cellule = ImageIO.read(new File("cellule.png"));
			ribosome = ImageIO.read(new File("ribosome.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		synthese();
	}
	

	public void synthese()
	{
		commandes.setBackground(new Color(204, 204, 255));

		brinArn = new BrinADN("TACTGATGCTccaccagccgtGATAACG").transcrire();
		brinArn.genererIntrons();
		brinArn.retirerIntrons();
		brinMess = new ARNm(brinArn);
		
		builder = new ARNmBuilder(brinMess, false);
		brinARNM = builder.creerARNmessager(27, 1);
		this.add(brinARNM);
		
		chaine = new ChaineAA(brinMess);
		//this.add(new AcideComp(new AcideAmine("Tyr", new Codon("UUU")), 10, 30));
		
		System.out.println(builder);
		System.out.println(chaine);

		/*
		ARNtManager m0 = new ARNtManager(builder.getCodCpAt(3), chaine.getAcideAt(3));
		ARNt = m0.creerARNt(0, 0);
		this.add(ARNt);
		*/

		initManagerList();

		//activityThread = new Thread(new Animation());

		
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
	
	public void initManagerList()
	{
		this.managerList = new ArrayList<ARNtManager>();
		
		for(int i = 0 ; i < brinMess.getTaille() ; i++)
		{
			managerList.add(new ARNtManager(builder.getCodCpAt(i), chaine.getAcideAt(i)));
			this.add(managerList.get(i).creerARNt(0, 0));
			managerList.get(i).start();
		}
		
		//System.out.println(managerList);
	}
	
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		super.paintComponent(g2d);
		
		g2d.setColor(new Color(255, 255, 255, 200));
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 20));

		g2d.drawImage(cellule, -700, -200, 2500, 2500, this);
		g2d.drawString("Noyau", ParaADN.LARGEUR_CONTENU - 250, ParaADN.HAUTEUR_CONTENU - 100);

		g2d.setColor(new Color(64, 149, 204, 200));
		g2d.drawString("Cellule", 10, 30);
		
		g2d.setColor(new Color(88, 77, 241, 200));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(ribosome, 167, 50, 600, 508, this);
		g2d.drawString("Ribosome", 12 * 36, 7 * 88 - 35);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

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
	
	class Animation implements Runnable
	{
		public synchronized void run()
		{
			recommencer.setEnabled(true);

			while(brinARNM.getX() > ParaADN.LARGEUR_NUCL * 15)
			{				
				
				if(alpha < 1.0)
					alpha = alpha + 0.02f;
				if(alpha > 0.99)
					alpha = 1.0f;
								
				brinARNM.setLocation(brinARNM.getX() - 9, brinARNM.getY());
				
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
			
			suivant.setEnabled(true);					
			
			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			
			for(int i = 0 ; i < managerList.size() + 2 ; i++)
			{			
				ARNtManager m1 = null;
				ARNtManager m2 = null, m3 = null;
				
				
				if(i > -1 && i < managerList.size())
					m1 = managerList.get(i);
				if(i > 0 && i < managerList.size() + 1)
					m2 = managerList.get(i - 1);
				if(i > 1 && i < managerList.size() + 2)
					m3 = managerList.get(i - 2);
				
				System.out.println(i + ", " + (i - 1) + ", " + (i - 2));
				System.out.println(m1 + ", " + m2 + ", " + m3);


				try 
				{
					if(m1 != null)
						m1.relancer(); System.out.println(m1 + " arrive");
					if(m3 != null)
						m3.relancer(); System.out.println(m3 + " repart");

				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}

				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		
				decalageGauche(m1, m2, null);
			}
			

			suivant.setEnabled(true);					
			
			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			alpha = 1.0f;
			
			while(brinARNM.getX() > -ParaADN.LARGEUR_ARNT * brinMess.getTaille())
			{				
				
				if(alpha > 0.0)
					alpha = alpha - 0.05f;
				if(alpha < 0.01)
					alpha = 0.0f;
								
				brinARNM.setLocation(brinARNM.getX() - 9, brinARNM.getY());
				
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
		
		public void decalageGauche(ARNtManager m1, ARNtManager m2, ARNtManager m3)
		{
			int pas = ParaADN.LARGEUR_ARNT / 12;
			JLabel l1, l2, l3;
			
			for(int i = 0 ; i < 12 ; i++)
			{				
				if(m1 != null)
				{
					l1 = m1.getARNtLabel();
					l1.setLocation(l1.getX() - pas, l1.getY());
				}

				if(m2 != null)
				{
					l2 = m2.getARNtLabel();
					l2.setLocation(l2.getX() - pas, l2.getY());
				}
				
				if(m3 != null)
				{
					l3 = m3.getARNtLabel();
					l3.setLocation(l3.getX() - pas, l3.getY());
				}

				brinARNM.setLocation(brinARNM.getX() - pas, brinARNM.getY());

				try
				{
					Thread.sleep(40);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

	}
	
	
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		System.out.println(parent);
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new SyntheseActivity(commandes, dim));
		
		parent.revalidate();
		parent.repaint();
	}
	
	
}
