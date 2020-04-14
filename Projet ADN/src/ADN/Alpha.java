package ADN;

public class Alpha extends Polymere{

	private Polymere comp;
	
	public Alpha() {
		// TODO Auto-generated constructor stub
		super ("Alpha");
		this.comp=comp;
	}

	public Polymere getComp() {
		this.comp= new Beta();
		return comp;
	}

	
	public void setComp(Polymere comp) {
		this.comp = comp;
	}
	
	

}
