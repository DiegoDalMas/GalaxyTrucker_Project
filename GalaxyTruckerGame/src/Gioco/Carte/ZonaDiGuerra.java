package Gioco.Carte;

import java.util.List;

import Gioco.Giocatore;

public class ZonaDiGuerra extends Carta {
	public ZonaDiGuerra() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA ZONA DI GUERRA");

	}
}
