package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaisieRepli extends JPanel {

	private JLabel propo;
	private JTextField saisie;
	private JButton chercher;
	private JPanel footer;
	public String sequence;
	
	
	public SaisieRepli(JPanel foot) {
		// TODO Auto-generated constructor stub
		
		this.propo=propo;
		this.saisie=saisie;
		this.chercher=chercher;
		this.footer = foot;
		
		chercher = new JButton("Analyse");
		chercher.addActionListener(new AfficheListener());
		
		add(propo);
		add(saisie);
		add(chercher);
		
		this.setBounds(0,0,1080,700);
		
		propo.setLocation(240, 635);
		saisie.setLocation(500, 635);
		chercher.setLocation(700, 635);
		
		propo.setSize(250, 50);		
		propo.setText("Saisir un brin constitué de A,C,G ou T:");
		
		sequence=saisie.getText();
		
	}
	
	/**@see ActionListener*/
	class AfficheListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			removeAll();
			repaint();
			revalidate();
			add(new ReplicationActivity(footer));
			}

		}
		
	
}
	

