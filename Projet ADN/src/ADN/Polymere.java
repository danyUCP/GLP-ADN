package ADN;


public abstract class Polymere {
	
	private String name;
	
	/**Constructeur caracterisé par le nom du monomere consituant Polymere*/
	public Polymere(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	/**methode abstraite qui permettra de recupere de monomere complementaire constituant l'arraypolymere*/
	public abstract Polymere getComp();
	
	public abstract void setComp(Polymere comp);
	
	/**@return le nom du monomere*/
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	

}
