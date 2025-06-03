package Gioco.Carte;

import java.util.List;

import Gioco.Dado;
import Gioco.Direzione;
import Gioco.Giocatore;
import Gioco.Tessera;
import Gioco.TipoConnettore;
import Gioco.TipoTessera;

public class PioggiaDiMeteoriti extends Carta {
	private Dado dado;
	private int numMeteoriti;
	private Meteorite[] meteoriti;

	public PioggiaDiMeteoriti(int numMeteoriti, Direzione direzione, int grandezza) {
		this.numMeteoriti = numMeteoriti;
		for (int i = 0; i < numMeteoriti; i++) {
			meteoriti[i] = new Meteorite(direzione, grandezza);
		}
	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader) {
		System.out.println("CARTA PIOGGIA DI METEORITI");
		for (int j = 0; j < numMeteoriti; j++) {
			Direzione direzione = meteoriti[j].getDirezione();
			int dimensione = meteoriti[j].getGrandezza();
			for (Giocatore g : giocatori) {
				switch (direzione) {
				case EST: {
					int y = dado.tira();
					Tessera puntoColpito = g.getAstronave().getTesseraDaRigaColonna(0, y);
					TipoConnettore[] connettore = puntoColpito.getConnettori();
					if (dimensione == 0) {
						// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
						if (connettore[3] != TipoConnettore.LISCIO) {
							System.out.println("COLPITO");
							// NON CONTROLLA GLI SCUDI
							g.getAstronave().subisciDanno();
						} else {
							System.out.println("SEI SALVO");
						}

					} else {
						if (puntoColpito.getTipo() == TipoTessera.CANNONE_SINGOLO
								|| puntoColpito.getTipo() == TipoTessera.CANNONE_DOPPIO) {
							System.out.println("SEI SALVO");
						} else {
							System.out.println("COLPITO");
							g.getAstronave().subisciDanno();
						}
						// capire bene come fare se ha i cannoni può farli esplodere
					}
				}
				case OVEST: {
					int y = dado.tira();
					Tessera puntoColpito = g.getAstronave().getTesseraDaRigaColonna(0, y);
					TipoConnettore[] connettore = puntoColpito.getConnettori();
					if (dimensione == 0) {
						// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
						if (connettore[1] != TipoConnettore.LISCIO) {
							System.out.println("COLPITO");
							// NON CONTROLLA GLI SCUDI
							g.getAstronave().subisciDanno();
						} else {
							System.out.println("SEI SALVO");
						}

					} else {
						if (puntoColpito.getTipo() == TipoTessera.CANNONE_SINGOLO
								|| puntoColpito.getTipo() == TipoTessera.CANNONE_DOPPIO) {
							System.out.println("SEI SALVO");
						} else {
							System.out.println("COLPITO");
							g.getAstronave().subisciDanno();
						}
						// capire bene come fare se ha i cannoni può farli esplodere
					}
				}
					;
				case NORD: {
					int y = dado.tira();
					Tessera puntoColpito = g.getAstronave().getTesseraDaRigaColonna(0, y);
					TipoConnettore[] connettore = puntoColpito.getConnettori();
					if (dimensione == 0) {
						// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
						if (connettore[0] != TipoConnettore.LISCIO) {
							System.out.println("COLPITO");
							// NON CONTROLLA GLI SCUDI
							g.getAstronave().subisciDanno();
						} else {
							System.out.println("SEI SALVO");
						}

					} else {
						if (puntoColpito.getTipo() == TipoTessera.CANNONE_SINGOLO
								|| puntoColpito.getTipo() == TipoTessera.CANNONE_DOPPIO) {
							System.out.println("SEI SALVO");
						} else {
							System.out.println("COLPITO");
							g.getAstronave().subisciDanno();
						}
						// capire bene come fare se ha i cannoni può farli esplodere
					}
				}
					;
				case SUD: {
					int y = dado.tira();
					Tessera puntoColpito = g.getAstronave().getTesseraDaRigaColonna(0, y);
					TipoConnettore[] connettore = puntoColpito.getConnettori();
					if (dimensione == 0) {
						// capire bene come fare contollare se ha lato liscio opppure se ha scudi ma
						if (connettore[2] != TipoConnettore.LISCIO) {
							System.out.println("COLPITO");
							// NON CONTROLLA GLI SCUDI
							g.getAstronave().subisciDanno();
						} else {
							System.out.println("SEI SALVO");
						}

					} else {
						if (puntoColpito.getTipo() == TipoTessera.CANNONE_SINGOLO
								|| puntoColpito.getTipo() == TipoTessera.CANNONE_DOPPIO) {
							System.out.println("SEI SALVO");
						} else {
							System.out.println("COLPITO");
							g.getAstronave().subisciDanno();
						}
						// capire bene come fare se ha i cannoni può farli esplodere
					}
				}
					;
				}
			}
		}
	}
}
