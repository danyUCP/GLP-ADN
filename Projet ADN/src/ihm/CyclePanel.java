package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CyclePanel extends JPanel
{
	private JPanel section, contenu, menu, header, footer;
	private JButton mitose, meiose, zoommt; 
	private JButton mainMenu, aPropos;
	private Dimension dim;

	public CyclePanel()
	{
		this.dim = new Dimension(1200, 900);
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
		footer.setBackground(Color.RED);
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);


	}
	
	public void initMenu()
	{
		menu.setLayout(new GridLayout(3, 1, 0, 100));
		mitose = new JButton("Mitose");
		meiose = new JButton("Méiose");
		zoommt = new JButton("Réseau du Cycle cellulaire");
		menu.add(mitose);
		menu.add(meiose);
		menu.add(zoommt);	
		
		mitose.addActionListener(new BoutonListener());
		meiose.addActionListener(new BoutonListener());
		zoommt.addActionListener(new BoutonListener());
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
	
	class BoutonListener implements ActionListener
	{
		
		private int activity =0;
		
		public void actionPerformed(ActionEvent e) 
		{

			contenu.setBackground(Color.BLACK);
			footer.setBackground(Color.LIGHT_GRAY);
			
			if (e.getSource()==mitose)
				activity = 1;
			else if (e.getSource()==meiose)
				activity =2;
			else if (e.getSource()==zoommt)
				activity =3 ; 
				
			initCyclelisten(activity);

			contenu.revalidate();
			contenu.repaint();
			//contenu.setVisible(true);
		}
	}
	
	
	public void initCyclelisten(int activity)
	{
		contenu.removeAll();
		//footer.removeAll();
		
		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());

		switch (activity) 
		{
		case 1 :
			//contenu.add(mit);
			contenu.add(new ComposantsMitose(footer));
			break;
		case 2 :

			break;
		case 3:

			break;
			//contenu.add(new ComposantsMitose(footer, activity, contenu.getPreferredSize()), BorderLayout.CENTER);
		}
	
	

	}
	
	public void fermer()
	{
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}
}

