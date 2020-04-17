package ihm.cycle;

public class MeiosePara2 {

	/**PARAMETRE DE Meiose cellule2*/
	
	/**--Positions de centrioles---*/
	public static int centri1posX = 540;
    public static int centri1posY = 100;
	public static int centri2posX =520;
	public static int centri2posY= 100;
	
	/**--Positions centrioles migrantes---*/
	public static int centri1finalX=150;
	public static int centri2finalX=850;
	
	public static int micentriX=405;
	public static int mi2centriX=360;
	
	/**--Positions des centrioles répliquées---*/
	public static int centri1bisposX = 850;
    public static int centri1bisposY = 240;
	public static int centri2bisposX =150;
	public static int centri2bisposY= 380;
	
	
	/**--Position début des microtubules---*/
	/**---Positions X de gauche---*/
	public static int mt1posX = 230;
	public static int mt2posX =230;
	public static int mt3posX = 250;
	public static int mt4posX =250;
	
	/**---Positions des X de droite---*/
	public static int mt1bisposX = 870;
	public static int mt2bisposX =870;
	public static int mt3bisposX = 850;
	public static int mt4bisposX =850;
	
	/**---Positions des Y de début---*/
	public static int mt1posY = 280;
	public static int mt2posY= 300;
    public static int mt3posY = 390;
	public static int mt4posY= 415;
	
	public static int mt1bisposY = 280;
	public static int mt2bisposY= 300;
    public static int mt3bisposY = 390;
	public static int mt4bisposY= 415;
	
	/**--Positions de fin des microtubules---*/
	/**---Position X mtgauche---*/
	public static int finalmtposX = 485;
	
	/**---Position X mtdroit---*/
	public static int finalmtbposX=640;
	
	/**---Position Y des mts dans l'ordre---*/
	public static int finalmtposY1=232;
	public static int finalmtposY2=315;
	public static int finalmtposY3=400;
	public static int finalmtposY4=495;
	
	/**--Postitions de la membrane cellulaire et de la cellule---*/
	public static int membraneposX = 150;
    public static int membraneposY = 100;
    
    public static int cellposX = 150;
    public static int cellposY = 100;
    
    	/**--ADN---*/
    
    /**---Enveloppe Noyaux---*/
    public static int nucleaireX= 420;
    public static int nucleaireY= 215;
    
    	/**---Décondensé---*/
    public static int decondensX= 400;
    public static int decondensY1= 155;
    public static int decondensY2= 325;
    
    	/**Condensés non-alignés---*/
    public static int condensX=505;
    public static int condensX2= 555;
    public static int condensX3= 595;
    
    public static int condensbisX=520;
    public static int condensbisX2= 510;
    
    public static int condensY2=290;
    public static int condensY3=340;
    public static int condensY4=405;
    
    public static int condensbY1=200;    
    public static int condensbY2=condensY2 ;
    public static int condensbY3=condensY3 ;
    public static int condensbY4=condensY4 ;
    
    	/**---Condensés alignés--*/
    
    	/**--chromosomes---*/
    public static int alignchroX= 520-65;
    public static int alignchrobisX= 550;
    
    public static int alignchro1Y= 200;
    public static int alignchro2Y= 285;
    public static int alignchro3Y= 370;
    public static int alignchro4Y= 465;
    
    	/**--Chromatides---*/
    public static int alignchromatideX= 470;
    public static int alignchromatidebisX= 510;
    
    /**---Positions finale Mt et Chro---*/
    
    	/**--Gauche---*/
	public static int finaltmtchroX =250;
	public static int finalchroX2 = 350;
	
	public static int finalmtchroY =280;
	public static int finalmtchroY2 = 415;
    
    	/**--Droite---*/
	public static int finalbistmtchroX =800;
	public static int finalbischroX2 =700;
	
	public static int finalbismtchroY =280;
	public static int finalbismtchroY2 = 415;
	
	/**--final mt post-migration---*/

	
	public static int retourmtposX =230;
	public static int retourmt2posX = 250;
	public static int retourmtbisposX =870;
	public static int retourmt2bisposX = 850;

	public static int retourmtposY1 = 280;
	public static int retourmtposY2= 300;
    public static int retourmtposY3 = 390;
	public static int retourmtposY4= 415;
	
	
	/**---Anneau d'actine---*/
    public static int actineX = 500;
	public static int actineY= 100;
	
	/**--Commentaires---*/
	
	/**--gauche--*/
	public static int InitheightLabel1=500;
	public static int InitwitdhLabel1=50;
	
	/**--droit--*/
	public static int InitwitdhLabel2=700;
	public static int InitheightLabel2=20;
	
	
	/**Permet un reset des parametres*/
	public static void resetMeiosePara2() {
		/**PARAMETRE DE Meiose cellule1*/
		
		/**---Positions de centrioles---*/
		 centri1posX = 540;
	     centri1posY = 100;
		 centri2posX =520;
		 centri2posY= 100;
		
		/**---Positions centrioles migrantes---*/
		 centri1finalX=150;
		 centri2finalX=850;
		
		 micentriX=405;
		 mi2centriX=360;
		
		/**---Positions des centrioles répliquées---*/
		 centri1bisposX = 850;
	     centri1bisposY = 240;
		 centri2bisposX =150;
		 centri2bisposY= 380;
		
		
		/**---Position début des microtubules---*/
		/**---Positions X de gauche---*/
		 mt1posX = 230;
		 mt2posX =230;
		 mt3posX = 250;
		 mt4posX =250;
		
		/**---Positions des X de droite---*/
		 mt1bisposX = 870;
		 mt2bisposX =870;
		 mt3bisposX = 850;
		 mt4bisposX =850;
		
		/**---Positions des Y de début---*/
		 mt1posY = 280;
		 mt2posY= 300;
	     mt3posY = 390;
		 mt4posY= 415;
		
		 mt1bisposY = 280;
		 mt2bisposY= 300;
	     mt3bisposY = 390;
		 mt4bisposY= 415;
		
		/**---Positions de fin des microtubules---*/
		/**---Position X mtgauche---*/
		 finalmtposX = 485;
		
		/**---Position X mtdroit---*/
		 finalmtbposX=640;
		
		/**---Position Y des mts dans l'ordre---*/
		 finalmtposY1=232;
		 finalmtposY2=315;
		 finalmtposY3=400;
		 finalmtposY4=495;
		
		/**---Postitions de la membrane cellulaire et de la cellule---*/
		 membraneposX = 150;
	     membraneposY = 100;
	    
	     cellposX = 150;
	     cellposY = 100;
	    
	    	/**---ADN---*/
	    
	    /**---Enveloppe Noyaux---*/
	     nucleaireX= 420;
	     nucleaireY= 215;
	    
	    	/**---Décondensé---*/
	     decondensX= 400;
	     decondensY1= 155;
	     decondensY2= 325;
	    
	    	/**Condensés non-alignés---*/
	     condensX=505;
	     condensX2= 555;
	     condensX3= 595;
	    
	     condensbisX=520;
	     condensbisX2= 510;
	    
	     condensY2=290;
	     condensY3=340;
	     condensY4=405;
	    
	     condensbY1=200;    
	     condensbY2=condensY2 ;
	     condensbY3=condensY3 ;
	     condensbY4=condensY4 ;
	    
	    	/**---Condensés alignés--*/
	    
	    	/**---chromosomes---*/
	     alignchroX= 520-65;
	     alignchrobisX= 550;
	    
	     alignchro1Y= 200;
	     alignchro2Y= 285;
	     alignchro3Y= 370;
	     alignchro4Y= 465;
	    
	    	/**---Chromatides---*/
	     alignchromatideX= 470;
	     alignchromatidebisX= 510;
	    
	    /**---Positions finale Mt et Chro---*/
	    
	    	/**---Gauche---*/
		 finaltmtchroX =250;
		 finalchroX2 = 350;
		
		 finalmtchroY =280;
		 finalmtchroY2 = 415;
	    
	    	/**---Droite---*/
		 finalbistmtchroX =800;
		 finalbischroX2 =700;
		
		 finalbismtchroY =280;
		 finalbismtchroY2 = 415;
		
		/**---final mt post-migration---*/

		
		 retourmtposX =230;
		 retourmt2posX = 250;
		 retourmtbisposX =870;
		 retourmt2bisposX = 850;

		 retourmtposY1 = 280;
		 retourmtposY2= 300;
	     retourmtposY3 = 390;
		 retourmtposY4= 415;
		
		
		/**----Anneau d'actine---*/
	     actineX = 500;
		 actineY= 100;
		
		/**---Commentaires---*/
		
		/**--gauche--*/
		 InitheightLabel1=500;
		 InitwitdhLabel1=50;
		
		/**--droit--*/
		 InitwitdhLabel2=700;
		 InitheightLabel2=20;
		
		}
}
