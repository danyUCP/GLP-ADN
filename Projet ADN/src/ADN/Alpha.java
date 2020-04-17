package ADN;

public class Alpha extends Polymeres{

	private Polymeres comp;
	/**Constructeur Alpha herite de Polymere: c'est un type de polymere*/
	public Alpha() {
		// TODO Auto-generated constructor stub
		super ("Alpha");
		this.comp=comp;
	}
	/**Retourne le polymere Beta complementaire de alpha:*/
	public Polymeres getComp() {
		this.comp= new Beta();
		return comp;
	}

	
	public void setComp(Polymeres comp) {
		this.comp = comp;
	}
	
	

}
