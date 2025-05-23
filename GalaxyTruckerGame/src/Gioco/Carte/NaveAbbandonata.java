package Gioco.Carte;

import java.util.List;
import java.util.Scanner;

import Gioco.Giocatore;

public class NaveAbbandonata extends Carta {
	private boolean conferma;
	private Scanner in = new Scanner(System.in);
	private int numeroCarta; // numero che ce sulla carta
	private int crediti; // crediti che vengono assegnati
	private int giorniPersi;

	public NaveAbbandonata() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA NAVE ABBANDONATA");
		do {
			System.out.println("giocatore " + leader.getColore() + "vuoi fermarti?"); // richiesta al giocatore se vuole																// fermarsi
			conferma = in.nextBoolean();
			if(conferma==true) {
				int equipaggio = leader.getAstronave().getEquipaggio();
				if (equipaggio > numeroCarta) {	
					leader.assegnaCrediti(crediti);
					leader.getAstronave().perditaEquipaggio(numeroCarta);
				}else {
					System.out.println("numero di equipaggio insufficente");
					conferma=false;
				}
			}
		} while (conferma == false);
		giocatori.aggiornaPosizioni(giorniPersi);
	}
	
}