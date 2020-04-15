package heritage;

public class  Chromatide
{
	private Allele g1;
	private Allele g2;
	
	
		
	/**
	 * @param g1
	 * @param g2
	 */
	public Chromatide(Allele g1, Allele g2) {
		super();
		this.g1 = g1;
		this.g2 = g2;
	}
	
	/**
	 * @param g1
	 */
	public Chromatide(Allele g1) {
		super();
		this.g1 = g1;
	}

	
	/**
	 * 
	 */
	public Chromatide() {
		super();
	}

	/**
	 * @return the g1
	 */
	public Allele getG1() {
		return g1;
	}
	/**
	 * @param g1 the g1 to set
	 */
	public void setG1(Allele g1) {
		this.g1 = g1;
	}
	/**
	 * @return the g2
	 */
	public Allele getG2() {
		return g2;
	}
	/**
	 * @param g2 the g2 to set
	 */
	public void setG2(Allele g2) {
		this.g2 = g2;
	}
	@Override
	public String toString() {
		if (g2	!= null) {
			return g1.toString() + g2.toString() ;
		}
		else {
			return g1.toString() ;
		}
	}
	
	
	
}
