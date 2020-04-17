package ihm.synthese;

import java.util.ArrayList;

import javax.swing.JLabel;

import ihm.ParaADN;

/**
 * ChaineLabel est la classe g�re la repr�sentation de la cha�ne d'acides amin�s (prot�ine) sous forme de composant graphique
 * 
 * @author Daniel
 */
@SuppressWarnings("serial")
public class ChaineLabel extends JLabel
{
	private ArrayList<AcideComp> acideList;
	
	/**
	 * Contructeur de la classe ChaineLabel.
	 * 
	 * A la construction d'un objet ChaineLabel, la liste d'AcideComp est cr��e et pr�te � accueillir chaque acide 
	 * que lui enverra un ARNtManager 
	 */
	public ChaineLabel()
	{
		super();
		this.acideList = new ArrayList<AcideComp>();
		
		this.setBounds(0, 0, 0, ParaADN.HAUTEUR_ACIDE);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
	}
	
	
	/**
	 * Cette m�thode permet d'ajouter un AcideComp � la chaine
	 */
	public void ajouterAcide(AcideComp acide)
	{
		this.acideList.add(acide);
		acide.setLocation((getTaille() - 1) * ParaADN.LARGEUR_ACIDE, 0);
		this.add(acide);
		this.setSize(this.getWidth() + ParaADN.LARGEUR_ACIDE, ParaADN.HAUTEUR_ACIDE);
	}
	
	public AcideComp getAcideCpAt(int index)
	{
		return this.acideList.get(index);
	}
	
	public void viderChaine()
	{
		this.acideList.clear();
	}
	
	public int getTaille()
	{
		return this.acideList.size();
	}
}
