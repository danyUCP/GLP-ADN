package ihm.synthese;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.BrinADN;
import ihm.NuclComp;

public class BrinBuilder
{
	private ArrayList<NuclComp> nuclList;
	private JLabel brinLabel;
	private BrinADN brin;
	private boolean orientation;
	
	public BrinBuilder(BrinADN brin)
	{
		this.brin = brin;
		this.orientation = true;
		
		initList();
		
		this.brinLabel = new JLabel();
	}
	
	public BrinBuilder(BrinADN brin, boolean orientation)
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
		
		System.out.println("Liste de nucléotides composantes initialisée");	
		System.out.println(nuclList);

	}
	
	public JLabel creerBrin(int x, int y)
	{
		this.brinLabel.setLayout(null);
		this.brinLabel.setSize(nuclList.size() * 36, 88);
		
		this.brinLabel.setLocation(x * 36, 330 + (y * 75));
		this.brinLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		
		for(int i = 0 ; i < nuclList.size() ; i++)
			this.brinLabel.add(this.nuclList.get(i));
		
		System.out.println(brinLabel.getBounds());
		
		return brinLabel;
	}
	
	public int getTaille()
	{
		return this.nuclList.size();
	}
		

}
