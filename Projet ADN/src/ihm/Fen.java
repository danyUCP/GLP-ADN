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

public class Fen extends JFrame
{
	private JPanel global, header, accueil;
	//private Panneau paneCentre;
	private JButton bouton1, bouton2, bouton3;
	private JLabel texte;
	
	public Fen()
	{
		this.setTitle("ADN");
		this.setSize(1200, 800);
		this.setResizable(true);
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
		bouton2 = new JButton("Synthèse des protéines");
		bouton3 = new JButton("Héritage génétique");
		accueil.add(bouton1);
		accueil.add(bouton2);
		accueil.add(bouton3);
		global.add(accueil, BorderLayout.CENTER);

		
		bouton1.addActionListener(new BoutonListener());	
		bouton2.addActionListener(new BoutonListener());
		bouton3.addActionListener(new BoutonListener());

		this.setVisible(true);
		//paneCentre.animer();
	}
	
	class BoutonListener implements ActionListener
	{
		private int cons=0;
		public void actionPerformed(ActionEvent e) 
		{
			global.removeAll();
			
			if (e.getSource()== bouton1)
				cons=1;
			if (e.getSource()== bouton2)
				cons=2;
			if (e.getSource()== bouton3)
				cons=3;
			
			initAnswer(cons);
			global.revalidate();
			global.repaint();
				
		}
	}
		
		public void initAnswer(int cons)
		{
			global.removeAll();
			header.removeAll();
			
			global.setLayout(new BorderLayout());
			header.setLayout(new FlowLayout());

			switch (cons) {
			
			case 1 :
				global.add(new CyclePanel(), BorderLayout.CENTER);
				break;
			case 2 :
				
				break;
			case 3:
				
				break;
			
		}
		
	}

		//@Override
		/**public void run() {
			 for(int i = x1; i > x1; i++){
			      int x = 75, y =y1;
			      x=x--;
			      y=y--;
			      setx1(x);
			      sety1(y);
			      repaint();  
			      try {
			        Thread.sleep(100);
			      } catch (InterruptedException e) {
			        e.printStackTrace();
			      }
			    }
			
		}*/
	
}
