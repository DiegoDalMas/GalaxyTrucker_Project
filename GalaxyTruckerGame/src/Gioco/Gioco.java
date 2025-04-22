package Gioco;

public class Gioco {
	private Colore giocatore1;
	private Colore giocatore2;
	private Colore giocatore3;
	private Colore giocatore4;
	
	public Gioco() {
		giocatore1 = Colore.BLU;
		giocatore2 = Colore.ROSSO;
		giocatore3 = Colore.VERDE;
		giocatore4 = Colore.GIALLO;
	}
	
	
	public void play() {
		Astronave[] astronavi;
		Colore[] giocatori;
		for(int i=0; i<4; i++) {
			astronavi[i] = new Astronave(giocatori[i]);
			astronavi[i].crea();
		}
		
		Carta[] mazzo;
		
		Magazzino m = new Magazzino();
		Volo plancia = new Volo();
		for(int i=0; i<mazzo.length(); i++) {
			mazzo[i].estraiCarta();		//per ogni carta avra il suo metodo
		}
		//giocatori.contaCrediti();
	}
}
