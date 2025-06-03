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
		int i=0;
		do {
			System.out.println("giocatore " + giocatori.get(i).getColore() + "vuoi fermarti?"); // richiesta al giocatore se vuole																// fermarsi
			conferma = in.nextBoolean();
			if(conferma==true) {
				int equipaggio = giocatori.get(i).getAstronave().getEquipaggio();
				if (equipaggio > numeroCarta) {	
					giocatori.get(i).assegnaCrediti(crediti);
					giocatori.get(i).getAstronave().perditaEquipaggio(numeroCarta);
				}else {
					System.out.println("numero di equipaggio insufficente");
					conferma=false;
				}
			}
			i++;
		} while (conferma == false);
		giocatori.aggiornaPosizioni(giorniPersi);
	}
	
}