package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class MitoseActivity extends JPanel {

	private JPanel foot;
	private MitoseActivity instance=this;
	
	/*----Execution---*/
	private Thread thread;
	private JButton lancement;
	private boolean stop;
	private static final int duplicadn = 2000;
	private static final int timing = 100;
	
	private ComposantsMitose mitose1;
	private Telophase telo1;
	
	public MitoseActivity(JPanel foot) {
		// TODO Auto-generated constructor stub
		super(null);
		
		mitose1 = new ComposantsMitose();
		telo1= new Telophase();
		
		this.stop = true;
		
		this.add(mitose1);
		
		
		this.foot = foot;
		foot.setBackground(Color.CYAN);
		lancement = new JButton("Lancement");
		lancement.addActionListener(new LanceListener());
		foot.add(lancement);
	}
	
	class LanceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (!stop) {
				stop = true;
				lancement.setText(" Lancement ");
				
			} else {
				stop = false;
				lancement.setText("En arr�t");
				thread = new Thread(new Animation());				
				thread.start();
				}

		}
		
	}
	
	private class Animation implements Runnable {

		private Thread thread2;
		public void run() {
			thread2=new Thread(mitose1);
			thread2.start();
			while(thread2.isAlive()) {
				try {
					Thread.sleep(duplicadn+2000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			}
			
			remove(mitose1);
			add(telo1);
			repaint();
			revalidate();
			
		}

	}
}
