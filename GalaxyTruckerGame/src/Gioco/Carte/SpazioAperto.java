package Gioco.Carte;

import java.util.List;
import java.util.Scanner;

import Gioco.Giocatore;

public class SpazioAperto extends Carta{
	private boolean cond;
	private Scanner in = new Scanner(System.in);
	private int GiorniGuad;
    public SpazioAperto(){
        
    }

    @Override
    public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader){
    	System.out.println("CARTA SPAZIO APERTO");
    	for(Giocatore g : giocatori) {
        	System.out.println("Vuoi avanzare? ");
        	cond=in.nextBoolean();
        	if(cond==true) {
        		GiorniGuad= g.getAstronave().getPotenzaMotrice();
        	  g.muoviGiocatore(GiorniGuad);
        	}
        }
    }
    
}