package ihm;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.BrinARN;

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
		System.out.println(nuclList);
	}
	
	public JLabel creerARN(int x, int y)
	{
		this.brinLabel.setLayout(null);
		this.brinLabel.setSize(nuclList.size() * 36, 88);
		
		this.brinLabel.setLocation(x * 36, 330 + (y * 75));
		//this.brinLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

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
