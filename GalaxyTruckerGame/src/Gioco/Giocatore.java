package Gioco;

import java.util.*;

public class Giocatore extends Astronave{
	private Colore colore;
	private PosizioneGiocatore pos;
	private List<Alieno> alieni;
	private List<Batteria> batterie;
	private List<Umano> umani;
	private int crediti;
 
	public Giocatore(Colore colore) {
		this.colore = colore;
		this.alieni = new ArrayList<>();
        this.batterie = new ArrayList<>();
        this.umani = new ArrayList<>();
		//Astronave a = new Astronave();
	}
	
	public boolean assegnaAlieno(Magazzino magazzino, ColoreAlieno colore) {
		for (Alieno a : alieni) {
		    if (a.getColore() == colore) {
		    	System.out.println("hai già un alieno " + colore);
		        return false;
		    }
		}
		Alieno a = magazzino.prendiAlieno(colore);
		alieni.add(a);
		System.out.println("hai ricevuto un alieno: " + colore);
		return true;
	}
	
	public boolean assegnaBatteria(Magazzino magazzino) {
        Batteria b = magazzino.prendiBatteria();
        if (b != null) {
            batterie.add(b);
            System.out.println("hai preso una batteria");
            return true;
        }
        System.out.println("Nessuna batteria disponibile.");
        return false;
    }
	
	public boolean assegnaUmano(Magazzino magazzino) {
        Umano u = magazzino.prendiUmano();
        if (u != null) {
            umani.add(u);
            System.out.println("hai preso un umano");
            return true;
        }
        System.out.println("Nessun umano disponibile.");
        return false;
    }
	
	
	public Colore getColore() {
		return colore;
	}
}