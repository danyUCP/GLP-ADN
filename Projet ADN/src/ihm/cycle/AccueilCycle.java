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
		
		theme= new CommentLabel("<html><strong><U>Le cycle cellulaire</U></strong> est l'ensemble des �tapes"
				+ " qui constituent"
				+ " et d�limitent la vie d'une cellule. Ce cycle est compos� de plusieurs phases de "
				+ "croissance dans lesquelles la cellule grossit et duplique son mat�riel g�n�tique "
				+ "(interphase) et d'une phase o� celle-ci se divise (mitose) pour donner naissance � deux "
				+ "cellules filles identiques (dans le cas de la mitose). Les cellules filles reproduiront "
				+ "ce cycle, et ainsi de suite. La m�iose en fait de m�me mais pour les cellules germinale -> cellules sexuelles.</html>",5);
		add(theme);
		
		definition= new CommentLabel("<html><strong><U>Petit Lexique !</U></strong> <br>"
				+ "Ici, sans pr�requis n�cessaire vous aurez besoin de comprendre <br>"
				+ " la notion de microtubules, centriole et reseau: <br>"
				+ "-> Reseau: compos� de centriole et de microtubule, n�cessaire � la division cellulaire,<br>"
				+ "-> Centrioles: base de ce r�seau, elles fonctionnent par paires <br>"
				+ "-> Microtubules: chaine de monom�re constituant les polymeres permettant l'anaphase <br>"
				+ "-> Monomere: 1 mol�cule ; Polym�re: plusieurs mol�cules.</html>",6);
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
