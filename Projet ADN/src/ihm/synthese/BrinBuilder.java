package ihm.synthese;

import java.util.ArrayList;

import javax.swing.JLabel;

import ARN.BrinADN;
import ihm.ParaADN;

/**
 * BrinBuilder est la classe gère la représentation d'un brin d'ADN sous forme de composant graphique
 * 
 * @author Daniel
 */
public class BrinBuilder
{
	private ArrayList<NuclComp> nuclList;
	private JLabel brinLabel;
	private BrinADN brin;
	private boolean orientation;
	
	
	/**
	 * Contructeur de la classe BrinBuilder.
	 * 
	 * A la construction d'un objet BrinBuilder, la liste de NuclComp est créée en fonction de chaque nucléotide contenu dans le brin
	 * d'ADN et un JLabel prêt à accueillir la chaine de NuclComp 
	 */
	public BrinBuilder(BrinADN brin, boolean orientation)
	{
		this.brin = brin;
		this.orientation = orientation;
		
		initList();
		
		this.brinLabel = new JLabel();
	}
	
	
	/**
	 * Cette méthode permet d'initialiser la liste de NuclComp correspondant aux nucléotides que contient le brin
	 */
	private void initList()
	{
		this.nuclList = new ArrayList<NuclComp>();
		
		for(int i = 0 ; i < brin.getTaille() ; i++)
			this.nuclList.add(new NuclComp(brin.getNuclAt(i), i, -1, orientation));
	}
	
	/**
	 * Cette méthode renvoie le JLabel du brin dimensionné et positionné et contenant tous les NuclComp
	 */
	public JLabel creerBrin(int x, int y)
	{
		this.brinLabel.setLayout(null);
		this.brinLabel.setSize(nuclList.size() * ParaADN.LARGEUR_NUCL, ParaADN.HAUTEUR_NUCL);
		
		this.brinLabel.setLocation(x * ParaADN.LARGEUR_NUCL, 330 + (y * (ParaADN.HAUTEUR_NUCL - 13)));
		//this.brinLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		
		for(int i = 0 ; i < nuclList.size() ; i++)
			this.brinLabel.add(this.nuclList.get(i));
				
		return brinLabel;
	}
	
	public int getTaille()
	{
		return this.nuclList.size();
	}
		

}
