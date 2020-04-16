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
import ARN.ModelSynthese;
import ihm.ParaADN;

/**
 * TranscriptionActivity est la classe qui g�re le panel de l'activit� Transcription
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class TranscriptionActivity extends JPanel
{
	private JPanel commandes;
	private Thread activityThread;
	
	//Elements graphiques de la transcription
	private BrinHelice helice1, helice2;
	private JLabel brinArnL;
	private CommentLabel comment;
	private JButton play, suivant, recommencer;
	private Image noyau, polymerase;
	
	//Donn�es necessaires � l'animation
	private int posARN, posHelice, brVisible;
	private float alpha;
	private boolean stop;

	//Donn�es du noyau
	private BrinADN brinCodant;
	private ModelSynthese modele;

	
	/**
	 * Constructeur de la classe TranscriptionActivity.
	 * 
	 * Ce construteur d�finit les dimensions du panel, met � jour le mod�le et d�marre l'activit�
	 */
	public TranscriptionActivity(ModelSynthese modele, JPanel commandes)
	{
		super(null);
		this.modele = modele;
		this.commandes = commandes;
		
		this.stop = true;
		this.alpha = 0.0f;
		
		this.setBounds(0, 0, ParaADN.LARGEUR_CONTENU, ParaADN.HAUTEUR_CONTENU);
		this.setBackground(Color.WHITE);
		
		try
		{
			noyau = ImageIO.read(new File("ressources/synthese/noyau.png"));
			polymerase = ImageIO.read(new File("ressources/synthese/poly.png"));

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		this.modele.transcription();
		transcription();
	}
	

	/**
	 * Cette m�thode est la m�thode principale du panel. Elle definit la disposition des �l�ments graphiques de l'activit�
	 * et initialise les commandes nec�ssaires au d�clenchement des animations
	 */
	public void transcription()
	{
		commandes.setBackground(new Color(204, 204, 255));
		
		this.brinCodant = modele.getBrinADN();
		
		posHelice = 24;
		helice1 = new BrinHelice(brinCodant, true);
		helice1.creerHelice(posHelice, 0);
		this.add(helice1);
		
		helice2 = new BrinHelice(brinCodant.getBrinComplem(), false);
		helice2.creerHelice(posHelice, 0);	
		this.add(helice2);
		
		BrinARN brinArn = modele.getBrinARN();
		
		ARNmBuilder builder2 = new ARNmBuilder(brinArn, false);
		brinArnL = builder2.creerARN(14, -3);
		this.add(brinArnL);

		brinArnL.setSize(brVisible * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
			
		
		comment = new CommentLabel("<html>1�re �tape : La Transcription</html>", 0);
		this.add(comment);
		
		initCommandes();
	}
	
	/**
	 * Dessine les �l�ments de fond, images et l�gende, du panel
	 */
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
		g2d.drawString("ARN Polym�rase", 12 * 36, 4 * 88);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));		
	}
	
	
	//------------------------------- GESTION COMMANDES ------------------------------//

	/**
	 * Cette m�thode initialise les commandes nec�ssaires au d�clenchement des animations
	 */
	public void initCommandes()
	{
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
	
	/**
	 * Ecouteur associ� aux boutons "play", "suivant" et "recommencer" du panneau de commandes.
	 *
	 * Le bouton "play" d�marre le thread contenant les animations de l'activit�.
	 * Le bouton "suivant" relance le thread lorsque celui-ci est en pause.
	 * Le bouton "recommencer" permet de red�marrer l'activit�
	 */
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

	
	//------------------------------- ANIMATIONS DE L'ACTIVIT� ------------------------------//
	
	/**
	 * Cette classe interne g�re tous les traitements n�cessaires aux animations de l'activit�
	 */
	private class Animation implements Runnable
	{
		public void run() 
		{
			int precision = 8;
			posARN = brinArnL.getX();
			
			comment.setComment("<html>La transcription commence avec un ARN polym�rase qui vient diviser les deux brins d'ADN</html>", 1);
			recommencer.setEnabled(true);
			
			/* 
			 * Apparition progressive de l'ARN Polym�rase et d�placement des 2 h�lices de l'ADN jusqu'� son niveau.
			 * Les deux h�lices continuent leur d�placement vers la gauche tandis que le brin d'ARN se forme progressivement
			 */
			while(helice1.getX() > ParaADN.LARGEUR_NUCL * helice1.getDecalage() - helice1.getWidth())
			{				
				helice1.deplacerGauche(precision);
				helice2.deplacerGauche(precision);
				
				if(alpha < 0.9f)
					alpha += 0.02f;
				
				repaint();
				
				
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
					
					comment.setComment("<html>Le polym�rase joint un � un les nucl�otides de l'ARN � un brin d'ADN...</html>", 1);
				}
				
				if(helice1.getX() < 12 * ParaADN.LARGEUR_NUCL && brVisible < brinCodant.getTaille())
				{
					brVisible = (posARN - helice1.getX()) / ParaADN.LARGEUR_NUCL;
					brinArnL.setSize(brVisible * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
					brinArnL.setLocation(brinArnL.getX() - (ParaADN.LARGEUR_NUCL / precision), brinArnL.getY());
					
					if(brVisible == brinCodant.getTaille())
						comment.setComment("<html>... afin de former le brin d'ARN messager correspondant au g�ne transcrit</html>", 1);
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
			
			suivant.setEnabled(true);

			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			comment.setComment("<html>Le brin d'ARN form� n'est pas encore pr�t � quitter le noyau</html>", 0);
			
			/* 
			 * Le brin d'ARN form� se d�place horizontalement jusqu'� ce qu'il soit enti�rement visible puis il descend
			 */
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
			
			comment.setComment("<html>Il doit passer par une �tape appel�e la maturation</html>", 0);
			
			while(brinArnL.getY() < ParaADN.HAUTEUR_NUCL * 5)
			{
				brinArnL.setLocation(brinArnL.getX(), brinArnL.getY() + 5);
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
	
	/**
	 * Cette m�thode permet de red�marrer l'activit�
	 */
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		System.out.println(parent);
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new TranscriptionActivity(modele, commandes));
		
		parent.revalidate();
		parent.repaint();
	}
	
}
