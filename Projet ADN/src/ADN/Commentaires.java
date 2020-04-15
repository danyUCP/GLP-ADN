package ADN;

public class Commentaires {

	public static void interphase() {
		System.out.println("\n <span color='blue'>\n INTERPHASE: \n phase G1: -Separation des centrioles \n"
				+ "\n S: -Duplication des centrioles \n"+"\n -Duplication ADN non condense \n</span>"
				+" <span color='red'>G2: Controle de bonne replication, sinon → Anomalies, cancer...</span>");
	}
	
	public static void prophase() {
		System.out.println("\n <span color='blue'>\n PROPHASE: \n Condensation des chromosomes \n </span>");
	}
	
	public static void methaphase() {
		System.out.println("\n <span color='blue'>\n PROMETAPHASE: \n Suppression membrane nucléaire \n"
				+ "\n Alignement chromosomique \n"+"\n METHAPHASE \n Accroche aux microtubules</span>");
	}
	
	public static void anaphase() {
		System.out.println("\n <span color='blue'>\n ANAPHASE: \n Migration vers les pôles \n </span>");
	}
	
	public static void telophase() {
		System.out.println("\n <span color='blue'>\n TELOPHASE: \n -Deux noyaux apparaissent + decondensation ADN \n"
				+ "\n -Cytokynese: apparition d'anneau d'actine → coupe la cellule en deux </span>");
	}
}
