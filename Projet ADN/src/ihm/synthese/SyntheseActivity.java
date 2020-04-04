package ihm.synthese;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ARN.BrinARN;
import ARN.Codon;
import ihm.CodonComp;

public class SyntheseActivity extends JPanel
{
	private BrinARN brinArn;
	private Dimension dim;
	private JPanel commandes;
	private JLabel brin;
	private JButton play, suivant;
	private boolean stop;
	private Thread activityThread;
	private ARNmBuilder builder;

	
	public SyntheseActivity(JPanel commandes, Dimension dim)
	{
		super(null);
		this.commandes = commandes;
		
		this.stop = true;

		this.dim = dim;
		this.setSize(dim);
		
		System.out.println(this.getBounds());

		System.out.println(dim);


		this.setBackground(Color.WHITE);
		
		synthese();
	}
	
	/*
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.fillRect(50, 50, 100, 100);
		
		int largeur = 500;
		int longueur = 200;
		g.fillRect(this.getWidth() / 2 - largeur / 2, this.getHeight() / 2 - longueur / 2, largeur, longueur);
	}
	*/
	
	public void synthese()
	{
		this.add(new CodonComp(new Codon("AUG"), 1, 0, true));

		
	}

	
	
}
