package ADN;

public class Alpha extends Polymere{

	private Polymere comp;
	/**Constructeur Alpha herite de Polymere: c'est un type de polymere*/
	public Alpha() {
		// TODO Auto-generated constructor stub
		super ("Alf");
		this.comp=comp;
	}
	/**Retourne le monomere Beta complementaire de alpha:*/
	public Polymere getComp() {
		this.comp= new Beta();
		return comp;
	}

	
	public void setComp(Polymere comp) {
		this.comp = comp;
	}
	
	

}
