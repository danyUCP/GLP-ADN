package heritage;

public class GametesU {
	
	private ChromatideU test;
	private Gametes g;
	
	/**
	 * @param test
	 */
	public GametesU(ChromatideU test,Gametes g) {
		this.g=g;
		this.test = test;
		int indiceAuHasard1 = (int) (Math.random() * 2);
		int indiceAuHasard2 = (int) (Math.random() * 2);
		int indiceAuHasard3 = (int) (Math.random() * 2);
		int indiceAuHasard4 = (int) (Math.random() * 2);
		
		Chromatide n1=new Chromatide();
		Chromatide n2=new Chromatide();
		Chromatide n3=new Chromatide();
		Chromatide n4=new Chromatide();
		
		n1=test.getG1().get(indiceAuHasard1);
		n2=test.getG2().get(indiceAuHasard2);
		n3=test.getG3().get(indiceAuHasard3);
		n4=test.getG4().get(indiceAuHasard4);
		
		this.g.construire(n1);
		this.g.construire(n2);
		this.g.construire(n3);
		this.g.construire(n4);
		
	}
	@Override
	public String toString() {
		return " g=" + g ;
	}
	/**
	 * @return the g
	 */
	public Gametes getG() {
		return g;
	}
	/**
	 * @param g the g to set
	 */
	public void setG(Gametes g) {
		this.g = g;
	}
	/**
	 * @return the test
	 */
	public ChromatideU getTest() {
		return test;
	}
			
	

}
