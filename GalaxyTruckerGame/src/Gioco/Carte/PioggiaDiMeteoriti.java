package Gioco.Carte;

import java.util.List;

import Gioco.Dado;
import Gioco.Giocatore;

public class PioggiaDiMeteoriti extends Carta {
	private Dado dado;
	private int numMeteoriti;
	private Meteorite[] meteoriti;

	public PioggiaDiMeteoriti(int numMeteoriti, String direzione, int grandezza) {
		this.numMeteoriti = numMeteoriti;
		for (int i = 0; i < numMeteoriti; i++) {
			meteoriti[i] = new Meteorite(direzione, grandezza);
		}
	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA PIOGGIA DI METEORITI");
		for (int j = 0; j < numMeteoriti; j++) {
			String direzione = meteoriti[j].getDirezione();
			int dimensione = meteoriti[j].getGrandezza();
			switch (direzione) {
			case "left": {
				int y = dado.tira();
				if (dimensione == 0) {
					// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
					// deve spendere una batteria

				} else {
					// capire bene come fare se ha i cannoni può farli esplodere
				}
			}
			case "right": {
				int y = dado.tira();
				if (dimensione == 0) {
					// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
					// deve spendere una batteria

				} else {
					// capire bene come fare se ha i cannoni in quella direzione può farli esplodere
				}
			}
				;
			case "front": {
				int x = dado.tira();
				if (dimensione == 0) {
					// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
					// deve spendere una batteria

				} else {
					// capire bene come fare se ha i cannoni può farli esplodere
				}
			};
			case "behind": {
				int x = dado.tira();
				if (dimensione == 0) {
					// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
					// deve spendere una batteria

				} else {
					// capire bene come fare se ha i cannoni può farli esplodere
				}
			};
			}
		}
	}
}
