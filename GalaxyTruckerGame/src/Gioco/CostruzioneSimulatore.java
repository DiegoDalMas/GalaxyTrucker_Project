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
        System.out.println("\n--- Inizio Fase di Costruzione ---");
        Set<Giocatore> giocatoriCompletati = new HashSet<>();

        while(giocatoriCompletati.size() < giocatori.size()){
            for(Giocatore g: giocatori){
                if(giocatoriCompletati.contains(g)) continue;       //se presente in giocatoriCompletati ha finito la costruzione

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

                tessera.mostraTessera();
                System.out.println("Vuoi tenerla? (s/n)");
                String scelta = scanner.nextLine();

                if (scelta.toLowerCase().equals("n")) {
                    tutteLeTessere.restituisciTessera(tessera);
                }

                System.out.println("Ora decidi dove vuoi posizionare la tessera");
                System.out.println("Inserisci riga (5-9):");
                int riga = Integer.parseInt(scanner.nextLine());
                System.out.println("Inserisci colonna (5-9):");
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
