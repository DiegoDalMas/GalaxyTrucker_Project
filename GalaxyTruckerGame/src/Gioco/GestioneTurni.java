package Gioco;

import java.util.Comparator;
import java.util.List;

public class GestioneTurni {
    private List<Giocatore> giocatori;
    private Mazzo mazzoCarte;


    public GestioneTurni(List<Giocatore> giocatori, Mazzo mazzo) {
        this.giocatori = giocatori;
        this.mazzoCarte = mazzo;
    }

    public void avviaFaseDiVolo(){
        System.out.println("\n Inizio Fase di Volo");

        while(true){
            Giocatore leader = giocatori.get(0);
            if(mazzoCarte.isEmpty()) break;
            mazzoCarte.pescaCarta(leader, giocatori);
            aggiornaOrdineDiRotta();
        }

        System.out.println("\n Fine Fase di Volo");
    }


    private void aggiornaOrdineDiRotta() {
        giocatori.sort(Comparator.comparingInt(g -> g.getPosizione().ordinal()));
        // Assegna la posizione aggiornata in base al nuovo ordine
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
