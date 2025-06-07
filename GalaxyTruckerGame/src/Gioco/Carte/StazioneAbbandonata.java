package Gioco.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import Gioco.Colore;
import Gioco.Giocatore;
import Gioco.Merci;
import Gioco.PlanciaVolo;

public class StazioneAbbandonata extends Carta {

	private int equipaggioRichiesto;
	private int giorniVoloPersi;
	private int numeroMerci;
	private List<Merci> ricompensa;

	public StazioneAbbandonata(){
		Random rand = new Random();
		this.equipaggioRichiesto = rand.nextInt(2) + 5;	//DA 5 A 6
		this.giorniVoloPersi = rand.nextInt(2) + 1;
		this.ricompensa = new ArrayList<>();
		this.numeroMerci = rand.nextInt(2) + 2;
		for(int i=0; i<numeroMerci; i++){
			Colore[] coloriDisponibili = {Colore.ROSSO, Colore.VERDE, Colore.BLU, Colore.GIALLO};
			int posColore = rand.nextInt(4);
			Colore coloreScelto = coloriDisponibili[posColore];
			ricompensa.add(new Merci(coloreScelto));
		}
	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia){
		Scanner sc = new Scanner(System.in);
		System.out.println("CARTA STAZIONE SPAZIALE");
		System.out.println("Equipaggio richiesto: " + equipaggioRichiesto);
		System.out.println("Merci disponibili: " + ricompensa.size());
		System.out.print("Colori delle merci: ");
		for (Merci m : ricompensa) {
			System.out.print("[" + m.getColore() + "] ");
		}
		System.out.println("Giorni di volo persi: " + giorniVoloPersi);

		for(Giocatore g: giocatori){
			System.out.println("Giocatore: " + g.getColore());
			System.out.println("Hai un equipaggio di " + g.getAstronave().getEquipaggio());

			if(g.getAstronave().getEquipaggio() < equipaggioRichiesto){
				System.out.println("Non hai abbastanza equipaggio. Tocca al prossimo giocatore");
				continue;
			}

			String scelta;
			do{
				System.out.println("Vuoi attraccare alla stazione? (s/n)");
				scelta = sc.nextLine().toLowerCase();
			}while(!scelta.equals("s") && !scelta.equals("n"));

			if(scelta.equals("s")){
				g.getAstronave().assegnaMerce(ricompensa);
				plancia.muoviGiocatore(g.getColore(), -giorniVoloPersi);
				System.out.println("Hai perso " + giorniVoloPersi + " giorni di volo");
				break;
			}else{
				System.out.println("Hai rinunciato, tocca al prossimoo giocatore");
			}
		}
	}
}