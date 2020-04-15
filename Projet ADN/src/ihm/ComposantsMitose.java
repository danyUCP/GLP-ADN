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

import ADN.Chromosome;

public class ComposantsMitose extends JLabel implements Runnable {
	
	private ComposantsMitose instance=this;
	private Telophase telophase1= new Telophase();
	
	/*----Execution---*/
	private boolean stop;
	private boolean suite;
	private boolean suite2;
	private static final int duplicadn = 2000;
	private static final int timing = 300;
	
	/*---Opacité---*/
	private float alpha = 1.0f;
    private float delta = 0.01f;
    
    private float centriop = 1.0f;
    private float centriop2 = 0.01f;
    private float actine = 0.01f;    
    private float decond1 = 0.01f;
    private float decond2 = 0.01f;
    private float membranenuc = 0.01f;
    private float dchrom = 0.01f;
    private float microtub = 1.0f;
    private float indice = 0.01f;
    
    public Image img1;
    public Image img2;
    
    public Image img3;
    
    public Image img4;
    public Image img5;
    
    public Image img6;
    public Image img7;
    
    public Image img8;
    public Image img9;

    public Image img10;
    
    private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
    
    
    Chromosome chromosome1= new Chromosome("Chrom1");
	//private String cellule = new JLabel("Cellule et sa membrane");
	private JLabel microtubules = new JLabel("Microtubule");
	private JLabel centrioles = new JLabel("Centriole");
	private JLabel nucleaire = new JLabel("Enveloppe nucléaire");
	
	public ComposantsMitose() {
		// TODO Auto-generated constructor stub
		super();
		this.chromosome1=chromosome1;
		this.stop = true;
		this.suite=false;
		this.suite2=false;	
		this.setBounds(0, 0, 1080, 700);
		

		
	}	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		 
		 /**--Ensemble des éléments Mitotique--*/		 
		 
		/*-------Cellule et sa Membrane--------*/
		g2d.setFont(font);
		
		/**---Indice Cellule--*/
		g2d.setColor(Color.BLACK);
		g2d.drawString("Cellule et sa membrane", MitosePara.membraneposX+50, MitosePara.membraneposY-50);
		 
		g2d.setColor(new Color(253, 208, 234));
		g2d.fillOval(MitosePara.membraneposX-50, MitosePara.membraneposY-20, MitosePara.membraneposX+790,MitosePara.membraneposY+420);
		g2d.setColor(new Color(197,46,163));
	    g2d.drawOval(MitosePara.cellposX-50, MitosePara.cellposY-20, MitosePara.cellposX+790, MitosePara.cellposY+420);
	    
	    
	    try {
	    	
	    	/*---Centrioles---*/
	    	
	    	 img1 = ImageIO.read(new File("centriole.png"));
	    	 img2 = ImageIO.read(new File("centriole2.png"));
	    	
	    	/*---Décondensé---*/
		    
	    	/**---Membrane nucléaire---*/
	    	
	    	 img3 = ImageIO.read(new File("membnucl.png"));
	    	
	    	/**---ADN décondensé---*/
	    	
	    	img4 = ImageIO.read(new File("noncond.png"));
	    	
	        img5 = ImageIO.read(new File("noncond2.png"));
	      
	        /*---Condensé---*/
	        
	        /**---Chromosomes gauches---*/
	        
	        img6 = ImageIO.read(new File("chro1mit.png"));
	        img7 = ImageIO.read(new File("crossing1.png"));
	        
	        /**---Chromosomes droites---*/
	        
	        img8 = ImageIO.read(new File("chro2mit.png"));
	        img9 = ImageIO.read(new File("crossing2.png"));
	        
	        img10 = ImageIO.read(new File("actine.png"));
	        
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    
	    
	    /*--------Centrioles au centre AU DEPART--------*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(centriop));
	    g2d.drawImage(img1, MitosePara.centri1posX, MitosePara.centri1posY+140,80,140, this);
	    g2d.drawImage(img2, MitosePara.centri2posX, (MitosePara.centri2posY*2)+180, 140, 80, this);
	    
	    /*---Centrioles Répliquées---*/
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(centriop2));
	    
	    	/**--Indice centriole--*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Centrioles",MitosePara.centri1bisposX+70, MitosePara.centri2bisposY);
	    	/**---CentriRep 2---*/
	    g2d.drawImage(img2, MitosePara.centri2bisposX, MitosePara.centri2bisposY, 140, 80, this);

	    	/**---CentriRep1---*/
	    g2d.drawImage(img1, MitosePara.centri1bisposX, MitosePara.centri1bisposY,80,140, this);        
	    
	    /*---Chromosomes décondensés---*/
	    
	    	/**---Membrane nucleaire---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(membranenuc));	
	    g2d.drawImage(img3, MitosePara.decondensX, MitosePara.decondensY1, this);
	    
	    	/**---Décondensé 1---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(decond1));
	    g2d.drawImage(img4, MitosePara.decondensX+15, MitosePara.decondensY1+10, this);
	    
	     	/**---Décondensé répliqué---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(decond2));	
	    g2d.drawImage(img5, MitosePara.decondensX+5, MitosePara.decondensY2, this);
		      
	    		/**--Indice ADN non condensé--*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("ADN décondensé", MitosePara.decondensX+330, MitosePara.decondensY2);

		
	    /*---Chromosomes condensés----**/
	       
	    	/**---Chromosomes gauche--*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(dchrom));	    
	    g2d.drawImage(img6, MitosePara.condensX,MitosePara.alignchro1Y,100,65, this);
	    g2d.drawImage(img6, MitosePara.condensX2, MitosePara.condensY2,100,65, this);
	    g2d.drawImage(img7, MitosePara.condensX3, MitosePara.condensY3,100,65, this);
	    g2d.drawImage(img6, MitosePara.condensX, MitosePara.condensY4,100,65, this);
	     
	    
	    	/**---Chromosomes droite---*/
	    
	    g2d.drawImage(img8, MitosePara.condensbisX,MitosePara.condensbY1,100,65, this);
	    g2d.drawImage(img8, MitosePara.condensbisX2, MitosePara.condensbY2,100,65, this);
	    g2d.drawImage(img9, MitosePara.condensbisX2, MitosePara.condensbY3,100,65, this);
	    g2d.drawImage(img8, MitosePara.condensbisX, MitosePara.condensbY4,100,65, this);
	     
	    
	    /*---------Microtubules schematises--------------*/
	    
	    
	    	/**--Indice microtubule--*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(indice));	
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Microtubules", 240, 230);
		
		
	    	/**---Microtubules de gauche---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(microtub));	
		g2d.setColor(new Color(197,46,163));
	    g2d.drawLine(230, 280, MitosePara.mt1posX, MitosePara.mt1posY);
	    g2d.drawLine(230, 300, MitosePara.mt2posX, MitosePara.mt2posY);
	    g2d.drawLine(250, 390, MitosePara.mt3posX, MitosePara.mt3posY);
	    g2d.drawLine(250, 415, MitosePara.mt4posX, MitosePara.mt4posY);
	    
	    
	    	/**---Microtubules de droite---*/
	    g2d.drawLine(870, 280, MitosePara.mt1bisposX, MitosePara.mt1bisposY);
	    g2d.drawLine(870, 300, MitosePara.mt2bisposX, MitosePara.mt2bisposY);
	    g2d.drawLine(850, 390, MitosePara.mt3bisposX, MitosePara.mt3bisposY);
	    g2d.drawLine(850, 415, MitosePara.mt4bisposX, MitosePara.mt4bisposY);

	    /*------------------Anneau d'actine----------------------*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(actine));
	    
	    g2d.drawImage(img3, MitosePara.finaltmtchroX-70, MitosePara.finalmtchroY-70, this);
	    g2d.drawImage(img3, MitosePara.finalbistmtchroX-170, MitosePara.finalbismtchroY-70, this);
	    g2d.drawImage(img10, MitosePara.actineX+40, MitosePara.actineY-30,80,555, this);

	    
	    	/**--Indice actine---*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Actine", MitosePara.actineX+40, MitosePara.actineY-50);
	    	    	
	    	/**--Indice nucleaire---*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Enveloppe nucléire", MitosePara.finaltmtchroX-70, MitosePara.finalmtchroY-90);
	  } 
	
	 
	public void duplicCentri() {
		centriop2=alpha;
		indice=1.0f;
		repaint();
		
	}
	
	public void adndecondens() {
		
			if (MitosePara.centri1posX==MitosePara.micentriX-45) {	
				membranenuc=alpha;
					decond1=alpha;
					try {
						Thread.sleep(duplicadn-1000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			
			if (MitosePara.centri1posX==MitosePara.mi2centriX-60) {
				decond2=alpha;
				try {
					Thread.sleep(duplicadn);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			 }
		}

		public void prophase() {
			decond1=0.01f;
			decond2=0.01f;
			dchrom=alpha;
				
		}

		
		public void deplCentrioles() {
			
			if (MitosePara.centri1posX!=MitosePara.centri1finalX) {
				MitosePara.centri1posX=MitosePara.centri1posX-15;
				adndecondens();
			}
			if (MitosePara.centri2posX!=(MitosePara.centri2finalX)) {
				MitosePara.centri2posX+=11;							
			}				
			repaint();
		}
		
		
		public void deplaceChromosomes() {
				/*---Chromosomes gauches---*/
			if((MitosePara.condensX>MitosePara.alignchroX)) {
				MitosePara.condensX-=10;
			}
			
			if((MitosePara.condensX<=475)&&(MitosePara.condensX>=465)) {
				membranenuc=0.01f;
				try {
					Thread.sleep(duplicadn-1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			
			if((MitosePara.condensX2>MitosePara.alignchroX)) {
				MitosePara.condensX2-=20;
			}
			
			if((MitosePara.condensX3>MitosePara.alignchroX)) {
				MitosePara.condensX3-=20;
			}
			
				/*---Chromosomes droites---*/
			
			if((MitosePara.condensbisX<=MitosePara.alignchrobisX)) {
				MitosePara.condensbisX+=10;
			}
			
			if((MitosePara.condensbisX2<=MitosePara.alignchrobisX)) {
				MitosePara.condensbisX2+=10;
			}
			
				/*---Positions ordonnées---*/
					
					/*--gauche--*/
			if(MitosePara.condensY2>MitosePara.alignchro2Y) {
				MitosePara.condensY2--;
			}			
			
			if (MitosePara.condensY3<MitosePara.alignchro3Y) {
				MitosePara.condensY3+=13;				
			}
			
			if(MitosePara.condensY4<MitosePara.alignchro4Y) {
				MitosePara.condensY4+=5;
			}
			
					/*--Droite--*/
			if(MitosePara.condensbY2>MitosePara.alignchro2Y) {
				MitosePara.condensbY2--;
			}
			
			if (MitosePara.condensbY3<MitosePara.alignchro3Y) {
				MitosePara.condensbY3+=13;				
			}
			
			if(MitosePara.condensbY4<MitosePara.alignchro4Y) {
				MitosePara.condensbY4+=5;
			}
			
			
		}
		
		public void migreChromosome() {
			/*---Chromosomes gauches---*/
			if((MitosePara.condensX>=MitosePara.finaltmtchroX)) {
				MitosePara.condensX-=10;
			}
			
			if((MitosePara.condensX2>=MitosePara.finalchroX2)) {
				MitosePara.condensX2-=20;
			}
			
			if((MitosePara.condensX3>=MitosePara.finalchroX2)) {
				MitosePara.condensX3-=20;
			}
			
			/*---Chromosomes droites---*/
			
			if((MitosePara.condensbisX<MitosePara.finalbistmtchroX)) {
				MitosePara.condensbisX+=20;
			}
			
			if((MitosePara.condensbisX2<MitosePara.finalbischroX2)) {
				MitosePara.condensbisX2+=10;
			}
			
			/*---Positions ordonnées---*/
			
				/*--Gauche--*/
			
			if(MitosePara.alignchro1Y<=MitosePara.finalmtchroY) {
				MitosePara.alignchro1Y+=10;
			}
			
			if(MitosePara.condensY2>=MitosePara.finalmtchroY) {
				MitosePara.condensY2--;
			}
	
			if (MitosePara.condensY3<=MitosePara.finalmtchroY2) {
				MitosePara.condensY3+=13;				
			}
	
			if(MitosePara.condensY4!=MitosePara.finalmtchroY2) {
				MitosePara.condensY4-=10;
			}

				/*--Droite--*/
			
			if(MitosePara.condensbY1<MitosePara.finalbismtchroY) {
				MitosePara.condensbY1+=10;
			}
			
			if(MitosePara.condensbY2>MitosePara.finalbismtchroY) {
				MitosePara.condensbY2--;
			}
	
			if (MitosePara.condensbY3<MitosePara.finalbismtchroY2) {
				MitosePara.condensbY3+=13;				
			}
	
			if(MitosePara.condensbY4!=MitosePara.finalbismtchroY2) {
				MitosePara.condensbY4-=10;
			}
			
			/**----Passage à la télophase---*/
			if((MitosePara.condensX<MitosePara.finaltmtchroX)) {
				centriop=delta;
				centriop2=delta;
				actine=alpha;
				stop=false;
			}
			

		}
		
		public void retourMt() {
			/*--Cote gauche--*/
			if ((MitosePara.mt1posX>=MitosePara.retourmtposX) ){
				MitosePara.mt1posX-=20;
			}
			if (MitosePara.mt1posY<=MitosePara.retourmtposY1) {
				MitosePara.mt1posY+=2;
			}
			
			if ((MitosePara.mt2posX>=MitosePara.retourmtposX)) {
				MitosePara.mt2posX-=20;				
			}
			if (MitosePara.mt2posY>=MitosePara.retourmtposY2) {
				MitosePara.mt2posY-=5;
			}
			
			if ((MitosePara.mt3posX>=MitosePara.retourmt2posX)) {
				MitosePara.mt3posX-=20;
			}
			if (MitosePara.mt3posY>=MitosePara.retourmtposY3) {
				MitosePara.mt3posY+=2;
			}
			
			if ((MitosePara.mt4posX>=MitosePara.retourmt2posX)) {
				MitosePara.mt4posX-=20;
			}
			if (MitosePara.mt4posY>=MitosePara.retourmtposY4){
				MitosePara.mt4posY-=5;
			}
			
			/*--Coté droit--*/
		
			if ((MitosePara.mt1bisposX<MitosePara.retourmtbisposX)) {
				MitosePara.mt1bisposX+=20;
				
			}
			if (MitosePara.mt1bisposY<MitosePara.retourmtposY1) {
				MitosePara.mt1bisposY+=2;
			}
			
			if ((MitosePara.mt2bisposX<MitosePara.retourmtbisposX)) {
				MitosePara.mt2bisposX+=20;		
			}
			if (MitosePara.mt2bisposY<MitosePara.retourmtposY2) {
				MitosePara.mt2bisposY-=5;
			}
			
			if ((MitosePara.mt3bisposX<MitosePara.retourmt2bisposX)) {
				MitosePara.mt3bisposX+=20;
			}
			if (MitosePara.mt3bisposY<MitosePara.retourmtposY3) {
				MitosePara.mt3bisposY+=2;
			}
			
			if ((MitosePara.mt4bisposX<MitosePara.retourmt2bisposX)) {
				MitosePara.mt4bisposX+=20;
				
			}
			if (MitosePara.mt4bisposY<MitosePara.retourmtposY4) {
				MitosePara.mt4bisposY-=5;
			}

			
			repaint();
		}
		
		public void anaphase() {
			migreChromosome();
			retourMt();
		}
		
		public void deplaceMt() {
			/*--Coté gauche--*/
			if ((MitosePara.mt1posX<MitosePara.finalmtposX) ){
				MitosePara.mt1posX+=20;
			}
			if (MitosePara.mt1posY>MitosePara.finalmtposY1) {
				MitosePara.mt1posY-=2;
			}
			
			if ((MitosePara.mt2posX<MitosePara.finalmtposX)) {
				MitosePara.mt2posX+=20;				
			}
			if (MitosePara.mt2posY<MitosePara.finalmtposY2) {
				MitosePara.mt2posY+=5;
			}
			
			if ((MitosePara.mt3posX<MitosePara.finalmtposX)) {
				MitosePara.mt3posX+=20;
			}
			if (MitosePara.mt3posY>MitosePara.finalmtposY3) {
				MitosePara.mt3posY-=2;
			}
			
			if ((MitosePara.mt4posX<MitosePara.finalmtposX)) {
				MitosePara.mt4posX+=20;
			}
			if (MitosePara.mt4posY<MitosePara.finalmtposY4){
				MitosePara.mt4posY+=5;
			}
			
			/*--Coté droit--*/
		
			if ((MitosePara.mt1bisposX>MitosePara.finalmtbposX)) {
				MitosePara.mt1bisposX-=20;
				
			}
			if (MitosePara.mt1bisposY>MitosePara.finalmtposY1) {
				MitosePara.mt1bisposY-=2;
			}
			
			if ((MitosePara.mt2bisposX>MitosePara.finalmtbposX)) {
				MitosePara.mt2bisposX-=20;		
			}
			if (MitosePara.mt2bisposY<MitosePara.finalmtposY2) {
				MitosePara.mt2bisposY+=5;
			}
			
			if ((MitosePara.mt3bisposX>MitosePara.finalmtbposX)) {
				MitosePara.mt3bisposX-=20;
			}
			if (MitosePara.mt3bisposY>MitosePara.finalmtposY3) {
				MitosePara.mt3bisposY-=2;
			}
			
			if ((MitosePara.mt4bisposX>MitosePara.finalmtbposX)) {
				MitosePara.mt4bisposX-=20;
				
			}
			if (MitosePara.mt4bisposY<MitosePara.finalmtposY4) {
				MitosePara.mt4bisposY+=5;
			}
			
			/**---Permet le passage à l'anaphase---*/
			if (MitosePara.mt1posY<=MitosePara.finalmtposY1) {
				indice=0.01f;
				microtub=0.01f;
				suite=true;
			}
			repaint();
			
		}
		
		
		
		public void run() {
			
			while(stop) {
				deplCentrioles();
				if (MitosePara.centri2posX==MitosePara.centri2finalX) {
					duplicCentri();
					prophase();
					
					if(dchrom==alpha) {
						deplaceChromosomes();		
						deplaceMt();
						if(suite==true) {
							anaphase();
						}
						
					}
				}
				try {
					Thread.sleep(timing);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			
			}
			
		}
		
	}
	


