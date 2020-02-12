/**
 * 
 */
package heritage;

/**
 * @author franc
 *
 */
public class Personne {
	private Chromosome paire1;
	private Chromosome paire2;
	private Chromosome paire3;
	private Chromosome paire4;
	/**
	 * @param paire1
	 * @param paire2
	 * @param paire3
	 * @param paire4
	 */
	public Personne(Chromosome paire1, Chromosome paire2, Chromosome paire3, Chromosome paire4) {
		this.paire1 = paire1;
		this.paire2 = paire2;
		this.paire3 = paire3;
		this.paire4 = paire4;
	}
	@Override
	
	public String toString() {
		return "le genome est donc \n" +  paire1.toString() +"\n" + paire2.toString() + "\n" + paire3.toString() + "\n" + paire4.toString();
	}
	/**
	 * @return the paire1
	 */
	public Chromosome getPaire1() {
		return paire1;
	}
	/**
	 * @param paire1 the paire1 to set
	 */
	public void setPaire1(Chromosome paire1) {
		this.paire1 = paire1;
	}
	/**
	 * @return the paire2
	 */
	public Chromosome getPaire2() {
		return paire2;
	}
	/**
	 * @param paire2 the paire2 to set
	 */
	public void setPaire2(Chromosome paire2) {
		this.paire2 = paire2;
	}
	/**
	 * @return the paire3
	 */
	public Chromosome getPaire3() {
		return paire3;
	}
	/**
	 * @param paire3 the paire3 to set
	 */
	public void setPaire3(Chromosome paire3) {
		this.paire3 = paire3;
	}
	/**
	 * @return the paire4
	 */
	public Chromosome getPaire4() {
		return paire4;
	}
	/**
	 * @param paire4 the paire4 to set
	 */
	public void setPaire4(Chromosome paire4) {
		this.paire4 = paire4;
	}
	public String reunir(Gametes a,Gametes b) {
		
		return a.toString()+ b.toString();
		
	}
	
	

}
