package ihm.heritage;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import heritage.Chromatide;
import heritage.Personne;



public class ChromatideIcon extends JLabel {
	
	private static  HashMap<Chromatide, ImageIcon> iconMap;

	private ImageIcon iconChr;
	private int posX;
	private int posY;
	private int largeur;
	private int longueur;
	private Chromatide c;
	
	private void initMap()
	{
		iconMap = new HashMap<Chromatide, ImageIcon>();
		
		Chromatide c1= new Chromatide();
		Chromatide c2= new Chromatide();
		Chromatide c3= new Chromatide();
		Chromatide c4= new Chromatide();
		
		iconMap.put(c1, new ImageIcon("c1c1.png"));
		iconMap.put(c2, new ImageIcon("c2c1.png"));
		iconMap.put(c3, new ImageIcon("c3c1.png"));
		iconMap.put(c4, new ImageIcon("c4c1.png"));
		
		System.out.println("IconMap initialisée");	
		System.out.println(iconMap);
	}

	/**
	 *
	 * @param p
	 */
	public ChromatideIcon( Chromatide c) {
		this.c = c;
		if(iconMap == null){	
				initMap();	
			}
			
		if(iconMap.size()==4){
			this.iconChr=iconMap.get(1);
			//iconMap.remove("c4", "c4c1");
					
			}
		
		
		
	}
	
	
}
