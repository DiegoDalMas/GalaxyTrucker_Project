package Gioco.Carte;

import java.util.List;

import Gioco.Colore;
import Gioco.Giocatore;
import Gioco.Merci;

public class Pianeta {
	private List<Merci> merci;
	private boolean occupato;
	private int numMerci;

	public Pianeta(Colore colore, int numMerci) {
		this.numMerci=numMerci;
		for (int i = 0; i < numMerci; i++) {
			Merci m = new Merci(colore);
			merci.add(m);
		}
		occupato = false;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	public void AssegnaMerci(Giocatore g) {
		for (int i = 0; i < numMerci; i++) {
			Merci m= merci.get(i);
			g.getAstronave().assegnaMerce(m);
		}
		 
	}

}
