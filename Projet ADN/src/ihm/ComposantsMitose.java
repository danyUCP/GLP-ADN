
package ihm;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import ADN.Chromosome;

public class ComposantsMitose extends JLabel implements Runnable {
	
	private ComposantsMitose instance=this;
	private Telophase telophase1= new Telophase();
	
	/**----Execution---*/
	private boolean stop;
	private boolean suite;
	private boolean suite2;
	private static final int duplicadn = 2000;
	private static final int timing = 300;
	
	/**---Opacite---*/
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
    
    private float com1 = 1.0f;
    private float com1b = 1.0f;
    private float com2 = 0.01f;
    private float com3 = 0.01f;
    private float com4 = 0.01f;
    private float com5 = 0.01f;
    
    
    
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
	
    
    /**@see ADN.Chromosome
     * recupere les chromosomes*/
    Chromosome chro1= new Chromosome("Chrom1");
    Chromosome chro2= new Chromosome("Chrom2");
    Chromosome chro3= new Chromosome("Chrom3");
    Chromosome chro4= new Chromosome("Chrom4");
    
    Chromosome chro1b= new Chromosome("Chrom1 replique");
    Chromosome chro2b= new Chromosome("Chrom2 replique");
    Chromosome chro3b= new Chromosome("Chrom3 replique");
    Chromosome chro4b= new Chromosome("Chrom4 replique");
    
    
   
    
 
    /**Constructeur*/
	public ComposantsMitose() {
		// TODO Auto-generated constructor stub
		super();
		this.stop = true;
		this.suite=false;
		this.suite2=false;	
		this.setBounds(0, 0, 1080, 700);
		repaint();
		revalidate();

		
	}	

	/**affichage des elements organiques*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		 
		 /**--Ensemble des elements Mitotique--*/		 
		 
		/**-------Cellule et sa Membrane--------*/
		g2d.setFont(font);
		
		/**---Indice Cellule--*/
		g2d.setColor(Color.BLACK);
		g2d.drawString("Cellulse et sa membrane", MitosePara.membraneposX+50, MitosePara.membraneposY-50);
		 
		g2d.setColor(new Color(253, 208, 234));
		g2d.fillOval(MitosePara.membraneposX-50, MitosePara.membraneposY-20, MitosePara.membraneposX+790,MitosePara.membraneposY+420);
		g2d.setColor(new Color(197,46,163));
	    g2d.drawOval(MitosePara.cellposX-50, MitosePara.cellposY-20, MitosePara.cellposX+790, MitosePara.cellposY+420);
	    
	    
	    try {
	    	
	    	/**---Centrioles---*/
	    	
	    	 img1 = ImageIO.read(new File("centriole.png"));
	    	 img2 = ImageIO.read(new File("centriole2.png"));
	    	
	    	/**---Decondense---*/
		    
	    	/**---Membrane nucleaire---*/
	    	
	    	 img3 = ImageIO.read(new File("membnucl.png"));
	    	
	    	/**---ADN decondense---*/
	    	
	    	img4 = ImageIO.read(new File("noncond.png"));
	    	
	        img5 = ImageIO.read(new File("noncond2.png"));
	      
	        /**---Condense---*/
	        
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
	    
	    
	    /**--------Centrioles au centre AU DEPART--------*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(centriop));
	    
	    /**--Indice centriole--*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Centrioles",MitosePara.centri1posX-120, MitosePara.centri1posY+160);

	    g2d.drawImage(img1, MitosePara.centri1posX, MitosePara.centri1posY+140,80,140, this);
	    g2d.drawImage(img2, MitosePara.centri2posX, (MitosePara.centri2posY*2)+180, 140, 80, this);
	    
	    /**---Centrioles Repliquees---*/
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(centriop2));
	    
	       	/**---CentriRep 2---*/
	    g2d.drawImage(img2, MitosePara.centri2bisposX, MitosePara.centri2bisposY, 140, 80, this);

	    	/**---CentriRep1---*/
	    g2d.drawImage(img1, MitosePara.centri1bisposX, MitosePara.centri1bisposY,80,140, this);        
	    
	    /**---Chromosomes decondenses---*/
	    
	    	/**---Membrane nucleaire---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(membranenuc));	
	    g2d.drawImage(img3, MitosePara.decondensX, MitosePara.decondensY1, this);
	    
	    	/**---Decondense 1---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(decond1));
	    g2d.drawImage(img4, MitosePara.decondensX+15, MitosePara.decondensY1+10, this);
	    
	     	/**---Decondense replique---*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(decond2));	
	    g2d.drawImage(img5, MitosePara.decondensX+5, MitosePara.decondensY2, this);
		      
	    		/**--Indice ADN non condense--*/
	    
	    g2d.setColor(Color.BLACK);
		g2d.drawString("ADN decondense", MitosePara.decondensX+330, MitosePara.decondensY2-40);
	    
	    g2d.setColor(Color.BLACK);
		g2d.drawString("ADN decondense Replique", MitosePara.decondensX+330, MitosePara.decondensY2+20);

		
	    /**---Chromosomes condenses----**/
	       
	    	/**---Chromosomes gauche--*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(dchrom));	 
	    
	    	/**--Indices chromosomique gauche--*/
	    g2d.setColor(Color.BLACK);
	    /**appel des chromosomes via @see Chromosome.getName()*/
		g2d.drawString(chro1.getName(), MitosePara.condensX+5, MitosePara.alignchro1Y-10);
		g2d.drawString(chro2.getName(), MitosePara.condensX2+5, MitosePara.condensY2-10);
		g2d.drawString(chro3.getName(), MitosePara.condensX3+5, MitosePara.condensY3-10);
		g2d.drawString(chro4.getName(), MitosePara.condensX+5, MitosePara.condensY4-10);

	    
	    g2d.drawImage(img6, MitosePara.condensX,MitosePara.alignchro1Y,100,65, this);
	    g2d.drawImage(img6, MitosePara.condensX2, MitosePara.condensY2,100,65, this);
	    g2d.drawImage(img7, MitosePara.condensX3, MitosePara.condensY3,100,65, this);
	    g2d.drawImage(img6, MitosePara.condensX, MitosePara.condensY4,100,65, this);
	     
	    
	    	/**---Chromosomes droite---*/
	    
	    	/**--Indice chromosomique droit--*/
	    
		g2d.drawString(chro1b.getName(), MitosePara.condensbisX+5, MitosePara.condensbY1-10);
		g2d.drawString(chro2b.getName(), MitosePara.condensbisX2+5, MitosePara.condensbY2-10);
		g2d.drawString(chro3b.getName(), MitosePara.condensbisX2+5, MitosePara.condensbY3-10);
		g2d.drawString(chro4b.getName(), MitosePara.condensbisX+5, MitosePara.condensbY4-10);
	    
	    g2d.drawImage(img8, MitosePara.condensbisX,MitosePara.condensbY1,100,65, this);
	    g2d.drawImage(img8, MitosePara.condensbisX2, MitosePara.condensbY2,100,65, this);
	    g2d.drawImage(img9, MitosePara.condensbisX2, MitosePara.condensbY3,100,65, this);
	    g2d.drawImage(img8, MitosePara.condensbisX, MitosePara.condensbY4,100,65, this);
	     
	    
	    /**---------Microtubules schematises--------------*/
	    
	    
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
		g2d.drawString("Noyaux1", MitosePara.finaltmtchroX-70, MitosePara.finalmtchroY-90);
	    g2d.drawString("Noyaux2", MitosePara.finalbistmtchroX-170, MitosePara.finalbismtchroY-90);
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com1));
	    g2d.drawString(" INTERPHASE:",0, MitosePara.centri2bisposY+150);
	    g2d.drawString(" phase G1: Separation des centrioles",0, MitosePara.centri2bisposY+180);
	    g2d.drawString(" phase S: Duplication des centrioles et de l'ADN non condense",0, MitosePara.centri2bisposY+210);
	    g2d.drawString(" G2: Controle de bonne replication, sinon: Anomalies, cancer...",0, MitosePara.centri2bisposY+250);
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com2));
	    g2d.drawString(" PROPHASE:",0, MitosePara.centri2bisposY+150);
	    g2d.drawString("Condensation des chromosomes",0, MitosePara.centri2bisposY+180);
	     
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com3));
	    g2d.drawString(" PROMETAPHASE:",0, MitosePara.centri2bisposY+120);
	    g2d.drawString(" Suppression membrane nucleaire",0, MitosePara.centri2bisposY+150);
	    g2d.drawString(" Alignement chromosomique",0, MitosePara.centri2bisposY+180);
	    g2d.drawString(" METHAPHASE",0, MitosePara.centri2bisposY+225);
	    g2d.drawString(" Signale des microtubules",0, MitosePara.centri2bisposY+250);
	
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com4));
	    g2d.drawString(" ANAPHASE:",0, MitosePara.centri2bisposY+210);
	    g2d.drawString(" Migration des chromosomes vers les poles",0, MitosePara.centri2bisposY+240);
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com5));
	    g2d.drawString(" TELOPHASE:",0, MitosePara.centri2bisposY+150);
	    g2d.drawString(" Deux noyaux apparaissent",0, MitosePara.centri2bisposY+180);
	    g2d.drawString(" Cytokynese: apparition d'anneau d'actine qui coupe la cellule en deux ",0, MitosePara.centri2bisposY+210);
	
	} 
	
	/**Permet duplication des centrioles*/ 
	public void duplicCentri() {
		centriop2=alpha;
		indice=1.0f;
		repaint();
		
	}
	
	/**Affiche ADN decondense et enveloppe nucleaire*/
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
		
		/**Condensation des chromosomes*/
		public void prophase() {
			decond1=0.01f;
			decond2=0.01f;
			dchrom=alpha;
				
		}

		/**deplament centrioles pendant interphase*/
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
		
		/**methaphase*/
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
			
				/**---Chromosomes droites---*/
			
			if((MitosePara.condensbisX<=MitosePara.alignchrobisX)) {
				MitosePara.condensbisX+=10;
			}
			
			if((MitosePara.condensbisX2<=MitosePara.alignchrobisX)) {
				MitosePara.condensbisX2+=10;
			}
			
				/**---Positions ordonnees---*/
					
					/**--gauche--*/
			if(MitosePara.condensY2>MitosePara.alignchro2Y) {
				MitosePara.condensY2--;
			}			
			
			if (MitosePara.condensY3<MitosePara.alignchro3Y) {
				MitosePara.condensY3+=13;				
			}
			
			if(MitosePara.condensY4<MitosePara.alignchro4Y) {
				MitosePara.condensY4+=5;
			}
			
					/**--Droite--*/
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
		
		/**Anaphase*/
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
			
			/**---Chromosomes droites---*/
			
			if((MitosePara.condensbisX<MitosePara.finalbistmtchroX)) {
				MitosePara.condensbisX+=20;
			}
			
			if((MitosePara.condensbisX2<MitosePara.finalbischroX2)) {
				MitosePara.condensbisX2+=10;
			}
			
			/**---Positions ordonnees---*/
			
				/**--Gauche--*/
			
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
			
			/**----Passage a  la telophase---*/
			if((MitosePara.condensX<MitosePara.finaltmtchroX)) {
				com4=delta;
				com5=alpha;
				centriop=delta;
				centriop2=delta;
				actine=alpha;
				stop=false;
			}
			

		}
		
		/**@see migreChromosome()*/
		public void anaphase() {
			migreChromosome();
		}
		
		/**Signale passage à anaphase*/
		public void deplaceMt() {
			/*--Cote gauche--*/
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
			
			/*--Cote droit--*/
		
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
			
			/**---Permet le passage Ã  l'anaphase---*/
			if (MitosePara.mt1posY<=MitosePara.finalmtposY1) {
				indice=0.01f;
				microtub=0.01f;
				suite=true;
			}
			repaint();
			
		}
		
		
		/**Lance l'animation
		 * @see deplCentrioles();
		 *@see prophase();
		 *@see deplaceChromosomes();		
		 *@see deplaceMt();
		 *@see anaphase()
		 */
		public void run() {
			
			while(stop) {

				deplCentrioles();
				if (MitosePara.centri2posX==MitosePara.centri2finalX) {
					duplicCentri();
					com1=delta;
					com2=alpha;
					prophase();
					com2=delta;
					
					com3=alpha;
					if(dchrom==alpha) {
						deplaceChromosomes();		
						deplaceMt();
						
						if(suite==true) {
							com3=delta;
							com4=alpha;
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
	


