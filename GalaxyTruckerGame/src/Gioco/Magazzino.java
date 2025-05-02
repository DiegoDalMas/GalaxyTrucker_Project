package Gioco;

import java.util.*;

/*
INFORMAZIONI UTILI:
60 CARTE AVVENTURA
156 COMPONENTI DI ASTRONAVE --> CONNETTORI LATI



6 TESSERE TITOLO CAMIONISTA
40 BATTERIE
42 ASTRONAUTI BIANCHI

2 DADI


CREATE
55 BLOCCHI MERCE

68 TESSERE CREDITO COSMICO	--> CREDITI COLORE
4 ALIENI MARRONI, 4 VIOLA
 */


public class Magazzino {
	//MERCE
	private static final int MAX_MERCI = 56;
	private static final int MAX_ALIENI = 8;
	private static final int MAX_BATTERIE = 40;
	private static final int MAX_UMANI = 42;
	private List<Merci> merci;
	private List<Alieno> alieni;
	private List<Batteria> batterie;
	private List<Umano> umani;
	
	public Magazzino() {
        merci = new ArrayList<>(MAX_MERCI);
        aggiungiMerci(Colore.BLU, 14);
        aggiungiMerci(Colore.GIALLO, 17);
        aggiungiMerci(Colore.VERDE, 13);
        aggiungiMerci(Colore.ROSSO, 12);
        alieni = new ArrayList<>(MAX_ALIENI);
        aggiungiAlieni(ColoreAlieno.VIOLA, 4);
        aggiungiAlieni(ColoreAlieno.MARRONE, 4);
        batterie = new ArrayList<>(MAX_BATTERIE);
        aggiungiBatterie(MAX_BATTERIE);
        umani = new ArrayList<>(MAX_UMANI);
        aggiungiUmani(MAX_UMANI);
    }

    private void aggiungiMerci(Colore colore, int quantita) {
        for (int i = 0; i < quantita; i++) {
            merci.add(new Merci(colore));
        }
    }
    
    private void aggiungiAlieni(ColoreAlieno colore, int quantita) {
        for (int i = 0; i < quantita; i++) {
            alieni.add(new Alieno(colore));
        }
    }
    
    private void aggiungiBatterie(int quantita) {
    	for(int i=0; i<quantita; i++) {
    		batterie.add(new Batteria());
    	}
    }
    
    private void aggiungiUmani(int quantita) {
        for (int i = 0; i < quantita; i++) {
            umani.add(new Umano());
        }
    }
    
    public Alieno prendiAlieno(ColoreAlieno colore) {
        for (Alieno a : alieni) {
            if (a.getColore() == colore) {
                alieni.remove(a);
                return a;
            }
        }
        return null;
    }
    
    public Batteria prendiBatteria() {
        if (!batterie.isEmpty()) {
        	return batterie.remove(0);
        }
        return null;
    }
    
    public Umano prendiUmano() {
        if (!umani.isEmpty()) {
        	return umani.remove(0);
        }
        return null;
    }
	
    
    /*//BATTERIE
    private Batteria[] batterie;
    private final int QUANTITA_BATTERIE = 40;
    
    //ASTRONAUTI
    private Astronauta[] astronauti;
    private final int QUANTITA_ASTRONAUTI = 42;
    
    
    
    // ALIENI
    private Alieno[] alieniViola;
    private Alieno[] alieniMarroni;
    private final int QUANTITA_ALIENI_COLORE = 4;
    
    
    public Magazzino() {
    	
    	
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
        
    }*/
	
	
	
	// PRELEVA E RIMUOVE UNA MERCE DI UN CERTO COLORE
	public Merci prelevaMerce(Colore colore) {
	    for (int i = 0; i < merci.size(); i++) {
	        if (merci.get(i).getColore() == colore) {
	            return merci.remove(i); // Restituisce e rimuove la merce trovata
	        }
	    }
	    return null; // Nessuna merce di quel colore
	}
    
    
    
    
    
    
	
	
   public void AssegnaCrediti() {
	   
   }
   public void AssegnaMerci() {
	   
   }
   public void AssegnaAstronauti() {
	   
   }
  public void AssegnaAlieni() {
	  
  }
  public void AssegnaBatterie() {
	  
  }
}
