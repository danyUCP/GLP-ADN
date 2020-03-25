package ihm;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ComposantsMitose extends JPanel implements Runnable {
	
	private JPanel commandes;
	/*----Execution---*/
	private Thread thread;
	private JButton play;
	private boolean stop;
	
	/*---Variables des positions de centrioles---*/
	private int centri1posX = 350;
    private int centri1posY = 200;
	private int centri2posX =350;
	private int centri2posY= 200;
	
	/*---Variables des positions des microtubules de gauche---*/
	private int mt1posX = 450;
    private int mt1posY = 380;
	private int mt2posX =450;
	private int mt2posY= 400;
	private int mt3posX = 450;
    private int mt3posY = 420;
	private int mt4posX =450;
	private int mt4posY= 440;
	
	/*---Variables des positions des microtubules de droite---*/
	private int mt1bisposX = 1050;
    private int mt1bisposY = 380;
	private int mt2bisposX =1050;
	private int mt2bisposY= 400;
	private int mt3bisposX = 1050;
    private int mt3bisposY = 420;
	private int mt4bisposX =1050;
	private int mt4bisposY= 440;
	
	/*---Variables des postitions de la membrane cellulaire et de la cellule---*/
	private int membraneposX = 350;
    private int membraneposY = 200;
    
    private int cellposX = 350;
    private int cellposY = 200;
    
	private ComposantsMitose instance=this;
	
	public ComposantsMitose(JPanel commandes) {
		// TODO Auto-generated constructor stub
		super(null);
		
		this.stop = true;
		this.commandes = commandes;
		commandes.setBackground(Color.CYAN);
		play = new JButton("Lancement");
		play.addActionListener(new PlayListener());
		commandes.add(play);
		
		
		this.cellposX=cellposX;
		this.cellposY=cellposY;
		this.membraneposX=membraneposX;
		this.membraneposY=membraneposY;
		
		this.centri1posX=centri1posX;
		this.centri1posY=centri1posY;
		this.centri2posX=centri2posX;
		this.centri2posY=centri2posY;
		
		this.mt1posX=mt1posX;
		this.mt1posY=mt1posY;
		this.mt2posX=mt2posX;
		this.mt2posY=mt2posY;
		this.mt3posX=mt3posX;
		this.mt3posY=mt3posY;
		this.mt4posX=mt4posX;
		this.mt4posY=mt4posY;
		
		this.mt1bisposX=mt1bisposX;
		this.mt1bisposY=mt1bisposY;
		this.mt2bisposX=mt2bisposX;
		this.mt2bisposY=mt2bisposY;
		this.mt3bisposX=mt3bisposX;
		this.mt3bisposY=mt3bisposY;
		this.mt4bisposX=mt4bisposX;
		this.mt4bisposY=mt4bisposY;
		
		
		
	}
	
	/*public void intAction() {
	
		commandes.setBackground(Color.CYAN);
		play = new JButton("Lancement");
		play.addActionListener(new PlayListener());
		commandes.add(play);
	}*/
		
		
	
	
	/**
	 * @return the centri1posX
	 */
	public int getCentri1posX() {
		return centri1posX;
	}

	/**
	 * @param centri1posX the centri1posX to set
	 */
	public void setCentri1posX(int centri1posX) {
		this.centri1posX = centri1posX;
	}

	/**
	 * @return the centri1posY
	 */
	public int getCentri1posY() {
		return centri1posY;
	}

	/**
	 * @param centri1posY the centri1posY to set
	 */
	public void setCentri1posY(int centri1posY) {
		this.centri1posY = centri1posY;
	}

	/**
	 * @return the centri2posX
	 */
	public int getCentri2posX() {
		return centri2posX;
	}

	/**
	 * @param centri2posX the centri2posX to set
	 */
	public void setCentri2posX(int centri2posX) {
		this.centri2posX = centri2posX;
	}

	/**
	 * @return the centri2posY
	 */
	public int getCentri2posY() {
		return centri2posY;
	}

	/**
	 * @param centri2posY the centri2posY to set
	 */
	public void setCentri2posY(int centri2posY) {
		this.centri2posY = centri2posY;
	}

	/**
	 * @return the mt1posX
	 */
	public int getMt1posX() {
		return mt1posX;
	}

	/**
	 * @param mt1posX the mt1posX to set
	 */
	public void setMt1posX(int mt1posX) {
		this.mt1posX = mt1posX;
	}

	/**
	 * @return the mt1posY
	 */
	public int getMt1posY() {
		return mt1posY;
	}

	/**
	 * @param mt1posY the mt1posY to set
	 */
	public void setMt1posY(int mt1posY) {
		this.mt1posY = mt1posY;
	}

	/**
	 * @return the mt2posX
	 */
	public int getMt2posX() {
		return mt2posX;
	}

	/**
	 * @param mt2posX the mt2posX to set
	 */
	public void setMt2posX(int mt2posX) {
		this.mt2posX = mt2posX;
	}

	/**
	 * @return the mt2posY
	 */
	public int getMt2posY() {
		return mt2posY;
	}

	/**
	 * @param mt2posY the mt2posY to set
	 */
	public void setMt2posY(int mt2posY) {
		this.mt2posY = mt2posY;
	}

	/**
	 * @return the mt3posX
	 */
	public int getMt3posX() {
		return mt3posX;
	}

	/**
	 * @param mt3posX the mt3posX to set
	 */
	public void setMt3posX(int mt3posX) {
		this.mt3posX = mt3posX;
	}

	/**
	 * @return the mt3posY
	 */
	public int getMt3posY() {
		return mt3posY;
	}

	/**
	 * @param mt3posY the mt3posY to set
	 */
	public void setMt3posY(int mt3posY) {
		this.mt3posY = mt3posY;
	}

	/**
	 * @return the mt4posX
	 */
	public int getMt4posX() {
		return mt4posX;
	}

	/**
	 * @param mt4posX the mt4posX to set
	 */
	public void setMt4posX(int mt4posX) {
		this.mt4posX = mt4posX;
	}

	/**
	 * @return the mt4posY
	 */
	public int getMt4posY() {
		return mt4posY;
	}

	/**
	 * @param mt4posY the mt4posY to set
	 */
	public void setMt4posY(int mt4posY) {
		this.mt4posY = mt4posY;
	}

	/**
	 * @return the mt1bisposX
	 */
	public int getMt1bisposX() {
		return mt1bisposX;
	}

	/**
	 * @param mt1bisposX the mt1bisposX to set
	 */
	public void setMt1bisposX(int mt1bisposX) {
		this.mt1bisposX = mt1bisposX;
	}

	/**
	 * @return the mt1bisposY
	 */
	public int getMt1bisposY() {
		return mt1bisposY;
	}

	/**
	 * @param mt1bisposY the mt1bisposY to set
	 */
	public void setMt1bisposY(int mt1bisposY) {
		this.mt1bisposY = mt1bisposY;
	}

	/**
	 * @return the mt2bisposX
	 */
	public int getMt2bisposX() {
		return mt2bisposX;
	}

	/**
	 * @param mt2bisposX the mt2bisposX to set
	 */
	public void setMt2bisposX(int mt2bisposX) {
		this.mt2bisposX = mt2bisposX;
	}

	/**
	 * @return the mt2bisposY
	 */
	public int getMt2bisposY() {
		return mt2bisposY;
	}

	/**
	 * @param mt2bisposY the mt2bisposY to set
	 */
	public void setMt2bisposY(int mt2bisposY) {
		this.mt2bisposY = mt2bisposY;
	}

	/**
	 * @return the mt3bisposX
	 */
	public int getMt3bisposX() {
		return mt3bisposX;
	}

	/**
	 * @param mt3bisposX the mt3bisposX to set
	 */
	public void setMt3bisposX(int mt3bisposX) {
		this.mt3bisposX = mt3bisposX;
	}

	/**
	 * @return the mt3bisposY
	 */
	public int getMt3bisposY() {
		return mt3bisposY;
	}

	/**
	 * @param mt3bisposY the mt3bisposY to set
	 */
	public void setMt3bisposY(int mt3bisposY) {
		this.mt3bisposY = mt3bisposY;
	}

	/**
	 * @return the mt4bisposX
	 */
	public int getMt4bisposX() {
		return mt4bisposX;
	}

	/**
	 * @param mt4bisposX the mt4bisposX to set
	 */
	public void setMt4bisposX(int mt4bisposX) {
		this.mt4bisposX = mt4bisposX;
	}

	/**
	 * @return the mt4bisposY
	 */
	public int getMt4bisposY() {
		return mt4bisposY;
	}

	/**
	 * @param mt4bisposY the mt4bisposY to set
	 */
	public void setMt4bisposY(int mt4bisposY) {
		this.mt4bisposY = mt4bisposY;
	}

	/**
	 * @return the membraneposX
	 */
	public int getMembraneposX() {
		return membraneposX;
	}

	/**
	 * @param membraneposX the membraneposX to set
	 */
	public void setMembraneposX(int membraneposX) {
		this.membraneposX = membraneposX;
	}

	/**
	 * @return the membraneposY
	 */
	public int getMembraneposY() {
		return membraneposY;
	}

	/**
	 * @param membraneposY the membraneposY to set
	 */
	public void setMembraneposY(int membraneposY) {
		this.membraneposY = membraneposY;
	}

	/**
	 * @return the cellposX
	 */
	public int getCellposX() {
		return cellposX;
	}

	/**
	 * @param cellposX the cellposX to set
	 */
	public void setCellposX(int cellposX) {
		this.cellposX = cellposX;
	}

	/**
	 * @return the cellposY
	 */
	public int getCellposY() {
		return cellposY;
	}

	/**
	 * @param cellposY the cellposY to set
	 */
	public void setCellposY(int cellposY) {
		this.cellposY = cellposY;
	}

	/**
	 * @return the instance
	 */
	public ComposantsMitose getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(ComposantsMitose instance) {
		this.instance = instance;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*-------Cellule et sa Membrane--------*/
		g.setColor(new Color(253, 208, 234));
		g.fillOval(membraneposX-25, membraneposY-20, membraneposX+550,membraneposY+320);
		g.setColor(new Color(197,46,163));
	    g.drawOval(cellposX-25, cellposY-20, cellposX+550, cellposY+320);
	    
	    
	    /*--------Centrioles au centre AU DEPART--------*/
	    	/*----Centriole1---*/
	    try {
	        Image img1 = ImageIO.read(new File("centriole.png"));
	        g.drawImage(img1, (centri1posX*2)+40, centri1posY+140,80,140, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }      
	    
	    	/*---Centriole2---*/
	    try {
	        Image img2 = ImageIO.read(new File("centriole2.png"));
	        g.drawImage(img2, centri2posX+370, (centri2posY*2)+80, 140, 80, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }  
	    
	    
	    /*---Chromosome----**/
	    
	 /*   try {
	        Image img3 = ImageIO.read(new File("chro1.png"));
	        g.drawImage(img3, mt1posX+380, mt1posY+120,100,50, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }      
	    
	    	
	    try {
	        Image img4 = ImageIO.read(new File("chro1.png"));
	        g.drawImage(img4, mt2posX+360, mt1posY+210, 100, 50, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      } 
	    
	    try {
	        Image img5 = ImageIO.read(new File("chro1.png"));
	        g.drawImage(img5, mt3posX+360, mt1posY+280,100,50, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }      
	    
	    	
	    try {
	        Image img6 = ImageIO.read(new File("chro1.png"));
	        g.drawImage(img6, mt4posX+380, mt1posY+370, 100, 50, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }*/
	    
	   /** try {
	        Image img1 = ImageIO.read(new File("centriole.png"));
	        g.drawImage(img1, x1+90, y1+140,80,140, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }         
	    
	    try {
	        Image img1 = ImageIO.read(new File("centriole2.png"));
	        g.drawImage(img1, x1+90, (y1*2)+80, 140, 80, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    
	    try {
	        Image img1 = ImageIO.read(new File("centriole.png"));
	        g.drawImage(img1, x1*3, y1+140,80,140, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }         
	    
	    try {
	        Image img1 = ImageIO.read(new File("centriole2.png"));
	        g.drawImage(img1, x1*3, (y1*2)+80, 140, 80, this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }*/
	    
	    /*---------Microtubules schematises--------------*/
	    	    
	    	/*---Microtubules de gauche---*/
	    g.drawLine(450, 380, mt1posX, mt1posY);
	    g.drawLine(450, 400, mt2posX, mt2posY);
	    g.drawLine(450, 420, mt3posX, mt3posY);
	    g.drawLine(450, 440, mt4posX, mt4posY);
	    
	    
	    /*---Microtubules de droite---*/
	    g.setColor(new Color(164, 68, 234));
	    g.drawLine(1050, 380, mt1bisposX, mt1bisposY);
	    g.drawLine(1050, 400, mt2bisposX, mt2bisposY);
	    g.drawLine(1050, 420, mt3bisposX, mt3bisposY);
	    g.drawLine(1050, 440, mt4bisposX, mt4bisposY);

	    
	  } 
		
	class PlayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (!stop) {
				stop = true;
				play.setText(" Lancement ");
			} else {
				stop = false;
				play.setText(" En arrêt ");
				thread = new Thread(instance);				
				thread.start();
				}

		}
		
	}
	 
	


	//class AnimationMitose implements Runnable {
		
		//private ComposantsMitose composants = new ComposantsMitose();
		private static final int timing = 1000;
		
		public void run() {
			
			while(!stop) {
				deplcentrisome();
				deplacemt();
				try {
					Thread.sleep(timing);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				repaint();
			
			}

		}
		
		public void deplcentrisome() {
			if (centri1posX!=((centri1posX*2)-130)) {
				/*composants.*/setCentri1posX(centri1posX-80);
				/*composants.*/
				
				//centri1posX--;
				
			}
			if (centri2posX!=(centri2posX+370)+165) {
				/*composants.*/setCentri2posX(centri2posX+140);
				/*composants.*/getCentri2posY();
				
				//centri2posX++;
				
			}
			
			/*composants.*/repaint();
		}
		
		public void deplacemt() {
			if ((mt1posX!=720)&&(mt1posY!=360)) {
				/*composants.*/setMt1posX(mt1posX+20);
				/*composants.*/setMt1posY(mt1posY-2);
				
			}
			
			if ((mt2posX!=700)&&(mt2posY!=450)) {
				/*composants.*/setMt2posX(mt2posX+20);
				/*composants.*/setMt2posY(mt2posY+5);
				
			}
			if ((mt3posX!=700)&&(mt3posY!=520)) {
				/*composants.*/setMt3posX(mt3posX+20);
				/*composants.*/setMt3posY(mt3posY+10);
			}
			if ((mt4posX!=720)&&(mt4posY!=610)) {
				/*composants.*/setMt4posX(mt4posX+20);
				/*composants.*/setMt4posY(mt4posY+15);
			}
			
			
			if ((mt1bisposX!=800)&&(mt1bisposY!=360)) {
				/*composants.*/setMt1bisposX(mt1posX-20);
				/*composants.*/setMt1bisposY(mt1posY-2);
			}
			
			if ((mt2bisposX!=820)&&(mt2bisposY!=450)) {
				/*composants.*/setMt2bisposX(mt2posX-20);
				/*composants.*/setMt2bisposY(mt2posY+5);
			}
			if ((mt3bisposX!=820)&&(mt3bisposY!=520)) {
				/*composants.*/setMt3bisposX(mt3bisposX-20);
				/*composants.*/setMt3bisposY(mt3bisposY+10);
			}
			if ((mt4bisposX!=800)&&(mt4bisposY!=610)) {
				/*composants.*/setMt4posX(mt4bisposX-20);
				/*composants.*/setMt4posY(mt4bisposY+15);
			}
			repaint();
			
		}
		
	}
//}
	


