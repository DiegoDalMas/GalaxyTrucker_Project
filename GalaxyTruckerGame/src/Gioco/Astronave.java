package Gioco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	private int batterieTotali;
	private int umaniTotali;
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
		this.batterieTotali = 0;
		this.umaniTotali = 0;
		this.griglia = new Casella[NUMERO_RIGHE][NUMERO_COLONNE];
		for (int i = 0; i < NUMERO_RIGHE; i++) {
			for (int j = 0; j < NUMERO_COLONNE; j++) {
				griglia[i][j] = null;
			}
		}

		int rigaCabina = -1;
		int colonnaCabina = -1;
		if (livello == 1) {
			rigaCabina = 2;
			colonnaCabina = 2;
		} else if (livello == 2) {
			rigaCabina = 2;
			colonnaCabina = 3;
		} else if (livello == 3) {
			rigaCabina = 3;
			colonnaCabina = 4;
		}

		Tessera cabina = new Tessera(TipoConnettore.UNIVERSALE, TipoConnettore.UNIVERSALE,
						TipoConnettore.UNIVERSALE, TipoConnettore.UNIVERSALE, TipoTessera.CABINA,
						0, 0,
						null);
		
		griglia[rigaCabina][colonnaCabina] = new Casella(rigaCabina, colonnaCabina);
		griglia[rigaCabina][colonnaCabina].setTessera(cabina);
						
	}
	
	//METODO PER INSERIRE UNA TESSERA NELLA ASTRONAVE
	public boolean piazzaTessera(Tessera t, int riga, int colonna) {
		if (riga < 0 || riga >= NUMERO_RIGHE || colonna < 0 || colonna >= NUMERO_COLONNE)
			return false;

		if (!mascheraValidita[riga][colonna]) return false;
		if (griglia[riga][colonna] != null) return false;

		if(!adiacenteATesseraEsistente(riga, colonna)){
			System.out.println("La tessera deve essere adiacente a un'altra tessera!");
			return false;
		}

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

	public boolean assegnaBatteria(Magazzino magazzino){
		if(magazzino.prendiBatteria()){
			batterieTotali++;
			System.out.println("Hai preso una Batteria!");
			return true;
		}else{
			System.out.println("Son finite le batterie!");
			return false;
		}
	}
	
	public boolean assegnaUmano(Magazzino magazzino) {
		if(magazzino.prendiUmano()) {
			umaniTotali++;
			System.out.println("Hai preso un Umano");
			return true;
		}else {
			System.out.println("Son finiti gli umani!");
			return false;
		}
	}
	
	public void perditaEquipaggio(int numero) {
		if(umaniTotali >= numero) {
			umaniTotali -= numero;
		}else {
			umaniTotali = 0;
		}
		System.out.println("Hai perso "+numero+" umani. Ti rimangono "+umaniTotali+" umani!");
	}
	
	public void subisciDanno(Tessera t) {
		// Trova la posizione della tessera
		for (int i = 0; i < griglia.length; i++) {
			for (int j = 0; j < griglia[i].length; j++) {
				Casella c = griglia[i][j];
				if (c != null && c.getTessera() == t) {
					System.out.println("Rimuovo tessera in posizione: [RIGA" + i + ", COLONNA " + j + "]");
					c = null;
					return;
				}
			}
		}
	}
	
	public void assegnaMerce(List<Merci> ricompensa) {
		int merciInserite=0;
		for(Merci m: ricompensa){
			boolean aggiunta = false;

			//cerco una stiva disponibile
			for(int i=0; (i<griglia.length && !aggiunta); i++){
				for(int j=0; (j<griglia[i].length && !aggiunta); j++){
					Casella c = griglia[i][j];
					if(c != null && c.getTessera() != null){
						Tessera t = c.getTessera();
						TipoTessera tipo = t.getTipo();

						if(tipo == TipoTessera.STIVA || tipo == TipoTessera.STIVA_SPECIALE){
							if(t.aggiungiMerce(m)){
								System.out.println("Merce "+m.getColore()+" caricata in riga "+i+" e colonna "+j);
								aggiunta = true;
								merciInserite++;
							}
						}
					}
				}
			}
			if (!aggiunta) {
				System.out.println("Nessuna stiva disponibile per la merce " + m.getColore());
			}
		}
	}
	
	public void perditaMerce(int quantita) {
		int merciRimosse = 0;
		Colore[] prioritaColori = {Colore.ROSSO, Colore.GIALLO, Colore.VERDE, Colore.BLU};
		for(Colore colore: prioritaColori){
			if(merciRimosse >= quantita){
				break;
			}
			for(int i=0; i<griglia.length && merciRimosse < quantita; i++){
				for(int j=0; j<griglia[i].length && merciRimosse < quantita; j++){
					Casella casella = griglia[i][j];
					if(casella == null || casella.getTessera() != null){
						continue;
					}

					Tessera t = casella.getTessera();
					if(t.getTipo() != TipoTessera.STIVA && t.getTipo() != TipoTessera.STIVA_SPECIALE){
						continue;
					}

					List<Merci> merci = t.getMerciContenute();
					for(int k=0; k<merci.size() && merciRimosse < quantita; k++){
						if(merci.get(k).getColore() == colore){
							System.out.println("Hai perso una merce di COLORE "+colore+" in riga "+i+" e colonna "+j);
							merci.remove(k);
							merciRimosse++;
							k--;
						}
					}
				}
			}
		}
	}
	
	public Tessera getTesseraDaRigaColonna(int riga, int colonna) {
        if (riga < 0 || riga >= NUMERO_RIGHE || colonna < 0 || colonna >= NUMERO_COLONNE)
            return null;
        Casella casella = griglia[riga][colonna];
        if (casella != null) {
            return casella.getTessera();
        }
        return null;
    }

	public int getEquipaggio() {
		int equipaggio = alieni.size() + umaniTotali;
		return equipaggio;
	}

	
	public double getPotenzaDiFuoco() {
		double potenza = 0.0;
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<NUMERO_RIGHE; i++){
			for(int j=0; j<NUMERO_COLONNE; j++){
				Casella casella = griglia[i][j];
				if(casella == null || casella.getTessera() == null){
					continue;
				}
				Tessera t = casella.getTessera();
				TipoTessera tipo = t.getTipo();
				Direzione direzione = t.getUnicaDirezione();

				if(tipo == TipoTessera.CANNONE_SINGOLO){
					if(direzione == Direzione.NORD){
						potenza += 1;
					}else if(direzione != null){
						potenza += 0.5;
					}
				}else if(tipo == TipoTessera.CANNONE_DOPPIO){
					System.out.println("Vuoi usare una batteria per attivare il cannone doppio in posizione [RIGA: "+i+" ; COLONNA: "+j+"]? (s/n)");
					String input = scanner.nextLine().toLowerCase();

					if(input.equals("s") && batterieTotali>0){
						batterieTotali--;

						if(direzione == Direzione.NORD){
							potenza += 2;
						}else if(direzione != null){
							potenza += 1;
						}

					}else{
						System.out.println("Cannone DOPPIO non attivato");
					}
				}
			}
		}
		if(potenza > 0){
			for(Alieno a: alieni){
				potenza += a.bonusPotenzaFuoco();
			}
		}
		return potenza;
	}

	
	public int getPotenzaMotrice() {
		int potenza = 0;
		Scanner scanner = new Scanner(System.in);

		for(int i=0; i<NUMERO_RIGHE; i++){
			for(int j=0; j<NUMERO_COLONNE; j++){
				Casella casella = griglia[i][j];
				if(casella == null || casella.getTessera() == null){
					continue;
				}
				Tessera t = casella.getTessera();
				TipoTessera tipo = t.getTipo();
				if(tipo == TipoTessera.PROPULSORE_SINGOLO){
					potenza += 1;
				}else if(tipo == TipoTessera.PROPULSORE_DOPPIO){
					System.out.println("Vuoi usare una batteria per attivare il propulsore doppio in posizione [RIGA: "+i+" ; COLONNA: "+j+"]? (s/n)");
					String input = scanner.nextLine().toLowerCase();
					if(input.equals("s") && batterieTotali>0){
						batterieTotali--;
						potenza += 2;
					}else{
						System.out.println("Propulsore DOPPIO non attivato");
					}
				}
			}
		}
		if(potenza>0){
			for(Alieno a:alieni){
				potenza += a.bonusPotenzaMotore();
			}
		}
		return potenza;

	}
	
	public int connettoriEsposti(){
		int connettoriEsposti = 0;
		for(int riga=0; riga<NUMERO_RIGHE; riga++){
			for(int colonna=0; colonna<NUMERO_COLONNE; colonna++){
				Casella casella = griglia[riga][colonna];
				if(casella == null || casella.getTessera() == null) continue;

				Tessera t = casella.getTessera();
				if (riga == 0 || griglia[riga - 1][colonna] == null || griglia[riga - 1][colonna].getTessera() == null) {		//CONTROLLA SE SOPRA LA TESSERA C'E "SPAZIO"
					if (t.getConnettoreSuLato(Direzione.NORD) != TipoConnettore.LISCIO) {
						connettoriEsposti++;
					}
				}
				if (riga == NUMERO_RIGHE - 1 || griglia[riga + 1][colonna] == null || griglia[riga + 1][colonna].getTessera() == null) {
					if (t.getConnettoreSuLato(Direzione.SUD) != TipoConnettore.LISCIO) {
						connettoriEsposti++;
					}
				}
				if (colonna == NUMERO_COLONNE - 1 || griglia[riga][colonna + 1] == null || griglia[riga][colonna + 1].getTessera() == null) {
					if (t.getConnettoreSuLato(Direzione.EST) != TipoConnettore.LISCIO) {
						connettoriEsposti++;
					}
				}
				if (colonna == 0 || griglia[riga][colonna - 1] == null || griglia[riga][colonna - 1].getTessera() == null) {
					if (t.getConnettoreSuLato(Direzione.OVEST) != TipoConnettore.LISCIO) {
						connettoriEsposti++;
					}
				}
			}
		}
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
		System.out.print("\t");
		for (int col = 0; col < NUMERO_COLONNE; col++) {
			System.out.print(col + "\t");
		}
		System.out.println();

		for (int i = 0; i < NUMERO_RIGHE; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < NUMERO_COLONNE; j++) {
				if (mascheraValidita[i][j]) {
					if (griglia[i][j] != null && griglia[i][j].getTessera() != null) {
						Tessera t = griglia[i][j].getTessera();
						TipoTessera tipo = t.getTipo();
						switch (tipo) {
							case SCUDO:
								System.out.print("[ SC ]\t");
								break;
							case CABINA:
								System.out.print("[ CA ]\t");
								break;
							case PROPULSORE_SINGOLO:
								System.out.print("[PR.S]\t");
								break;
							case PROPULSORE_DOPPIO:
								System.out.print("[PR.D]\t");
								break;
							case CANNONE_SINGOLO:
								System.out.print("[ CS ]\t");
								break;
							case CANNONE_DOPPIO:
								System.out.print("[ CD ]\t");
								break;
							case BATTERIA:
								System.out.print("[ BA ] \t");
								break;
							case STIVA:
								System.out.print("[ ST ]\t");
								break;
							case STIVA_SPECIALE:
								System.out.print("[ST++]\t");
								break;
							case MODULI_VITALI_MARRONI:
								System.out.print("[AL_M]\t");
								break;
							case MODULI_VITALI_VIOLA:
								System.out.print("[AL_V]\t");
								break;
							case MODULI_STRUTTURALI:
								System.out.print("[CONN]\t");
								break;
							default:
								System.out.print("[❓]\t");
								break;
						}
					} else {
						System.out.print("[    ]\t"); // valida ma vuota
					}
				} else {
					System.out.print("\t"); // non valida, spazio vuoto
				}
			}
			System.out.println();
		}
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
	
	// controlla se almeno una casella adiacente contiene una tessera
	private boolean adiacenteATesseraEsistente(int riga, int colonna) {
		// NORD 
		if (riga > 0 && griglia[riga - 1][colonna] != null && griglia[riga - 1][colonna].getTessera() != null) {
			return true;
		}

		// SUD
		if (riga < NUMERO_RIGHE - 1 && griglia[riga + 1][colonna] != null && griglia[riga + 1][colonna].getTessera() != null) {
			return true;
		}

		// EST
		if (colonna < NUMERO_COLONNE - 1 && griglia[riga][colonna + 1] != null && griglia[riga][colonna + 1].getTessera() != null) {
			return true;
		}

		// OVEST
		if (colonna > 0 && griglia[riga][colonna - 1] != null && griglia[riga][colonna - 1].getTessera() != null) {
			return true;
		}

		// Nessuna tessera adiacente
		return false;
	}
	
	public int getNumeroRighe() {
		return NUMERO_RIGHE;
	}

	public int getNumeroColonne() {
		return NUMERO_COLONNE;
	}
	
	public void usaBatteria() {
		if (batterieTotali > 0) {
			batterieTotali--;
			System.out.println("Hai usato una batteria. Batterie rimaste: " + batterieTotali);
		} else {
			System.out.println("Non hai batterie disponibili.");
		}
	}
	
	public boolean connettoreEsposto(Tessera t, Direzione dir){
		TipoConnettore connettore = t.getConnettoreSuLato(dir);
		if(connettore != TipoConnettore.LISCIO){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean puoUsareScudo(Direzione dir){
		for(int i=0; i< griglia.length; i++){
			for(int j=0; j<griglia[i].length; j++){
				Casella casella = griglia[i][j];
				if(casella != null && casella.getTessera() != null){
					Tessera t = casella.getTessera();
					if(t.getTipo() == TipoTessera.SCUDO && t.getDirezione().contains(dir)){
						if(batterieTotali > 0){
							String scelta;
							do{
								Scanner sc = new Scanner(System.in);
								System.out.println("Hai uno scudo verso " + dir + " Vuoi usarlo? (costo una batteria) (s/n)");
								scelta = sc.nextLine().toLowerCase();
							}while(!scelta.equals("s") && !scelta.equals("n"));
							if(scelta.equals("s")){
								usaBatteria();
								System.out.println("Hai usato uno scudo per bloccare il meteorite");
								return true;
							}else{
								System.out.println("HAi scelto di NON usare lo scudo");
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean puoSparareMeteorite(Direzione dir, int risultato){
		Scanner sc = new Scanner(System.in);
		if(dir == Direzione.NORD){
			for(int i=0; i<griglia.length; i++){
				Casella casella = griglia[i][risultato];
				if(casella != null && casella.getTessera() != null){
					Tessera t = casella.getTessera();
					TipoTessera tipo = t.getTipo();

					if((tipo == TipoTessera.CANNONE_SINGOLO || tipo == TipoTessera.CANNONE_DOPPIO) && t.getDirezione().contains(Direzione.NORD)){
						if(tipo == TipoTessera.CANNONE_DOPPIO && batterieTotali > 0){
							String scelta;
							do{
								System.out.println("Hai un CANNONE DOPPIO rivolto a NORD. Vuoi usarlo per sparare al meteorite? (s/n)");
								scelta = sc.nextLine().toLowerCase();
							}while(!scelta.equals("s") && !scelta.equals("n"));

							if(scelta.equals("s")){
								batterieTotali--;
								System.out.println("Hai usato 1 batteria per sparare al meteorite");
								return true;
							}else{
								System.out.println("Non hai sparato al meteorite.");
							}
						}else if(tipo == TipoTessera.CANNONE_SINGOLO){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
}
