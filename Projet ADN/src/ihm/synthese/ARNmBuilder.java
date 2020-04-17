package ihm.synthese;

import java.util.ArrayList;

import javax.swing.JLabel;

import ARN.ARNm;
import ARN.BrinARN;
import ihm.ParaADN;

/**
 * ARNmBuilder est la classe gère la représentation d'un brin d'ARN ou d'ARNm sous forme de composant graphique
 * 
 * @author Daniel
 */
public class ARNmBuilder 
{
	private ArrayList<NuclComp> nuclList;
	private BrinARN brin;

	private ArrayList<CodonComp> codonList;
	private ARNm brinMessager;

	private JLabel brinLabel, ARNmLabel;
	private boolean orientation;
	
	
	/**
	 * Premier contructeur de la classe ARNmBuilder.
	 * 
	 * A la construction d'un objet ARNmBuilder, la liste de NuclComp est créée en fonction de chaque nucléotide contenu dans le brin
	 * d'ARN et un JLabel prêt à accueillir la chaine de NuclComp 
	 */
	public ARNmBuilder(BrinARN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		initNuclList();
		
		this.brinLabel = new JLabel();
	}
	
	/**
	 * Second contructeur de la classe ARNmBuilder.
	 * 
	 * A la construction d'un objet ARNmBuilder, la liste de CodonComp est créée en fonction de chaque codon contenu dans le brin
	 * d'ARNm et un JLabel prêt à accueillir la chaine de CodonComp 
	 */
	public ARNmBuilder(ARNm brinMessager, boolean orientation)
	{
		this.brinMessager = brinMessager;
		this.orientation = orientation;
		
		initCodonList();
		
		this.ARNmLabel = new JLabel();
	}
	
	/**
	 * Cette méthode permet d'initialiser la liste de NuclComp correspondant aux nucléotides que contient le brin d'ARN
	 */
	private void initNuclList()
	{
		this.nuclList = new ArrayList<NuclComp>();
		
		for(int i = 0 ; i < brin.getTaille() ; i++)
			this.nuclList.add(new NuclComp(brin.getNuclAt(i), i, -1, orientation));		
	}
	
	/**
	 * Cette méthode renvoie le JLabel du brin d'ARN dimensionné et positionné et contenant tous les NuclComp
	 */
	public JLabel creerARN(int x, int y)
	{
		this.brinLabel.setLayout(null);
		this.brinLabel.setSize(nuclList.size() * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
		
		this.brinLabel.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + (y * (ParaADN.HAUTEUR_NUCL - 13)));
		//this.brinLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));

		for(int i = 0 ; i < nuclList.size() ; i++)
			this.brinLabel.add(this.nuclList.get(i));
				
		
		return brinLabel;
	}
	
	/**
	 * Cette méthode permet de retirer un NuclComp du brin d'ARN
	 */
	public void retirerNuclCp()
	{
		for(int i = getTaille() - 1 ; i >= 0 ; i--)
		{
			if(this.getNuclCpAt(i).getNucl().estExon() == false)
				this.nuclList.remove(i);
		}
	}
	
	
	/**
	 * Cette méthode permet d'initialiser la liste de CodonComp correspondant aux codons que contient le brin d'ARNm
	 */
	public void initCodonList()
	{
		this.codonList = new ArrayList<CodonComp>();
		
		for(int i = 0 ; i < brinMessager.getTaille() ; i++)
			this.codonList.add(new CodonComp(brinMessager.getCodonAt(i), i, -1, orientation));
	}
	
	/**
	 * Cette méthode renvoie le JLabel du brin d'ARNm dimensionné et positionné et contenant tous les CodonComp
	 */
	public JLabel creerARNmessager(int x, int y)
	{
		this.ARNmLabel.setLayout(null);
		this.ARNmLabel.setSize(codonList.size() * (3 * ParaADN.LARGEUR_NUCL), ParaADN.HAUTEUR_NUCL);
		
		this.ARNmLabel.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + (y * (ParaADN.HAUTEUR_NUCL - 13)));
		//this.ARNmLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

		for(int i = 0 ; i < codonList.size() ; i++)
			this.ARNmLabel.add(this.getCodCpAt(i));
				
		
		return ARNmLabel;
	}
	
	
	public NuclComp getNuclCpAt(int index)
	{
		return this.nuclList.get(index);
	}
	
	public CodonComp getCodCpAt(int index)
	{
		return this.codonList.get(index);
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
