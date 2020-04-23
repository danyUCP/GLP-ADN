package ihm.synthese;

import java.awt.AlphaComposite;
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ARN.BrinADN;
import ARN.BrinARN;
import ARN.ModelSynthese;
import ihm.BoutonCommande;
import ihm.CommentLabel;
import ihm.ParaADN;

/**
 * TranscriptionActivity est la classe qui gère le panel de l'activité Transcription
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
	private JLabel brinArnL, leg;
	private CommentLabel comment;
	private BoutonCommande play, suivant, recommencer;
	private JCheckBox legende;
	private Image noyau, polymerase;
	
	//Données necessaires à l'animation
	private int posARN, posHelice, brVisible;
	private float alpha;
	private boolean stop;

	//Données du noyau
	private BrinADN brinCodant;
	private ModelSynthese modele;

	
	/**
	 * Constructeur de la classe TranscriptionActivity.
	 * 
	 * Ce construteur définit les dimensions du panel, met à jour le modèle et démarre l'activité
	 */
	public TranscriptionActivity(ModelSynthese modele, JPanel commandes)
	{
		super(null);
		this.modele = modele;
		this.commandes = commandes;
		this.commandes.setBackground(new Color(28, 28, 28));
		
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
	 * Cette méthode est la méthode principale du panel. Elle definit la disposition des éléments graphiques de l'activité
	 * et initialise les commandes necéssaires au déclenchement des animations
	 */
	public void transcription()
	{		
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
			
		
		comment = new CommentLabel("<html>1ère étape : La Transcription</html>", 0);
		this.add(comment);
		
		leg = new JLabel(new ImageIcon("ressources/synthese/leg.png"));
		leg.setBounds(20, 20, 356, 405);
		leg.setVisible(false);
		this.add(leg);
		
		initCommandes();
	}
	
	/**
	 * Dessine les éléments de fond, images et légende, du panel
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
		g2d.drawString("ARN Polymérase", 12 * 36, 4 * 88);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));		
	}
	
	
	//------------------------------- GESTION COMMANDES ------------------------------//

	/**
	 * Cette méthode initialise les commandes necéssaires au déclenchement des animations
	 */
	public void initCommandes()
	{
		legende = new JCheckBox("Légende");
		legende.setOpaque(false);
		legende.setBorder(null);
		legende.setFont(new Font("Verdana", Font.PLAIN, 20));
		legende.setForeground(Color.WHITE);
		legende.addActionListener(new PlayListener());
		commandes.add(legende);
		
		play = new BoutonCommande("Lancer l'animation");
		play.addActionListener(new PlayListener());
		commandes.add(play);
		
		suivant = new BoutonCommande("Suivant");
		suivant.setEnabled(false);
		suivant.addActionListener(new PlayListener());
		commandes.add(suivant);
		
		recommencer = new BoutonCommande("Recommencer");
		recommencer.setEnabled(false);
		recommencer.addActionListener(new PlayListener());
		commandes.add(recommencer);
	}
	
	/**
	 * Ecouteur associé aux boutons "play", "suivant" et "recommencer" du panneau de commandes.
	 *
	 * Le bouton "play" démarre le thread contenant les animations de l'activité.
	 * Le bouton "suivant" relance le thread lorsque celui-ci est en pause.
	 * Le bouton "recommencer" permet de redémarrer l'activité
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
					play.setEnabled(false);
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
			else if(e.getSource() == legende)
			{
				if(legende.isSelected())
					leg.setVisible(true);
				else
					leg.setVisible(false);
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

	
	//------------------------------- ANIMATIONS DE L'ACTIVITÉ ------------------------------//
	
	/**
	 * Cette classe interne gère tous les traitements nécessaires aux animations de l'activité
	 */
	private class Animation implements Runnable
	{
		public void run() 
		{
			int precision = 4;
			posARN = brinArnL.getX();
			
			comment.setComment("<html>La transcription commence avec un ARN polymérase qui vient diviser les deux brins d'ADN</html>", 1);
			recommencer.setEnabled(true);
			
			/* 
			 * Etape 1 : Apparition progressive de l'ARN Polymérase et déplacement des 2 hélices de l'ADN jusqu'à son niveau.
			 * Les deux hélices continuent leur déplacement vers la gauche tandis que le brin d'ARN se forme progressivement
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
					
					comment.setComment("<html>Le polymérase joint un à un les nucléotides de l'ARN à un brin d'ADN...</html>", 1);
				}
				
				if(helice1.getX() < 12 * ParaADN.LARGEUR_NUCL && brVisible < brinCodant.getTaille())
				{
					brVisible = (posARN - helice1.getX()) / ParaADN.LARGEUR_NUCL;
					brinArnL.setSize(brVisible * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
					brinArnL.setLocation(brinArnL.getX() - (ParaADN.LARGEUR_NUCL / precision), brinArnL.getY());
					
					if(brVisible == brinCodant.getTaille())
						comment.setComment("<html>... afin de former le brin d'ARN messager correspondant au gène transcrit</html>", 1);
				}
				
				
				
				try
				{
					Thread.sleep(70);
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
			
			comment.setComment("<html>Le brin d'ARN formé n'est pas encore prêt à quitter le noyau</html>", 0);
			
			/* 
			 * Etape 2 : Le brin d'ARN formé se déplace horizontalement jusqu'à ce qu'il soit entièrement visible puis il descend
			 */
			while(brinArnL.getX() < ParaADN.LARGEUR_NUCL / 2)
			{
				//posARN++;
				brinArnL.setLocation(brinArnL.getX() + (ParaADN.LARGEUR_NUCL / 6), brinArnL.getY());				

				if(alpha > 0.02f)
					alpha -= 0.02f;
				else
					alpha = 0.0f;
				
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
			
			comment.setComment("<html>Il doit passer par une étape appelée la maturation</html>", 0);
			
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
	 * Cette méthode permet de redémarrer l'activité
	 */
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new TranscriptionActivity(modele, commandes));
		
		parent.revalidate();
		parent.repaint();
	}
	
}
