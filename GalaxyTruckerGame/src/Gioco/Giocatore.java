package Gioco;

import java.util.*;

public class Giocatore {
	private Colore colore;
	private Astronave astronave;
	private PosizioneGiocatore pos;
	private int crediti;
	private int componentiDistrutti;
 
	public Giocatore(Colore colore) {
		this.colore = colore;
		this.astronave = new Astronave();
		this.crediti = 0;
		this.componentiDistrutti = 0;
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
	
	
	public void assegnaCrediti(int crediti) {
		this.crediti += crediti;
	}
	
	public PosizioneGiocatore getPosizione() {
		return pos;
	}

	public void setPosizione(PosizioneGiocatore pos) {
		this.pos = pos;
	}
}