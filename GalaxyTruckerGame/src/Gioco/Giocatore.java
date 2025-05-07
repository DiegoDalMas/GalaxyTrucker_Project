package Gioco;

import java.util.*;

public class Giocatore {
	private Colore colore;
	private PosizioneGiocatore pos;
	private int crediti;
	private Astronave a ;
 
	public Giocatore(Colore colore) {
		this.colore = colore;
		a = new Astronave();
	}
	
	
	public Astronave getA() {
		return a;
	}

	public void setA(Astronave a) {
		this.a = a;
	}

	public Colore getColore() {
		return colore;
	}
}