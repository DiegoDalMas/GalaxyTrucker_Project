package Gioco;

public class Tessera {
	private TipoConnettore[] connettori;	// ALTO, DESTRA, BASSO, SINISTRA
	private TipoTessera tipo;
    private int capacitaBatteria;       //SOLO SE BATTERIA
    private int capacitaStiva;         //SOLO SE STIVA, STIVA_SPECIALE
    
    public Tessera(TipoConnettore alto, TipoConnettore destra, TipoConnettore basso, TipoConnettore sinistra,
            TipoTessera tipo, int capacitaBatteria, int capacitaStiva) {
    	this.connettori = new TipoConnettore[] {alto, destra, basso, sinistra};
    	this.tipo = tipo;
    	this.capacitaBatteria = capacitaBatteria;
    	this.capacitaStiva = capacitaStiva;
    }
    
    public TipoConnettore[] getConnettori() {
        return connettori;
    }

    public TipoTessera getTipo() {
        return tipo;
    }

    public int getCapacitaBatteria(){
        return capacitaBatteria;
    }

    public int getCapacitaStiva(){
        return capacitaStiva;
    }
}
