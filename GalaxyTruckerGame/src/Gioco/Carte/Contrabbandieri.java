package Gioco.Carte;

import java.util.List;

import Gioco.Giocatore;

public class Contrabbandieri extends Carta {
	private boolean conferma =false;
	private int potFuocoContrabbandieri;
	private int penalita;
	private int ricompensa;
	public Contrabbandieri() {

	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA CONTRABBANDIERI");
		do {
			for (Giocatore g : giocatori) {
				int potFuocoGiocatore = g.getAstronave().getPotenzaDiFuoco();
				if (potFuocoContrabbandieri > potFuocoGiocatore) {
					System.out.println("HAI PERSO");
					g.getAstronave().perditaMerci(penalita);
				} else if (potFuocoContrabbandieri < potFuocoGiocatore) {
					System.out.println("HAI VINTO");
                   g.getAstronave().guadagnaMerci(ricompensa);
                   conferma=true;
				}else {
					System.out.println("HAI PAREGGIATO");
				}
			}
		} while (conferma == false);

	}
}
