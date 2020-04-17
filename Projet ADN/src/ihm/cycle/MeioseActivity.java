package ihm.cycle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ihm.BoutonCommande;
import ihm.CommentLabel;



public class MeioseActivity extends JPanel {

	private JPanel foot;
	private MeioseActivity instance=this;
	
	/**----Execution---*/
	private Thread thread;
	private BoutonCommande lancement;
	private boolean stop;
	private static final int duplicadn = 2000;
	private static final int timing = 100;
	
	private ComposantsMitose mitose1;
	private Telophase telo1;
	private ComposantsMeiose1 meiose1;
	private ComposantsMeiose2 meiose2;
	private Telophasesecond telo2;
	
	private CommentLabel commentaire1;
	
	/**Constructeur instanciant les labels, button, et la variable d'arrêt*/
	public MeioseActivity(JPanel foot) {
		// TODO Auto-generated constructor stub
		super(null);
		
		mitose1 = new ComposantsMitose();
		telo1= new Telophase();
		meiose1= new ComposantsMeiose1();
		meiose2=new ComposantsMeiose2();
		telo2= new Telophasesecond();
		
		this.stop = true;
		
		this.add(mitose1);
		this.commentaire1=new CommentLabel("<html>Meiose1<br> Pertmet d'avoir des cellules<br> "
				+ "genetiquement differentes</html>", 4);
		commentaire1.setBackground(null);
		add(commentaire1);
		
		this.foot = foot;
		foot.setBackground(new Color(28, 28, 28));
		lancement = new BoutonCommande("Lancement");
		lancement.addActionListener(new LanceListener());
		foot.add(lancement);
	}
	
	/**@see ActionListener*/
	class LanceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (!stop) {
				stop = true;
				lancement.setText(" Lancement ");
				
			} else {
				stop = false;
				thread = new Thread(new Animation());				
				thread.start();
				if (!stop) {
					stop = true;
					
				}
			}

		}
		
	}
	
	/**Permet lancement animation via ajout et suppression de JLabel animes*/ 
	private class Animation implements Runnable {

		private Thread thread2;
		public void run() {
			thread2=new Thread(mitose1);
			thread2.start();
			while(thread2.isAlive()) {
				try {
					Thread.sleep(duplicadn+3000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			}
			
			remove(mitose1);
			remove(commentaire1);
			add(telo1);
			remove(telo1);
			remove(commentaire1);
			add(meiose1);
			add(commentaire1);
			commentaire1.setText("<html>Meiose2 cellule 1</html>");
			thread2=new Thread(meiose1);
			thread2.start();
			while(thread2.isAlive()) {
				try {
					Thread.sleep(duplicadn+3000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			}
			remove(meiose1);
			remove(commentaire1);
			add(meiose2);
			add(commentaire1);
			commentaire1.setText("<html>En parallele<br> Meiose2 cellule 2</html>");
			thread2=new Thread(meiose2);
			thread2.start();
			while(thread2.isAlive()) {
				try {
					Thread.sleep(duplicadn+3000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			}
			remove(meiose2);
			add(telo2);
			repaint();
			revalidate(); 
		}

	}
}
