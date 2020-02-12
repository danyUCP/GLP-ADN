package ADN;

public class Beta extends Polymere{

	private Polymere comp;
	
	public Beta() {
		// TODO Auto-generated constructor stub
		super ("Beta");
		this.comp=comp;
	}

	public Polymere getComp() {
		this.comp= new Alpha();
		return comp;
	}
}
