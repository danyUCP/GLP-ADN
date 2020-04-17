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
		part2=per.getPaire1().getPart1().getG1();
		
		if((part1.getNameA()=="0")&(part2.getNameA()=="0")) {
			poly="La personne a deux allèles O: "
			+ "elle est homozygote et est de groupe sanguin O";
			suite="";
		}
		if((part1.getNameA()=="A")&(part2.getNameA()=="A")) {
			poly="La personne a deux allèles A: "
			+ "elle est homozygote et est de groupe sanguin A";
			suite="";
		}
		if((part1.getNameA()=="B")&(part2.getNameA()=="B")) {
			poly="La personne a deux allèles B: "
			+ "elle est homozygote et est de groupe sanguin B";
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

}
