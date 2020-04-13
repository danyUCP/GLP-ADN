package heritage;

public class GametesU {
	
	private ChromatideU test;
	private Gametes g;
	private Chromatide n1;
	private Chromatide n2;
	private Chromatide n3;
	private Chromatide n4;
	
	
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
		
		this.n1=new Chromatide();
		this.n2=new Chromatide();
		this.n3=new Chromatide();
		this.n4=new Chromatide();
		
		n1=test.getG1().get(indiceAuHasard1);
		n2=test.getG2().get(indiceAuHasard2);
		n3=test.getG3().get(indiceAuHasard3);
		n4=test.getG4().get(indiceAuHasard4);
		
		this.g.construire(n1);
		this.g.construire(n2);
		this.g.construire(n3);
		this.g.construire(n4);
		
	}
	/**
	 * @return the n1
	 */
	public Chromatide getN1() {
		return n1;
	}
	/**
	 * @param n1 the n1 to set
	 */
	public void setN1(Chromatide n1) {
		this.n1 = n1;
	}
	/**
	 * @return the n2
	 */
	public Chromatide getN2() {
		return n2;
	}
	/**
	 * @param n2 the n2 to set
	 */
	public void setN2(Chromatide n2) {
		this.n2 = n2;
	}
	/**
	 * @return the n3
	 */
	public Chromatide getN3() {
		return n3;
	}
	/**
	 * @param n3 the n3 to set
	 */
	public void setN3(Chromatide n3) {
		this.n3 = n3;
	}
	/**
	 * @return the n4
	 */
	public Chromatide getN4() {
		return n4;
	}
	/**
	 * @param n4 the n4 to set
	 */
	public void setN4(Chromatide n4) {
		this.n4 = n4;
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
