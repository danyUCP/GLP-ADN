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


public class Telophasesecond extends JLabel {

		private Telophasesecond instance=this;
		private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

		/**---Variables des elements de l'ihm---*/
		private int witdh=200;
		private int heidth=250;
		
		public Image img3;
	    
	    public Image img6;
	    public Image img7;
	    
	    public Image img8;
	    public Image img9;
	    
	    /**Instanciation Chromatide*/
	    
	    Chromatide chro1= new Chromatide("Chrom1");
	    Chromatide chro2= new Chromatide("Chrom2");
	    Chromatide chro3= new Chromatide("Chrom3");
	    Chromatide chro4= new Chromatide("Chrom4");
		
		public Telophasesecond() {
			// TODO Auto-generated constructor stub
			super();	
			
			this.setBounds(0, 0, 1080, 700);
		}	
		
		/**Afficher elements*/
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			 Graphics2D g2d = (Graphics2D)g;
			 
			 g2d.setFont(font);
			 
			/**-------Cellule et sa Membrane--------*/
			 /**--Cellule fille 1--*/
			g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MeiosePara1.alignchroX-200, MeiosePara1.alignchro1Y-170, witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MeiosePara1.alignchroX-200,MeiosePara1.alignchro1Y-170, witdh, heidth);
		    
		    /**--Cellule fille 2--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MeiosePara1.alignchrobisX, MeiosePara1.alignchro1Y-170,witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MeiosePara1.alignchrobisX, MeiosePara1.alignchro1Y-170, witdh, heidth);

		    /**--Cellule fille 3--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MeiosePara1.alignchroX-200, MeiosePara1.alignchro3Y, witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MeiosePara1.alignchroX-200,MeiosePara1.alignchro3Y, witdh,heidth);
		    
		    /**--Cellule fille 4--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MeiosePara1.alignchrobisX, MeiosePara1.alignchro3Y,witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MeiosePara1.alignchrobisX, MeiosePara1.alignchro3Y, witdh, heidth);

		    
		    
		    /**---Chromatides---*/
		    try {
		    	
		    	img3 = ImageIO.read(new File("membnucl.png"));
		    	
		        img6 = ImageIO.read(new File("chromatide1.png"));

		        img7 = ImageIO.read(new File("chromatide2.png"));
		    
		        img8 = ImageIO.read(new File("chromatide3.png"));

		        img9 = ImageIO.read(new File("chromatide4.png"));
		       
		     } catch (IOException e) {
		       e.printStackTrace();
		     }       		   
		       
		       
		    	/**---Chromosomes cellule 1--*/
		    
		    	/**--Paire Haute--*/
		    
		    g2d.drawImage(img6, MeiosePara1.alignchroX-150, MeiosePara1.alignchro1Y-120, 50,65, this);
		    g2d.drawImage(img7, MeiosePara1.alignchroX-100, MeiosePara1.alignchro1Y-120, 50,65, this); 
		    
		    
		    	/**--Paire Basse--*/
		    g2d.drawImage(img6, MeiosePara1.alignchroX-150, MeiosePara1.alignchro1Y-55, 50,65, this);
		    g2d.drawImage(img7, MeiosePara1.alignchroX-100, MeiosePara1.alignchro1Y-55, 50, 65, this);
		    
		    	/**---Chromosomes cellule 3---*/
		    
		    	/**--Paire Haute--*/
		    
		    g2d.drawImage(img6,MeiosePara1.alignchroX-150,MeiosePara1.alignchro3Y+40,50,65, this);
		    g2d.drawImage(img7,MeiosePara1.alignchroX-100,MeiosePara1.alignchro3Y+40,50,65, this); 
		    
		    	/**--Paire Basse--*/
		    g2d.drawImage(img6,MeiosePara1.alignchroX-150,MeiosePara1.alignchro3Y+120,50,65, this);
		    g2d.drawImage(img8,MeiosePara1.alignchroX-100,MeiosePara1.alignchro3Y+120,50,65, this);
		    
		   	/**---Chromosomes cellule 2--*/
		    
		    	/**--Paire Haute--*/
		    
		    g2d.drawImage(img7, MeiosePara1.alignchrobisX+120,MeiosePara1.alignchro1Y-120,50,65, this);
		    g2d.drawImage(img6, MeiosePara1.alignchrobisX+70,MeiosePara1.alignchro1Y-120,50,65, this); 
		    
		    	/**--Paire Basse--*/
		    g2d.drawImage(img7, MeiosePara1.alignchrobisX+120, MeiosePara1.alignchro1Y-55, 50, 65, this);
		    g2d.drawImage(img6, MeiosePara1.alignchrobisX+70, MeiosePara1.alignchro1Y-55, 50, 65, this);	     
		    
		    	/**---Chromosomes cellule 4---*/
		    	
		    	/**--Paire Haute--*/
		    g2d.drawImage(img7, MeiosePara1.alignchrobisX+120,MeiosePara1.alignchro3Y+40,50,65, this);
		    g2d.drawImage(img6, MeiosePara1.alignchrobisX+70,MeiosePara1.alignchro3Y+40,50,65, this); 
		    
		    	/**--Paire Basse--*/
		    g2d.drawImage(img7, MeiosePara1.alignchrobisX+120,MeiosePara1.alignchro3Y+120,50,65, this); 
		    g2d.drawImage(img9, MeiosePara1.alignchrobisX+70,MeiosePara1.alignchro3Y+120,50,65, this);
	    
		    
		    	/**----Noyaux---*/
		    g2d.drawImage(img3, MeiosePara1.alignchroX-170, MeiosePara1.alignchro1Y-150,witdh-40,heidth-40, this);
		    g2d.drawImage(img3, MeiosePara1.alignchrobisX+40, MeiosePara1.alignchro1Y-150,witdh-40,heidth-40, this);
		    g2d.drawImage(img3, MeiosePara1.alignchroX-170, MeiosePara1.alignchro3Y+20,witdh-40,heidth-40, this);
		    g2d.drawImage(img3, MeiosePara1.alignchrobisX+40, MeiosePara1.alignchro3Y+20,witdh-40,heidth-40, this);

		    /**appel des Chromatide vie @see getName()*/
		    
		    g2d.setColor(Color.BLACK);
		    
		    g2d.drawString("Noyaux1", MeiosePara1.alignchroX-270, MeiosePara1.finalmtchroY-45);
		    g2d.drawString("Noyaux2", MeiosePara1.alignchrobisX+130, MeiosePara1.finalbismtchroY-45);
		    g2d.drawString("Noyaux3", MeiosePara1.alignchroX-270, MeiosePara1.finalmtchroY+260);
		    g2d.drawString("Noyaux4", MeiosePara1.alignchrobisX+130, MeiosePara1.finalbismtchroY+260);
		    
			g2d.drawString("Cellule1", MeiosePara1.alignchroX-270, MeiosePara1.finalmtchroY-25);
		    g2d.drawString("Cellule2", MeiosePara1.alignchrobisX+130, MeiosePara1.finalbismtchroY-25);
		    g2d.drawString("Cellule3", MeiosePara1.alignchroX-270, MeiosePara1.finalmtchroY+280);
		    g2d.drawString("Cellule4", MeiosePara1.alignchrobisX+130, MeiosePara1.finalbismtchroY+280);

		    g2d.drawString(chro1.getName(), MeiosePara1.alignchroX-150, MeiosePara1.alignchro1Y-120);
		    g2d.drawString(chro2.getName(), MeiosePara1.alignchroX-10, MeiosePara1.alignchro1Y-120);
		    g2d.drawString(chro3.getName(), MeiosePara1.alignchroX-150, MeiosePara1.alignchro3Y-200);
		    g2d.drawString(chro4.getName(), MeiosePara1.alignchroX-10, MeiosePara1.alignchro3Y-200);


		    g2d.drawString(chro1.getName(), MeiosePara1.alignchroX-150, MeiosePara1.alignchro3Y+40);
		    g2d.drawString(chro2.getName(), MeiosePara1.alignchroX-10, MeiosePara1.alignchro3Y+40);
		    g2d.drawString(chro3.getName(), MeiosePara1.alignchroX-150, MeiosePara1.alignchro3Y+120);
		    g2d.drawString(chro4.getName(), MeiosePara1.alignchroX-10, MeiosePara1.alignchro3Y+120);

		    g2d.drawString(chro1.getName(), MeiosePara1.alignchrobisX+120, MeiosePara1.alignchro1Y-120);
		    g2d.drawString(chro2.getName(), MeiosePara1.alignchrobisX-10, MeiosePara1.alignchro1Y-120);
		    g2d.drawString(chro3.getName(), MeiosePara1.alignchrobisX+120, MeiosePara1.alignchro3Y-200);
		    g2d.drawString(chro4.getName(), MeiosePara1.alignchrobisX-10, MeiosePara1.alignchro3Y-200);


		    g2d.drawString(chro1.getName(), MeiosePara1.alignchrobisX+120, MeiosePara1.alignchro3Y+40);
		    g2d.drawString(chro2.getName(), MeiosePara1.alignchrobisX-10, MeiosePara1.alignchro3Y+40);
		    g2d.drawString(chro3.getName(), MeiosePara1.alignchrobisX+120, MeiosePara1.alignchro3Y+120);
		    g2d.drawString(chro4.getName(), MeiosePara1.alignchrobisX-10, MeiosePara1.alignchro3Y+120);
		    
		    /**Commentaire--*/
		    
		    g2d.drawString(" TELOPHASE2:",0, MeiosePara1.centri2bisposY+250);
		    g2d.drawString(" Quatre cellules apparaissent avec ADN differents: utile a la fecondation",0, MeiosePara1.centri2bisposY+280);
		   
		    
		} 

	
	}

