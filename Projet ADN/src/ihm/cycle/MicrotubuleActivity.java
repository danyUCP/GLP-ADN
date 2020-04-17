package ihm.cycle;

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

import ADN.Chromosome;
import ihm.BoutonCommande;
import ADN.Chaine;

public class MicrotubuleActivity extends JPanel implements Runnable {

	private JPanel foot;
	private MicrotubuleActivity instance=this;
	
	/*----Execution---*/
	private Thread thread;
	private BoutonCommande lancement;
	private boolean stop;
	private boolean suite;
	private static final int duplicadn = 2000;
	private static final int timing = 100;
	
	
	public float delta=0.01f;
	public float alpha=1.0f;
	
	public float partie1=0.01f;
	public float partie2=0.01f;
	public float partie1b=0.01f;
	public float partie2b=0.01f;
	public float partie3=0.01f;

	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private Image img1;
	private Image img2;
	private Image img3;
	
	private Chaine chain1= new Chaine("A");
	private Chaine chain2= new Chaine("AAA");
	
	private JLabel pileLabel;
	private JLabel pileLabel2;
	private JLabel pileLabel3;
	private JLabel pileLabel4;
	private JLabel pileLabel5;
	private JLabel pileLabel6;
	
	private ChainBuilder buildpile;
	private ChainBuilder buildpile2;
	private ChainBuilder buildpile3;
	private ChainBuilder buildpile4;
	private ChainBuilder buildpile5;
	private ChainBuilder buildpile6;
	
	/**Constructeur instanciant en partie les label utilisées*/
	public MicrotubuleActivity(JPanel foot) {
		// TODO Auto-generated constructor stub
		super(null);
		
		this.stop = true;	
		this.suite = false;	
		
		this.setBounds(0, 0, 1080, 700);
		this.setBackground(Color.WHITE);
		this.foot = foot;
		foot.setBackground(new Color(28, 28, 28));
		lancement = new BoutonCommande("Lancement");
		lancement.addActionListener(new LanceListener());
		foot.add(lancement);
		
		this.buildpile=new ChainBuilder(chain1, true);
		this.pileLabel=buildpile.creerPile(0, -10);
		this.add(pileLabel);
		
		this.buildpile3=new ChainBuilder(chain1.getComp(), true);
		this.pileLabel3=buildpile3.creerPile(0, -10);
		this.add(pileLabel3);
		
		this.buildpile2=new ChainBuilder(chain2, true);
		this.pileLabel2=buildpile2.creerPile(0, -10);
		this.add(pileLabel2);
		
		this.buildpile4=new ChainBuilder(chain2.getComp(), true);
		this.pileLabel4=buildpile4.creerPile(0, -10);
		this.add(pileLabel4);
		
		this.buildpile5=new ChainBuilder(chain2, true);
		this.pileLabel5=buildpile5.creerPile(0, -10);
		this.add(pileLabel5);
		
		this.buildpile6=new ChainBuilder(chain2.getComp(), true);
		this.pileLabel6=buildpile6.creerPile(0, -10);
		this.add(pileLabel6);
		
	}
	
	


	
	private class LanceListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
		{
			if (!stop) {
				stop = true;
				lancement.setText(" Lancement ");
				
			} else {
				stop = false;
				thread = new Thread(instance);				
				thread.start();
				}

		}
		
	}

			public void paintComponent(Graphics g) {
					
			super.paintComponent(g);
			
			 Graphics2D g2d = (Graphics2D)g;
			 
			 try {
			    	 img1 = ImageIO.read(new File("alpha.png"));
			    	 img2 = ImageIO.read(new File("beta.png"));
			    	 img3 = ImageIO.read(new File("microtubule.png"));
			      } catch (IOException e) {
			        e.printStackTrace();
			      }
			    
			
			 
			 
			g2d.setFont(font);
		//	g2d.setComposite(AlphaComposite.SrcOver.derive(partie1));
			g2d.drawString("Le microtubule donne le signe du passage à l'anaphase: composé de 2 monomères",30,30);
			
			
		//	g2d.setComposite(AlphaComposite.SrcOver.derive(partie2));
			g2d.drawString("Ces monomères formants des polymères forment plusieurs piles comme celles ci:",30,220);
			
		//	g2d.setComposite(AlphaComposite.SrcOver.derive(partie3));
			g2d.drawString("Chaque pile s'accolent alors les unes aux autres :",30,500);
			
			g2d.setColor(Color.RED);
			g2d.drawString("13 piles forment un cylindre de microtubule",30,520);
			g2d.drawString("ALPHA noté alpha dans le rond vers clair, et BETA noté beta rond vert fonce",30,50);
			
			g2d.drawImage(img3, 280, 520,250,150, this);

			
			}
		
			/**Modification position labels servant à la partie 1*/
			public void partie1() {
				pileLabel.setLocation(350, 50);
				pileLabel3.setLocation(350, 90);
			}
		
			/**Modification position labels servant à la partie 2*/
			public void partie2() {
				pileLabel2.setLocation(350, 230);
				pileLabel4.setLocation(350, 275);
				
				pileLabel5.setLocation(350, 317);
				pileLabel6.setLocation(350, 362);
			}
		
			/**Lancement de l'animation
			 * @see partie1()
			 * @see partie2()
			 */
		public void run() {
			
			while(!stop) {
			//	partie1=alpha;
				partie1();
			//	partie2=alpha;
				partie2();
			//	partie3=alpha;
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
	

