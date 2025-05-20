package Gioco;
import java.util.Collections;
import java.util.*;
import Gioco.Carte.*;
import java.io.*;


public class Mazzo {
	private List<Carta> mazzoCarte;
	//private int livelloMazzo;
	
	
	public Mazzo(String path) {
		mazzoCarte = new ArrayList<>();
		caricaCarteDaFile(path);
		Collections.shuffle(mazzoCarte);
	}
	
	private void caricaCarteDaFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valori = linea.split(",");
                String tipo = valori[0];
                switch (tipo.toUpperCase()) {
                    case "PIANETI":
                        mazzoCarte.add(new Pianeti(/*Integer.parseInt(valori[1])*/));
                        break;
                    case "NAVE_ABBANDONATA":
                        mazzoCarte.add(new NaveAbbandonata(/*Integer.parseInt(valori[1])*/));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura delle carte: " + e.getMessage());
        }
    }

    public void pescaCarta(Giocatore leader, List<Giocatore> giocatori) {
        if (mazzoCarte.isEmpty()) {
            System.out.println("Il mazzo è vuoto.");
            return;
        }
        Carta c = mazzoCarte.remove(0);
        System.out.println("\n[" + leader.getColore() + " pesca una carta di tipo]: " + c.getTipo());
        c.applicaEffetto(giocatori, leader);
    }
	
}
