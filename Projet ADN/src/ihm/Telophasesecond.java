package ihm;

import java.awt.AlphaComposite;
import java.awt.Color;
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

public class Telophasesecond extends JLabel {

		private Telophasesecond instance=this;
		

		/*---Opacité---*/
		private int witdh=200;
		private int heidth=250;

	    
	    public Image img6;
	    public Image img7;
	    
	    public Image img8;
	    public Image img9;
	    
		
		public Telophasesecond() {
			// TODO Auto-generated constructor stub
			super();	
			
			this.setBounds(0, 0, 1080, 700);
		}	
		

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			 Graphics2D g2d = (Graphics2D)g;
			/*-------Cellule et sa Membrane--------*/
			 /**--Cellule fille 1--*/
			g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MitosePara.alignchroX-200, MitosePara.alignchro1Y-170, witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MitosePara.alignchroX-200,MitosePara.alignchro1Y-170, witdh, heidth);
		    
		    /**--Cellule fille 2--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MitosePara.alignchrobisX, MitosePara.alignchro1Y-170,witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MitosePara.alignchrobisX, MitosePara.alignchro1Y-170, witdh, heidth);

		    /**--Cellule fille 3--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MitosePara.alignchroX-200, MitosePara.alignchro3Y, witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MitosePara.alignchroX-200,MitosePara.alignchro3Y, witdh,heidth);
		    
		    /**--Cellule fille 4--*/
		    g2d.setColor(new Color(253, 208, 234));
			g2d.fillOval(MitosePara.alignchrobisX, MitosePara.alignchro3Y,witdh,heidth);
			g2d.setColor(new Color(197,46,163));
		    g2d.drawOval(MitosePara.alignchrobisX, MitosePara.alignchro3Y, witdh, heidth);

		    
		    
		    /*---Chromatides---*/
		    try {
		        img6 = ImageIO.read(new File("chromatide1.png"));

		        img7 = ImageIO.read(new File("chromatide2.png"));
		    
		        img8 = ImageIO.read(new File("chromatide3.png"));

		        img9 = ImageIO.read(new File("chromatide4.png"));
		       
		     } catch (IOException e) {
		       e.printStackTrace();
		     }       
		       
		       
		    	/**---Chromosomes cellule 1--*/
		    
		    	/*--Paire Haute--*/
		    
		    g2d.drawImage(img6,MitosePara.alignchroX-150,MitosePara.alignchro1Y-120,50,65, this);
		    g2d.drawImage(img7,MitosePara.alignchroX-100,MitosePara.alignchro1Y-120,50,65, this); 
		    
		    
		    	/*--Paire Basse--*/
		    g2d.drawImage(img6,MitosePara.alignchroX-150,MitosePara.alignchro3Y-120,50,65, this);
		    g2d.drawImage(img7,MitosePara.alignchroX-100,MitosePara.alignchro3Y-120,50,65, this);
		    
		    	/**---Chromosomes cellule 2---*/
		    
		    	/*--Paire Haute--*/
		    
		    g2d.drawImage(img6,MitosePara.alignchroX-150,MitosePara.alignchro3Y+40,50,65, this);
		    g2d.drawImage(img7,MitosePara.alignchroX-100,MitosePara.alignchro3Y+40,50,65, this); 
		    
		    	/*--Paire Basse--*/
		    g2d.drawImage(img6,MitosePara.alignchroX-150,MitosePara.alignchro3Y+120,50,65, this);
		    g2d.drawImage(img8,MitosePara.alignchroX-100,MitosePara.alignchro3Y+120,50,65, this);
		    
		   	/**---Chromosomes cellule 3--*/
		    
		    	/*--Paire Haute--*/
		    
		    g2d.drawImage(img7, MitosePara.alignchrobisX+120,MitosePara.alignchro1Y-120,50,65, this);
		    g2d.drawImage(img6, MitosePara.alignchrobisX+70,MitosePara.alignchro1Y-120,50,65, this); 
		    
		    	/*--Paire Basse--*/
		    g2d.drawImage(img7, MitosePara.alignchrobisX+120,MitosePara.alignchro3Y-120,50,65, this);
		    g2d.drawImage(img6, MitosePara.alignchrobisX+70,MitosePara.alignchro3Y-120,50,65, this);	     
		    
		    	/**---Chromosomes cellule 4---*/
		    	
		    	/*--Paire Haute--*/
		    g2d.drawImage(img7, MitosePara.alignchrobisX+120,MitosePara.alignchro3Y+40,50,65, this);
		    g2d.drawImage(img6, MitosePara.alignchrobisX+70,MitosePara.alignchro3Y+40,50,65, this); 
		    
		    	/*--Paire Basse--*/
		    g2d.drawImage(img7, MitosePara.alignchrobisX+120,MitosePara.alignchro3Y+120,50,65, this); 
		    g2d.drawImage(img9, MitosePara.alignchrobisX+70,MitosePara.alignchro3Y+120,50,65, this);
	    
		  } 
			
			
		}


