package Gioco.Carte;
import java.util.List;
import Gioco.Giocatore;
import Gioco.PlanciaVolo;

public abstract class Carta{
    public abstract void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia);
    
    
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
