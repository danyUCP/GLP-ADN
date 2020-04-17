package ihm.heritage;

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
import ihm.BoutonCommande;
import ihm.BoutonMenu;
import ihm.BoutonNav;
import ihm.Fenetre;
import ihm.synthese.CommentLabel;


public class HeritagePanel extends JPanel {
	private JPanel section, contenu, menu, header, footer;
	private JLabel tester;
	private BoutonMenu arbres ,base,phenotype; 
	private BoutonNav mainMenu, aPropos;
	private BoutonCommande enfanter,Nucleotide,Gene,Chromosome,Homo,gpere,gmere,pmere,ppere,penfant,couleur;
	private Dimension dim;
	private Personne pere,mere,enfant;
	private CommentLabel resum;
	private CommentLabel cliquer;
	
	private BufferedImage adn;
	
	private ChromatideU test ;
	private ChromatideU testm ;
	private Personne personne;
	private PersonneA pheno;
	
	private Gametes ovuleU;
	private Gametes sperU;
	private Color fond;
	private Color citrouille;
	
	public HeritagePanel() {
		Gene groupeSanguin = new Gene("groupeSanguin");
		Allele o = new Allele("groupeSanguin","O",20);
		Allele a = new Allele("groupeSanguin","A",50);
		Allele b = new Allele("groupeSanguin","B",50);
		
		Gene yeux= new Gene ("yeux");
		Allele blue = new Allele("yeux","b",20);
		Allele brown = new Allele("yeux","M",60);
		
		Gene polydactylie = new Gene ("polydactylie");
		Allele polyp= new Allele("polydactylie","p",20);
		Allele polyP= new Allele("polydactylie","P",50);
				
		Gene albinisme = new Gene ("albinism");
		Allele aa= new Allele("albinism","al",20);
		Allele aA= new Allele("albinism","Al",60);
		
		Gene nez=new Gene("forme du nez");
		Allele crochu=new Allele("forme du nez","C",70);
		Allele fin=new Allele("forme du nez","F",20);
		
		Chromatide c1c1 = new Chromatide(o,aA);
		Chromatide c1c2 = new Chromatide(a,aa);
		Chromatide c1c3 = new Chromatide(b,aa);
		Chromatide c1c4 = new Chromatide(o,aa);
		Chromatide c2c1 = new Chromatide(polyp);
		Chromatide c2c2= new Chromatide (polyP);
		Chromatide c3c1= new Chromatide (blue);
		Chromatide c3c2= new Chromatide (brown);
		Chromatide c4c1=new Chromatide (crochu);
		Chromatide c4c2=new Chromatide (fin);
		
		
		
		Chromosome c1= new Chromosome(c1c1,c1c2);
		Chromosome c2 = new Chromosome(c2c1,c2c2);
		Chromosome c3 = new Chromosome(c3c1,c3c2);
		Chromosome c4=new Chromosome(c4c1,c4c2);
		Chromosome c5 = new Chromosome(c1c3,c1c4);
		Chromosome c6=new Chromosome(c3c1,c3c1);
		Chromosome c7=new Chromosome(c4c2,c4c2);
		pere = new Personne (c1,c2,c3,c4,"pere");
		mere = new Personne (c5,c2,c6,c7,"mere");
		
		this.test = new ChromatideU(pere);
		this.testm = new ChromatideU(mere);
		
		ovuleU=new Gametes();
		sperU=new Gametes();
		
		GametesU ovule= new GametesU(testm,ovuleU);
		GametesU spermatozoide= new GametesU(test,sperU);
		
		pheno = new PersonneA(personne,0,0);
		
		personne=new Personne(ovule,spermatozoide,"Personne");
		enfant=new Personne(ovule,spermatozoide,"enfant");
		
		
		this.dim = new Dimension(1200, 900);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		
		fond=new Color(151,223,198);
		citrouille= new Color(223,109,20);
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(new Color(28, 28, 28));
		header.setPreferredSize(new Dimension(dim.width, 40));
		header.setLayout(new FlowLayout());
		initNavigateur();
		this.add(header, BorderLayout.NORTH);
		
		//-------------- PARTIE SECTION -----------------//
		section = new JPanel();
		section.setPreferredSize(new Dimension(dim.width, dim.height - (100)));
		section.setLayout(new BorderLayout());
		this.add(section, BorderLayout.CENTER);
		
		//-------------- PARTIE MENU --------------------//
		menu = new JPanel();
		menu.setBackground(new Color(28, 28, 28));
		menu.setPreferredSize(new Dimension(1200 / 10, dim.height - (100)));
		menu.setLayout(new FlowLayout());
		
		initMenu();
		
		section.add(menu, BorderLayout.WEST);
		
		//-------------- PARTIE CONTENU -----------------//
		contenu = new JPanel();
		contenu.setBackground(fond);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		section.add(contenu, BorderLayout.CENTER);
		
		this.resum=new CommentLabel("<html>Le génome, ou rarement génôme, est l'ensemble du matériel génétique d'une espèce "
				+ "codé dans son acide désoxyribonucléique (ADN). Cette partie permet de comprendre comment le génome d'une "
				+ "personne est hérité et par quels critères celui-ci est exprimé sur le phénotype</html>",10);
		contenu.add(resum);
		
		this.cliquer=new CommentLabel("<html>Cliquer ci-dessous pour mieux comprendre les concepts </html>",0);
		contenu.add(cliquer);
		
		Dictionnaire dico=new Dictionnaire(10,140);
		contenu.add(dico);
		
		
		
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(new Color(28, 28, 28));
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);
		
		Nucleotide = new BoutonCommande("Nucleotide / ADN");
		footer.add(Nucleotide);
		Nucleotide.addActionListener(new NavListener());
		
		Gene = new BoutonCommande("Gene / Allèle");
		footer.add(Gene);
		Gene.addActionListener(new NavListener());
		
		Chromosome = new BoutonCommande("Chromatide / Chromosome");
		footer.add(Chromosome);
		Chromosome.addActionListener(new NavListener());
		
		Homo = new BoutonCommande("Homozygote / Hétérozygote");
		footer.add(Homo);
		Homo.addActionListener(new NavListener());
	}
	
	
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 100));
		arbres = new BoutonMenu("Arbres généalogiques", "ressources/mini_synthese.png");
		base = new BoutonMenu("Les bases", "ressources/mini_synthese.png");
		phenotype= new BoutonMenu("Phenotype", "ressources/mini_synthese.png");
		menu.add(arbres);
		menu.add(base);	
		menu.add(phenotype);
		
		arbres.addActionListener(new BoutonListener());
		base.addActionListener(new BoutonListener());
		phenotype.addActionListener(new BoutonListener());
	}
	public void arbres(int activity) {
		
	}
	
	public void initNavigateur()
	{
		header.setLayout(new GridLayout(1, 3, 0, 3));
		mainMenu = new BoutonNav("Retour à l'accueil", "ressources/home.png");
		aPropos = new BoutonNav("À propos", "ressources/propos.png");
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
				contenu.add(resum);
				contenu.add(cliquer);
				contenu.add(adn);
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			else if(e.getSource() == Gene) {
				JLabel adn = new JLabel( new ImageIcon( "gene.png"));
				contenu.removeAll();
				contenu.setLayout(new BorderLayout());
				contenu.add(resum);
				contenu.add(cliquer);
				contenu.add(adn);
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			else if(e.getSource() == Chromosome) {
				JLabel adn = new JLabel( new ImageIcon( "Chromosome.png"));
				contenu.removeAll();
				contenu.setLayout(new BorderLayout());
				contenu.add(resum);
				contenu.add(cliquer);
				contenu.add(adn);
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			else if(e.getSource() == Homo) {
				JLabel adn = new JLabel( new ImageIcon( "homozygote.png"));
				contenu.removeAll();
				contenu.setLayout(new BorderLayout());
				contenu.add(resum);
				contenu.add(cliquer);
				contenu.add(adn);
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			else if(e.getSource() == enfanter) {
				ChromatideU test = new ChromatideU(pere);
				ChromatideU testm = new ChromatideU(mere);
				
				Gametes ovuleU=new Gametes();
				Gametes sperU=new Gametes();
				
				GametesU ovule= new GametesU(testm,ovuleU);
				GametesU spermatozoide= new GametesU(test,sperU);
				
				GametesA ov= new GametesA(ovule,400,0);
				GametesA sp= new GametesA(spermatozoide,320,150);
				
				Personne enfant=new Personne(ovule,spermatozoide,"enfant");
				PersonneA enf=new PersonneA(enfant,100,300);
				CommentLabel expli=new CommentLabel("<html>Les deux gamètes en gris sont formés"
						+ " grâce à la meiose en se basant sur le génome respectif des deux parents. "
						+ "Le génome de l'enfant est ensuite formé: les paires de chromosomes(ici chaque"  
						+ "paire a la même couleur) se forment en mettant ensemble les chromatides des gamètes</html>",12);
				
				
				PersonneA pereaa=new PersonneA(pere,0,0);
				contenu.removeAll();
				contenu.add(expli);
				
				
				//contenu.add(pereaa);
				contenu.add(ov);
				contenu.add(sp);
				contenu.add(enf);
				
				contenu.revalidate();
				
				contenu.repaint();
				
				
				
			}
			else if(e.getSource() == gmere) {
				contenu.removeAll();
				PersonneA mers=new PersonneA(mere,1,100);
				//CommentLabel expliquer=new CommentLabel("<html>Cependant lors de la mitose, il peut aussi arriver qu'une division se passe mal"
					//	+ " et qu'on se retrouve avec une paire de chromosome à la place d'une chromatide dans les gamètes. "
						//+ "Ceci est à l'origine de maladies telles que la trisomie21</html>",11);
				
				CommentLabel expli=new CommentLabel("<html>Lors de la meiose,les divisions cellulaires successives permettent une distribution"
						+ " aléatoire des chromatides dans les gamètes. Cette distribution aléatoire entraîne une multitude de combinaisons possibles "
						+ " lors le la création des gamètes: ceci est la base de la diversité au sein des espèces</html>",12);
				//ChromatideU test = new ChromatideU(pere);
				//ChromatideU testm = new ChromatideU(mere);
				
				Gametes ovuleU=new Gametes();
				
				
				GametesU ovule= new GametesU(testm,ovuleU);
				GametesU ovule1= new GametesU(testm,ovuleU);
				GametesU ovule2= new GametesU(testm,ovuleU);
				GametesU ovule3= new GametesU(testm,ovuleU);
				
				GametesA ov= new GametesA(ovule,320,0);
				GametesA ov1= new GametesA(ovule1,320,160);
				GametesA ov2= new GametesA(ovule2,530,0);
				GametesA ov3= new GametesA(ovule3,530,160);
				//contenu.add(expliquer);
				contenu.add(expli);
				contenu.add(ov);
				contenu.add(ov1);
				contenu.add(ov2);
				contenu.add(ov3);
				contenu.add(mers);
				
				contenu.revalidate();
				
				contenu.repaint();
			}
			else if(e.getSource() == gpere) {
				contenu.removeAll();
				PersonneA mers=new PersonneA(pere,1,100);
				//CommentLabel expliquer=new CommentLabel("<html>Cependant lors de la meiose, il peut aussi arriver qu'une division se passe mal"
					//	+ " et qu'on se retrouve avec une paire de chromosome à la place d'une chromatide dans les gamètes. "
						//+ "Ceci est à l'origine de maladies telles que la trisomie21</html>",11);
				
				CommentLabel expli=new CommentLabel("<html>Lors de la mitose,les divisions cellulaires successives permettent une distribution"
						+ " aléatoire des chromatides dans les gamètes. Cette distribution aléatoire entraîne une multitude de combinaisons possibles "
						+ " lors le la création des gamètes: ceci est la base de la diversité au sein des espèces</html>",12);
				//ChromatideU test = new ChromatideU(pere);
				//ChromatideU testm = new ChromatideU(mere);
				
				
				Gametes sperU=new Gametes();
				
				GametesU spermatozoide= new GametesU(test,sperU);
				GametesU spermatozoide1= new GametesU(test,sperU);
				GametesU spermatozoide2= new GametesU(test,sperU);
				GametesU spermatozoide3= new GametesU(test,sperU);
				
				GametesA ov= new GametesA(spermatozoide,320,0);
				GametesA ov1= new GametesA(spermatozoide1,320,160);
				GametesA ov2= new GametesA(spermatozoide2,530,0);
				GametesA ov3= new GametesA(spermatozoide3,530,160);
				//contenu.add(expliquer);
				contenu.add(expli);
				contenu.add(ov);
				contenu.add(ov1);
				contenu.add(ov2);
				contenu.add(ov3);
				contenu.add(mers);
				
				contenu.revalidate();
				
				contenu.repaint();
				footer.revalidate();
				
				footer.repaint();
			}
			else if(e.getSource() == couleur) {
				
				contenu.removeAll();
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				CommentLabel explip=new CommentLabel("<html>Le phénotype répresente l'expression visuelle du génome. C'est l'ensemble des "
						+ "caractères spécifiques à une personne tel que la couleur des cheveux, des yeux, la taille et bien d'autres. "
						+ " </html>",12);
				
				
				GametesU ovule= new GametesU(testm,ovuleU);
				GametesU spermatozoide= new GametesU(test,sperU);
				
				pheno = new PersonneA(personne,0,0);
				
				personne=new Personne(ovule,spermatozoide,"Personne");
				PhenotypeA affichage=new PhenotypeA(personne,0,200);
				
				contenu.add(explip);
				contenu.add(pheno);
				contenu.add(affichage);
				contenu.revalidate();
				
				contenu.repaint();
				couleur = new BoutonCommande("Nouveau Phénotype");
				footer.add(couleur);
				couleur.addActionListener(new NavListener());
				footer.revalidate();
				
				footer.repaint();
				
			}
			else if(e.getSource() == pmere) {
				contenu.removeAll();
				CommentLabel explip=new CommentLabel("<html>Le phénotype répresente l'expression visuelle du génome. C'est l'ensemble des "
						+ "caractères spécifiques à une personne tel que la couleur des cheveux, des yeux, la taille et bien d'autres. "
						+ " </html>",12);
				contenu.add(explip);
				pheno = new PersonneA(mere,0,0);
				
				PersonneA ex=new PersonneA(mere,0,0);
				PhenotypeA affichage=new PhenotypeA(mere,0,200);
				
				contenu.add(ex);
				contenu.add(pheno);
				contenu.add(affichage);
				contenu.revalidate();
				contenu.repaint();
				
				footer.revalidate();
				
				footer.repaint();
			}
			else if(e.getSource() == ppere) {
				contenu.removeAll();
				CommentLabel explip=new CommentLabel("<html>Le phénotype répresente l'expression visuelle du génome. C'est l'ensemble des "
						+ "caractères spécifiques à une personne tel que la couleur des cheveux, des yeux, la taille et bien d'autres. "
						+ " </html>",12);
				contenu.add(explip);
				pheno = new PersonneA(pere,0,0);
				PersonneA ex=new PersonneA(pere,0,0);
				
				PhenotypeA affichage=new PhenotypeA(pere,0,200);
				
				contenu.add(ex);
				contenu.add(pheno);
				contenu.add(affichage);
				contenu.revalidate();
				contenu.repaint();
				
				footer.revalidate();
				
				footer.repaint();
			}
			else if(e.getSource() == penfant) {
				
				contenu.removeAll();
				CommentLabel explip=new CommentLabel("<html>Le phénotype répresente l'expression visuelle du génome. C'est l'ensemble des "
						+ "caractères spécifiques à une personne tel que la couleur des cheveux, des yeux, la taille et bien d'autres. "
						+ " </html>",12);
				contenu.add(explip);
				pheno = new PersonneA(enfant,0,0);
				
				PersonneA ex=new PersonneA(enfant,0,0);
				PhenotypeA affichage=new PhenotypeA(enfant,0,200);
				
				contenu.add(ex);
				contenu.add(pheno);
				contenu.add(affichage);
				contenu.revalidate();
				contenu.repaint();
				
				footer.revalidate();
				
				footer.repaint();
			}
			
		}
	}
	
	class BoutonListener implements ActionListener {
		private int activity =0;
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==arbres) {
				activity=1;
				contenu.removeAll();
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				
				contenu.add(new Arbre(pere,mere));
				enfanter = new BoutonCommande("enfant");
				gmere=new BoutonCommande("Gamètes mère");
				gpere=new BoutonCommande("Gamètes père");
				footer.add(enfanter);
				footer.add(gmere);
				footer.add(gpere);
				enfanter.addActionListener(new NavListener());
				gpere.addActionListener(new NavListener());
				gmere.addActionListener(new NavListener());
				
				pmere=new BoutonCommande("Phénotype mère");
				ppere=new BoutonCommande("Phénotype père");
				penfant=new BoutonCommande("Phénotype enfant");
				footer.add(pmere);
				footer.add(ppere);
				footer.add(penfant);
				penfant.addActionListener(new NavListener());
				ppere.addActionListener(new NavListener());
				pmere.addActionListener(new NavListener());
				
				contenu.revalidate();
				
				contenu.repaint();
				footer.revalidate();
				
				footer.repaint();
				
			}
		
			else if(e.getSource()==base) {
				activity=2;
				contenu.removeAll();
				contenu.add(resum);
				contenu.add(cliquer);
				Dictionnaire dico=new Dictionnaire(10,140);
				contenu.add(dico);
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				
				footer.add(Nucleotide);
				footer.add(Gene);
				footer.add(Chromosome);
				footer.add(Homo);
				
				footer.revalidate();
				
				footer.repaint();
				contenu.revalidate();
				
				contenu.repaint();
				
			}
			else if(e.getSource()== phenotype) {
				activity=3;
				contenu.removeAll();
				footer.removeAll();
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				CommentLabel explip=new CommentLabel("<html>Le phénotype répresente l'expression visuelle du génome. C'est l'ensemble des "
						+ "caractères spécifiques à une personne tel que la couleur des cheveux, des yeux, la taille et bien d'autres. "
						+ " </html>",12);
				
				
				GametesU ovule= new GametesU(testm,ovuleU);
				GametesU spermatozoide= new GametesU(test,sperU);
				
				pheno = new PersonneA(personne,0,0);
				
				personne=new Personne(ovule,spermatozoide,"Personne");
				PhenotypeA affichage=new PhenotypeA(personne,0,200);
				
				contenu.add(explip);
				contenu.add(pheno);
				contenu.add(affichage);
				contenu.revalidate();
				
				contenu.repaint();
				couleur = new BoutonCommande("Nouveau Phénotype");
				footer.add(couleur);
				couleur.addActionListener(new NavListener());
				footer.revalidate();
				
				footer.repaint();
			}
			
		}
	}
	
	
	
	public void fermer()
	{
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}
	
}
