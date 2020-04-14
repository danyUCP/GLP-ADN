package ihm.synthese;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.ChaineAA;
import ihm.ParaADN;

public class ChaineLabel extends JLabel
{
	private ArrayList<AcideComp> acideList;
	private ChaineAA chaine;
	
	
	public ChaineLabel()
	{
		super();
		this.acideList = new ArrayList<AcideComp>();
		
		this.setBounds(0, 0, 0, ParaADN.HAUTEUR_ACIDE);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	}
	
	public void ajouterAcide(AcideComp acide)
	{
		this.acideList.add(acide);
		acide.setLocation((getTaille() - 1) * ParaADN.LARGEUR_ACIDE, 0);
		this.add(acide);
		this.setSize(this.getWidth() + ParaADN.LARGEUR_ACIDE, ParaADN.HAUTEUR_ACIDE);
	}
	
	public AcideComp getNuclCpAt(int index)
	{
		return this.acideList.get(index);
	}
	
	public void viderHelice()
	{
		this.acideList.clear();
	}
	
	public int getTaille()
	{
		return this.acideList.size();
	}
}
