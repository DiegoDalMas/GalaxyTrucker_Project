package Gioco;
import java.util.*;

public enum Direzione {
    NORD, SUD, EST, OVEST;

    private static Random rand = new Random();

    public static Direzione random(){
        Direzione[] valori = {Direzione.NORD, Direzione.EST, Direzione.SUD, Direzione.OVEST};
        int posDirezione = rand.nextInt(4);
        Direzione scelta = valori[posDirezione];
        return scelta;
    }
}