package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import heritage.Allele;
import heritage.Chromatide;
import heritage.Chromosome;
import heritage.Gene;
import heritage.Personne;
import heritage.Test;


public class HeritagePanel extends JPanel {
	private JPanel section, contenu, menu, header, footer,tester;
	private JButton transcription, arbres , tests; 
	private Dimension dim;
	private Personne pere;
	
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
		Allele aa= new Allele("albinism","a",20);
		Allele aA= new Allele("albinism","A",60);
		
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
		//this.mere = new Personne (c1,c2,c3,c1,"mere");
		this.dim = new Dimension(1200, 900);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(Color.BLUE);
		header.setPreferredSize(new Dimension(dim.width, 40));
		header.setLayout(new FlowLayout());
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
		contenu.setBackground(Color.GREEN);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		section.add(contenu, BorderLayout.CENTER);
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(Color.RED);
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);


	}
	
	
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(2, 1, 0, 100));
		arbres = new JButton("Arbres généalogiques");
		tests = new JButton("Tests de paternité");
		menu.add(arbres);
		menu.add(tests);	
		
		arbres.addActionListener(new BoutonListener());
	}
	public void arbres(int activity) {
		
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
				contenu.setLayout(new BorderLayout());
				footer.setLayout(new FlowLayout());
				contenu.add(new Arbre(pere));
		
				
				contenu.revalidate();
				
				contenu.repaint();
				//contenu.setVisible(true);
				
			}
			
		}
	}
	
	public void paintComponent(Graphics g) {
		
	     g.drawOval(300, 200, 400, 300);
	     

	}
	

}
