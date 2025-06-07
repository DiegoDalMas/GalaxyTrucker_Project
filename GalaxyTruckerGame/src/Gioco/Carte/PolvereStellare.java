package Gioco.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Gioco.Giocatore;
import Gioco.PlanciaVolo;

public class PolvereStellare extends Carta {
	
	//COSTRUTTORE DEFAULT - NO ATTRIBUTI
	
	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia){
		System.out.println("CARTA POLVERE STELLARE");
		System.out.println("In ordine INVERSO ogni giocatore perde Giorni di volo per ogni connettore esposto");


		//giocatori.reversed() non funzionava
		List<Giocatore> ordineInvertito = new ArrayList<>(giocatori);
		Collections.reverse(ordineInvertito);
		for(Giocatore g: ordineInvertito){
			int connettoriEsposti = g.getAstronave().connettoriEsposti();
			System.out.println("Giocatore: " + g.getColore() + " ha " + connettoriEsposti + " connettori esposti");
			plancia.muoviGiocatore(g.getColore(), -connettoriEsposti);
			System.out.println("Retrocedi di " + connettoriEsposti + " giorni di volo.");
		}
	}
}
