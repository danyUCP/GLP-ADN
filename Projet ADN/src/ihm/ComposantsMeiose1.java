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


public class ComposantsMeiose1 extends JLabel implements Runnable {
	
	
	/**----Execution---*/
	private Thread thread;
	private boolean stop;
	private boolean suite;
	private static final int timing = 300;
	private static final int sec=2000;
	
	/**---OpacitÃ©---*/
	private float alpha = 1.0f;
    private float delta = 0.01f;
    
    private float centriop = 1.0f;
    private float actine = 0.01f;
    private float membranenuc = 1.0f;
    private float microtub = 0.01f;
    private float dchrom = 1.0f;
    
    private float com1 = 1.0f;
    private float com1b = 1.0f;
    private float com2 = 0.01f;
    private float com3 = 0.01f;
    
    public Image img1;
    public Image img2;
    public Image img3;
    
    public Image img6;
    public Image img7;
    
    public Image img8;
    public Image img9;
    
    public Image img10;
    
    private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

    /**Instanciation des Chromatides utilisés dans cette division*/
    Chromatide chro1= new Chromatide("Chrom1");
    Chromatide chro2= new Chromatide("Chrom2");
    Chromatide chro3= new Chromatide("Chrom3");
    Chromatide chro4= new Chromatide("Chrom4");
    
    Chromatide chro1b= new Chromatide("Chrom5");
    Chromatide chro2b= new Chromatide("Chrom6");
    Chromatide chro3b= new Chromatide("Chrom7");
    Chromatide chro4b= new Chromatide("Chrom8");
    

    	/**Constructeur */
	public ComposantsMeiose1() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setBounds(0, 0, 1080, 700);
		this.stop = true;
		this.suite=false;
	}	

		/**Classe d'affichage des elements*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		/*-------Cellule et sa Membrane--------*/
		 g2d.setFont(font);
			
		 	/**---Indice Cellule--*/
		g2d.setColor(Color.BLACK);
		g2d.drawString("Cellule et sa membrane", MeiosePara1.membraneposX+50, MeiosePara1.membraneposY-50);

		 
		g2d.setColor(new Color(253, 208, 234));
		g2d.fillOval(MeiosePara1.membraneposX-50, MeiosePara1.membraneposY-20, MeiosePara1.membraneposX+790,MeiosePara1.membraneposY+420);
		g2d.setColor(new Color(197,46,163));
	    g2d.drawOval(MeiosePara1.cellposX-50, MeiosePara1.cellposY-20, MeiosePara1.cellposX+790, MeiosePara1.cellposY+420);
	    
	    
	    try {
	        img1 = ImageIO.read(new File("centriole.png"));   
	    
	    	/*---Centriole2---*/

	        img2 = ImageIO.read(new File("centriole2.png"));

	    	/*---DÃ©condensÃ©---*/
	    
	    	/**---Membrane nuclÃ©aire---*/

	        img3 = ImageIO.read(new File("membnucl.png"));

	    	/*---Chromosomes---*/

	        img6 = ImageIO.read(new File("chromatide1.png"));

	        img7 = ImageIO.read(new File("chromatide2.png")); 
	    
	    	/*---Chromosomes droites---*/

	        img8 = ImageIO.read(new File("chromatide3.png"));
	        img9 = ImageIO.read(new File("chromatide4.png"));
	        
	        /*---Anneau d'actine---*/
	        
	        img10 = ImageIO.read(new File("actine.png")); 
	        
	     } catch (IOException e) {
	       e.printStackTrace();
	     }       
	    /*--------Centrioles --------*/
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(centriop));
	    g2d.drawImage(img1, MeiosePara1.centri1finalX, MeiosePara1.centri1posY+140,80,140, this);
	    g2d.drawImage(img2, MeiosePara1.centri2finalX, (MeiosePara1.centri2posY*2)+180, 140, 80, this);
	    
	    /*---Centrioles RÃ©pliquÃ©es---*/
	    
			/**--Indice centriole--*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Centrioles",MeiosePara1.centri1bisposX+70, MeiosePara1.centri2bisposY);

	    	/**---CentriRep 2---*/
	    g2d.drawImage(img2, MeiosePara1.centri2bisposX, MeiosePara1.centri2bisposY, 140, 80, this);

	    	/**---CentriRep1---*/
	    g2d.drawImage(img1, MeiosePara1.centri1bisposX, MeiosePara1.centri1bisposY,80,140, this);      
	    
	  	
	    g2d.setComposite(AlphaComposite.SrcOver.derive(membranenuc));	 
	    g2d.drawImage(img3, MeiosePara1.decondensX, MeiosePara1.decondensY1, this);
	    
	    /*---Chromosomes condensÃ©s----**/    
	    	/**---Chromosomes gauche--*/
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(dchrom));
	    
	    	/**--Indices chromosomique gauche--*/
	    
	    g2d.setColor(Color.BLACK);
	    /**Instanciation des chromatides via Chromatides.getName()*/
		g2d.drawString(chro1.getName(), MeiosePara1.condensX, MeiosePara1.alignchro1Y-10);
		g2d.drawString(chro2.getName(), MeiosePara1.condensX2, MeiosePara1.condensY2-10);
		g2d.drawString(chro3.getName(), MeiosePara1.condensX3, MeiosePara1.condensY3-10);
		g2d.drawString(chro4.getName(), MeiosePara1.condensX, MeiosePara1.condensY4-10);

	    
	    g2d.drawImage(img6, MeiosePara1.condensX,MeiosePara1.alignchro1Y,30,65, this);
	    g2d.drawImage(img6, MeiosePara1.condensX2, MeiosePara1.condensY2,30,65, this);
	    g2d.drawImage(img6, MeiosePara1.condensX3, MeiosePara1.condensY3,30,65, this);
	    g2d.drawImage(img6, MeiosePara1.condensX, MeiosePara1.condensY4,30,65, this);
	     
	    
	    	/**---Chromosomes droite---*/
	    	
	    	/**--Indice chromosomique droit--*/
	    
		g2d.drawString(chro1b.getName(), MeiosePara1.condensbisX+5, MeiosePara1.condensbY1-10);
		g2d.drawString(chro2b.getName(), MeiosePara1.condensbisX2+5, MeiosePara1.condensbY2-10);
		g2d.drawString(chro3b.getName(), MeiosePara1.condensbisX2+5, MeiosePara1.condensbY3-10);
		g2d.drawString(chro4b.getName(), MeiosePara1.condensbisX+5, MeiosePara1.condensbY4-10);
	  
	    
	    g2d.drawImage(img7, MeiosePara1.condensbisX,MeiosePara1.condensbY1,30,65, this);
	    g2d.drawImage(img7, MeiosePara1.condensbisX2, MeiosePara1.condensbY2,30,65, this);
	    g2d.drawImage(img8, MeiosePara1.condensbisX2, MeiosePara1.condensbY3,30,65, this);
	    g2d.drawImage(img7, MeiosePara1.condensbisX, MeiosePara1.condensbY4,30,65, this);
	     
	    
	    /**---------Microtubules schematises--------------*/
	    
			/**--Indice microtubule--*/
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(microtub));	
	    
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Microtubules", 240, 230);
		
	    	/**---Microtubules de gauche---*/
		g2d.setColor(new Color(197,46,163));
	    g2d.drawLine(230, 280, MeiosePara1.mt1posX, MeiosePara1.mt1posY);
	    g2d.drawLine(230, 300, MeiosePara1.mt2posX, MeiosePara1.mt2posY);
	    g2d.drawLine(250, 390, MeiosePara1.mt3posX, MeiosePara1.mt3posY);
	    g2d.drawLine(250, 415, MeiosePara1.mt4posX, MeiosePara1.mt4posY);
	    
	    
	    	/**---Microtubules de droite---*/
	    g2d.drawLine(870, 280, MeiosePara1.mt1bisposX, MeiosePara1.mt1bisposY);
	    g2d.drawLine(870, 300, MeiosePara1.mt2bisposX, MeiosePara1.mt2bisposY);
	    g2d.drawLine(850, 390, MeiosePara1.mt3bisposX, MeiosePara1.mt3bisposY);
	    g2d.drawLine(850, 415, MeiosePara1.mt4bisposX, MeiosePara1.mt4bisposY);

	    /*------------------Anneau d'actine----------------------*/
	    g2d.setComposite(AlphaComposite.SrcOver.derive(actine));
	    g2d.drawImage(img10, MeiosePara1.actineX+40, MeiosePara1.actineY-30,80,555, this);
	    g2d.drawImage(img3, MeiosePara1.finaltmtchroX-20, MeiosePara1.finalmtchroY-30,180,150, this);
	    g2d.drawImage(img3, MeiosePara1.finalbistmtchroX-120, MeiosePara1.finalbismtchroY-30,180,150, this);
	    g2d.drawImage(img3, MeiosePara1.finaltmtchroX-20, MeiosePara1.finalmtchroY+110,180,150, this);
	    g2d.drawImage(img3, MeiosePara1.finalbistmtchroX-120, MeiosePara1.finalbismtchroY+110,180,150, this);
	   
	    	/**--Indice actine---*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Actine", MeiosePara1.actineX+40, MeiosePara1.actineY-50);
	    	    	
	    	/**--Indice nucleaire---*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Noyaux1", MeiosePara1.finaltmtchroX-70, MeiosePara1.finalmtchroY-90);
	    g2d.drawString("Noyaux2", MeiosePara1.finalbistmtchroX-170, MeiosePara1.finalbismtchroY-90);
	    g2d.drawString("Noyaux3", MeiosePara1.finaltmtchroX-70, MeiosePara1.finalmtchroY+100);
	    g2d.drawString("Noyaux4", MeiosePara1.finalbistmtchroX-170, MeiosePara1.finalbismtchroY+100);

	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com1));
	    g2d.drawString(" PROMETAPHASE2:",0, MeiosePara1.centri2bisposY+120);
	    g2d.drawString(" Suppression membrane nucleaire",0, MeiosePara1.centri2bisposY+150);
	    g2d.drawString(" Alignement chromosomique",0, MeiosePara1.centri2bisposY+180);
	    g2d.drawString(" METHAPHASE",0, MeiosePara1.centri2bisposY+210);
	    g2d.drawString(" Signale des microtubules",0, MeiosePara1.centri2bisposY+250);
	
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com2));
	    g2d.drawString(" ANAPHASE2:",0, MeiosePara1.centri2bisposY+210);
	    g2d.drawString(" Migration des chromatides vers les poles",0, MeiosePara1.centri2bisposY+240);
	    
	    g2d.setComposite(AlphaComposite.SrcOver.derive(com3));
	    g2d.drawString(" TELOPHASE2:",0, MeiosePara1.centri2bisposY+150);
	    g2d.drawString(" Deux noyaux apparaissent dans chaque nouvelles cellule",0, MeiosePara1.centri2bisposY+180);
	    g2d.drawString(" Cytokynese: apparition d'anneau d'actine qui coupe la cellule en deux ",0, MeiosePara1.centri2bisposY+210);
	
	  } 

		
		/**run du Label Runnable, permet le lancement de l'animation
		 *Lance l'animation
		 * @see deplCentrioles();
		 *@see deplaceChromosomes();		
		 *@see deplaceMt();
		 *@see anaphase()
		 */
		public void run() {
			while(stop) {
					deplaceChromosomes();
					deplaceMt();
					com1=delta;
					if(suite==true) {
						com2=alpha;
						anaphase();
					}		
				try {
					Thread.sleep(timing);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					
				}
				repaint();
			
			}
		}
		
		/**Procédure permettant le déplacement des chromosomes à la methaphase*/
		public void deplaceChromosomes() {
			
				/**---Chromosomes gauches---*/
			if((MeiosePara1.condensX>MeiosePara1.alignchromatideX)) {
				MeiosePara1.condensX-=10;
			}
			
			if((MeiosePara1.condensX<=485)&&(MeiosePara1.condensX>=475)) {
				membranenuc=0.01f;
				microtub=1.0f;
				
				try {
					Thread.sleep(sec);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			
			if((MeiosePara1.condensX2>MeiosePara1.alignchromatideX)) {
				MeiosePara1.condensX2-=20;
			}
			
			if((MeiosePara1.condensX3>MeiosePara1.alignchromatideX)) {
				MeiosePara1.condensX3-=20;
			}
			
				/**---Chromosomes droites---*/
			
			if((MeiosePara1.condensbisX<=MeiosePara1.alignchromatidebisX)) {
				MeiosePara1.condensbisX+=10;
			}
			
			if((MeiosePara1.condensbisX2<=MeiosePara1.alignchromatidebisX)) {
				MeiosePara1.condensbisX2+=10;
			}
			
				/**---Positions ordonnÃ©es---*/
					
					/**--gauche--*/
			if(MeiosePara1.condensY2>MeiosePara1.alignchro2Y) {
				MeiosePara1.condensY2--;
			}			
			
			if (MeiosePara1.condensY3<MeiosePara1.alignchro3Y) {
				MeiosePara1.condensY3+=13;				
			}
			
			if(MeiosePara1.condensY4<MeiosePara1.alignchro4Y) {
				MeiosePara1.condensY4+=10;
			}
			
					/*--Droite--*/
			if(MeiosePara1.condensbY2>MeiosePara1.alignchro2Y) {
				MeiosePara1.condensbY2--;
			}
			
			if (MeiosePara1.condensbY3<MeiosePara1.alignchro3Y) {
				MeiosePara1.condensbY3+=13;				
			}
			
			if(MeiosePara1.condensbY4<MeiosePara1.alignchro4Y) {
				MeiosePara1.condensbY4+=10;
			}
			
		}
		
		/**Permet l'anaphase*/
		public void migreChromosome() {
			/**---Chromosomes gauches---*/
			if((MeiosePara1.condensX>=MeiosePara1.finaltmtchroX)) {
				MeiosePara1.condensX-=10;
			}
			
			if((MeiosePara1.condensX2>=MeiosePara1.finalchroX2)) {
				MeiosePara1.condensX2-=20;
			}
			
			if((MeiosePara1.condensX3>=MeiosePara1.finalchroX2)) {
				MeiosePara1.condensX3-=20;
			}
			
			/**---Chromosomes droites---*/
			
			if((MeiosePara1.condensbisX<MeiosePara1.finalbistmtchroX)) {
				MeiosePara1.condensbisX+=20;
			}
			
			if((MeiosePara1.condensbisX2<MeiosePara1.finalbischroX2)) {
				MeiosePara1.condensbisX2+=10;
			}
			
			/**---Positions ordonnÃ©es---*/
			
				/**--Gauche--*/
			
			if(MeiosePara1.alignchro1Y<=MeiosePara1.finalmtchroY) {
				MeiosePara1.alignchro1Y+=10;
			}
			
			if(MeiosePara1.condensY2>=MeiosePara1.finalmtchroY) {
				MeiosePara1.condensY2--;
			}
	
			if (MeiosePara1.condensY3<=MeiosePara1.finalmtchroY2) {
				MeiosePara1.condensY3+=13;				
			}
	
			if(MeiosePara1.condensY4!=MeiosePara1.finalmtchroY2) {
				MeiosePara1.condensY4-=10;
			}

				/**--Droite--*/
			
			if(MeiosePara1.condensbY1<MeiosePara1.finalbismtchroY) {
				MeiosePara1.condensbY1+=10;
			}
			
			if(MeiosePara1.condensbY2>MeiosePara1.finalbismtchroY) {
				MeiosePara1.condensbY2--;
			}
	
			if (MeiosePara1.condensbY3<MeiosePara1.finalbismtchroY2) {
				MeiosePara1.condensbY3+=13;				
			}
	
			if(MeiosePara1.condensbY4!=MeiosePara1.finalbismtchroY2) {
				MeiosePara1.condensbY4-=10;
			}
			
			if((MeiosePara1.condensX<MeiosePara1.finaltmtchroX)) {
				com2=delta;
				com3=alpha;
				centriop=delta;
				actine=alpha;
				stop=false;
			}
			
		}
		
		/**@see migreChromosome();*/
		public void anaphase() {
			migreChromosome();
		}
		
		/**--Permet donner le signal de migration*/
		public void deplaceMt() {
			/**--Cote gauche--*/
			if ((MeiosePara1.mt1posX<MeiosePara1.alignchromatideX) ){
				MeiosePara1.mt1posX+=20;
			}
			if (MeiosePara1.mt1posY>MeiosePara1.finalmtposY1) {
				MeiosePara1.mt1posY-=2;
			}
			
			if ((MeiosePara1.mt2posX<MeiosePara1.alignchromatideX)) {
				MeiosePara1.mt2posX+=20;				
			}
			if (MeiosePara1.mt2posY<MeiosePara1.finalmtposY2) {
				MeiosePara1.mt2posY+=5;
			}
			
			if ((MeiosePara1.mt3posX<MeiosePara1.alignchromatideX)) {
				MeiosePara1.mt3posX+=20;
			}
			if (MeiosePara1.mt3posY>MeiosePara1.finalmtposY3) {
				MeiosePara1.mt3posY-=2;
			}
			
			if ((MeiosePara1.mt4posX<MeiosePara1.alignchromatideX)) {
				MeiosePara1.mt4posX+=20;
			}
			if (MeiosePara1.mt4posY<MeiosePara1.finalmtposY4){
				MeiosePara1.mt4posY+=5;
			}
			
			/**--Cote droit--*/
		
			if ((MeiosePara1.mt1bisposX>MeiosePara1.alignchromatidebisX+30)) {
				MeiosePara1.mt1bisposX-=20;
				
			}
			if (MeiosePara1.mt1bisposY>MeiosePara1.finalmtposY1) {
				MeiosePara1.mt1bisposY-=2;
			}
			
			if ((MeiosePara1.mt2bisposX>MeiosePara1.alignchromatidebisX+30)) {
				MeiosePara1.mt2bisposX-=20;		
			}
			if (MeiosePara1.mt2bisposY<MeiosePara1.finalmtposY2) {
				MeiosePara1.mt2bisposY+=5;
			}
			
			if ((MeiosePara1.mt3bisposX>MeiosePara1.alignchromatidebisX+30)) {
				MeiosePara1.mt3bisposX-=20;
			}
			if (MeiosePara1.mt3bisposY>MeiosePara1.finalmtposY3) {
				MeiosePara1.mt3bisposY-=2;
			}
			
			if ((MeiosePara1.mt4bisposX>MeiosePara1.alignchromatidebisX+30)) {
				MeiosePara1.mt4bisposX-=20;
				
			}
			if (MeiosePara1.mt4bisposY<MeiosePara1.finalmtposY4) {
				MeiosePara1.mt4bisposY+=5;
			}
			
			/**---Permet le passage a  l'anaphase---*/
			if (MeiosePara1.mt1posY<=MeiosePara1.finalmtposY1) {
				microtub=0.01f;
				suite=true;
			}
			repaint();
			
		}
		
	}
//}
	


