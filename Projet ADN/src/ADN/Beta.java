package ADN;

public class Beta extends Polymere{

	private Polymere comp;
	/**Constructeur Beta herite de Polymere: c'est un type de polymere*/
	public Beta() {
		// TODO Auto-generated constructor stub
		super ("Bet");
		this.comp=comp;
	}

	/**Retourne le monomere Alpha complementaire de beta:*/
	public Polymere getComp() {
		this.comp= new Alpha();
		return comp;
	}
	
	
	public void setComp(Polymere comp) {
		this.comp = comp;
	}
	
	
}
