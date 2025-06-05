package Gioco;

import java.util.*;

/*
INFORMAZIONI UTILI:
156 COMPONENTI DI ASTRONAVE --> CONNETTORI LATI
2 DADI

CREATE
55 BLOCCHI MERCE
40 BATTERIE
42 ASTRONAUTI BIANCHI
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
	private int batterieDisponibili;
	private List<Umano> umani;
	
	public Magazzino() {
        merci = new ArrayList<>(MAX_MERCI);
        aggiungiMerciMagazzino(Colore.BLU, 14);
        aggiungiMerciMagazzino(Colore.GIALLO, 17);
        aggiungiMerciMagazzino(Colore.VERDE, 13);
        aggiungiMerciMagazzino(Colore.ROSSO, 12);
        alieni = new ArrayList<>(MAX_ALIENI);
        aggiungiAlieniMagazzino(ColoreAlieno.VIOLA, 4);
        aggiungiAlieniMagazzino(ColoreAlieno.MARRONE, 4);
        batterieDisponibili = MAX_BATTERIE;
        umani = new ArrayList<>(MAX_UMANI);
        aggiungiUmaniMagazzino(MAX_UMANI);
    }

    private void aggiungiMerciMagazzino(Colore colore, int quantita) {
        for (int i = 0; i < quantita; i++) {
            merci.add(new Merci(colore));
        }
    }
    
    private void aggiungiAlieniMagazzino(ColoreAlieno colore, int quantita) {
        for (int i = 0; i < quantita; i++) {
            alieni.add(new Alieno(colore));
        }
    }
    
    
    
    private void aggiungiUmaniMagazzino(int quantita) {
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
    
    public boolean prendiBatteria() {
        if(batterieDisponibili > 0){
            batterieDisponibili--;
            return true;
        }
        return false;
    }
    
    public Umano prendiUmano() {
        if (!umani.isEmpty()) {
        	return umani.remove(0);
        }
        return null;
    }
	
	// PRELEVA E RIMUOVE UNA MERCE DI UN CERTO COLORE
	public Merci prelevaMerce(Colore colore) {
	    for (int i = 0; i < merci.size(); i++) {
	        if (merci.get(i).getColore() == colore) {
	            return merci.remove(i); // Restituisce e rimuove la merce trovata
	        }
	    }
	    return null; // Nessuna merce di quel colore
	}
 
}
