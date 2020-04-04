package ihm;

import javax.swing.JLabel;

import ARN.Codon;

public class CodonComp extends JLabel 
{
	private NuclComp[] triplet;
	private Codon codon;
	private int posX;
	private int posY;
	private int largeur;
	private int longueur;
	private boolean orientation;

	
	public CodonComp(Codon codon, int posX, int posY, boolean orientation)
	{
		this.triplet = new NuclComp[3];
		
		triplet[0] = new NuclComp(codon.getN(0), 0, -1, orientation);
		triplet[1] = new NuclComp(codon.getN(1), 1, -1, orientation);
		triplet[2] = new NuclComp(codon.getN(2), 2, -1, orientation);
		
		this.orientation = orientation;
		this.posX = posX;
		this.posY = posY;
		this.largeur = 3 * triplet[0].getWidth();
		this.longueur = triplet[0].getHeight();
		
		this.setBounds(posX * largeur, posY, largeur, longueur);
		
		for(int i = 0 ; i < 3 ; i++)
			this.add(triplet[i]);
	}
	
	public String toString()
	{
		return "" + triplet[0] + triplet[1] + triplet[2];	}
}
