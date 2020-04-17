package ihm.cycle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import ihm.CommentLabel;

public class AccueilCycle extends JLabel {
	
	public Image img1;
	
	private CommentLabel theme, definition;
	
	
	public AccueilCycle() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setBounds(0, 0, 1080, 700);
		
		theme= new CommentLabel("<html><strong><U>Le cycle cellulaire</U></strong> est l'ensemble des étapes"
				+ " qui constituent"
				+ " et délimitent la vie d'une cellule. Ce cycle est composé de plusieurs phases de "
				+ "croissance dans lesquelles la cellule grossit et duplique son matériel génétique "
				+ "(interphase) et d'une phase où celle-ci se divise (mitose) pour donner naissance à deux "
				+ "cellules filles identiques (dans le cas de la mitose). Les cellules filles reproduiront "
				+ "ce cycle, et ainsi de suite. La méiose en fait de même mais pour les cellules germinale -> cellules sexuelles.</html>",5);
		add(theme);
		
		definition= new CommentLabel("<html><strong><U>Petit Lexique !</U></strong> <br>"
				+ "Ici, sans prérequis nécessaire vous aurez besoin de comprendre <br>"
				+ " la notion de microtubules, centriole et reseau: <br>"
				+ "-> Reseau: composé de centriole et de microtubule, nécessaire à la division cellulaire,<br>"
				+ "-> Centrioles: base de ce réseau, elles fonctionnent par paires <br>"
				+ "-> Microtubules: chaine de monomère constituant les polymeres permettant l'anaphase <br>"
				+ "-> Monomere: 1 molécule ; Polymère: plusieurs molécules.</html>",6);
		add(definition);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		  
		    try {
		        img1 = ImageIO.read(new File("ressources/cycle/fondcycle.png"));   
		    } catch (IOException e) {
			       e.printStackTrace();
			     }    
		    
		    g2d.drawImage(img1,0,0, 1080, 700, this);
			   
	}
	
}
