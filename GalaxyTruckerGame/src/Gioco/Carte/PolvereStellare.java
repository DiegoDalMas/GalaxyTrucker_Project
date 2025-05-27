package Gioco.Carte;

import java.util.List;

import Gioco.Giocatore;

public class PolvereStellare extends Carta {
	public PolvereStellare() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		for(int i=giocatori.size();i>0;i--) {
			int numConnettoriEsposti= giocatori.get(i).getAstronave().connettoriEsposti();
			giocatori.muoviGiocatore(numConnettoriEsposti); // creare un metodo in Giocatore? che faccia perdere i giorni di volo
		}


	}
}
