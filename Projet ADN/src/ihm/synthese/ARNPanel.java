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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ihm.Fenetre;
import ihm.ParaADN;

public class ARNPanel extends JPanel
{
	private JPanel section, menu, header, footer;
	private ContenuPanel contenu;
	private JButton transcription, maturation, synthese; 
	private JButton mainMenu, aPropos;
	private Dimension dim;
	private Image fond;
	
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
		section.add(contenu, BorderLayout.CENTER);
		
		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(new Color(204, 204, 255));
		footer.setPreferredSize(new Dimension(ParaADN.LARGEUR_FENETRE, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);

		try 
		{
			fond = ImageIO.read(new File("arnfond.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		//repaint();
	}
	
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 3));
		transcription = new JButton("Transcription");
		maturation = new JButton("Maturation");
		synthese = new JButton("Synthèse");
		menu.add(transcription);
		menu.add(maturation);
		menu.add(synthese);	
		
		transcription.addActionListener(new MenuListener());
		maturation.addActionListener(new MenuListener());
		synthese.addActionListener(new MenuListener());
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
			else if(e.getSource() == aPropos)
				
			
			contenu.revalidate();
			contenu.repaint();
			//contenu.setVisible(true);
		}
	}
	
	class MenuListener implements ActionListener
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
			//contenu.setVisible(true);
		}
	}
	
	public void initARNActivity(int activity)
	{
		contenu.removeAll();
		footer.removeAll();
		
		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());
		
		switch(activity)
		{
			case 1:
				contenu.add(new TranscriptionActivity(footer, contenu.getPreferredSize()), BorderLayout.CENTER);
				break;
			case 2:
				contenu.add(new MaturationActivity(footer, contenu.getPreferredSize()), BorderLayout.CENTER);
				break;
			case 3:
				contenu.add(new SyntheseActivity(footer, contenu.getPreferredSize()), BorderLayout.CENTER);
				break;
			case 4:
				break;
		
		}
	}
	
	private class ContenuPanel extends JPanel
	{
		private Image img;
		
		public ContenuPanel()
		{
			super(null);
			try
			{
				img = ImageIO.read(new File("arnfond.png"));
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
	
	public void fermer()
	{
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}
	
	
	
	/*
	public void paintComponent(Graphics g)
	{
		try 
		{
			Image img = ImageIO.read(new File("banane3.jpg"));
			g.drawImage(img, 0, 0, this);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
	    }                
	  
	}     
	*/
	

}
