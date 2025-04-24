package Gioco;

/*
INFORMAZIONI UTILI:
60 carte avventura
156 componenti di astronave --> connettori lati


68 tessere credito cosmico	--> crediti colore
6 tessere titolo camionista
4 alieni marroni, 4 viola

2 dadi


CREATE
55 blocchi merce
40 batterie
42 astronauti bianchi
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
    
    private Crediti[] creditiUNO;
    private Crediti[] creditiDUE;
    private Crediti[] creditiCINQUE;
    private Crediti[] creditiDIECI;
    private Crediti[] creditiVENTI;
    private Crediti[] creditiCINQUANTA;
    
   
    // crediti e alieni
    
    
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
        
        //creditiUNO = new Crediti[]
    }
	
}
