package Gioco;

import java.util.ArrayList;
import java.util.List;

public class Astronave {
	private static final boolean[][] MASCHERA_LIVELLO_1 = {
        // COLONNE:   	5      6      7      8      9
        /* RIGA 5 */ {false, false, true,  false, false},
        /* RIGA 6 */ {false, true,  true,  true,  false},
        /* RIGA 7 */ {true,  true,  true,  true,  true},
        /* RIGA 8 */ {true,  true,  true,  true,  true},
        /* RIGA 9 */ {true,  true,  false, true,  true}
    };
	private static final boolean[][] MASCHERA_LIVELLO_2 = {
        // COLONNE:		4      5      6      7      8       9    10
        /* RIGA 5 */ {false, false, true,  false, true, false, false},
		/* RIGA 6 */ {false, true,  true,  true,  true, true,  false},
        /* RIGA 7 */ {true,  true,  true,  true,  true, true,  true},
        /* RIGA 8 */ {true,  true,  true,  true,  true, true,  true},
        /* RIGA 9 */ {true,  true,  true,  false, true, true,  true}
    };
	private static final boolean[][] MASCHERA_LIVELLO_3 = {
        // COLONNE:		3      4      5      6      7     8      9     10     11
    	/* RIGA 4 */ {false, false, false, false, true, false, false, false, false},
		/* RIGA 5 */ {false, false, false, true,  true, true,  false, false, false},
		/* RIGA 6 */ {true,  false, true,  true,  true, true,  true,  false, true},
        /* RIGA 7 */ {true,  true,  true,  true,  true, true,  true,  true,  true},
        /* RIGA 8 */ {true,  true,  true,  true,  true, true,  true,  true,  true},
        /* RIGA 9 */ {true,  true,  false, true,  true, true,  false, true,  true}
    };

	private List<Alieno> alieni;
	private List<Batteria> batterie;
	private List<Umano> umani;
	private Casella[][] griglia;
	private boolean[][] mascheraValidita;
	private int livello;
	private final int NUMERO_COLONNE;
	private final int NUMERO_RIGHE;

	public Astronave(int livello) {
		this.livello = livello;

		switch (this.livello) {
			case 1:
				this.NUMERO_COLONNE = 5;
				this.NUMERO_RIGHE = 5;
				this.mascheraValidita = MASCHERA_LIVELLO_1;
				break;

			case 2:
				this.NUMERO_COLONNE = 7;
				this.NUMERO_RIGHE = 5;
				this.mascheraValidita = MASCHERA_LIVELLO_2;
				break;

			case 3:
				this.NUMERO_COLONNE = 9;
				this.NUMERO_RIGHE = 6;
				this.mascheraValidita = MASCHERA_LIVELLO_3;
				break;

			default:
				throw new IllegalArgumentException("livello non valido: ");
		}
		this.alieni = new ArrayList<>();
		this.batterie = new ArrayList<>();
		this.umani = new ArrayList<>();
		this.griglia = new Casella[NUMERO_RIGHE][NUMERO_COLONNE];
		for (int i = 0; i < NUMERO_RIGHE; i++) {
			for (int j = 0; j < NUMERO_COLONNE; j++) {
				griglia[i][j] = null;
			}
		}
	}


	
	//METODO PER INSERIRE UNA TESSERA NELLA ASTRONAVE
	public boolean piazzaTessera(Tessera t, int riga, int colonna) {
		if (riga < 0 || riga >= NUMERO_RIGHE || colonna < 0 || colonna >= NUMERO_COLONNE)
			return false;

		if (!mascheraValidita[riga][colonna]) return false;
		if (griglia[riga][colonna] != null) return false;

		if (!connettoriCompatibili(t, riga, colonna)) {
			System.out.println("Connettori non compatibili con tessere adiacenti.");
			return false;
		}

		griglia[riga][colonna] = new Casella(riga, colonna);
		griglia[riga][colonna].setTessera(t);
		return true;
    }
	
	

	public boolean assegnaAlieno(Magazzino magazzino, ColoreAlieno colore) {
		for (Alieno a : alieni) {
			if (a.getColore() == colore) {
				System.out.println("hai già un alieno " + colore);
				return false;
			}
		}
		Alieno a = magazzino.prendiAlieno(colore);
		alieni.add(a);
		System.out.println("hai ricevuto un alieno: " + colore);
		return true;
	}

	public boolean assegnaBatteria(Magazzino magazzino) {
		Batteria b = magazzino.prendiBatteria();
		if (b != null) {
			batterie.add(b);
			System.out.println("hai preso una batteria");
			return true;
		}
		System.out.println("Nessuna batteria disponibile.");
		return false;
	}

	public boolean assegnaUmano(Magazzino magazzino) {
		Umano u = magazzino.prendiUmano();
		if (u != null) {
			umani.add(u);
			System.out.println("hai preso un umano");
			return true;
		}
		System.out.println("Nessun umano disponibile.");
		return false;
	}

	public void perditaEquipaggio(int numero) {
		for (int i = 0; i < numero; i++) {
			umani.remove(i);
			// si possno perdere anche alieni facciamo decidere al giocatore? o facciamo che
			// si perodno solo umani?
		}
	}

	public int getEquipaggio() {
		int equipaggio = alieni.size() + umani.size();
		return equipaggio;
	}

	
	//DA FARE
	public int getPotenzaDiFuoco() {
		int potenzaDiFuoco = 0; // andrebbe assegnata il numero dei cannoni singoli + ilo numero dei cannoni doppi che se vengnono usati viene tolta una batteria
		return potenzaDiFuoco;
	}

	
	//DA FARE
	public int getPotenzaMotrice() {
		int potenzaMotrice = 0; // andrebbe assegnata il numero dei motori singoli + il numero dei motori
								// doppi che se vengnono usati viene tolta una batteria
		return potenzaMotrice;
	}
	public int connettoriEsposti() {
		int connettoriEsposti=0;
		return connettoriEsposti;
	}
	
	public void assegnazioneMaterialeGiocatore(Magazzino m){
		for(int i=0; i<griglia.length; i++){
			for(int j=0; j<griglia[i].length; j++){
				Casella casella = griglia[i][j];
				if(casella != null && casella.getTessera() != null){
					Tessera t = casella.getTessera();
					switch (t.getTipo()) {
						case CABINA:
							for(int k=0; k<2; k++){
								assegnaUmano(m);
							}
							break;
						case BATTERIA:
							int cariche = t.getCapacitaBatteria();
							for (int k = 0; k < cariche; k++) {
								assegnaBatteria(m);
							}
							break;
						default:
							break;
					}
				}
			}
		}
	}
	
	
	
	public void stampaGrigliaAstronave() {
		System.out.print("   ");
		for (int col = 0; col < NUMERO_COLONNE; col++) {
			System.out.print(col + "  ");
		}
		System.out.println();

		for (int i = 0; i < NUMERO_RIGHE; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < NUMERO_COLONNE; j++) {
				if (mascheraValidita[i][j]) {
					if (griglia[i][j] != null && griglia[i][j].getTessera() != null) {
						Tessera t = griglia[i][j].getTessera();
						TipoTessera tipo = griglia[i][j].getTessera().getTipo();
						switch (tipo) {
							case SCUDO:
								System.out.print("[🛡️" + getFrecceDirezione(t) + "]");
								break;
							
							case CABINA:
								System.out.print("[⬜]");
								break;
							
							case PROPULSORE_SINGOLO:
								System.out.print("[🚀]");
								break;

							case PROPULSORE_DOPPIO:
								System.out.print("[🚀🚀]");
								break;

							case CANNONE_SINGOLO:
								System.out.print("[🔫" + getFrecceDirezione(t) + "]");
								break;

							case CANNONE_DOPPIO:
								System.out.print("[🔫🔫" + getFrecceDirezione(t) + "]");
								break;
							
							case BATTERIA:
								System.out.print("[🔋]");
								break;

							case STIVA:
								System.out.print("[📦]");
								break;

							case STIVA_SPECIALE:
								System.out.print("[🎁]");
								break;
							
							case MODULI_VITALI_MARRONI:
								System.out.print("[🟫]");
								break;
							
							case MODULI_VITALI_VIOLA:
								System.out.println("[🟪]");
								break;
							
							case MODULI_STRUTTURALI:
								System.out.println("[⌘]");
								break;
							
							default:
								System.out.print("[❓]");
								break;
						}
					} else {
						System.out.print("[ ]"); // valida ma vuota
					}
				} else {
					System.out.print(" . "); // non valida, lascia vuoto
				}
			}
			System.out.println();
		}
	}
	
	public String getFrecceDirezione(Tessera t) {
		if (t == null || t.getDirezione() == null || t.getDirezione().isEmpty()) return "";

		StringBuilder sb = new StringBuilder();
		for (Direzione dir : t.getDirezione()) {
			switch (dir) {
				case NORD -> sb.append("↑");
				case EST  -> sb.append("→");
				case SUD  -> sb.append("↓");
				case OVEST-> sb.append("←");
			}
		}
		return sb.toString();
	}
	
	
	private boolean connettoriCompatibili(Tessera nuova, int riga, int colonna) {
		// Controlla connettore a NORD
		if (riga > 0 && griglia[riga - 1][colonna] != null && griglia[riga - 1][colonna].getTessera() != null) {
			Tessera vicina = griglia[riga - 1][colonna].getTessera();
			TipoConnettore mio = nuova.getConnettoreSuLato(Direzione.NORD);
			TipoConnettore suo = vicina.getConnettoreSuLato(Direzione.SUD); // opposto
			if (!mio.compatibileCon(suo)) return false;
		}

		// Controlla connettore a SUD
		if (riga < NUMERO_RIGHE - 1 && griglia[riga + 1][colonna] != null && griglia[riga + 1][colonna].getTessera() != null) {
			Tessera vicina = griglia[riga + 1][colonna].getTessera();
			TipoConnettore mio = nuova.getConnettoreSuLato(Direzione.SUD);
			TipoConnettore suo = vicina.getConnettoreSuLato(Direzione.NORD); // opposto
			if (!mio.compatibileCon(suo)) return false;
		}

		// Controlla connettore a EST
		if (colonna < NUMERO_COLONNE - 1 && griglia[riga][colonna + 1] != null && griglia[riga][colonna + 1].getTessera() != null) {
			Tessera vicina = griglia[riga][colonna + 1].getTessera();
			TipoConnettore mio = nuova.getConnettoreSuLato(Direzione.EST);
			TipoConnettore suo = vicina.getConnettoreSuLato(Direzione.OVEST); // opposto
			if (!mio.compatibileCon(suo)) return false;
		}

		// Controlla connettore a OVEST
		if (colonna > 0 && griglia[riga][colonna - 1] != null && griglia[riga][colonna - 1].getTessera() != null) {
			Tessera vicina = griglia[riga][colonna - 1].getTessera();
			TipoConnettore mio = nuova.getConnettoreSuLato(Direzione.OVEST);
			TipoConnettore suo = vicina.getConnettoreSuLato(Direzione.EST); // opposto
			if (!mio.compatibileCon(suo)) return false;
		}

		return true;
	}
	
	
}
