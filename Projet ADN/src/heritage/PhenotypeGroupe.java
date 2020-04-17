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
			poly="La personne a deux all�les O: "
			+ "elle est homozygote et est de groupe sanguin O";
			suite="";
		}
		if((part1.getNameA()=="A")&(part2.getNameA()=="A")) {
			poly="La personne a deux all�les A: "
			+ "elle est homozygote et est de groupe sanguin A";
			suite="";
		}
		if((part1.getNameA()=="B")&(part2.getNameA()=="B")) {
			poly="La personne a deux all�les B: "
			+ "elle est homozygote et est de groupe sanguin B";
			suite="";
		}
		else if((part1.getNameA()=="C")&(part2.getNameA()=="C")) {
			poly="La personne a deux all�les C: "
			+ "elle est homozygote et a donc le nez crochu";
			suite="";
		}
		else {
			poly="La personne a un all�le C et un all�le F "
			+ "elle est h�t�rozygote et comme F est dominant par rapport � C ";
			suite="La personne a donc le nez fin";
		}
		
	}

}
