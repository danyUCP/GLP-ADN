package ihm.cycle;

import java.util.ArrayList;

import javax.swing.JLabel;

import ADN.Chaine;

public class ChainBuilder {
	private ArrayList<Microtubs> poly;
	private JLabel polypile;
	private Chaine pile;
	private boolean orientation;
	
	/**Constructeur constitué des polymeres initialisé*/
	public ChainBuilder(Chaine pile) {
		this.pile = pile;
		this.orientation = true;
		
		initList();
		
		this.polypile = new JLabel();
	}
	
	/**Constructeur constitué des polymeres initialisé, caractérisé par l'orientation*/
	public ChainBuilder(Chaine pile, boolean orientation) {
		this.pile = pile;
		this.orientation = orientation;
		
		initList();
		
		this.polypile = new JLabel();
	}
	
	/**Affiche la chaine de monomere formant les polymeres*/
	private void initList() {
		this.poly = new ArrayList<Microtubs>();
		
		for(int i = 0 ; i < pile.getTaille() ; i++)
			this.poly.add(new Microtubs(pile.getMono(i), i, -1, orientation));

	}
	
	/**Création du label à artir de l'array de l'array de polymere*/
	public JLabel creerPile(int x, int y) {
		this.polypile.setLayout(null);
		this.polypile.setSize(70, 75);
		
		this.polypile.setLocation(70, 330 + (y * 75));

		
		for(int i = 0 ; i < poly.size() ; i++)
			this.polypile.add(this.poly.get(i));

			return polypile;
	}
	
	/**@return la longueur de l'array*/
	public int getTaille() {
		return this.poly.size();
	}
		

}
