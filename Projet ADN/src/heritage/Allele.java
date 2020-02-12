package heritage;

public class Allele extends Gene {
	private String nameA;
	private int dominance;
	/**
	 * @param name
	 * @param name2
	 * @param dominance
	 */
	public Allele( String name1,String name2, int dominance) {
		super(name1);
		this.nameA=name2;
		this.dominance = dominance;
	}
	
	
	/**
	 * @return the nameA
	 */
	public String getNameA() {
		return nameA;
	}
	/**
	 * @param nameA the nameA to set
	 */
	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	/**
	 * @return the dominance
	 */
	public int getDominance() {
		return dominance;
	}
	/**
	 * @param dominance the dominance to set
	 */
	public void setDominance(int dominance) {
		this.dominance = dominance;
	}


	@Override
	public String toString() {
		return getNameA();
	}
	
	

}
