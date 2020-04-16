package ADN;

import java.util.ArrayList;

public class Chaine {

	private ArrayList<Polymere> chain;
	
	/**Constructeur de Chaine constitue de l'array de polymere*/
	public Chaine() {
		// TODO Auto-generated constructor stub
		this.chain= new ArrayList<Polymere>();
	}
	
	/**cr�er une chaine polymere pour chaque caract�re saisie de la chaine de caract�re appel de methode transformant ces caracteres en monomere
	 * @see  Alpha et Beta retourne donc leur complementaire
	 * @see ajouterMonomere(mono) proc�dure ajoutant le monomere � l'array de monomere nomm�e Polymere*/
	public Chaine(String seq) {
		this.chain = new ArrayList<Polymere>();
		Polymere mono = null;
		
		for(int i = 0 ; i < seq.length() ; i++) {
			
			switch(seq.charAt(i)) {
				case 'A':
					mono= new Alpha();
					break;
				case 'B':
					mono = new Beta();
					break;
				}
			if(mono != null)
				this.ajouterMonomere(mono);
			
		}
	}
	
	/**Ajoute � la chaine "polymere" cr��e, le monomere constitu� � partir de la chaine de caract�re saisie*/ 
	public void ajouterMonomere(Polymere mono) {
		this.chain.add(mono);
	}
	
	/**@return recupere chaque monomere de l'array polymere*/
	public Polymere getMono(int index)
	{
		return this.chain.get(index);
	}
	
	/**@return la taille de la chaine cr�er � partir des caract�res constituants la saisie*/
	public int getTaille()
	{
		return this.chain.size();
	}
	
	/**@return en caract�re chaque monomere de l'array cr�er*/
	public String toString() {
		String str = "";
		for(int i = 0 ; i < this.chain.size() ; i++)
				str += this.chain.get(i) + " ";
				
		return str;
	}
	
	/**recupere pour chaque monomere de l'array son complementaire
	 * @see Polymere.getCompl()
	 * @return chaine polymere complementaire*/
	public Chaine getComp() {
		Chaine mtcomp = new Chaine();
		
		for(int i = 0 ; i < this.chain.size() ; i++)
			mtcomp.ajouterMonomere(this.chain.get(i).getComp());
		
		return mtcomp;
	}
	
}
