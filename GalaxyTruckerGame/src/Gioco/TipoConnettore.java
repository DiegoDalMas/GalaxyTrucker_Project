package Gioco;

public enum TipoConnettore {
    SINGOLO, DOPPIO, UNIVERSALE, LISCIO;

    public boolean compatibileCon(TipoConnettore c) {
        if (this == LISCIO || c == LISCIO) return false;
        if (this == UNIVERSALE || c == UNIVERSALE) return true;
        return this == c; // SINGOLO con SINGOLO, DOPPIO con DOPPIO
    }
}
