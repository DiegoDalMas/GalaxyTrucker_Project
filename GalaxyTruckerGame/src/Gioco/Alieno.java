package Gioco;

public class Alieno {
	public enum Colore {
        VIOLA, MARRONE
    }
    private Colore colore;

    public Alieno(Colore colore) {
        this.colore = colore;
    }

    public Colore getColore() {
        return this.colore;
    }

    public int bonusPotenzaFuoco() {
        if(colore == Colore.VIOLA) {
        	return 2;
        }else {
        	return 0;
        }
    }

    public int bonusPotenzaMotore() {
    	if(colore == Colore.MARRONE) {
        	return 2;
        }else {
        	return 0;
        }
    }
}
