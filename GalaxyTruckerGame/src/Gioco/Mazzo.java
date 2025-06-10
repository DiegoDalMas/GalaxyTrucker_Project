package Gioco;
import java.util.Collections;
import java.util.*;
import Gioco.Carte.*;
import java.io.*;


public class Mazzo {
	private List<Carta> mazzoCarte;
	
	public Mazzo(String path) {
		mazzoCarte = new ArrayList<>();
		mazzoCarte.add(new Pianeti());
		mazzoCarte.add(new NaveAbbandonata());
		mazzoCarte.add(new StazioneAbbandonata());
		mazzoCarte.add(new SpazioAperto());
		mazzoCarte.add(new Contrabbandieri());
		mazzoCarte.add(new PolvereStellare());
		mazzoCarte.add(new PioggiaDiMeteoriti());

		
		Collections.shuffle(mazzoCarte);
	}

    public void pescaCarta(Giocatore leader, List<Giocatore> giocatori, PlanciaVolo plancia) {
        if (mazzoCarte.isEmpty()) {
            System.out.println("Il mazzo è vuoto");
            return;
        }
        Carta c = mazzoCarte.remove(0);
        System.out.println("[" + leader.getColore() + " pesca una carta di tipo]: " + c.getTipo());
        
        c.applicaEffetto(giocatori, leader, plancia);
    }
	
    public boolean isEmpty() {
    	return mazzoCarte.isEmpty();
    }
}
