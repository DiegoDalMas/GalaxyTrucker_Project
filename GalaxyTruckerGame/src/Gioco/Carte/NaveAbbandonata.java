package Gioco.Carte;

import java.util.List;
import java.util.Scanner;

import Gioco.Giocatore;

public class NaveAbbandonata extends Carta {
	private boolean conferma;
	private Scanner in = new Scanner(System.in);
	private int numero; // numero che ce sulla carta
	private int crediti; // crediti che vengono assegnati

	public NaveAbbandonata() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		do {
			System.out.println("giocatore " + leader.getColore() + "vuoi fermarti?"); // richiesta al giocatore se vuole																// fermarsi
			conferma = in.nextBoolean();
			if(conferma==true) {
				int eq = leader.getAstronave().getEquipaggio();
				if (eq > numero) {	
					leader.assegnaCrediti(crediti);
					leader.getAstronave().perditaEquipaggio(numero);
				}else {
					System.out.println("numero di equipaggio insufficente");
					conferma=false;
				}
			}
		} while (conferma == false);

	}
}