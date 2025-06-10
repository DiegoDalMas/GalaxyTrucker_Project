package Gioco;

import java.util.*;

public class Gioco {
	private List<Giocatore> giocatori;
	private Magazzino magazzino;
	private Mazzo mazzoCarteAvventura;
	private PlanciaVolo plancia;
	private GestioneTessere tutteLeTessere;
	private List<Giocatore> ordineDiRotta;
	private static int livello;
	private Dado dado;
	
	public Gioco() {
		this.magazzino = new Magazzino();
		this.mazzoCarteAvventura = new Mazzo("carteAvventura.csv");		//crea Mazzo con le carte già mischiato
		this.tutteLeTessere = new GestioneTessere("fileTessere.csv");
		this.ordineDiRotta = new ArrayList<>();
		this.plancia = new PlanciaVolo();
	}
	
	public void play(){
		Scanner scanner = new Scanner(System.in);
    	int livelloDiGioco = chiediLivello(scanner);		//chiede livello
		Gioco.setLivello(livelloDiGioco);				//lo imposta all'inizio e non cambia più

		// CREAZIONE 4 GIOCATORI
		this.giocatori = new ArrayList<>();
        giocatori.add(new Giocatore(Colore.BLU));
        giocatori.add(new Giocatore(Colore.ROSSO));
        giocatori.add(new Giocatore(Colore.VERDE));
        giocatori.add(new Giocatore(Colore.GIALLO));
		
        System.out.println("\n--- INIZIO DEL GIOCO! ---");
		
		//I GIOCATORI SCELGONO PRIMA DI INIZIARE IL GIOCO IL RISPETTIVO COLORE
		//L'ORDINE DI PARTENZA SARA CASUALE
		Collections.shuffle(giocatori);
		this.ordineDiRotta = new ArrayList<>(giocatori);

		System.out.println("\nOrdine Iniziale di COSTRUZIONE: ");
		for (int i = 0; i < ordineDiRotta.size(); i++) {
            System.out.println((i+1) + ". " + ordineDiRotta.get(i).getColore());
        }

		//FASE DI COSTRUZIONE
		CostruzioneSimulatore costruzione = new CostruzioneSimulatore(giocatori, tutteLeTessere);
		costruzione.avviaCostruzione();

		//ASSEGNAMO AD OGNI GIOCATORE BATTERIE/UMANI/ECC..
		for (Giocatore g : giocatori) {
			g.getAstronave().assegnazioneMaterialeGiocatore(magazzino);
		}
		
		//FASE DI VOLO
		GestioneTurni volo = new GestioneTurni(giocatori, mazzoCarteAvventura);
        volo.avviaFaseDiVolo(plancia);

		//FINITO IL VOLO, CALCOLO DEI CREDITI
		calcolaCrediti();
	}
	
	private void calcolaCrediti() {
        System.out.println("CALCOLO CREDITI FINALI");
        int[] creditiPosizione = {4, 3, 2, 1};
        for(int i=0; i<giocatori.size(); i++) {
        	Giocatore g = giocatori.get(i);
        	g.assegnaCrediti(creditiPosizione[i]);
        	System.out.println("Giocatore "+g.getColore()  +" ottiene "+ creditiPosizione[i] + " crediti per la propria posizione sulla rotta");
        }
        
        //MIGLIOR NAVE
        Giocatore migliorNave = giocatori.get(0);
        int minConnettori = migliorNave.getAstronave().connettoriEsposti();
        for(Giocatore g: giocatori) {
        	int connEsposti = g.getAstronave().connettoriEsposti();
        	if(connEsposti < minConnettori) {
        		migliorNave = g;
        		minConnettori = connEsposti;
        	}
        }
        migliorNave.assegnaCrediti(2);
        System.out.println("Giocatore " + migliorNave.getColore() + " ha la nave piu bella e ha guadagnato 2 crediti");
        
        
        // Vendita merci
        for(Giocatore g: giocatori) {
        	int guadagnoMerci = 0;
        	Casella[][] griglia = g.getAstronave().getGriglia();
        	for(int i=0; i<griglia.length; i++) {
        		for(int j=0; j<griglia[i].length; j++) {
        			Casella casella = griglia[i][j];
        			if(casella != null && casella.getTessera() != null) {
        				Tessera t = casella.getTessera();
        				if(t.getTipo() == TipoTessera.STIVA || t.getTipo() == TipoTessera.STIVA_SPECIALE) {
        					for(Merci m: t.getMerciContenute()) {
        						switch(m.getColore()) {
	        						case ROSSO -> guadagnoMerci += 4;
	                                case GIALLO -> guadagnoMerci += 3;
	                                case VERDE -> guadagnoMerci += 2;
	                                case BLU -> guadagnoMerci += 1;
        						}
        					}
        				}
        			}
        		}
        	}
        	g.assegnaCrediti(guadagnoMerci);
            System.out.println("Giocatore" + g.getColore() + " guadagna " + guadagnoMerci + " crediti dalla vendita delle merci");
        }
        
        System.out.println("CLASSIFICA FINALE");
        giocatori.sort((a, b) -> Integer.compare(b.getCrediti(), a.getCrediti()));
        for(int i=0; i<giocatori.size(); i++) {
        	Giocatore g = giocatori.get(i);
        	System.out.println((i+1) + ". " + g.getColore() + " con Crediti " + g.getCrediti());
        }        
    }
	
	public static int getLivello() {
        return livello;
    }

	private static void setLivello(int livelloScelto){
		livello = livelloScelto;
	}

    private int chiediLivello(Scanner scanner) {
		while (true) {
			try {
				System.out.print("Scegli il livello di gioco che vuoi usare (1, 2 o 3): ");
				int livello = Integer.parseInt(scanner.nextLine());
				if (livello < 1 || livello > 3){
					throw new IllegalArgumentException();
				}
				return livello;
			} catch (Exception e) {
				System.out.println("Input non valido. Inserisci 1, 2 o 3.");
			}
		}
	}

}
