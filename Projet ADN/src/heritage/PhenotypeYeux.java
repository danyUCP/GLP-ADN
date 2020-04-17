package heritage;

import java.util.ArrayList;

public class PhenotypeYeux {
	private Personne per;
	private String yeux;
	private String suite;
	

	/**
	 * @param per
	 */
	public PhenotypeYeux(Personne per) {
		super();
		this.per = per;
		
		if((per.getPaire3().getPart1().getG1().getNameA()=="b")&(per.getPaire3().getPart2().getG1().getNameA()=="b")){
			yeux="La personne a deux all�les b: elle "
					+ "est homozygote et a donc les yeux bleus";
			suite="";
		}
		
		else if((per.getPaire3().getPart1().getG1().getNameA()=="M")&(per.getPaire3().getPart2().getG1().getNameA()=="M")){
			yeux="La personne a deux all�les M: elle "
					+ "est homozygote et a donc les yeux marrons";
			suite="";
		}
		else {
			yeux="La personne a un all�le b et un all�le M: "
					+ "elle est h�t�rozygote. Mais comme ";
					suite= "l'all�le M est dominant par rapport � b, La personne a les yeux marrons";
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
	 * @return the yeux
	 */
	public String getYeux() {
		return yeux;
	}


	/**
	 * @param yeux the yeux to set
	 */
	public void setYeux(String yeux) {
		this.yeux = yeux;
	}
	

}
