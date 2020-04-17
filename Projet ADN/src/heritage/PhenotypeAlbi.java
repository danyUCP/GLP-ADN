package heritage;

public class PhenotypeAlbi {
	private Personne per;
	private String poly;
	private String suite;
	

	/**
	 * @param per
	 */
	public PhenotypeAlbi(Personne per) {
		super();
		this.per = per;
		
		if((per.getPaire1().getPart1().getG2().getNameA()=="AL")&(per.getPaire1().getPart2().getG2().getNameA()=="AL")){
			poly="La personne a deux allèles AL(version normale du gène): "
			+ "elle est homozygote et n'est donc pas albinos";
			suite="";
		}
		
		else if((per.getPaire1().getPart1().getG2().getNameA()=="al")&(per.getPaire1().getPart2().getG2().getNameA()=="al")){
			poly="La personne a deux allèles al(version mutée du gène): "
					+ "Elle est homozygote et est donc albinos";
			suite="";
			
		}
		else {
			poly="La personne a un allèle AL(version normale du gène) et un allèle al(version mutée du gène). Elle est hétérozygote et ";
				suite =	 "comme AL est dominant et al est récessif, la personne n'est donc pas albinos";
			
		}
		
		
	}


	/**
	 * @return the suite
	 */
	public String getSuite() {
		return suite;
	}


	/**
	 * @param suite the suite to set
	 */
	public void setSuite(String suite) {
		this.suite = suite;
	}


	/**
	 * @return the poly
	 */
	public String getPoly() {
		return poly;
	}


	/**
	 * @param poly the poly to set
	 */
	public void setPoly(String poly) {
		this.poly = poly;
	}

}
