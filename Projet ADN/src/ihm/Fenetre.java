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

@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	private JPanel global, header;
	private AccueilPanel accueil;
	//private Panneau paneCentre;
	private BoutonMenu cycle, proteine, heritage;
	private JLabel texte;
	private Image img;
	
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
		/*
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setPreferredSize(new Dimension(this.getWidth(), 40));
		header.setBackground(Color.BLUE);
		header.setLayout(new FlowLayout());
		global.add(header, BorderLayout.NORTH);
		*/
		
		//-------------- PARTIE GAUCHE ------------------//
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

		
		/*
		//-------------- PARTIE DROITE CENTRE ------------------//
		paneCentre = new Panneau();
		paneCentre.setBackground(Color.BLUE);
		paneCentre.setLayout(new FlowLayout());
		paneDroite.add(paneCentre, BorderLayout.CENTER);
		*/
		
		
		cycle.addActionListener(new BoutonListener());
		proteine.addActionListener(new BoutonListener());
		heritage.addActionListener(new BoutonListener());


		this.setVisible(true);
	}
	
	public void resetAccueil()
	{
		System.out.println("On réinitialise la page d'accueil");
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
	

	
}

