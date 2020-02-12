/**
 * 
 */
package heritage;

/**
 * @author franc
 *
 */
public class Gene {
	private String nameG;

	public Gene(String name) {
		this.nameG = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return nameG;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.nameG = name;
	}

	@Override
	public String toString() {
		return "gène " + getName() ;
		
	}
	
	
	
}
