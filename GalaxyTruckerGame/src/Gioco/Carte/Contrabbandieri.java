package Gioco.Carte;

import java.util.*;
import java.util.Random;

import Gioco.Colore;
import Gioco.Giocatore;
import Gioco.Merci;
import Gioco.PlanciaVolo;

public class Contrabbandieri extends Carta {
	private boolean conferma=false;
    private int potenzaFuocoContrabbandieri;
	private int penalita;
    private int giorniDiVoloPersi;
    private List<Merci> ricompensa;
    public Contrabbandieri(){
    	Random rand = new Random();
    	this.potenzaFuocoContrabbandieri = rand.nextInt(3) + 4;
    	this.penalita = rand.nextInt(2) + 2;
    	this.giorniDiVoloPersi = rand.nextInt(2) + 1;
    	this.ricompensa = new ArrayList<>();
    	int numeroMerci = rand.nextInt(3) + 2;
    	Colore[] coloriDisponibili = Colore.values();
    	for(int i=0; i<numeroMerci; i++) {
    		int posColore = rand.nextInt(coloriDisponibili.length);
    		ricompensa.add(new Merci(coloriDisponibili[posColore]));
    	}
    }

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia) {
		System.out.println("CARTA CONTRABBANDIERI");
		System.out.println("POTENZA: "+potenzaFuocoContrabbandieri);
        System.out.println("Penalita: perdi " + penalita + " merci");
		
		do{
			for(Giocatore g: giocatori){
				double potenzaFuocoGiocatore = g.getAstronave().getPotenzaDiFuoco();	//DA FARE
				if(potenzaFuocoContrabbandieri > potenzaFuocoGiocatore){
                	System.out.println("HAI PERSO! Perdi " + penalita + " merci");
					g.getAstronave().perditaMerce(penalita);
				}else if(potenzaFuocoContrabbandieri < potenzaFuocoGiocatore){
                	System.out.println("HAI VINTO! Ottieni la ricompensa.");
					g.getAstronave().assegnaMerce(ricompensa);
					System.out.println("Merce ricevuta: ");
					for(Merci m: ricompensa){
						System.out.println(m.getColore());
					}
					System.out.println("Hai perso 2 giorni di volo");
					plancia.muoviGiocatore(g.getColore(), -giorniDiVoloPersi);
					conferma = true;
				}else{
                	System.out.println("PAREGGIO: i contrabbandieri passano al prossimo giocatore.");
				}
			}
		}while(!conferma);
	}
}
