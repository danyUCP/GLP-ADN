package heritage;
import java.util.ArrayList;

public class ChromatideU  {
	private Personne p;
	private ArrayList<Chromatide> g1;
	private ArrayList<Chromatide>  g2;
	private ArrayList <Chromatide>g3;
	private ArrayList<Chromatide> g4;
	/**
	 * @param p
	 */
	public ChromatideU(Personne p) {
		this.p = p;
		
		this.g1 = new ArrayList<Chromatide>();
		this.g1.add(p.getPaire1().getPart1());
		this.g1.add(p.getPaire1().getPart2());
		
		this.g2 = new ArrayList<Chromatide>();
		this.g2.add(p.getPaire2().getPart1());
		this.g2.add(p.getPaire2().getPart2());
		
		this.g3 = new ArrayList<Chromatide>();
		this.g3.add(p.getPaire3().getPart1());
		this.g3.add(p.getPaire3().getPart2());
		
		this.g4 = new ArrayList<Chromatide>();
		this.g4.add(p.getPaire4().getPart1());
		this.g4.add(p.getPaire4().getPart2());
		
		
	}
	/**
	 * @return the g1
	 */
	public ArrayList<Chromatide> getG1() {
		return g1;
	}
	/**
	 * @param g1 the g1 to set
	 */
	public void setG1(ArrayList<Chromatide> g1) {
		this.g1 = g1;
	}
	/**
	 * @return the g2
	 */
	public ArrayList<Chromatide> getG2() {
		return g2;
	}
	/**
	 * @param g2 the g2 to set
	 */
	public void setG2(ArrayList<Chromatide> g2) {
		this.g2 = g2;
	}
	/**
	 * @return the g3
	 */
	public ArrayList<Chromatide> getG3() {
		return g3;
	}
	/**
	 * @param g3 the g3 to set
	 */
	public void setG3(ArrayList<Chromatide> g3) {
		this.g3 = g3;
	}
	/**
	 * @return the g4
	 */
	public ArrayList<Chromatide> getG4() {
		return g4;
	}
	/**
	 * @param g4 the g4 to set
	 */
	public void setG4(ArrayList<Chromatide> g4) {
		this.g4 = g4;
	}
	@Override
	public String toString() {
		return "ChromatideU [g1=" + g1 + ", g2=" + g2 + ", g3=" + g3 + ", g4=" + g4 + "]";
	}
		
	
	

}
