package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import heritage.Personne;

public class Arbre extends JPanel implements Runnable  {
	private Personne pere;
	private Personne mere;
	private Personne enfant;
	
	private BufferedImage image;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	
	private JButton nouvel;
	private Thread gamètes;
	
	public Arbre(Personne pere)  {
		super(null);
		this.pere=pere;
		
		
		try {
			image = ImageIO.read(new File("c1c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image1 = ImageIO.read(new File("c2c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("c3c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			image3 = ImageIO.read(new File("c4c1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton nouvel=new JButton("faire un enfant");
		
	}


	public void paintComponent(Graphics g) {
		//parents
		g.setColor(Color.WHITE);
		g.fillOval(70, 75, 200, 150);
		g.drawImage(image, 95, 115, this);
		g.drawImage(image, 105, 115, this);
		g.drawImage(image1, 125, 135, this);
		g.drawImage(image1, 135, 135, this);
		g.drawImage(image2, 155, 165, this);
		g.drawImage(image2, 165, 165, this);
		g.drawImage(image3, 185, 120, this);
		g.drawImage(image3, 195, 120, this);
		
		g.setColor(Color.WHITE);
		g.fillOval(340, 75, 200, 150);
		g.drawImage(image, 365, 115, this);
		g.drawImage(image, 375, 115, this);
		g.drawImage(image1, 395, 135, this);
		g.drawImage(image1, 405, 135, this);
		g.drawImage(image2, 425, 165, this);
		g.drawImage(image2, 435, 165, this);
		g.drawImage(image3, 450, 120, this);
		g.drawImage(image3, 460, 120, this);
		
		//gamètes
		g.setColor(Color.WHITE);
		g.fillOval(700, 150, 200, 150);
		g.drawImage(image, 725, 210, this);
		g.drawImage(image1, 755, 190, this);
		g.drawImage(image2, 790, 240, this);
		g.drawImage(image3, 820, 190, this);
		
		g.setColor(Color.WHITE);
		g.fillOval(700, 300, 200, 150);
		g.drawImage(image, 725, 360, this);
		g.drawImage(image1, 755, 340, this);
		g.drawImage(image2, 790, 390, this);
		g.drawImage(image3, 820, 340, this);
		
		
		//enfants
		g.setColor(Color.WHITE);
		g.fillOval(340, 350, 200, 150);
		g.drawImage(image, 365, 390, this);
		g.drawImage(image, 375, 390, this);
		g.drawImage(image1, 395, 410, this);
		g.drawImage(image1, 405, 410, this);
		g.drawImage(image2, 425, 440, this);
		g.drawImage(image2, 435, 440, this);
		g.drawImage(image3, 455, 395, this);
		g.drawImage(image3, 465, 395, this);
		
		g.setColor(Color.WHITE);
		g.fillOval(70, 350, 200, 150);
		g.drawImage(image, 95, 390, this);
		g.drawImage(image, 105, 390, this);
		g.drawImage(image1, 125, 410, this);
		g.drawImage(image1, 135, 410, this);
		g.drawImage(image2, 155, 440, this);
		g.drawImage(image2, 165, 440, this);
		g.drawImage(image3, 185, 395, this);
		g.drawImage(image3, 195, 395, this);
		
		//allèles
		g.setColor(Color.BLACK);
		g.fillRect(112, 140, 5, 3);
		g.setColor(Color.BLACK);
		g.fillRect(122, 140, 5, 3);
		
		g.setColor(Color.yellow);
		g.fillRect(150, 170, 9, 5);
		g.setColor(Color.yellow);
		g.fillRect(160, 170, 9, 5);
		g.setColor(Color.white);
			g.drawString("a", 112, 140);
		if(pere.getPaire1().getPart1().getG1().getName()=="a") {
			
			Font fonte = new Font("TimesRoman ",Font.BOLD,30);
					g.setFont(fonte);
					
			
		}
		
		
		
	}


	@Override
	public void run() {
		
		
	}
	
		
	
	

}
