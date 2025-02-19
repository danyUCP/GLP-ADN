package ihm.synthese;

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

import ARN.ARNm;
import ARN.BrinARN;
import ARN.ModelSynthese;
import ihm.BoutonCommande;
import ihm.CommentLabel;
import ihm.ParaADN;

/**
 * MaturationActivity est la classe qui g�re le panel de l'activit� Maturation
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class MaturationActivity extends JPanel
{
	private JPanel commandes;
	private Thread activityThread;

	//Elements graphiques de la transcription
	private JLabel brin, leg;
	private ARNmBuilder builder, builder2;
	private CommentLabel comment;
	private BoutonCommande play, suivant, recommencer;
	private JCheckBox legende;
	private Image noyau;
	
	//Donn�es necessaires � l'animation
	private int noyX = -300;
	private boolean mature, stop;

	//Donn�es du noyau
	private BrinARN brinArn;
	private ModelSynthese modele;

	
	/**
	 * Constructeur de la classe MaturationActivity.
	 * 
	 * Ce construteur d�finit les dimensions du panel, met � jour le mod�le et d�marre l'activit�
	 */
	public MaturationActivity(ModelSynthese modele, JPanel commandes)
	{
		super(null);
		this.modele = modele;
		this.commandes = commandes;
		this.commandes.setBackground(new Color(28, 28, 28));
		
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
	
	/**
	 * Cette m�thode est la m�thode principale du panel. Elle definit la disposition des �l�ments graphiques de l'activit�
	 * et initialise les commandes nec�ssaires au d�clenchement des animations
	 */
	public void maturation()
	{	
		brinArn = modele.getARNmature();
		
		builder = new ARNmBuilder(brinArn, false);
		brin = builder.creerARN(1, 2);
		this.add(brin);
		
		comment = new CommentLabel("<html>2�me �tape : La Maturation</html>", 0);
		this.add(comment);
		
		leg = new JLabel(new ImageIcon("ressources/synthese/leg.png"));
		leg.setBounds(20, 20, 356, 405);
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
        
		super.paintComponent(g2d);
		g2d.setColor(new Color(255, 255, 255, 200));
		g2d.setFont(new Font("Comic sans MS", Font.BOLD, 20));
		
		g2d.drawImage(noyau, noyX, -520, 1800, 1800, this);
		g2d.drawString("Noyau", 10, 30);

		g2d.setColor(new Color(0, 0, 255, 100));
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
	
	
	//------------------------------- ANIMATIONS DE L'ACTIVIT� ------------------------------//
	
	/**
	 * Cette m�thode permet de rendre progressivement transparents les introns du brin d'ARN
	 */
	public void excision()
	{
		float alpha = 1.0f;
		
		if(!mature)
		{
			brinArn.genererIntrons();
			mature = true;
		}
		
		comment.setComment("<html>La maturation est l'�tape au cours de laquelle l'ARN devient ARNm, le brin est alors amput� de ses introns</html>", 1);

		/*
		 * Mise � jour de la transparence de tous les introns
		 */
		while(alpha > 0.0)
		{
			alpha = alpha - 0.05f;
			if(alpha < 0.01)
				alpha = 0;

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
	
	/**
	 * Cette m�thode d�place le brin vers le centre du panel et d�clenche un second thread simultan� qui relie les s�quences 
	 * codantes de l'ARN puis affiche le brin d'ARNm 
	 */
	public void epissage()
	{
		brinArn.retirerIntrons();

		comment.setComment("<html>Les s�quences non-codantes (les introns) sont retir�es pour ne garder que les s�quences codantes (les exons)</html>", 1);

		int echelleX = ((ParaADN.LARGEUR_CONTENU / 2 - brinArn.getTaille() * ParaADN.LARGEUR_NUCL / 2) - brin.getX()) / 12;
		int echelleY = (brin.getY() - 330) / 10;
		
		/*
		 * D�clenchement de l'animation qui recolle les morceaux du brin
		 */
		Thread t = new Thread(new LigatureAnimation());
		t.start();

		/*
		 * Deplacement du brin vers le centre
		 */
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

		/*
		 * Cr�ation et affichage du brin d'ARNm
		 */
		builder2 = new ARNmBuilder(new ARNm(brinArn), false);
		remove(brin);
		brin = builder2.creerARNmessager(0, 0);
		brin.setLocation(bx, by);
		add(brin);
		repaint();

	}
	
	/**
	 * Cette classe interne g�re tous les traitements n�cessaires aux animations de l'activit�
	 */
	private class Animation implements Runnable
	{
		public synchronized void run()
		{
			recommencer.setEnabled(true);
			
			/*
			 * Etape 1 : Transparence des introns
			 */
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
			
			/*
			 * Etape 2 : Liaisons des exons d�tach�s
			 */
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

			/*
			 * Etape 3 : D�placement de l'ARNm et de l'arri�re-plan pour simuler une sortie du noyau
			 */
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
	
	/**
	 * Cette classe interne g�re l'animation de la ligature
	 */
	private class LigatureAnimation implements Runnable
	{
		public void run() 
		{
			builder.retirerNuclCp();
			
			/*
			 * Rapprochement des exons d�connect�s de l'ARN
			 */
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
	
	
	
	/**
	 * Cette m�thode permet de red�marrer l'activit�
	 */
	public void resetPanel()
	{		
		JPanel parent = (JPanel) SwingUtilities.getUnwrappedParent(this);
		
		parent.removeAll();
		commandes.removeAll();
		
		parent.add(new MaturationActivity(modele, commandes));
		
		parent.revalidate();
		parent.repaint();
	}
	

}
