package Gioco;

public class Merci {
	private Colore[] cubettiMerce;
	private final int NUMERO_MERCE;
	private Colore colore;
	
	public Merci(Colore colore, int NUMERO_MERCE) {
		this.colore = colore;
		this.NUMERO_MERCE = NUMERO_MERCE;
		cubettiMerce = new Colore[NUMERO_MERCE];
		for (int i = 0; i < NUMERO_MERCE; i++) {
            cubettiMerce[i] = colore;
        }
	}
	
	/*private Colore[] cubettiMerceRossi;
    private Colore[] cubettiMerceVerdi;
    private Colore[] cubettiMerceGialli;
    private Colore[] cubettiMerceBlu;
	private static final int MERCE_ROSSA = 8; //non sono sicuro delle quantita;
	private static final int MERCE_VERDE = 8; 
	private static final int MERCE_GIALLA = 8; 
	private static final int MERCE_BLU = 8; 
	
	public Merci() {
		cubettiMerceRossi = new Colore[MERCE_ROSSA];
        cubettiMerceVerdi = new Colore[MERCE_VERDE];
        cubettiMerceGialli = new Colore[MERCE_GIALLA];
        cubettiMerceBlu = new Colore[MERCE_BLU];
        for (int i = 0; i < MERCE_ROSSA; i++) {
            cubettiMerceRossi[i] = Colore.ROSSO;
        }
        for (int i = 0; i < MERCE_VERDE; i++) {
            cubettiMerceVerdi[i] = Colore.VERDE;
        }
        for (int i = 0; i < MERCE_GIALLA; i++) {
            cubettiMerceGialli[i] = Colore.GIALLO;
        }
        for (int i = 0; i < MERCE_BLU; i++) {
            cubettiMerceBlu[i] = Colore.BLU;
        }
	}*/
	
}
