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
    
    public void ruotaSensoOrario() {
        // ruota i connettori in senso orario: alto <- sinistra, destra <- alto, ...
        TipoConnettore temp = connettori[3];
        connettori[3] = connettori[2];
        connettori[2] = connettori[1];
        connettori[1] = connettori[0];
        connettori[0] = temp;
    }
}
