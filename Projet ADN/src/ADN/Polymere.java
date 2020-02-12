package ADN;

public abstract class Polymere {
	
	private String name;
	
	public Polymere(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	public abstract Polymere getComp();
	
	public String toString() {
		return name;
	}
	

}
