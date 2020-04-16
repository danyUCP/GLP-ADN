package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class CyclePanel extends JPanel {
	private JPanel section, contenu, menu, header, footer;
	private JButton mitose, meiose, zoommt, replication, crossing;
	private JButton mainMenu, aPropos;
	private Image img1; 
	private Dimension dim;

	/**Constructeur, insanciation des panels et buttons*/
	public CyclePanel() {
		this.dim = new Dimension(1200, 800);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		//private ComposantsMitose composant = ComposantsMitose();

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
		contenu.setBackground(Color.WHITE);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		section.add(contenu, BorderLayout.CENTER);


		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(Color.CYAN);
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);


	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		try {
			img1 = ImageIO.read(new File("fondcycle.png"));   
		} catch (IOException e) {
			e.printStackTrace();
		}     

		g2d.drawImage(img1, 0, 0,1080,700, this);
	}


	/**@see ActionListener*/
	class BoutonListener implements ActionListener
	{

		private int activity =0;

		public void actionPerformed(ActionEvent e) 
		{

			contenu.setBackground(Color.BLACK);
			footer.setBackground(Color.LIGHT_GRAY);

			if (e.getSource()==mitose)
				activity = 1;
			else if (e.getSource()==replication)
				activity =2;
			else if (e.getSource()==crossing)
				activity =3;
			else if (e.getSource()==meiose)
				activity =4;
			else if (e.getSource()==zoommt)
				activity =5 ; 

			initCyclelisten(activity);


			contenu.revalidate();
			contenu.repaint();
			//contenu.setVisible(true);
		}
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

	/**Instanciation et ajout d'elements du menu*/
	public void initMenu()
	{
		menu.setLayout(new GridLayout(5, 1, 0, 100));
		mitose = new JButton("Mitose");
		replication = new JButton("Replication");
		crossing = new JButton("CrossingOver");
		meiose = new JButton("Méiose");
		zoommt = new JButton("Réseau du Cycle cellulaire");
		menu.add(mitose);
		menu.add(replication);
		menu.add(crossing);
		menu.add(meiose);
		menu.add(zoommt);	

		mitose.addActionListener(new BoutonListener());
		replication.addActionListener(new BoutonListener());
		crossing.addActionListener(new BoutonListener());
		meiose.addActionListener(new BoutonListener());
		zoommt.addActionListener(new BoutonListener());
	}

	/**Reponse a la selection de la rubrique*/
	public void initCyclelisten(int activity)
	{
		contenu.removeAll();
		//footer.removeAll();

		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());

		switch (activity) {

		case 1 :
			//contenu.add(mit);
			footer.removeAll();
			contenu.removeAll();
			contenu.add(new MitoseActivity(footer));
			//contenu.add(new ComposantsMitose(footer, activity, contenu.getPreferredSize()), BorderLayout.CENTER);
			break;
		case 2 :
			footer.removeAll();
			contenu.removeAll();
			contenu.add(new ReplicationActivity(footer));
			break;
		case 3:
			footer.removeAll();
			contenu.removeAll();
			contenu.add(new CrossingOver(footer));
			break;
		case 4 :
			footer.removeAll();
			contenu.removeAll();
			contenu.add(new MeioseActivity(footer));
			break;
		case 5:
			footer.removeAll();
			contenu.removeAll();
			contenu.add(new MicrotubuleActivity(footer));
			break;

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

