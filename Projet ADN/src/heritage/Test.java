/**
 * 
 */
package heritage;
import ihm.Fenetre;



/**
 * @author franc
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Gene groupeSanguin = new Gene("groupeSanguin");
		Allele o = new Allele("groupeSanguin","O",20);
		Allele a = new Allele("groupeSanguin","A",50);
		Allele b = new Allele("groupeSanguin","B",50);
		
		Gene yeux= new Gene ("yeux");
		Allele blue = new Allele("yeux","b",20);
		Allele brown = new Allele("yeux","B",60);
		
		Gene polydactylie = new Gene ("polydactylie");
		Allele polyp= new Allele("polydactylie","p",20);
		Allele polyP= new Allele("polydactylie","P",50);
				
		Gene albinisme = new Gene ("albinism");
		Allele aa= new Allele("albinism","a",20);
		Allele aA= new Allele("albinism","A",60);
		
		Chromatide c1c1 = new Chromatide(o,aA);
		Chromatide c1c2 = new Chromatide(a,aa);
		Chromatide c2c1 = new Chromatide(polyp);
		Chromatide c2c2= new Chromatide (polyP);
		Chromatide c3c1= new Chromatide (blue);
		Chromatide c3c2= new Chromatide (brown);
		
		
		
		Chromosome c1= new Chromosome(c1c1,c1c2);
		Chromosome c2 = new Chromosome(c2c1,c2c2);
		Chromosome c3 = new Chromosome(c3c1,c3c2);
		Personne pere = new Personne (c1,c2,c3,c1,"pere");
		Personne mere = new Personne (c1,c2,c3,c1,"mere");
		
		ChromatideU test = new ChromatideU(pere);
		ChromatideU testm = new ChromatideU(mere);
		
		Gametes ovuleU=new Gametes();
		Gametes sperU=new Gametes();
		
		GametesU ovule= new GametesU(testm,ovuleU);
		GametesU spermatozoide= new GametesU(test,sperU);
		
		Personne enfant=new Personne(ovule,spermatozoide,"enfant");
				
	
	
		System.out.println(pere);
		System.out.println(mere);
		System.out.println(ovule);
		System.out.println(test);
		System.out.println(spermatozoide);
		System.out.println(enfant);
		Fenetre fen=new Fenetre();

		
	
	}

}
