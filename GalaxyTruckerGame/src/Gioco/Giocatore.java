package Gioco;

import java.util.*;

public class Giocatore {
	private Colore colore;
	private PosizioneGiocatore pos;
	private int crediti;
	private Astronave astronave;
 
	public Giocatore(Colore colore) {
		this.colore = colore;
		this.crediti = 0;
		this.astronave = new Astronave();
	}
	
	
	public Astronave getAstronave() {
		return astronave;
	}

	public void setAstronave(Astronave a) {
		this.astronave = a;
	}

	public Colore getColore() {
		return colore;
	}
}