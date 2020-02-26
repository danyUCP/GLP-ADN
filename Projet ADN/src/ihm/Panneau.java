package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel
{
	private NuclComp nucl;
	
	public Panneau()
	{
		super();
		//this.nucl = new NuclComp();
				
		//this.add(this.nucl);
	}
	
	public void paintComponent(Graphics g)
	{
		/*
		int longueur = 20;
		int largeur = 20;
		*/
		

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		/*
		g.setColor(Color.RED);
		g.fillOval(posX, posY, largeur, longueur);
		*/
	}

	/*
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	*/
	
	/*
	public void animer()
	{
		double pas = (Math.PI) / 4;

		for(int i = 0 ; i < 30 ; i++)
		{
			if(i > 24)
				i = 0;
			
			int x = this.getPosX();
			int y = this.getHeight() / 2 - 10;
			
			x = i * (this.getWidth() / 22);
			y += Math.sin(i * pas) * (this.getHeight() / 8);
			
			if(x > 5 * (this.getWidth() / 22) && x < 14 * (this.getWidth() / 22))
			{
				y = this.getHeight() / 2 - 10;
				y -= Math.sin(2 * pas) * (this.getHeight() / 6);
			}
			
			System.out.println(x + " : " + (y - this.getHeight() / 2 + 10) + " et i = " + i);
			
			this.setPosX(x);
			this.setPosY(y);
			this.repaint();
			
			try
			{
				Thread.sleep(550);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	*/

	
}
