package Gioco;

import java.util.*;

public class CostruzioneSimulatore {
    private List<Giocatore> giocatori;
    private GestioneTessere tutteLeTessere;
    private Scanner scanner = new Scanner(System.in);
    private PlanciaVolo plancia;

    public CostruzioneSimulatore(List<Giocatore> giocatori, GestioneTessere tutteLeTessere, PlanciaVolo plancia) {
        this.giocatori = giocatori;
        this.tutteLeTessere = tutteLeTessere;
        this.plancia = plancia;
    }

    public void avviaCostruzione(){
        System.out.println("\n--- Inizio Fase di COSTRUZIONE ---");
        List<Giocatore> giocatoriCompletati = new ArrayList<>();

        while(giocatoriCompletati.size() < giocatori.size()){
            for(Giocatore g: giocatori){
                if(giocatoriCompletati.contains(g)) continue;       //se presente in giocatoriCompletati ha finito la costruzione

                System.out.println(g.getColore() + ". Questa e' la tua Astronave!");
                g.getAstronave().stampaGrigliaAstronave();
                System.out.println("\n" + g.getColore() + 
                ", premi INVIO per pescare una tessera o digita 'X' se hai completato la nave:");
                String input = scanner.nextLine();
                if (input.toLowerCase().equals("x")) {
                    giocatoriCompletati.add(g);
                    System.out.println(g.getColore() + " ha completato la sua astronave.");
                    continue;
                }

                Tessera tessera = tutteLeTessere.pescaTessera();
                if(tessera == null){
                    System.out.println("Sono finite le tessere!!");
                    continue;
                }
                System.out.println("Hai pescato la seguente TESSERA:");
                tessera.mostraTessera();

                String sceltaRotazione = "";
                do{
                    System.out.println("\nVuoi ruotare la tessera? (r = ruota, invio = continua)");
                    sceltaRotazione = scanner.nextLine().toLowerCase();
                    if (sceltaRotazione.equals("r")) {
                        tessera.ruotaSensoOrario();
                        System.out.println("Tessera ruotata:");
                        tessera.mostraTessera();
                    }  
                }while(sceltaRotazione.toLowerCase().equals("r"));

                System.out.println("Vuoi tenere la TESSERA? (s/n)");
                String sceltaFinale = scanner.nextLine().toLowerCase();
                if (sceltaFinale.equals("n")) {
                    tutteLeTessere.restituisciTessera(tessera);
                    System.out.println("Tessera scartata. Turno terminato.");
                    System.out.println("----------------------------------");
                    continue; // passa al prossimo giocatore
                }

                boolean piazzata = false;
                while(!piazzata){
                    System.out.println("Ora decidi dove vuoi posizionare la tessera");
                    System.out.println("Inserisci riga (0 - "+(g.getAstronave().getNumeroRighe() - 1) + "):");
                    int riga = Integer.parseInt(scanner.nextLine());
                    System.out.println("Inserisci colonna (0 - "+(g.getAstronave().getNumeroColonne() - 1) + "):");
                    int colonna = Integer.parseInt(scanner.nextLine());
                    
                    piazzata = g.getAstronave().piazzaTessera(tessera, riga, colonna);
                    if(!piazzata){
                        System.out.println("ERRORE! La tessera NON e' stata posizionata");
                        System.out.println("Vuoi riprovare a posizionarla? (s/n)");
                        String scelta = scanner.nextLine().toLowerCase();
                        if(scelta.equals("n")){
                            tutteLeTessere.restituisciTessera(tessera);
                            System.out.println("Hai scartato la tessera! TURNO TERMINATO");
                            break;
                        }
                    }else{
                        System.out.println("Tessera piazzata con successo!");
                    }
                
                }

            }
        }

        System.out.println("\nTutti i giocatori hanno completato la costruzione!");
        
        for (int i = 0; i < giocatori.size(); i++) {
            switch (i) {
                case 0 -> giocatori.get(i).setPosizione(PosizioneGiocatore.PRIMO);
                case 1 -> giocatori.get(i).setPosizione(PosizioneGiocatore.SECONDO);
                case 2 -> giocatori.get(i).setPosizione(PosizioneGiocatore.TERZO);
                case 3 -> giocatori.get(i).setPosizione(PosizioneGiocatore.QUARTO);
            }
        }
    }
}
