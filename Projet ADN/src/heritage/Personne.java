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
	private GametesU ovule;
	private GametesU spermatozoide;
	private String nom;
	
	
	
	/**
	 * @param ovule
	 * @param spermatozoide
	 */
	public Personne(GametesU ovule, GametesU spermatozoide,String nom) {
		this.nom=nom;
		this.ovule = ovule;
		this.spermatozoide = spermatozoide;
		
		Chromatide c1 = new Chromatide();
		Chromatide c2 = new Chromatide();
		Chromatide c3 = new Chromatide();
		Chromatide c4 = new Chromatide();
		Chromatide c5 = new Chromatide();
		Chromatide c6 = new Chromatide();
		Chromatide c7 = new Chromatide();
		Chromatide c8 = new Chromatide();
		
		c1=ovule.getG().getListe1().get(0);
		c2=ovule.getG().getListe1().get(1);
		c3=ovule.getG().getListe1().get(2);
		c4=ovule.getG().getListe1().get(3);
		
		c5=spermatozoide.getG().getListe1().get(0);
		c6=spermatozoide.getG().getListe1().get(1);
		c7=spermatozoide.getG().getListe1().get(2);
		c8=spermatozoide.getG().getListe1().get(3);
		
		this.paire1=new Chromosome(c1,c5);
		this.paire2=new Chromosome(c2,c6);
		this.paire3=new Chromosome(c3,c7);
		this.paire4=new Chromosome(c4,c8);
		
		
		
		
	}




	/**
	 * @param paire1
	 * @param paire2
	 * @param paire3
	 * @param paire4
	 */
	public Personne(Chromosome paire1, Chromosome paire2, Chromosome paire3, Chromosome paire4,String nom) {
		this.paire1 = paire1;
		this.paire2 = paire2;
		this.paire3 = paire3;
		this.paire4 = paire4;
		this.nom=nom;
	}
	



	@Override
	
	public String toString() {
		return nom +": \n" +  paire1.toString() +"\n" + paire2.toString() + "\n" + paire3.toString() + "\n" + paire4.toString();
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}




	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
	
	

}
