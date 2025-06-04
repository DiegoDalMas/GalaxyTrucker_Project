package Gioco.Carte;

import java.util.List;
import java.util.Scanner;

import Gioco.Colore;
import Gioco.Giocatore;

public class Pianeti extends Carta {
	private int giorniPersi;
	private boolean conferma = false;
	private int  cont=0;
	private Scanner in = new Scanner(System.in);
	private List<Pianeta> pianeti;

	public Pianeti(int numPianeti, Colore colore, int numMerci) {
		for (int i = 0; i < numPianeti; i++) {
			Pianeta p = new Pianeta(colore, numMerci);
			pianeti.add(p);
		}
	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA PIANETI");
		do {
			boolean controllo = controlloPianeti();
			if (controllo == true || cont>=4) {
				for (Giocatore g : giocatori) {
					System.out.println("giocatore: " + g.getColore() + " vuoi fermarti? y/n");
					String scelta = in.nextLine();
					if (scelta.equals("y")) {
						System.out.println("su quale pianeta vuoi fermarti?");// o facciamo inserire il numero oppure il colore però poi è da verificare nella lista
						int sceltapianeta = in.nextInt();
						boolean cond = true;
						while (cond == true) {
							if (pianeti.get(sceltapianeta).isOccupato() == false) {
								pianeti.get(sceltapianeta).setOccupato(true);
								pianeti.get(sceltapianeta).AssegnaMerci(g);
								
								g.aggiornaPosizioni(giorniPersi);
								cond = false;
							}
						}
					}
                  cont++;
				}
			}else {
				System.out.println("I PIANETI SONO TUTTI OCCUPATI");
				conferma=false;
			}
		} while (conferma == false);
	}

	private boolean controlloPianeti() {
		boolean controllo = true;
		for (int i = 0; i < pianeti.size(); i++) {
			if (pianeti.get(i).isOccupato() == true) {
				controllo = false;
			}
		}
		return controllo;
	}
}