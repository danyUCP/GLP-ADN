package heritage;

public class PhenotypeGroupe {
	private Personne per;
	private String poly;
	private String suite;
	private Allele part1;
	private Allele part2;
	/**
	 * @param per
	 */
	public PhenotypeGroupe(Personne per) {
		super();
		this.per = per;
		
		part1=per.getPaire1().getPart1().getG1();
		part2=per.getPaire1().getPart2().getG1();
		
		if((part1.getNameA()=="0")&(part2.getNameA()=="0")) {
			poly="La personne a deux all�les O: "
			+ "elle est homozygote et est de groupe sanguin O";
			suite="";
		}
		else if((part1.getNameA()=="A")&(part2.getNameA()=="A")) {
			poly="La personne a deux all�les A: "
			+ "elle est homozygote et est de groupe sanguin A";
			suite="";
		}
		else if((part1.getNameA()=="B")&(part2.getNameA()=="B")) {
			poly="La personne a deux all�les B: "
			+ "elle est homozygote et est de groupe sanguin B";
			suite="";
		}
		else if((part1.getNameA()=="0")&(part2.getNameA()=="A")) {
			poly="La personne a un all�le A et un all�le O: "
			+ "elle est h�t�rozygote et comme A est dominant";
			suite="par rapport � O, la personne est de groupe sanguin A";
		}
		else if((part1.getNameA()=="A")&(part2.getNameA()=="0")) {
			poly="La personne a un all�le A et un all�le O: "
			+ "elle est h�t�rozygote et comme A est dominant";
			suite="par rapport � O, la personne est de groupe sanguin A";
		}
		else if((part1.getNameA()=="0")&(part2.getNameA()=="B")) {
			poly="La personne a un all�le B et un all�le O: "
			+ "elle est h�t�rozygote et comme B est dominant";
			suite="par rapport � O, la personne est de groupe sanguin B";
		}
		else if((part1.getNameA()=="B")&(part2.getNameA()=="O")) {
			poly="La personne a un all�le B et un all�le O: "
			+ "elle est h�t�rozygote et comme B est dominant";
			suite="par rapport � O, la personne est de groupe sanguin B";
		}
		
		else {
			poly="La personne a un all�le A et un all�le B "
			+ "elle est h�t�rozygote et comme ces deux all�les ont la m�me dominance ";
			suite="La personne est de groupe sanguin AB";
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
