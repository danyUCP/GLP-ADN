package ihm.synthese;

import java.util.ArrayList;

import javax.swing.JLabel;

import ARN.BrinARN;
import ihm.NuclComp;
import ihm.ParaADN;

public class ARNmBuilder 
{
	private ArrayList<NuclComp> nuclList;
	private JLabel brinLabel;
	private BrinARN brin;
	private boolean orientation;
	
	public ARNmBuilder(BrinARN brin)
	{
		this.brin = brin;
		this.orientation = true;
		
		initList();
		
		this.brinLabel = new JLabel();
	}
	
	public ARNmBuilder(BrinARN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		initList();
		
		this.brinLabel = new JLabel();
	}
	
	private void initList()
	{
		this.nuclList = new ArrayList<NuclComp>();
		
		for(int i = 0 ; i < brin.getTaille() ; i++)
			this.nuclList.add(new NuclComp(brin.getNuclAt(i), i, -1, orientation));
		
		System.out.println("Liste de nucléotides composantes ARN initialisée");	
		//System.out.println(nuclList);
	}
	
	public JLabel creerARN(int x, int y)
	{
		this.brinLabel.setLayout(null);
		this.brinLabel.setSize(nuclList.size() * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
		
		this.brinLabel.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + (y * (ParaADN.HAUTEUR_NUCL - 13)));
		//this.brinLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

		for(int i = 0 ; i < nuclList.size() ; i++)
			this.brinLabel.add(this.nuclList.get(i));
		
		//System.out.println(brinLabel.getBounds());
		
		
		return brinLabel;
	}
	
	public void retirerNuclCp()
	{
		for(int i = getTaille() - 1 ; i >= 0 ; i--)
		{
			if(this.getNuclCpAt(i).getNucl().estExon() == false)
				this.nuclList.remove(i);
		}
	}
	
	public int getTaille()
	{
		return this.nuclList.size();
	}
	
	public NuclComp getNuclCpAt(int index)
	{
		return this.nuclList.get(index);
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0 ; i < this.nuclList.size() ; i++)
			str += this.nuclList.get(i) + " ";
		
		return str;
	}
	
}
