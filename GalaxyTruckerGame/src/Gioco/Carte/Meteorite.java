package Gioco.Carte;

import Gioco.Direzione;

public class Meteorite {
	private TipoMeteorite tipo;
	private Direzione direzione;

	public Meteorite(TipoMeteorite tipo, Direzione direzione) {
		this.direzione = direzione;
		this.tipo = tipo;
	}

	public Direzione getDirezione() {
		return direzione;
	}

	public TipoMeteorite getTipo() {
        return tipo;
    }

}
