package Gioco;
import java.util.EnumSet;

public class Tessera {
	private TipoConnettore[] connettori;	// ALTO, DESTRA, BASSO, SINISTRA
	private TipoTessera tipo;
    private int capacitaBatteria;       //SOLO SE BATTERIA
    private int capacitaStiva;         //SOLO SE STIVA, STIVA_SPECIALE
    private EnumSet<Direzione> direzione;
    
    public Tessera(TipoConnettore alto, TipoConnettore destra, TipoConnettore basso, TipoConnettore sinistra,
            TipoTessera tipo, int capacitaBatteria, int capacitaStiva, EnumSet<Direzione> direzione) {
    	this.connettori = new TipoConnettore[] {alto, destra, basso, sinistra};
    	this.tipo = tipo;
    	this.capacitaBatteria = capacitaBatteria;
    	this.capacitaStiva = capacitaStiva;
        this.direzione = direzione;
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

    public TipoConnettore getConnettoreSuLato(Direzione d) {
        TipoConnettore risultato;
        switch (d) {
            case NORD:
                risultato = connettori[0];
                break;
            case EST:
                risultato = connettori[1];
                break;
            case SUD:
                risultato = connettori[2];
                break;
            case OVEST:
                risultato = connettori[3];
                break;
            default:
                throw new IllegalArgumentException("Direzione non valida: " + d);
        }

        return risultato;
    }
    
    public EnumSet<Direzione> getDirezione() {
        return direzione;
    }

    public void setDirezione(EnumSet<Direzione> direzione) {
        this.direzione = direzione;
    }
    
    public void ruotaSensoOrario() {
        // ruota i connettori in senso orario: alto <- sinistra, destra <- alto, ...
        TipoConnettore temp = connettori[3];
        connettori[3] = connettori[2];
        connettori[2] = connettori[1];
        connettori[1] = connettori[0];
        connettori[0] = temp;

        //rotazione anche delle direzioni
        if (direzione != null && !direzione.isEmpty()) {
            EnumSet<Direzione> nuoveDirezioni = EnumSet.noneOf(Direzione.class);
            for (Direzione d : direzione) {
                switch (d) {
                    case NORD -> nuoveDirezioni.add(Direzione.EST);
                    case EST -> nuoveDirezioni.add(Direzione.SUD);
                    case SUD -> nuoveDirezioni.add(Direzione.OVEST);
                    case OVEST -> nuoveDirezioni.add(Direzione.NORD);
                }
            }
            direzione = nuoveDirezioni;
        }
    }
    
    public void mostraTessera() {
        System.out.println("\nTessera Dettagli:");
        System.out.println("Tipo: " + this.getTipo());
        TipoConnettore[] c = this.getConnettori();
        System.out.println("Connettori - ALTO: " + c[0] + ", DESTRA: " + c[1] + ", BASSO: " + c[2] + ", SINISTRA: " + c[3]);
        if (this.getCapacitaBatteria() > 0) System.out.println("Capacità Batteria: " + this.getCapacitaBatteria());
        if (this.getCapacitaStiva() > 0) System.out.println("Capacità Stiva: " + this.getCapacitaStiva());
        if (this.getDirezione() != null) System.out.println("Direzione: " + this.getDirezione());
    }
}
