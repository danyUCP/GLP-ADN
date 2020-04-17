package ADN;


public abstract class Polymeres {
	
	private String name;
	
	/**Constructeur caracteris� par le nom du polym�re constituant Polymere*/
	public Polymeres(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	/**methode abstraite qui permettra de recupere de polym�re complementaire*/
	public abstract Polymeres getComp();
	
	public abstract void setComp(Polymeres comp);
	
	/**@return le nom du polym�re*/
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	

}
