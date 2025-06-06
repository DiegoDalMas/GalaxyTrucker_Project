package Gioco.Carte;

import java.util.List;

import Gioco.Giocatore;
import Gioco.Merci;
import Gioco.PlanciaVolo;

public class Contrabbandieri extends Carta {
	private boolean conferma=false;
    private int potenzaFuocoContrabbandieri;
	private int penalita;
    private int giorniDiVoloPersi;
    private List<Merci> ricompensa;
    public Contrabbandieri(int potenzaFuoco, int penalita, int giorniDiVoloPersi, List<Merci> ricompensa){
        this.potenzaFuocoContrabbandieri = potenzaFuoco;
        this.penalita = penalita;
        this.giorniDiVoloPersi = giorniDiVoloPersi;
        this.ricompensa = ricompensa;
    }

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia) {
		System.out.println("CARTA CONTRABBANDIERI");
		System.out.println("POTENZA: "+potenzaFuocoContrabbandieri);
        System.out.println("Penalita: perdi " + penalita + " merci");
		
		do{
			for(Giocatore g: giocatori){
				double potenzaFuocoGiocatore = g.getAstronave().getPotenzaDiFuoco();
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
