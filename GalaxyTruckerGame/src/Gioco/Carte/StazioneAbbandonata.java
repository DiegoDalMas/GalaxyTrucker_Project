package Gioco.Carte;

import java.util.List;

import Gioco.Giocatore;

public class StazioneAbbandonata extends Carta{
    
    public StazioneAbbandonata(){
        
    }

    @Override
    public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader){
        System.out.println(""); // richiesta al giocatore se vuole fermarsi
        // boolean conferma 
        /* if boolean is true 
         * conrollo equipaggio giocatore
         * if contorllo is true
         * carica merci
         * if contorllo is false 
         * conferma is false
         */
    }

    
}