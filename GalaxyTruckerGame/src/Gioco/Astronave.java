package Gioco;

import java.util.ArrayList;
import java.util.List;

public class Astronave {
	private List<Alieno> alieni;
	private List<Batteria> batterie;
	private List<Umano> umani;
	private Casella[][] griglia;
	private int livello;
	private final int NUMERO_COLONNE;
	private final int NUMERO_RIGHE;

	public Astronave(int livello) {
		this.livello = livello;

		switch (this.livello) {
		case 1:
			this.NUMERO_COLONNE = 5;
			this.NUMERO_RIGHE = 5;
			break;

		case 2:
			this.NUMERO_COLONNE = 7;
			this.NUMERO_RIGHE = 5;
			break;

		case 3:
			this.NUMERO_COLONNE = 9;
			this.NUMERO_RIGHE = 6;
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

	public boolean piazzaTessera(Tessera t, int riga, int colonna) {
		if (riga < 0 || riga >= NUMERO_RIGHE || colonna < 0 || colonna >= NUMERO_COLONNE)
			return false;
		if (griglia[riga][colonna] != null)
			return false;
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

	public int getPotenzaDiFuoco() {
		int potenzaDiFuoco = ???; // andrebbe assegnata il numero dei cannoni singoli + ilo numero dei cannoni doppi che se vengnono usati viene tolta una batteria
		return potenzaDiFuoco;
	}

	public int getPotenzaMotrice() {
		int potenzaMotrice = ""; // andrebbe assegnata il numero dei motori singoli + il numero dei motori
								// doppi che se vengnono usati viene tolta una batteria
		return potenzaMotrice;
	}
}
