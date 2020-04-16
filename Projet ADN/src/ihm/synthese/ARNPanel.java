package ihm.synthese;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ARN.BrinADN;
import ARN.ModelSynthese;
import ihm.Fenetre;
import ihm.ParaADN;

/**
 * ARNPanel est la classe qui gère le panel de l'accès aux activités de la synthèse des protéines
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class ARNPanel extends JPanel
{
	private JPanel section, menu, header, footer;
	private ContenuPanel contenu;
	private JButton transcription, maturation, synthese, saisie, generer; 
	private JButton mainMenu, aPropos;
	private Dimension dim;
	
	private CommentLabel comment1, comment2, comment3;
	private JLabel brinADN;
	private BrinBuilder builder;
	
	/**
	 * Modèle de synthèse contenant tout le noyau nécessaire au fonctionnement des activités liées à la synthèse des protéines
	 */
	private ModelSynthese modele; 
	
	
	/**
	 * Constructeur de la classe ARNPanel.
	 * 
	 * Ce constructeur gère la disposition des éléments du panel et initialise le modèle de synthèse
	 */
	public ARNPanel()
	{
		this.dim = new Dimension(ParaADN.LARGEUR_FENETRE, ParaADN.HAUTEUR_FENETRE);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(new Color(204, 204, 255));
		header.setPreferredSize(new Dimension(ParaADN.LARGEUR_FENETRE, 40));
		header.setLayout(new FlowLayout());
		initNavigateur();
		this.add(header, BorderLayout.NORTH);
		
		//-------------- PARTIE SECTION -----------------//
		section = new JPanel();
		section.setBackground(Color.ORANGE);
		section.setPreferredSize(new Dimension(ParaADN.LARGEUR_SECTION, ParaADN.HAUTEUR_SECTION));
		section.setLayout(new BorderLayout());
		this.add(section, BorderLayout.CENTER);
		
		//-------------- PARTIE MENU --------------------//
		menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setPreferredSize(new Dimension(ParaADN.LARGEUR_MENU, ParaADN.HAUTEUR_MENU));
		menu.setLayout(new FlowLayout());
		initMenu();
		section.add(menu, BorderLayout.WEST);
		
		//-------------- PARTIE CONTENU -----------------//
		contenu = new ContenuPanel();
		contenu.setBackground(Color.BLUE);
		contenu.setPreferredSize(new Dimension(ParaADN.LARGEUR_CONTENU, ParaADN.HAUTEUR_CONTENU));
		contenu.setLayout(null);
		comment1 = new CommentLabel("<html>La synthèse des protéines</html>", 2);
		comment2 = new CommentLabel("<html>Dans cette partie nous allons retracer comment l'on passe d'une molécule d'ADN, située dans le noyau de "
				+ "chaque cellule, à la synthèse des protéines qui détermineront l'expression d'un caractère observable à l'oeil nu</html>", 20);
		comment3 = new CommentLabel("<html>Commencez par choisir ci-dessous si vous préférez personnaliser votre brin d'ADN ou si vous souhaitez "
				+ "le générer aléatoirement pour accéder aux activités à gauche</html>", 21);
		contenu.add(comment1);
		contenu.add(comment2);
		contenu.add(comment3);
		section.add(contenu, BorderLayout.CENTER);
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(new Color(204, 204, 255));
		footer.setPreferredSize(new Dimension(ParaADN.LARGEUR_FENETRE, 60));
		footer.setLayout(new FlowLayout());
		initFooter();
		this.add(footer, BorderLayout.SOUTH);

	
		this.modele = new ModelSynthese();

		repaint();
	}
	
	
	//------------------------------- GESTION MENU ------------------------------//

	/**
	 * Cette méthode initialise les éléments du menu des activités
	 */
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 3));
		transcription = new JButton("Transcription");
		maturation = new JButton("Maturation");
		synthese = new JButton("Synthèse");
		
		transcription.setEnabled(false);
		maturation.setEnabled(false);
		synthese.setEnabled(false);
		
		menu.add(transcription);
		menu.add(maturation);
		menu.add(synthese);	
		
		transcription.addActionListener(new MenuListener());
		maturation.addActionListener(new MenuListener());
		synthese.addActionListener(new MenuListener());
	}
	
	/**
	 * Cette méthode permet de lancer une des activités en fonction du bouton enclenché
	 */
	public void initARNActivity(int activity)
	{
		contenu.removeAll();
		footer.removeAll();
		
		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());
		
		switch(activity)
		{
			case 1:
				contenu.add(new TranscriptionActivity(modele, footer), BorderLayout.CENTER);
				break;
			case 2:
				contenu.add(new MaturationActivity(modele, footer), BorderLayout.CENTER);
				break;
			case 3:
				contenu.add(new SyntheseActivity(modele, footer), BorderLayout.CENTER);
				break;
			case 4:
				break;
		
		}
	}
	
	/**
	 * Ecouteur associé aux boutons "transcription", "maturation" et "synthese" du menu d'activité.
	 *
	 * Chacun des boutons met à jour l'activité à lancer et appelle la méthode {@link #initARNActivity(int)}
	 */
	private class MenuListener implements ActionListener
	{
		private int activity = 1;
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == transcription)
				activity = 1;
			else if(e.getSource() == maturation)
				activity = 2;
			else if(e.getSource() == synthese)
				activity = 3;
			
			initARNActivity(activity);

			contenu.revalidate();
			contenu.repaint();
		}
	}
	
	
	//------------------------------- GESTION NAVIGATEUR ------------------------------//
	
	/**
	 * Cette méthode initialise les éléments du navigateur
	 */
	public void initNavigateur()
	{
		header.setLayout(new GridLayout(1, 3, 0, 3));
		mainMenu = new JButton("Retour à l'accueil");
		aPropos = new JButton("À propos");
		header.add(mainMenu);
		header.add(aPropos);
		
		mainMenu.addActionListener(new NavListener());
	}
	
	private class NavListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == mainMenu)
				fermer();
			else if(e.getSource() == aPropos)
				
			
			contenu.revalidate();
			contenu.repaint();
		}
	}
	
	//------------------------------- GESTION COMMANDES ------------------------------//

	/**
	 * Cette méthode initialise les éléments du panneau de commandes
	 */
	public void initFooter()
	{
		saisie = new JButton("Saisir mon brin ADN");
		generer = new JButton("Générer aléatoirement");
		footer.add(saisie);
		footer.add(generer);
		
		saisie.addActionListener(new CommandeListener());
		generer.addActionListener(new CommandeListener());
	}
	
	/**
	 * Ecouteur associé aux boutons "saisie" et "generer" du panneau de commandes.
	 *
	 * Le bouton "saisie" déclenche l'affichage d'une boite de dialogue pour que l'utilisateur puisse saisir
	 * un brin d'ADN personnalisé.
	 * 
	 * Le bouton "generer" permet de générer aléatoirement le brin d'ADN du modèle, de mettre celui-ci à jour,
	 * d'afficher le brin sur le panel "contenu" et de débloquer l'accès aux boutons du menu d'activité.
	 */
	private class CommandeListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == saisie)
			{
				SaisieDial dial = new SaisieDial(null, "Saisie du brin d'ADN", true);		
				dial.setVisible(true);
			}
			else if(e.getSource() == generer)
			{
				modele.genererBrin();
				
				transcription.setEnabled(true);
				maturation.setEnabled(true);
				synthese.setEnabled(true);
				
				if(brinADN != null)
					contenu.remove(brinADN);
				builder = new BrinBuilder(modele.getBrinADN(), false);
				brinADN = builder.creerBrin(1, 2);
				contenu.add(brinADN);
			}
				
			
			contenu.revalidate();
			contenu.repaint();
		}
	}
	
	/**
	 * Cette classe interne gère la boite de dialogue qui permet à l'utilisateur de saisir son brin d'ADN.
	 * 
	 * Cette boite de dialogue contient un clavier de tous les codons existants et permet de saisir 7 à 8
	 * codons. La saisie d'un brin valide met à jour le modèle, affiche le brin saisie sur le panel "contenu"
	 * et débloque l'accès aux boutons du menu d'activité.
	 */
	@SuppressWarnings("serial")
	private class SaisieDial extends JDialog
	{
		private JTextField sequence;
		private JPanel brinPanel, clavierCodons, controle;
		private JLabel brinLabel;
		private JButton valider, effacer, annuler;
		private TreeSet<String> codons;
		
		
		/**
		 * Le contructeur initialise les éléments de la boite de dialogue, à savoir la zone de saisie du brin,
		 * le clavier de codons ainsi que les boutons de validation
		 */
		public SaisieDial(JFrame parent, String title, boolean modal)
		{
			super(parent, title, modal);
			this.setResizable(false);
			this.setLocationRelativeTo(mainMenu);
			this.setLayout(new BorderLayout());
			
			brinPanel = new JPanel();
			brinPanel.setPreferredSize(new Dimension(this.getWidth(), 60));
			brinLabel = new JLabel("Saisir 7 à 8 codons     Brin ADN :     TAC ");
	
			sequence = new JTextField();
			sequence.setEditable(false);
			sequence.setPreferredSize(new Dimension(250, 22));
			brinPanel.add(brinLabel);
			brinPanel.add(sequence);
			this.add(brinPanel, BorderLayout.NORTH);
			
			clavierCodons = new JPanel();
			clavierCodons.setLayout(new GridLayout(8, 8, 1, 1));
			codons = new TreeSet<String>(modele.getCodeGenetique().keySet());
			for(String codon : codons)
			{
				codon = codon.replace("U", "T");
				JButton boutonCodon = new JButton(codon);
				Color couleurBouton = null;
				switch(codon.charAt(0))
				{
					case 'A':
						couleurBouton = new Color(255, 243, 0);
						break;
					case 'T':
						couleurBouton = new Color(238, 26, 36);
						break;
					case 'G':
						couleurBouton = new Color(33, 177, 75);
						break;
					case 'C':
						couleurBouton = new Color(0, 162, 232);
						break;
				}
				boutonCodon.setBackground(couleurBouton);
				boutonCodon.addActionListener(new CodonBoutonListener());
				this.clavierCodons.add(boutonCodon);
			}
			this.add(clavierCodons);

			controle = new JPanel();
			valider = new JButton("OK");
			effacer = new JButton("Effacer");
			annuler = new JButton("Annuler");
			valider.setEnabled(false);
			effacer.setEnabled(false);
			valider.addActionListener(new ControleListener());
			effacer.addActionListener(new ControleListener());
			annuler.addActionListener(new ControleListener());
			controle.add(valider);
			controle.add(effacer);
			controle.add(annuler);
			this.add(controle, BorderLayout.SOUTH);			


			this.pack();
		}
		
		private class CodonBoutonListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent e) 
			{
				if(sequence.getText().length() < 24)
					sequence.setText(sequence.getText() + ((JButton)e.getSource()).getText());
				
				effacer.setEnabled(true);
				
				if(sequence.getText().length() > 18)
					valider.setEnabled(true);
			}
		}
		
		private class ControleListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == valider)
				{
					modele.setBrinADN(new BrinADN("TAC" + sequence.getText()));
					sequence.setText("");
					setVisible(false);
					
					transcription.setEnabled(true);
					maturation.setEnabled(true);
					synthese.setEnabled(true);
					
					if(brinADN != null)
						contenu.remove(brinADN);
					builder = new BrinBuilder(modele.getBrinADN(), false);
					brinADN = builder.creerBrin(1, 2);
					contenu.add(brinADN);
				}
				else if(e.getSource() == effacer)
				{
					sequence.setText("");
					valider.setEnabled(false);
					effacer.setEnabled(false);
				}
				else if(e.getSource() == annuler)
				{
					sequence.setText("");
					setVisible(false);
				}

			}
		}
		
	}
	
	
	
	
	
	/**
	 * Cette classe interne gère la personnalisation du panel central "contenu"
	 */
	private class ContenuPanel extends JPanel
	{
		private Image img;
		
		public ContenuPanel()
		{
			super(null);
			try
			{
				img = ImageIO.read(new File("ressources/synthese/arnfond.png"));
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

			g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), contenu);
		}
	}
	
	/**
	 * Cette méthode permet de fermer le panel et de revenir au menu principal
	 */
	public void fermer()
	{
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}

}
