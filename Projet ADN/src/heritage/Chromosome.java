package heritage;

public class Chromosome {
	private Chromatide part1;
	private Chromatide part2;
	/**
	 * @param part1
	 * @param part2
	 */
	public Chromosome(Chromatide part1, Chromatide part2) {
		super();
		this.part1 = part1;
		this.part2 = part2;
	}
	/**
	 * @return the part1
	 */
	public Chromatide getPart1() {
		return part1;
	}
	/**
	 * @param part1 the part1 to set
	 */
	public void setPart1(Chromatide part1) {
		this.part1 = part1;
	}
	/**
	 * @return the part2
	 */
	public Chromatide getPart2() {
		return part2;
	}
	/**
	 * @param part2 the part2 to set
	 */
	public void setPart2(Chromatide part2) {
		this.part2 = part2;
	}
	
	
	@Override
	public String toString() {
		return part1.toString() +" " + part2.toString();
	}
	
	
	
	
	}

	