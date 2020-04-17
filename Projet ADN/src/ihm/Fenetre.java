package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ihm.synthese.ARNPanel;

/**
 * Fenetre principale du programme
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	private JPanel global, header;
	private AccueilPanel accueil;
	private BoutonMenu cycle, proteine, heritage;
	private JLabel texte;
	private Image img;
	
	
	/**
	 * Constructeur de la classe Fenetre.
	 * 
	 * Ce constructeur gère la disposition des éléments de l'accueil
	 */
	public Fenetre()
	{
		this.setTitle("ADN");
		this.setSize(ParaADN.LARGEUR_FENETRE, ParaADN.HAUTEUR_FENETRE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		//-------------- CONTENT PANE ------------------//
		global = new JPanel();
	    global.setPreferredSize(new Dimension(ParaADN.LARGEUR_FENETRE, ParaADN.HAUTEUR_FENETRE));
		global.setBackground(Color.CYAN);
		global.setLayout(new BorderLayout());
		this.setContentPane(global);
		
		
		//-------------- PAGE D'ACCUEIL ------------------//
		accueil = new AccueilPanel();
		accueil.setBackground(Color.WHITE);
		accueil.setLayout(new GridLayout(3, 1, 200, 200));
		cycle = new BoutonMenu("Cycle cellulaire");
		proteine = new BoutonMenu("Synthèse des protéines");
		heritage = new BoutonMenu("Héritage génétique");
		accueil.add(cycle);
		accueil.add(proteine);
		accueil.add(heritage);
		global.add(accueil, BorderLayout.CENTER);

		
		cycle.addActionListener(new BoutonListener());
		proteine.addActionListener(new BoutonListener());
		heritage.addActionListener(new BoutonListener());

		
		this.setVisible(true);
	}
	
	/**
	 * Cette méthode permet de réinitialiser l'accueil
	 */
	public void resetAccueil()
	{
		global.removeAll();
		
		accueil = new AccueilPanel();
		accueil.setBackground(Color.WHITE);
		accueil.setLayout(new GridLayout(3, 1, 200, 200));
		cycle = new BoutonMenu("Cycle cellulaire");
		proteine = new BoutonMenu("Synthèse des protéines");
		heritage = new BoutonMenu("Héritage génétique");
		accueil.add(cycle);
		accueil.add(proteine);
		accueil.add(heritage);

		global.add(accueil, BorderLayout.CENTER);
		
		cycle.addActionListener(new BoutonListener());
		proteine.addActionListener(new BoutonListener());
		heritage.addActionListener(new BoutonListener());
		
		this.revalidate();
	}
	
	
	/**
	 * Cette classe interne gère la personnalisation du panel central "accueil"
	 */
	private class AccueilPanel extends JPanel
	{
		private Image img;
		
		public AccueilPanel()
		{
			try
			{
				img = ImageIO.read(new File("adnfond3"));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

			super.paintComponent(g2d);

			g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), accueil);
		}
	}

	/**
	 * Cette classe interne gère la personnalisation des boutons de l'accueil
	 */
	private class BoutonMenu extends JButton implements MouseListener
	{
		public BoutonMenu(String nom)
		{
			super(nom);
			
			this.setBorder(null);
			this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			this.setFont(new Font("Comic sans MS", Font.BOLD, 40));
			this.setForeground(Color.WHITE);
			
			this.addMouseListener(this);
		}
		
		public void mouseEntered(MouseEvent e) 
		{
			this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		}

		public void mouseExited(MouseEvent e) 
		{
			this.setBorder(null);
		}
		
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	/**
	 * Ecouteur associé aux boutons "cycle", "proteine" et "heritage" du panneau de commandes.
	 * 
	 * Chacun des boutons déclenche l'affichage du panel d'accès aux activités
	 */
	private class BoutonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			global.removeAll();
			
			if(e.getSource() == cycle)
				global.add(new CyclePanel(), BorderLayout.CENTER);
			else if(e.getSource() == proteine)
				global.add(new ARNPanel(), BorderLayout.CENTER);
			else if(e.getSource() == heritage)
				global.add(new HeritagePanel(),BorderLayout.CENTER);

			global.revalidate();	
		}
	}

}

