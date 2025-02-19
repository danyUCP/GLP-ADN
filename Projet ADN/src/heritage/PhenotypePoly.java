package heritage;

public class PhenotypePoly {
	private Personne per;
	private String poly;
	private String suite;


	/**
	 * @param per
	 */
	public PhenotypePoly(Personne per) {
		super();
		this.per = per;
		
		if((per.getPaire2().getPart1().getG1().getNameA()=="P")&(per.getPaire2().getPart2().getG1().getNameA()=="P")){
			poly="La personne a deux all�les P(version normale du g�ne): "
			+ "elle est homozygote et n'a donc pas la polydactilye";
			suite="";
		}
		
		else if((per.getPaire2().getPart1().getG1().getNameA()=="p")&(per.getPaire2().getPart2().getG1().getNameA()=="p")){
			poly="La personne a deux all�les p(version mut�e du g�ne): "
					+ "Elle est homozygote et a donc la polydactilye";
			suite="";
			
		}
		else {
			poly="La personne a un all�le P(version normale du g�ne) et un all�le p(version mut�e du g�ne). Elle est h�t�rozygote et ";
				suite =	 "comme P est dominant et p est r�cessif, la personne n'a donc pas la polydactylie";
			
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
