package heritage;

public class PhenotypePoly {
	private Personne per;
	private String poly;
	private String suite;
	private String suite1;
	private String suite2;

	/**
	 * @param per
	 */
	public PhenotypePoly(Personne per) {
		super();
		this.per = per;
		
		if((per.getPaire2().getPart1().getG1().getNameA()=="P")&(per.getPaire2().getPart2().getG1().getNameA()=="P")){
			poly="La personne a deux allèles P(version normale du gène): "
			+ "elle est homozygote et n'a donc pas la polydactilye";
			suite="";
		}
		
		else if((per.getPaire2().getPart1().getG1().getNameA()=="p")&(per.getPaire2().getPart2().getG1().getNameA()=="p")){
			poly="La personne a deux allèles p(version mutée du gène): "
					+ "Elle est homozygote et a donc la polydactilye";
			suite="";
			suite="";
		}
		else {
			poly="La personne a un allèle P(version normale du gène) et un allèle p(version mutée du gène). Elle est hétérozygote et ";
				suite =	 "comme P est dominant et p est récessif, la personne n'a donc pas la polydactylie";
			
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
	 * @return the suite1
	 */
	public String getSuite1() {
		return suite1;
	}


	/**
	 * @param suite1 the suite1 to set
	 */
	public void setSuite1(String suite1) {
		this.suite1 = suite1;
	}


	/**
	 * @return the suite2
	 */
	public String getSuite2() {
		return suite2;
	}


	/**
	 * @param suite2 the suite2 to set
	 */
	public void setSuite2(String suite2) {
		this.suite2 = suite2;
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
