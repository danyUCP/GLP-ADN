package ADN;


public abstract class Polymeres {
	
	private String name;
	
	/**Constructeur caracterisé par le nom du polymère constituant Polymere*/
	public Polymeres(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	/**methode abstraite qui permettra de recupere de polymère complementaire*/
	public abstract Polymeres getComp();
	
	public abstract void setComp(Polymeres comp);
	
	/**@return le nom du polymère*/
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	

}
