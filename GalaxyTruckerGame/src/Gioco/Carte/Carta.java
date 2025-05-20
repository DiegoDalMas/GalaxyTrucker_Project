package Gioco.Carte;
import java.util.List;
import Gioco.Giocatore;

public abstract class Carta{
    public abstract void applicaEffetto(List<Giocatore> giocatori, Giocatore leader);
    
    
    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}
