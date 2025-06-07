package Gioco.Carte;

import java.util.List;
import Gioco.Giocatore;
import Gioco.PlanciaVolo;

public class SpazioAperto extends Carta{
	
	//COSTYTTORE DI DEFAULT
	
	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia){
		System.out.println("CARTA SPAZIO APERTO");
		for(Giocatore g: giocatori){
			System.out.println("Giocatore: " + g.getColore());
			int potenzaMotrice = g.getAstronave().getPotenzaMotrice();
			System.out.println("LA tua potenza motrice corrisponde a: " + potenzaMotrice);
			plancia.muoviGiocatore(g.getColore(), potenzaMotrice);
		}
	}
}