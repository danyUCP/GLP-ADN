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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ARN.ARNm;
import ARN.ChaineAA;
import ARN.ModelSynthese;
import ihm.BoutonCommande;
import ihm.CommentLabel;
import ihm.ParaADN;

@SuppressWarnings("serial")
public class SyntheseActivity extends JPanel
{
	private JPanel commandes;
	private Thread activityThread;

	//Elements graphiques de la transcription
	private ArrayList<ARNtManager> managerList;
	private ARNmBuilder builder;
	private JLabel brinARNM, leg;
	private ChaineLabel chaineLabel;
	private CommentLabel comment;
	private BoutonCommande play, suivant, recommencer;
	private JCheckBox legende;
	private Image cellule, ribosome;
	
	//Donn�es necessaires � l'animation
	private float alpha;
	private boolean stop;

	//Donn�es du noyau
	private ARNm brinMess;
	private ChaineAA chaine;
	private ModelSynthese modele;


	/**
	 * Constructeur de la classe SyntheseActivity.
	 * 
	 * Ce construteur d�finit les dimensions du panel, met � jour le mod�le et d�marre l'activit�
	 */
	public SyntheseActivity(ModelSynthese modele, JPanel commandes)
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
			cellule = ImageIO.read(new File("ressources/synthese/cellule.png"));
			ribosome = ImageIO.read(new File("ressources/synthese/ribosome.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		modele.synthese();
		synthese();
	}
	
	/**
	 * Cette m�thode est la m�thode principale du panel. Elle definit la disposition des �l�ments graphiques de l'activit�
	 * et initialise la liste des managers ainsi que les commandes nec�ssaires au d�clenchement des animations
	 */
	public void synthese()
	{
		brinMess = modele.getBrinMess();
		
		builder = new ARNmBuilder(brinMess, false);
		brinARNM = builder.creerARNmessager(27, 1);
		this.add(brinARNM);
		
		chaine = modele.getChaineAcide();
		chaineLabel = new ChaineLabel();
		this.add(chaineLabel);
		
		initManagerList();

		comment = new CommentLabel("<html>3�me �tape : La Synth�se</html>", 0);
		this.add(comment);
		
		leg = new JLabel(new ImageIcon("ressources/synthese/leg2.png"));
		leg.setBounds(20, 20, 686, 292);
		leg.setVisible(false);
		this.add(leg);
		
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
        
		//g2d.scale(0.5, 0.5);

		super.paintComponent(g2d);

		g2d.setColor(new Color(255, 255, 255, 200));
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 20));

		g2d.drawImage(cellule, -700, -200, 2500, 2500, this);
		g2d.drawString("Noyau", ParaADN.LARGEUR_CONTENU - 250, ParaADN.HAUTEUR_CONTENU - 110);

		g2d.setColor(new Color(64, 149, 204, 200));
		g2d.drawString("Cellule", 10, 30);
		
		g2d.setColor(new Color(88, 77, 241, 200));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(ribosome, 167, 50, 600, 508, this);
		g2d.drawString("Ribosome", 12 * 36, 7 * 88 - 35);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

	}
	
	/**
	 * Cette m�thode initialise la liste des ARNtManager 
	 */
	public void initManagerList()
	{
		this.managerList = new ArrayList<ARNtManager>();
		
		for(int i = 0 ; i < brinMess.getTaille() ; i++)
		{
			managerList.add(new ARNtManager(builder.getCodCpAt(i), chaine.getAcideAt(i)));
			this.add(managerList.get(i).creerARNt(0, 0));
			managerList.get(i).start();
		}
		
	}
	
	//------------------------------- GESTION COMMANDES ------------------------------//

	/**
	 * Cette m�thode initialise les commandes nec�ssaires au d�clenchement des animations
	 */
	public void initCommandes()
	{
		legende = new JCheckBox("L�gende");
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

	
	/**
	 * Cette classe interne g�re tous les traitements n�cessaires aux animations de l'activit�
	 */
	private class Animation implements Runnable
	{
		public synchronized void run()
		{
			comment.setComment("<html>L'assemblage des acides amin�s se fait dans un ribosome, constitu� de 2 sous-unit�s. Il se fixe sur l'ARNm</html>", 1);
			recommencer.setEnabled(true);
 
			/*
			 * Etape 1 : Le brin d'ARNm se d�place en direction du ribosome tandis que celui-ci apparait progressivement
			 */
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
			
			comment.setComment("<html>Pour chacun des codons, le ribosome fixe un ARNt correspondant </html>", 0);
			
			/*
			 * Etape 2 : Donne le signal de d�part de chaque thread de managerList qui d�place chaque ARNt
			 * vers son codon correspondant et qui transf�re son acide amin� � la chaine prot�ique avant de repartir
			 */
			for(int i = 0 ; i < managerList.size() + 2 ; i++)
			{			
				ARNtManager m1 = null, m2 = null, m3 = null;
				
				if(i > -1 && i < managerList.size())
					m1 = managerList.get(i);
				if(i > 0 && i < managerList.size() + 1)
					m2 = managerList.get(i - 1);
				if(i > 1 && i < managerList.size() + 2)
					m3 = managerList.get(i - 2);
				
				//System.out.println(m1 + ", " + m2 + ", " + m3);

				try 
				{
					if(m1 != null)
						m1.relancer(); //System.out.println(m1 + " arrive");
					if(m3 != null)
						m3.relancer(); //System.out.println(m3 + " repart");

				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}

				repaint();

				try
				{
					Thread.sleep(2000);
					
					if(m1 != null)
						m1.transfererAcide(chaineLabel);
					
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				decalageGauche(m1, m2, null);
				
				if(i == 3)
					comment.setComment("<html>Un nouvel acide amin� se joint au pr�c�dent</html>", 0);
				if(i == 5)
					comment.setComment("<html>La cha�ne prot�ique s'allonge avec de nouveaux acides amin�s</html>", 0);

				

			}
			

			suivant.setEnabled(true);					
			comment.setComment("<html>La traduction s'interrompt lorsque le ribosome arrive � la terminaison du brin d'ARNm</html>", 1);

			try 
			{
				pause();
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			alpha = 1.0f;
			comment.setComment("<html>La synth�se est achev�e, la prot�ine est relach�e dans la cellule</html>", 0);

			/*
			 * Etape 3 : D�placement de la chain vers le centre et disparition des autres �l�ments
			 */
			while(brinARNM.getX() > -ParaADN.LARGEUR_ARNT * brinMess.getTaille() || chaineLabel.getX() < getWidth() / 2 - chaineLabel.getWidth() / 2)
			{				
				
				if(alpha > 0.0)
					alpha = alpha - 0.05f;
				if(alpha < 0.01)
					alpha = 0.0f;
							
				if(chaineLabel.getX() < getWidth() / 2 - chaineLabel.getWidth() / 2)
					chaineLabel.setLocation(chaineLabel.getX() + 9, chaineLabel.getY());
				
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
		
		/**
		 * Cette m�thode permet de d�caler l'ARNm la chaine d'acides amin�s et les ARNt d'un cran vers la gauche 
		 */
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
					chaineLabel.setLocation(chaineLabel.getX() - pas, chaineLabel.getY());
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
	
	/**
	 * Cette m�thode permet de red�marrer l'activit�
	 */
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new SyntheseActivity(modele, commandes));
		
		parent.revalidate();
		parent.repaint();
	}
	
	
}
