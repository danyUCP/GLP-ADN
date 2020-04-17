package heritage;

public class PhenotypeNez {
	private Personne per;
	private String poly;
	private String suite;
	private Allele part1;
	private Allele part2;
	/**
	 * @param per
	 */
	public PhenotypeNez(Personne per) {
		super();
		this.per = per;
		
		part1=per.getPaire4().getPart1().getG1();
		part2=per.getPaire4().getPart1().getG1();
		
		if((part1.getNameA()=="F")&(part2.getNameA()=="F")) {
			poly="La personne a deux allèles F: "
			+ "elle est homozygote et a donc le nez fin";
			suite="";
		}
		else if((part1.getNameA()=="C")&(part2.getNameA()=="C")) {
			poly="La personne a deux allèles C: "
			+ "elle est homozygote et a donc le nez crochu";
			suite="";
		}
		else {
			poly="La personne a un allèle C et un allèle F "
			+ "elle est hétérozygote et comme F est dominant par rapport à C ";
			suite="La personne a donc le nez fin";
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
	
}
