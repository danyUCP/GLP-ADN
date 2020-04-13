package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import heritage.Allele;
import heritage.Chromatide;
import heritage.ChromatideU;
import heritage.Chromosome;
import heritage.Gametes;
import heritage.GametesU;
import heritage.Gene;
import heritage.Personne;
import ihm.synthese.CommentLabel;


public class HeritagePanel extends JPanel {
	private JPanel section, contenu, menu, header, footer,tester;
	private JButton arbres ,base,phenotype; 
	private JButton mainMenu, aPropos,enfanter,Nucleotide;
	private Dimension dim;
	private Personne pere,mere;
	private CommentLabel resum;
	private CommentLabel cliquer;
	
	private BufferedImage adn;
	
	public HeritagePanel() {
		Gene groupeSanguin = new Gene("groupeSanguin");
		Allele o = new Allele("groupeSanguin","O",20);
		Allele a = new Allele("groupeSanguin","A",50);
		Allele b = new Allele("groupeSanguin","B",50);
		
		Gene yeux= new Gene ("yeux");
		Allele blue = new Allele("yeux","b",20);
		Allele brown = new Allele("yeux","B",60);
		
		Gene polydactylie = new Gene ("polydactylie");
		Allele polyp= new Allele("polydactylie","p",20);
		Allele polyP= new Allele("polydactylie","P",50);
				
		Gene albinisme = new Gene ("albinism");
		Allele aa= new Allele("albinism","al",20);
		Allele aA= new Allele("albinism","Al",60);
		
		Chromatide c1c1 = new Chromatide(o,aA);
		Chromatide c1c2 = new Chromatide(a,aa);
		Chromatide c2c1 = new Chromatide(polyp);
		Chromatide c2c2= new Chromatide (polyP);
		Chromatide c3c1= new Chromatide (blue);
		Chromatide c3c2= new Chromatide (brown);
		
		
		
		Chromosome c1= new Chromosome(c1c1,c1c2);
		Chromosome c2 = new Chromosome(c2c1,c2c2);
		Chromosome c3 = new Chromosome(c3c1,c3c2);
		this.pere = new Personne (c1,c2,c3,c1,"pere");
		this.mere = new Personne (c1,c2,c3,c1,"mere");
		
		
		this.dim = new Dimension(1200, 900);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(Color.BLUE);
		header.setPreferredSize(new Dimension(dim.width, 40));
		header.setLayout(new FlowLayout());
		initNavigateur();
		this.add(header, BorderLayout.NORTH);
		
		//-------------- PARTIE SECTION -----------------//
		section = new JPanel();
		section.setBackground(Color.ORANGE);
		section.setPreferredSize(new Dimension(dim.width, dim.height - (100)));
		section.setLayout(new BorderLayout());
		this.add(section, BorderLayout.CENTER);
		
		//-------------- PARTIE MENU --------------------//
		menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setPreferredSize(new Dimension(1200 / 10, dim.height - (100)));
		menu.setLayout(new FlowLayout());
		
		initMenu();
		
		section.add(menu, BorderLayout.WEST);
		
		//-------------- PARTIE CONTENU -----------------//
		contenu = new JPanel();
		contenu.setBackground(Color.green);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		section.add(contenu, BorderLayout.CENTER);
		
		this.resum=new CommentLabel("<html>Le génome, ou rarement génôme, est l'ensemble du matériel génétique d'une espèce "
				+ "codé dans son acide désoxyribonucléique (ADN). Cette partie permet de comprendre comment le génome d'une "
				+ "personne est hérité et par quels critères celui-ci est exprimé sur le phénotype</html>",3);
		contenu.add(resum);
		
		this.cliquer=new CommentLabel("<html>Cliquer ci-dessous pour mieux comprendre les concepts </html>",0);
		contenu.add(cliquer);
		
		Dictionnaire dico=new Dictionnaire(10,140);
		contenu.add(dico);
		
		
		
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(Color.red);
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);
		
		Nucleotide = new JButton("Nucleotide / ADN");
		footer.add(Nucleotide);
		Nucleotide.addActionListener(new NavListener());
		
		JButton Gene = new JButton("Gene / Allèle");
		footer.add(Gene);
		Gene.addActionListener(new NavListener());
		
		JButton Chromosome = new JButton("Chromatide / Chromosome");
		footer.add(Chromosome);
		Chromosome.addActionListener(new NavListener());
		
		JButton Homo = new JButton("Homozygote / Hétérozygote");
		footer.add(Homo);
		Homo.addActionListener(new NavListener());
	}
	
	
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 100));
		arbres = new JButton("Arbres généalogiques");
		base = new JButton("Les bases");
		phenotype= new JButton("Phenotype");
		menu.add(arbres);
		menu.add(base);	
		menu.add(phenotype);
		
		arbres.addActionListener(new BoutonListener());
		base.addActionListener(new BoutonListener());
	}
	public void arbres(int activity) {
		
	}
	
	public void initNavigateur()
	{
		header.setLayout(new GridLayout(1, 3, 0, 3));
		mainMenu = new JButton("Retour à l'accueil");
		aPropos = new JButton("À propos");
		header.add(mainMenu);
		header.add(aPropos);
		
		
		mainMenu.addActionListener(new NavListener());
	}
	
	class NavListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == mainMenu)
				fermer();
			else if(e.getSource() == aPropos) {
				
			}
			else if(e.getSource() == Nucleotide) {
				JLabel adn = new JLabel( new ImageIcon( "adn.png"));
				contenu.removeAll();
				contenu.setLayout(new BorderLayout());
				contenu.add(cliquer);
				contenu.add(adn);
				contenu.revalidate();
				
				contenu.repaint();
				
			}	
			
			
		}
	}
	
	class BoutonListener implements ActionListener {
		private int activity =0;
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==arbres) {
				activity=1;
				contenu.setBackground(Color.WHITE);
				footer.setBackground(Color.LIGHT_GRAY);
				contenu.removeAll();
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				
				contenu.add(new Arbre(pere,mere));
				enfanter = new JButton("faire un enfant");
				footer.add(enfanter);
				enfanter.addActionListener(new NavListener());
				
				
				contenu.revalidate();
				
				contenu.repaint();
			
				
			}
			else if(e.getSource()==base) {
				activity=2;
				contenu.removeAll();
				contenu.setBackground(Color.green);
				contenu.add(resum);
				contenu.add(cliquer);
				Dictionnaire dico=new Dictionnaire(10,140);
				contenu.add(dico);
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				
				footer.setBackground(Color.red);
				footer.add(Nucleotide);
				Nucleotide.addActionListener(new NavListener());
				
				JButton Gene = new JButton("Gene / Allèle");
				footer.add(Gene);
				Gene.addActionListener(new NavListener());
				
				JButton Chromosome = new JButton("Chromatide / Chromosome");
				footer.add(Chromosome);
				Chromosome.addActionListener(new NavListener());
				
				JButton Homo = new JButton("Homozygote / Hétérozygote");
				footer.add(Homo);
				Homo.addActionListener(new NavListener());
				
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			
		}
	}
	
	public void paintComponent(Graphics g) {
		
	     g.drawImage(adn, 500, 100, contenu);
	}
	
	public void fermer()
	{
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}
	
}
