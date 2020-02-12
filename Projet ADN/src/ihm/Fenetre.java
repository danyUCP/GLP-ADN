package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Fenetre extends JFrame
{
	private JSplitPane global;
	private JPanel paneGauche, paneDroite, paneHaut, paneCentre, paneBas;
	
	private JLabel texte;
	
	public Fenetre()
	{
		this.setTitle("ADN");
		this.setSize(900, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		//-------------- CONTENT PANE ------------------//
		global = new JSplitPane();
		global.setBackground(Color.DARK_GRAY);
		this.setContentPane(global);
		
		//-------------- PARTIE GAUCHE ------------------//
		paneGauche = new JPanel();
		paneGauche.setMinimumSize(new Dimension(140, this.getHeight()));
		paneGauche.setBackground(Color.CYAN);
		paneGauche.setLayout(new GridLayout(3, 1));
		global.setLeftComponent(paneGauche);
		
		//-------------- PARTIE DROITE ------------------//
		paneDroite = new JPanel();
		paneDroite.setMinimumSize(new Dimension(730, this.getHeight()));
		paneDroite.setBackground(Color.MAGENTA);
		paneDroite.setLayout(new BorderLayout());
		global.setRightComponent(paneDroite);

		//-------------- PARTIE DROITE HAUT ------------------//
		paneHaut = new JPanel();
		paneHaut.setBackground(Color.BLUE);
		paneHaut.setLayout(new FlowLayout());
		paneDroite.add(paneHaut, BorderLayout.NORTH);
		
		//-------------- PARTIE DROITE CENTRE ------------------//
		paneCentre = new Panneau();
		paneCentre.setBackground(Color.WHITE);
		paneCentre.setLayout(new FlowLayout());
		paneDroite.add(paneCentre, BorderLayout.CENTER);
			
		//-------------- PARTIE DROITE BAS ------------------//
		paneBas = new JPanel();
		paneBas.setBackground(Color.RED);
		paneBas.setLayout(new FlowLayout());
		paneDroite.add(paneBas, BorderLayout.SOUTH);
		
		
		
		this.setVisible(true);
	}
	
	class Panneau extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			
			int longueur = 400;
			int largeur = 200;
			int x = this.getWidth() / 2 - largeur / 2;
			int y = this.getHeight() / 2 - longueur / 2;
			g.setColor(Color.GREEN);
			g.fillOval(x, y, largeur, longueur);
			
		}
		
	}

}
