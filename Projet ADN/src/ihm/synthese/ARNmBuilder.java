package ihm.synthese;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ARN.ARNm;
import ARN.BrinARN;
import ihm.CodonComp;
import ihm.NuclComp;
import ihm.ParaADN;

public class ARNmBuilder 
{
	private ArrayList<NuclComp> nuclList;
	private ArrayList<CodonComp> codonList;
	private JLabel brinLabel, ARNmLabel;
	private BrinARN brin;
	private ARNm brinMessager;
	private boolean orientation;
	
	public ARNmBuilder(BrinARN brin)
	{
		this.brin = brin;
		this.orientation = true;
		
		initNuclList();
		
		this.brinLabel = new JLabel();
		this.ARNmLabel = new JLabel();
	}
	
	public ARNmBuilder(BrinARN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		initNuclList();
		
		this.brinLabel = new JLabel();
	}
	
	public ARNmBuilder(ARNm brinMessager, boolean orientation)
	{
		this.brinMessager = brinMessager;
		this.orientation = orientation;
		
		initCodonList();
		
		this.ARNmLabel = new JLabel();
	}
	
	private void initNuclList()
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
		
		System.out.println(brinLabel.getBounds());
		
		
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
	
	public NuclComp getNuclCpAt(int index)
	{
		return this.nuclList.get(index);
	}
	
	
	public void initCodonList()
	{
		this.codonList = new ArrayList<CodonComp>();
		
		for(int i = 0 ; i < brinMessager.getTaille() ; i++)
			this.codonList.add(new CodonComp(brinMessager.getCodonAt(i), i, -1, orientation));
		
		System.out.println("Liste de codons composants ARNm initialisée");	
	}
	
	public CodonComp getCodCpAt(int index)
	{
		return this.codonList.get(index);
	}
	
	public JLabel creerARNmessager(int x, int y)
	{
		this.ARNmLabel.setLayout(null);
		this.ARNmLabel.setSize(codonList.size() * (3 * ParaADN.LARGEUR_NUCL), ParaADN.HAUTEUR_NUCL);
		
		this.ARNmLabel.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + (y * (ParaADN.HAUTEUR_NUCL - 13)));
		//this.ARNmLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

		for(int i = 0 ; i < codonList.size() ; i++)
			this.ARNmLabel.add(this.getCodCpAt(i));
		
		System.out.println(ARNmLabel.getBounds());
		
		
		return ARNmLabel;
	}
	
	public int getTaille()
	{
		return this.nuclList.size();
	}
	
	public String toString()
	{
		String str = "";
		
		if(this.nuclList != null)
		{
			for(int i = 0 ; i < this.nuclList.size() ; i++)
				str += this.nuclList.get(i) + " ";
		}
		else
		{
			for(int i = 0 ; i < this.codonList.size() ; i++)
				str += this.codonList.get(i) + " ";
		}
		
		return str;
	}
	
}
