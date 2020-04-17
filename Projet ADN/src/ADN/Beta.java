package ADN;

public class Beta extends Polymeres{

	private Polymeres comp;
	/**Constructeur Beta herite de Polymere: c'est un type de polymere*/
	public Beta() {
		// TODO Auto-generated constructor stub
		super ("Beta");
		this.comp=comp;
	}

	/**Retourne le polymere Alpha complementaire de beta:*/
	public Polymeres getComp() {
		this.comp= new Alpha();
		return comp;
	}
	
	
	public void setComp(Polymeres comp) {
		this.comp = comp;
	}
	
	
}
