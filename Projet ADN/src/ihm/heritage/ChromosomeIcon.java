package ihm.heritage;

import java.util.ArrayList;

import javax.swing.JLabel;

import heritage.Chromosome;
import heritage.Personne;

public class ChromosomeIcon {
	private ArrayList<ChromatideIcon> liste;
	private Chromosome c;
	private JLabel paire;
	/**
	 * @param c
	 */
	public ChromosomeIcon(Chromosome c) {
		this.c = c;
		this.paire=new JLabel();
		initList();
		
		
	}
	
	private void initList()
	{
		this.liste = new ArrayList<ChromatideIcon>();
		ChromatideIcon part1=new ChromatideIcon(this.c.getPart1());
		ChromatideIcon part2=new ChromatideIcon(this.c.getPart2());
		
		liste.add(part1);
		liste.add(part2);
		
		
		
		System.out.println("Liste de nucléotides composantes initialisée");	
		System.out.println(liste);

	}
	
}
