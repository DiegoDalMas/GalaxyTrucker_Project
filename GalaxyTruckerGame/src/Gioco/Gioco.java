package Gioco;

import java.util.*;

public class Gioco {
	private List<Giocatore> giocatori;
	private Magazzino magazzino;
	private Mazzo mazzoCarteAvventura;
	private GestioneTessere tutteLeTessere;
	private List<Giocatore> ordineDiRotta;
	
	public Gioco() {
		// CREAZIONE 4 GIOCATORI
		this.giocatori = new ArrayList<>();
        giocatori.add(new Giocatore(Colore.BLU));
        giocatori.add(new Giocatore(Colore.ROSSO));
        giocatori.add(new Giocatore(Colore.VERDE));
        giocatori.add(new Giocatore(Colore.GIALLO));

		this.magazzino = new Magazzino();
		this.mazzoCarteAvventura = new Mazzo("carteAvventura.csv");	//crea Mazzo con le carte già mischiato
		this.tutteLeTessere = new GestioneTessere("fileTessere.csv");

		this.ordineDiRotta = new ArrayList<>();
	}
	
	public void play(){
		System.out.println("INIZIO DEL GIOCO!");
		
		//I GIOCATORI SCELGONO PRIMA DI INIZIARE UN GIOCO IL RISPETTIVO COLORE
		//L'ORDINE DI PARTENZA SARA CASUALE
		Collections.shuffle(giocatori);
		this.ordineDiRotta = new ArrayList<>(giocatori);

		System.out.println("\n Ordine Iniziale di COSTRUZIONE: ");
		for (int i = 0; i < ordineDiRotta.size(); i++) {
            System.out.println((i+1) + ". " + ordineDiRotta.get(i).getColore());
        }

		//FASE DI COSTRUZIONE
		CostruzioneSimulatore costruzione = new CostruzioneSimulatore(giocatori, tutteLeTessere);
		costruzione.avviaCostruzione();

		//FASE DI VOLO
		GestioneTurni volo = new GestioneTurni(giocatori, mazzoCarteAvventura);
        volo.avviaFaseDiVolo();

		//FINITO IL VOLO, CALCOLO DEI CREDITI
		calcolaCrediti();//DA FARE
	}
	
	private void calcolaCrediti() {
        System.out.println("\n Classifica Finale del Round");
        //metodo per calcolare i crediti
    }
	
}
