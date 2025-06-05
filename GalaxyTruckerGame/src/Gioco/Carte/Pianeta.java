package Gioco.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Gioco.Colore;
import Gioco.Giocatore;
import Gioco.Merci;

public class Pianeta {
	private List<Merci> merci;
	private boolean occupato;
	private int numero_merci;

	public Pianeta() {
		this.merci = new ArrayList<>();
		Random rand = new Random();
		this.numero_merci = rand.nextInt(3) + 2;

		for(int i=0; i<numero_merci; i++){
			Colore[] coloriDisponibili = {Colore.ROSSO, Colore.VERDE, Colore.BLU, Colore.GIALLO};
			Random r = new Random();
			int posColore = r.nextInt(4);
			Colore coloreScelto = coloriDisponibili[posColore];
			merci.add(new Merci(coloreScelto));
		}
		this.occupato = false;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	//serve per trasferire le merci del pianeta all'astronave del giocatore
	public void raccogliMerci(Giocatore g) {
		g.getAstronave().assegnaMerce(merci);
	}

	public void stampaPianeta(){
		if(occupato) return;
		System.out.println("CASSE: \n");
		for(Merci m: merci){
			System.out.print("[" + m.getColore() + "] ");
		}
	}
}
