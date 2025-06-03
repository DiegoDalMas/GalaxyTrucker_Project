package Gioco.Carte;

public class Meteorite {
	private String direzione;
	private int grandezza;

	public Meteorite(String direzione, int grandezza) {
		this.direzione = direzione;
		this.grandezza = grandezza;
	}

	public String getDirezione() {
		return direzione;
	}

	public int getGrandezza() {
		return grandezza;
	}

}
