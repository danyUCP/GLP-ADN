package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class CyclePanel extends JPanel {
	private JPanel section, contenu, menu, header, footer;
	private BoutonMenu mitose, meiose, zoommt, replication, crossing;
	private BoutonNav mainMenu, aPropos;
	private AccueilCycle fond;
	private Dimension dim;

	/**Constructeur, insanciation des panels et buttons*/
	public CyclePanel() {
		this.dim = new Dimension(1200, 800);
		this.setPreferredSize(dim);
		this.setLayout(new BorderLayout());
		//private ComposantsMitose composant = ComposantsMitose();

		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setBackground(new Color(28, 28, 28));
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
		menu.setBackground(new Color(28, 28, 28));
		menu.setPreferredSize(new Dimension(1200 / 10, dim.height - (100)));
		menu.setLayout(new FlowLayout());

		initMenu();

		section.add(menu, BorderLayout.WEST);

		//-------------- PARTIE CONTENU -----------------//
		contenu = new JPanel();
		fond=new AccueilCycle();
		contenu.setBackground(Color.WHITE);
		contenu.setPreferredSize(new Dimension(9 * (1200 / 10), dim.height - (100)));
		contenu.setLayout(null);
		contenu.add(fond);
		section.add(contenu, BorderLayout.CENTER);
		


		//-------------- PARTIE FOOTER ------------------//
		footer = new JPanel();
		footer.setBackground(new Color(28, 28, 28));
		footer.setPreferredSize(new Dimension(this.getPreferredSize().width, 60));
		footer.setLayout(new FlowLayout());
		this.add(footer, BorderLayout.SOUTH);


	}

	/**@see ActionListener*/
	class BoutonListener implements ActionListener {

		private int activity =0;

		public void actionPerformed(ActionEvent e) {

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
	
	public void initNavigateur() {
		header.setLayout(new GridLayout(1, 3, 0, 3));
		mainMenu = new BoutonNav("Retour à l'accueil", "ressources/home.png");
		aPropos = new BoutonNav("À propos", "ressources/propos.png");
		header.add(mainMenu);
		header.add(aPropos);
		
		mainMenu.addActionListener(new NavListener());
	}
	
	private class NavListener implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mainMenu)
				fermer();
			else if(e.getSource() == aPropos)
				
			
			contenu.revalidate();
			contenu.repaint();
		}
	}

	/**Instanciation et ajout d'elements du menu*/
	public void initMenu() {
		menu.setLayout(new GridLayout(5, 1, 0, 10));
		mitose = new BoutonMenu("Mitose", "ressources/mini_synthese.png");
		replication = new BoutonMenu("Replication", "ressources/mini_synthese.png");
		crossing = new BoutonMenu("CrossingOver", "ressources/mini_synthese.png");
		meiose = new BoutonMenu("Méiose", "ressources/mini_synthese.png");
		zoommt = new BoutonMenu("Réseau", "ressources/mini_synthese.png");
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
	public void initCyclelisten(int activity) {
		contenu.removeAll();
		//footer.removeAll();

		contenu.setLayout(new BorderLayout());
		footer.setLayout(new FlowLayout());

		switch (activity) {

		case 1 :
			//contenu.add(mit);
			footer.removeAll();
			/**Réinitialisation du contenue et des parametres
			 * @see MitosePara.resetMitosePara
			 */
			MitosePara.resetMitosePara();
			contenu.repaint();
			contenu.revalidate();
			contenu.removeAll();
			contenu.add(new MitoseActivity(footer));
			//contenu.add(new ComposantsMitose(footer, activity, contenu.getPreferredSize()), BorderLayout.CENTER);
			break;
		case 2 :
			footer.removeAll();
			contenu.removeAll();
			contenu.repaint();
			contenu.revalidate();
			contenu.add(new ReplicationActivity(footer));
			break;
		case 3:
			footer.removeAll();
			contenu.removeAll();
			contenu.repaint();
			contenu.revalidate();
			contenu.add(new CrossingOver(footer));
			break;
		case 4 :
			footer.removeAll();
			/**Réinitialisation du contenue et des parametres
			 * @see MitosePara.resetMitosePara();
			 *@see MeiosePara1.resetMeiosePara1();
			 *@see MeiosePara2.resetMeiosePara2();
			 */
			MitosePara.resetMitosePara();
			MeiosePara1.resetMeiosePara1();
			MeiosePara2.resetMeiosePara2();
			contenu.repaint();
			contenu.revalidate();
			contenu.removeAll();
			contenu.add(new MeioseActivity(footer));
			break;
		case 5:
			footer.removeAll();
			contenu.removeAll();
			contenu.repaint();
			contenu.revalidate();
			contenu.add(new MicrotubuleActivity(footer));
			break;

		}
	}
	
	/**
	 * Cette méthode permet de fermer le panel et de revenir au menu principal
	 */
	public void fermer() {
		Fenetre frame = (Fenetre) (SwingUtilities.getRoot(this));
		
		this.removeAll();
		frame.resetAccueil();
	}
}

