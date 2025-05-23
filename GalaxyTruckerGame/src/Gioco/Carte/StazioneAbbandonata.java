package Gioco.Carte;

import java.util.List;
import java.util.Scanner;

import Gioco.Giocatore;
import Gioco.Merci;

public class StazioneAbbandonata extends Carta {

	private boolean conferma;

	private Scanner in = new Scanner(System.in);
	private Merci coloreMerci;
	private int numeroCarta;
	private int giorniPersi;

	public StazioneAbbandonata() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA STAZIONE ABBANDONATA");
		do {
			System.out.println("giocatore " + leader.getColore() + "vuoi fermarti?"); // richiesta al giocatore se vuole fermarsi
			conferma = in.nextBoolean();
			if (conferma == true) {
				int equipaggio = leader.getAstronave().getEquipaggio();
				if (equipaggio > numeroCarta) {
					leader.assegnaMerce(coloreMerci);// prende le merci dalla carta e le assegna al giocatore oppure alla sua
					//AGGIORNA LEADER     // asrtronave?
				} else {
					System.out.print("non hai abbastanza equipaggio");
					conferma = false;
				}
			}
		} while (conferma == false);
		giocatori.aggiornaPosizionni(giorniPersi);// aggiornare le posizioni
	}

}