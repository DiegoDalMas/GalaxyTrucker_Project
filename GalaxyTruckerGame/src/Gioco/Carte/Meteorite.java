package Gioco.Carte;

import Gioco.Direzione;

public class Meteorite {
	private Direzione direzione;
	private int grandezza;

	public Meteorite(Direzione direzione, int grandezza) {
		this.direzione = direzione;
		this.grandezza = grandezza;
	}

	public Direzione getDirezione() {
		return direzione;
	}

	public int getGrandezza() {
		return grandezza;
	}

}
