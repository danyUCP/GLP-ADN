package ihm;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ADN.Chromatide;
import ARN.BrinADN;
import ihm.synthese.BrinBuilder;

public class CrossingOver extends JPanel implements Runnable {

	private JPanel foot;
	private CrossingOver instance=this;
	
	/*----Execution---*/
	private Thread thread;
	private JButton lancement;
	private boolean stop;
	private boolean suite;
	private static final int duplicadn = 2000;
	private static final int timing = 100;
	
	
	public float delta=0.01f;
	public float alpha=1.0f;
	public float com=0.01f;
	
	private BrinADN brin;
	private BrinADN brinCros;
	
	private JLabel brinLabel;
	private JLabel brinLabel2;
	
	private JLabel brinLabel3;
	private JLabel brinLabel4;
	
	private BrinBuilder builder;
	private BrinBuilder builder2;
	
	private BrinBuilder builder3;
	private BrinBuilder builder4;
	
	private JLabel brinCrosLabel;
	private BrinBuilder buildercros;
	
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private Image img1;
	private Image img2;
	
	private int X;
	
	/**@see ADN.Chromatide*/
	
	Chromatide brin1= new Chromatide("Brin1");
	Chromatide brin2= new Chromatide("Brin2");

	Chromatide brin1b= new Chromatide("Brin1 répliqué");
	Chromatide brin2b= new Chromatide("Brin2 répliqué");

	/**constructeur*/
	public CrossingOver(JPanel foot) {
		// TODO Auto-generated constructor stub
		super(null);
		
		this.stop = true;	
		this.suite = false;	
		this.X=X;
		
		this.setBounds(0, 0, 1080, 700);
		this.setBackground(Color.WHITE);
		this.foot = foot;
		foot.setBackground(Color.CYAN);
		lancement = new JButton("Lancement");
		lancement.addActionListener(new LanceListener());
		foot.add(lancement);
		
		affichebrins();
		
	}
	
	/**Instanciation des chaines 
	 * @see BrinBuilder 
	 * @see ARN.Chaine.getBrinComplem()
	 * et ajout des brins labels
	 */
	public void affichebrins() {
		this.brin=new BrinADN("AGGTAATGCGATATGAACTCGTAAGTCGCG");
		this.brinCros=new BrinADN("GAAGCCGA");
		this.builder=new BrinBuilder(brin, true);
		this.brinLabel=builder.creerBrin(0, -4);
		this.add(brinLabel);
		
		this.builder2=new BrinBuilder(brin.getBrinComplem(), false);
		this.brinLabel2=builder2.creerBrin(0, -2);
		this.add(brinLabel2);
		

		this.buildercros=new BrinBuilder(brinCros,false );
		this.brinCrosLabel=buildercros.creerBrin(0, -3);
		brinCrosLabel.setLocation(0, -100);
		this.add(brinCrosLabel);
		
		this.builder3=new BrinBuilder(brin.getBrinComplem().getBrinComplem().getBrinComplem(),false );
		this.brinLabel3=builder3.creerBrin(0, -3);
		brinLabel3.setLocation(0, -100);
		this.add(brinLabel3);
		
		
		this.builder4=new BrinBuilder(brin.getBrinComplem().getBrinComplem(),true );
		this.brinLabel4=builder4.creerBrin(0, 2);
		brinLabel4.setLocation(0, -100);
		this.add(brinLabel4);
	}
	
	/**Signale pour passage à la réplicationdes des brin
	 * Via brinLabel2.setLocation(x,y) separation d'un brin avant relication
	 */
	public void ruptureLiaisons() {
		while(X<1080) {
			X+=100;
			repaint();
		}
		if(X>1080) {
			brinLabel2.setLocation(0, 500);
			suite=true;
		}
	}
	
	/** Affichage (via set.Location(x,y) des brinc repliques*/
	public void replication() {
		
		if(suite==true) {
			brinLabel3.setLocation(0, 130);
			brinCrosLabel.setLocation(0, 130);
			brinLabel4.setLocation(0, 400);
			com=alpha;
		}
		if(X==0) {
			stop=false;
		}
		
	}

	/**@class Lance Listener*/
	private class LanceListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			if (!stop) {
				stop = true;
				lancement.setText(" Lancement ");
				
			} else {
				stop = false;
				lancement.setText("En arrêt");
				thread = new Thread(instance);				
				thread.start();
				}

		}
		
	}
			/**Affichage d'elements*/
			public void paintComponent(Graphics g) {
					
			super.paintComponent(g);
			
			 Graphics2D g2d = (Graphics2D)g;
			 
			 try {
			    	 img1 = ImageIO.read(new File("helicase.png"));
			    	 img2 = ImageIO.read(new File("liaison.png"));
			        
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			    
			
			 
			 
			g2d.setFont(font);
			g2d.setComposite(AlphaComposite.SrcOver.derive(delta));
			g2d.drawImage(img1, X, 150, this);
			g2d.drawImage(img2, X+40, 150,700,100, this);
			
			System.out.println(X);
			g2d.setComposite(AlphaComposite.SrcOver.derive(com));
			g2d.drawString(brin1.getName(),0,25);
			g2d.drawString(brin2.getName()+"séparé du brin1",0,610);

			g2d.drawString(brin1b.getName(),0,370);
			g2d.drawString(brin2b.getName(),0, 250);
			
			
			g2d.setColor(Color.RED);
			g2d.drawRect(0, 100, 300, 130);
			
			g2d.drawString("Le brin encadré correspond ", 300, 280);
			g2d.drawString("-> portion d'ADN échange lors duplication ADN decondense", 300, 300);
			g2d.drawString("A ne va pas avec T, ni C avec G", 300, 320);
			g2d.drawString("-> résultat modification génétique bonne ou mauvaise", 300, 340);
			

			
			}
		
		/**Run permettant le lancement*/
		public void run() {
			
			while(!stop) {
				ruptureLiaisons();
				replication();
				stop=false;
			}
			try {
				Thread.sleep(duplicadn);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			repaint();
			
		}
		
		
	}
	

