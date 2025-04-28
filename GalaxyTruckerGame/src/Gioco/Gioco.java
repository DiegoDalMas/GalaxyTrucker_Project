package Gioco;

public class Gioco {
	private Giocatore g1;
	private Giocatore g2;
	private Giocatore g3;
	private Giocatore g4;
	
	public Gioco() {
		g1 = new Giocatore(Colore.BLU);             // QUANDO VIENE CREATO IL GIOCO SI CREANO I 4 GIOCATORI
		g2 = new Giocatore(Colore.ROSSO);
		g3 = new Giocatore(Colore.VERDE);
		g4 = new Giocatore(Colore.GIALLO);
	}

	
	public void play() {
        // VENGONO CREATE LE ASTRONAVI, oppure meglio le astronavi vegnono create all'interno di giocatore, ASTRONAVE EXTENDS GIOCATORE
		

		// creare un metodo che prenda in input i giocatori e che gli faccia costruire la nave
		
		int livello_mazzo=0;
		Mazzo mazzo= new Mazzo(livello_mazzo);      // crei il mazzo di carte 
		Magazzino m = new Magazzino(); // crei il magazzino
		Volo plancia = new Volo();   // crei il tabellone di volo
		for(int i=0; i<8; i++) {
			Carta c= mazzo.estrai(g1,g2,g3,g4);//per ogni carta avra il suo metodo
			// creare una classe turno che prende in imput i giocatori, la carta estratta.
		}
		//giocatori.contaCrediti();
	}
}
