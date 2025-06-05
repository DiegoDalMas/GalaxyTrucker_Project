package Gioco.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Gioco.Giocatore;
import Gioco.PlanciaVolo;

public class Pianeti extends Carta {

	private List<Pianeta> pianeti;
	private int giorniDiVoloPersi;

	public Pianeti(){
		this.pianeti = new ArrayList<>();
		Random rand = new Random();
		this.giorniDiVoloPersi = rand.nextInt(3) + 1;	//DA 1 A 3
		int numero_pianeti = rand.nextInt(3) + 2;	//DA 2 A 4
		for(int i=0; i<numero_pianeti; i++){
			pianeti.add(new Pianeta());
		}
	}

	public int getGiorniDiVoloPersi() {
        return giorniDiVoloPersi;
    }

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia) {
		Scanner sc = new Scanner(System.in);
		System.out.println("CARTA PIANETI");
		System.out.println("Giorni di Volo che PERDERAI quando atterri: " + giorniDiVoloPersi);
		
		//STAMPA I PIANETI A SCHERMO
		stampaPianeti();
		
		for(Giocatore g: giocatori){
			System.out.println("\nGiocatore " + g.getColore() + ", vuoi atterrare su un pianeta? (s/n)");
			String risposta = sc.nextLine().toLowerCase();
			if(risposta.equals("s")){
				boolean pianetaAssegnato = false;

				while (!pianetaAssegnato) {
					System.out.println("Scegli il numero del pianeta su cui vuoi atterrare:");
					int sceltaPianeta;
					try{
						sceltaPianeta = Integer.parseInt(sc.nextLine());
					}catch(NumberFormatException e){
						System.out.println("Inserisci un numero valido");
						continue;
					}

					if (sceltaPianeta < 1 || sceltaPianeta > pianeti.size()) {
						System.out.println("Numero fuori range.");
						continue;
					}
					Pianeta pianetaScelto = pianeti.get(sceltaPianeta-1);

					if (pianetaScelto.isOccupato()) {
						System.out.println("Quel pianeta è già occupato!");
					} else {
						pianetaScelto.setOccupato(true);
						pianetaScelto.raccogliMerci(g);
						System.out.println("Merci caricate con successo.");
						plancia.muoviGiocatore(g.getColore(), -giorniDiVoloPersi);
						System.out.println("Hai perso " + giorniDiVoloPersi + " giorni di volo.");
						pianetaAssegnato = true;
					}
				}
			}else{
				System.out.println("Hai scelto di NON atterrare. Tocca al prossimo giocatore!");
			}
		}
	}

	public void stampaPianeti(){
		System.out.println("\nPianeti disponibili su questa carta:");
		for(int i=0; i<pianeti.size(); i++){
			Pianeta p = pianeti.get(i);
			if(!p.isOccupato()){
				System.out.println("Pianeta "+i+1);
				p.stampaPianeta();
			}
		}
	}
}