package Gioco;

import java.util.*;

public class CostruzioneSimulatore {
    private List<Giocatore> giocatori;
    private GestioneTessere tutteLeTessere;
    private Scanner scanner = new Scanner(System.in);

    public CostruzioneSimulatore(List<Giocatore> giocatori, GestioneTessere tutteLeTessere) {
        this.giocatori = giocatori;
        this.tutteLeTessere = tutteLeTessere;
    }

    public void avviaCostruzione(){
        System.out.println("\n--- Inizio Fase di COSTRUZIONE ---");
        Set<Giocatore> giocatoriCompletati = new HashSet<>();

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
                
                System.out.println("Ora decidi dove vuoi posizionare la tessera");
                System.out.println("Inserisci riga (0-4):");
                int riga = Integer.parseInt(scanner.nextLine());
                System.out.println("Inserisci colonna (0-4):");
                int colonna = Integer.parseInt(scanner.nextLine());

                boolean piazzata = g.getAstronave().piazzaTessera(tessera, riga, colonna);      //creare metodo piazzaTessera
                if (piazzata) {
                    System.out.println("Tessera piazzata con successo.");
                } else {
                    System.out.println("Errore nel piazzamento. Tessera non piazzata.");
                    tutteLeTessere.restituisciTessera(tessera);
                }

            }
        }

        System.out.println("\n Tutti i giocatori hanno completato la costruzione!");

    }
}
