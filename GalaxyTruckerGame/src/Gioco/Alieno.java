package Gioco;

public class Alieno {
    private ColoreAlieno colore;

    public Alieno(ColoreAlieno colore) {
        this.colore = colore;
    }

    public ColoreAlieno getColore() {
        return this.colore;
    }

    public int bonusPotenzaFuoco() {
        if(colore == ColoreAlieno.VIOLA) {
        	return 2;
        }else {
        	return 0;
        }
    }

    public int bonusPotenzaMotore() {
    	if(colore == ColoreAlieno.MARRONE) {
        	return 2;
        }else {
        	return 0;
        }
    }
}
