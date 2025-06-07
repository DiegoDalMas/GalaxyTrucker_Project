package Gioco.Carte;

import java.util.List;
import java.util.Scanner;
import java.util.Random;


import Gioco.Giocatore;
import Gioco.PlanciaVolo;

public class NaveAbbandonata extends Carta {
	private int giorniVoloPersi;
	private int equipaggioPerso;
	private int creditiGuadagnati;

	public NaveAbbandonata(){
		Random rand = new Random();
		this.giorniVoloPersi = rand.nextInt(2) + 1;
		this.equipaggioPerso = rand.nextInt(3) + 2;
		this.creditiGuadagnati = rand.nextInt(3) + 3;
	}

	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia){
		Scanner sc = new Scanner(System.in);
		System.out.println("CARTA NAVE ABBANDONATA");
		System.out.println("Equipaggio richiesto: " + equipaggioPerso);
        System.out.println("Crediti ottenibili " + creditiGuadagnati);
		System.out.println("Giorni di Volo persi " + giorniVoloPersi);
		
		for(Giocatore g: giocatori){
			System.out.println("Giocatore: " + g.getColore());
			System.out.println("Hai un equipaggio di " + g.getAstronave().getEquipaggio());

			if(g.getAstronave().getEquipaggio() < equipaggioPerso){
				System.out.println("Non hai abbastanza Equipaggio. La scelta passa al prossimo giocatore");
				continue;
			}
			String scelta;
			do{
				System.out.println("Vuoi approfittare della nave abbandonata? (s/n)");
				scelta = sc.nextLine().toLowerCase();
			}while(!scelta.equals("s") && !scelta.equals("n"));	//EVITA INPUT ERRATI
			if(scelta.equals("s")){
				g.getAstronave().perditaEquipaggio(equipaggioPerso);
				g.assegnaCrediti(creditiGuadagnati);
				plancia.muoviGiocatore(g.getColore(), -giorniVoloPersi);
				System.out.println("Hai riparato la nave! Hai perso " + equipaggioPerso + " membri dell’equipaggio");
                System.out.println("Hai guadagnato " + creditiGuadagnati + " crediti");
                System.out.println("Hai perso " + giorniVoloPersi + " giorni di volo");
				break;	//si interrompe la carta
			}else{
				System.out.println("Hai scelto di non riparare la nave. La scelta passa al prossimo GIocatore");
			}
		}
	}
}