package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import heritage.ChromatideU;
import heritage.Gametes;
import heritage.GametesU;
import heritage.Personne;
import ihm.synthese.CommentLabel;

public class Arbre extends JPanel implements Runnable  {
	private Personne pere;
	private Personne mere;
	
	private BufferedImage image;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	
	private CommentLabel explication;
	
	private JButton enfanter;
	
	
	public Arbre(Personne pere,Personne mere)  {
		super(null);
		this.pere=pere;
		this.mere=mere;
		
		ChromatideU test = new ChromatideU(this.pere);
		ChromatideU testm = new ChromatideU(this.mere);
		
		Gametes ovuleU=new Gametes();
		Gametes sperU=new Gametes();
		
		GametesU ovule1= new GametesU(testm,ovuleU);
		GametesU ovule= new GametesU(testm,ovuleU);
		GametesU spermatozoide= new GametesU(test,sperU);
		
		Personne enfant=new Personne(ovule,spermatozoide,"enfant");
		
		CommentLabel resum=new CommentLabel("<html>Après avoir bien lu les bases du mécanisme de l'héritage génétique, "
				+ "choisissez le génome des parents dans le cadre ci-dessous!  </html>",3);
		this.add(resum);

		PersonneA pers=new PersonneA(pere,0,0);
		PersonneA mers=new PersonneA(mere,1,100);
		GametesA ov= new GametesA(ovule,100,100);
		GametesA ov1= new GametesA(ovule1,100,300);
		
		Choix merec=new Choix(0,100,"mere");
		Choix perec=new Choix(360,100,"pere");
		//this.add(merec);
		//this.add(perec);
		this.add(mers);
		this.add(ov);
		this.add(ov1);
		Dictionnaire dico=new Dictionnaire(750,230);
		this.add(dico);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
				
	}


	@Override
	public void run() {
		
		
	}
	
		
	
	

}
