package Gioco;

/*
INFORMAZIONI UTILI:
60 CARTE AVVENTURA
156 COMPONENTI DI ASTRONAVE --> CONNETTORI LATI



6 TESSERE TITOLO CAMIONISTA


2 DADI


CREATE
55 BLOCCHI MERCE
40 BATTERIE
42 ASTRONAUTI BIANCHI
68 TESSERE CREDITO COSMICO	--> CREDITI COLORE
4 ALIENI MARRONI, 4 VIOLA
 */


public class Magazzino {
	//MERCE			-->> TODO METTERE I VALORI GIUSTI ALLE COSTANTI IN BASE AL NUMERO DEI PEZZI
	private Merci[] merceRosse;
	private Merci[] merceVerde;
    private Merci[] merceGialla;
    private Merci[] merceBlu;
	private final int QUANTITA_MERCE_ROSSA = 8;
	private final int QUANTITA_MERCE_VERDE = 8;
    private final int QUANTITA_MERCE_GIALLA = 8;
    private final int QUANTITA_MERCE_BLU = 8;
    
    //BATTERIE
    private Batteria[] batterie;
    private final int QUANTITA_BATTERIE = 40;
    
    //ASTRONAUTI
    private Astronauta[] astronauti;
    private final int QUANTITA_ASTRONAUTI = 42;
    
    // CREDITI
    private final int[] creditiUNO;
    private final int[] creditiDUE;
    private final int[] creditiCINQUE;
    private final int[] creditiDIECI;
    private final int[] creditiVENTI;
    private final int[] creditiCINQUANTA;
    private final int QUANTITA_CREDITI_UNO = 10;
    private final int QUANTITA_CREDITI_DUE = 10;
    private final int QUANTITA_CREDITI_CINQUE = 10;
    private final int QUANTITA_CREDITI_DIECI = 10;
    private final int QUANTITA_CREDITI_VENTI = 10;
    private final int QUANTITA_CREDITI_CINQUANTA = 10;
    
    // ALIENI
    private Alieno[] alieniViola;
    private Alieno[] alieniMarroni;
    private final int QUANTITA_ALIENI_COLORE = 4;
    
    
    public Magazzino() {
    	//	CREATE MERCI
    	merceRosse = new Merci[this.QUANTITA_MERCE_ROSSA];
    	merceVerde = new Merci[this.QUANTITA_MERCE_VERDE];
    	merceGialla = new Merci[this.QUANTITA_MERCE_GIALLA];
    	merceBlu = new Merci[this.QUANTITA_MERCE_BLU];
    	for(int i=0; i < this.QUANTITA_MERCE_ROSSA; i++) {
    		merceRosse[i] = new Merci(Colore.ROSSO);
    	}
    	for(int i=0; i < this.QUANTITA_MERCE_VERDE; i++) {
    		merceVerde[i] = new Merci(Colore.VERDE);
    	}
    	for(int i=0; i < this.QUANTITA_MERCE_GIALLA; i++) {
    		merceGialla[i] = new Merci(Colore.GIALLO);
    	}
    	for(int i=0; i < this.QUANTITA_MERCE_BLU; i++) {
    		merceBlu[i] = new Merci(Colore.BLU);
    	}
    	
        //	CREATE BATTERIE
        batterie = new Batteria[this.QUANTITA_BATTERIE];
        for (int i = 0; i < this.QUANTITA_BATTERIE; i++) {
            batterie[i] = new Batteria();
        }
        
        //	CREATE ASTRONAUTI
        astronauti = new Astronauta[this.QUANTITA_ASTRONAUTI];
        for (int i = 0; i < this.QUANTITA_ASTRONAUTI; i++) {
            astronauti[i] = new Astronauta();
        }
        
        //	CREATE CREDITI
        this.creditiUNO = new int[this.QUANTITA_CREDITI_UNO];
        this.creditiDUE = new int[this.QUANTITA_CREDITI_DUE];
        this.creditiCINQUE = new int[this.QUANTITA_CREDITI_CINQUE];
        this.creditiDIECI = new int[this.QUANTITA_CREDITI_DIECI];
        this.creditiVENTI = new int[this.QUANTITA_CREDITI_VENTI];
        this.creditiCINQUANTA = new int[this.QUANTITA_CREDITI_CINQUANTA];
        
        for(int i = 0; i < this.QUANTITA_CREDITI_UNO; i++) {
        	this.creditiUNO[i] = 1;
        }
        for(int i = 0; i < this.QUANTITA_CREDITI_DUE; i++) {
        	this.creditiDUE[i] = 2;
        }
        for(int i = 0; i < this.QUANTITA_CREDITI_CINQUE; i++) {
        	this.creditiCINQUE[i] = 5;
        }
        for(int i = 0; i < this.QUANTITA_CREDITI_DIECI; i++) {
        	this.creditiDIECI[i] = 10;
        }
        for(int i = 0; i < this.QUANTITA_CREDITI_VENTI; i++) {
        	this.creditiVENTI[i] = 20;
        }
        for(int i = 0; i < this.QUANTITA_CREDITI_CINQUANTA; i++) {
        	this.creditiCINQUANTA[i] = 50;
        }
        
        // CREATE ALIENI
        this.alieniViola = new Alieno[this.QUANTITA_ALIENI_COLORE];
        this.alieniMarroni = new Alieno[this.QUANTITA_ALIENI_COLORE];
        for(int i = 0; i < this.QUANTITA_ALIENI_COLORE; i++) {
        	this.alieniMarroni[i] = new Alieno(ColoreAlieno.MARRONE);
        	this.alieniViola[i] = new Alieno(ColoreAlieno.VIOLA);
        }
        
        
        
        
    }
	
}
