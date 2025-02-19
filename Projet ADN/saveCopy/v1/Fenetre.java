package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	private JPanel global, header, accueil;
	//private Panneau paneCentre;
	private JButton bouton1, bouton2, bouton3;
	private JLabel texte;
	
	public Fenetre()
	{
		this.setTitle("ADN");
		this.setSize(1200, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		//-------------- CONTENT PANE ------------------//
		global = new JPanel();
	    global.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		global.setBackground(Color.CYAN);
		global.setLayout(new BorderLayout());
		this.setContentPane(global);
		
		//-------------- PARTIE HEADER ------------------//
		header = new JPanel();
		header.setPreferredSize(new Dimension(this.getWidth(), 40));
		header.setBackground(Color.BLUE);
		header.setLayout(new FlowLayout());
		global.add(header, BorderLayout.NORTH);
		
		//-------------- PARTIE GAUCHE ------------------//
		accueil = new JPanel();
		accueil.setBackground(Color.RED);
		accueil.setLayout(new GridLayout(3, 1, 200, 200));
		bouton1 = new JButton("Cycle cellulaire");
		bouton2 = new JButton("Synth�se des prot�ines");
		bouton3 = new JButton("H�ritage g�n�tique");
		accueil.add(bouton1);
		accueil.add(bouton2);
		accueil.add(bouton3);
		global.add(accueil, BorderLayout.CENTER);

		
		/*
		//-------------- PARTIE DROITE CENTRE ------------------//
		paneCentre = new Panneau();
		paneCentre.setBackground(Color.BLUE);
		paneCentre.setLayout(new FlowLayout());
		paneDroite.add(paneCentre, BorderLayout.CENTER);
		*/
		
		
		bouton2.addActionListener(new BoutonListener());		


		this.setVisible(true);
		//paneCentre.animer();
	}
	
	class BoutonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			global.removeAll();
			global.add(new ARNPanel(), BorderLayout.CENTER);
			global.revalidate();	
		}
		
	}
	
}
