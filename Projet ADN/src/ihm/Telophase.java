package ihm;

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


public class Telophase extends JLabel {
	private JPanel foot;
	private Telophase instance=this;
	
	/*----Execution---*/
	private boolean stop;
	
	/*---Opacité---*/
 
	public Image img3;
    
    public Image img6;
    public Image img7;
    
    public Image img8;
    public Image img9;
    
    private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	
	public Telophase() {
		// TODO Auto-generated constructor stub
		super();	
		this.setBounds(0, 0, 1080, 700);
		
	}	


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		 Graphics2D g2d = (Graphics2D)g;
		/*-------Cellule et sa Membrane--------*/
		 
		 	/**---Indice Cellule 1--*/
		g2d.setColor(Color.BLACK);
		g2d.drawString("Cellule fille 1", MitosePara.membraneposX-70, MitosePara.membraneposY-30);

		 
		g2d.setColor(new Color(253, 208, 234));
		g2d.fillOval(MitosePara.membraneposX-100, MitosePara.membraneposY, (MitosePara.membraneposX+790)/2,MitosePara.membraneposY+420);
		g2d.setColor(new Color(197,46,163));
	    g2d.drawOval(MitosePara.cellposX-100, MitosePara.cellposY, (MitosePara.cellposX+790)/2, MitosePara.cellposY+420);
	    
	    	/**---Indice Cellule 2--*/
		g2d.setColor(Color.BLACK);
		g2d.drawString("Cellule fille 2", MitosePara.membraneposX+370, MitosePara.membraneposY-30);
	    
	    g2d.setColor(new Color(253, 208, 234));
		g2d.fillOval(MitosePara.membraneposX+390, MitosePara.membraneposY, (MitosePara.membraneposX+790)/2,MitosePara.membraneposY+420);
		g2d.setColor(new Color(197,46,163));
	    g2d.drawOval(MitosePara.cellposX+390, MitosePara.cellposY, (MitosePara.cellposX+790)/2, MitosePara.cellposY+420);

	    g2d.setFont(font);
	    	
	    try {
	        img3 = ImageIO.read(new File("membnucl.png"));
	    	
	    	/*---Chromosomes gauches---*/
	    	
	        img6 = ImageIO.read(new File("chro1mit.png"));
	        img7 = ImageIO.read(new File("crossing1.png"));
 
	    
	    	/*---Chromosomes droites---*/

	        img8 = ImageIO.read(new File("chro2mit.png"));
	        img9 = ImageIO.read(new File("crossing2.png"));
	     } catch (IOException e) {
	       e.printStackTrace();
	     }       
	    
	    /*---Membranes nucléaire---*/
	    
	    	/**--Indice nucleaire---*/
	    g2d.setColor(Color.BLACK);
		g2d.drawString("Enveloppe nucléire", MitosePara.finaltmtchroX-70, MitosePara.finalmtchroY-80);
	    
	    	/**--Gauche--*/
	    g2d.drawImage(img3, MitosePara.finaltmtchroX-90, MitosePara.finalmtchroY-70, this);
	    
	    	/**--Droite--*/
	    g2d.drawImage(img3, MitosePara.finalbistmtchroX-170, MitosePara.finalbismtchroY-70, this);
	    
	    /*---Chromosomes condensés----**/
	       
	    	/**---Chromosomes gauche--*/
	    
	    g2d.drawImage(img6, MitosePara.finaltmtchroX,MitosePara.finalmtchroY,100,65, this);
	    g2d.drawImage(img6, MitosePara.finalchroX2, MitosePara.finalmtchroY,100,65, this);
	    g2d.drawImage(img7, MitosePara.finalchroX2, MitosePara.finalmtchroY2,100,65, this);
	    g2d.drawImage(img6, MitosePara.finaltmtchroX, MitosePara.finalmtchroY2,100,65, this);
	     
	    
	    	/**---Chromosomes droite---*/
	    
	    g2d.drawImage(img8, MitosePara.finalbistmtchroX,MitosePara.finalbismtchroY,100,65, this);
	    g2d.drawImage(img8, MitosePara.finalbischroX2, MitosePara.finalbismtchroY,100,65, this);
	    g2d.drawImage(img9, MitosePara.finalbischroX2, MitosePara.finalbismtchroY2,100,65, this);
	    g2d.drawImage(img8, MitosePara.finalbistmtchroX, MitosePara.finalbismtchroY2,100,65, this);
	     
	  } 


		
		
		
		
		
	}

