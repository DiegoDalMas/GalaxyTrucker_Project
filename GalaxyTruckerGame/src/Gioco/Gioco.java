package Gioco;

import java.util.*;

public class Gioco {
	private List<Giocatore> giocatori;
	private Magazzino magazzino;
	
	public Gioco() {
		this.magazzino = new Magazzino();
        this.giocatori = new ArrayList<>();

        // CREAZIONE 4 GIOCATORI
        giocatori.add(new Giocatore(Colore.BLU));
        giocatori.add(new Giocatore(Colore.ROSSO));
        giocatori.add(new Giocatore(Colore.VERDE));
        giocatori.add(new Giocatore(Colore.GIALLO));
	}

	
	public void play() {
        // VENGONO CREATE LE ASTRONAVI, oppure meglio le astronavi vegnono create all'interno di giocatore, ASTRONAVE EXTENDS GIOCATORE
		

		// creare un metodo che prenda in input i giocatori e che gli faccia costruire la nave
		
		int livello_mazzo=0;
		Mazzo mazzo= new Mazzo(livello_mazzo);      // crei il mazzo di carte 
		Magazzino m = new Magazzino(); // crei il magazzino
		Volo plancia = new Volo(); // crei il tabellone di volo
		for(Giocatore g: giocatori) {
			//Estrazione carta (metodo classe tessera)
	    	//chiedi se vuole tenere il componente
	    	// se la ripsosta è si
			g.getAstronave().crea(tessera);
	    	// altrimenti add al mazzo
		}
		for(int i=0; i<8; i++) {
			//Carta c= mazzo.estrai();//per ogni carta avra il suo metodo
			// creare una classe turno che prende in imput i giocatori, la carta estratta.
		}
		//giocatori.contaCrediti();
	}
	
	
	//ESEMPIO PER ASSEGNARE QUALCOSA (VOGLIO ASSEGNARE 2 UMANI AL ROSSO)
	/*for(Giocatore g: giocatori) {
		if(g.getColore() == Colore.ROSSO) {	//HO CONTROLLATO CHE IL COLORE SIA GIUSTO
			g.assegnaUmano(magazzino);
			g.assegnaUmano(magazzino);
		}
	}*/
}
