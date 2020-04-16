package heritage;

public class PhenotypePoly {
	private Personne per;
	private String poly;
	

	/**
	 * @param per
	 */
	public PhenotypePoly(Personne per) {
		super();
		this.per = per;
		
		if((per.getPaire2().getPart1().getG1().getNameA()=="P")&(per.getPaire2().getPart2().getG1().getNameA()=="P")){
			poly="La personne a deux allèles P(version normale du gène): Elle est homozygote et n'a donc pas la polydactilye";
		}
		
		else if((per.getPaire2().getPart1().getG1().getNameA()=="p")&(per.getPaire2().getPart2().getG1().getNameA()=="p")){
			poly="La personne a deux allèles p(version mutée du gène): Elle est homozygote et a donc la polydactilye";
		}
		else {
			poly="La personne a un allèle P(version normale du gène) et un allèle p(version mutée du gène)"
					+ "Elle est hétérozygote et comme P est dominant et p est récessif, la personne n'a donc pas la polydactylie";
			
		}
		
		
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
