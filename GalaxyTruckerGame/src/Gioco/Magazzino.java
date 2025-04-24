package Gioco;

/*
INFORMAZIONI UTILI:
60 carte avventura
156 componenti di astronave --> connettori lati



6 tessere titolo camionista
4 alieni marroni, 4 viola

2 dadi


CREATE
55 blocchi merce
40 batterie
42 astronauti bianchi
68 tessere credito cosmico	--> crediti colore
 */


public class Magazzino {
	//MERCE			-->> TODO METTERE I VALORI GIUSTI ALLE COSTANTI IN BASE AL NUMERO DEI PEZZI
	private Merci merceRossa;
    private Merci merceVerde;
    private Merci merceGialla;
    private Merci merceBlu;
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
    // e alieni
    
    
    public Magazzino() {
    	//	CREATE MERCI
    	this.merceRossa = new Merci(Colore.ROSSO, this.QUANTITA_MERCE_ROSSA);
        this.merceVerde = new Merci(Colore.VERDE, this.QUANTITA_MERCE_VERDE);
        this.merceGialla = new Merci(Colore.GIALLO, this.QUANTITA_MERCE_GIALLA);
        this.merceBlu = new Merci(Colore.BLU, this.QUANTITA_MERCE_BLU);
        
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
        
        
        
        
        
    }
	
}
