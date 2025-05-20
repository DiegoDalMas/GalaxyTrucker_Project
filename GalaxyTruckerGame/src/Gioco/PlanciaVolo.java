package Gioco;


public class PlanciaVolo {		
	private Colore[] posizioni;
	private final int DIMENSIONE = 100;
	private final int POSIZIONE_CENTRALE = 50;
	
	public PlanciaVolo(){
		posizioni = new Colore[DIMENSIONE];
		for(int i=0; i<DIMENSIONE; i++){
			posizioni[i] = null;		// null = casella vuota
		}
	}
	
	// Posiziona un giocatore in una posizione iniziale
		public boolean posizionaGiocatore(Colore colore, int posizionePartenza) {
			int pos = POSIZIONE_CENTRALE + posizionePartenza;
			if(pos < 0 || pos >= DIMENSIONE) return false;
	        if (posizioni[pos] != null) return false; 		// già occupato
	        posizioni[pos] = colore;
	        return true;
	    }
	
	
	
	
	
	
	/*
	private PosizioneGiocatore posizionamento;		//indica la classifica prima di iniziare i turni di volo, con dei set/get assegniamo in base alla classifica la posizione sui blocchi 1,2,3,4
	private Dado dado;
	 * IL LANCIO DADI VA FATTO NELLE CARTE CHE LO PREVEDONO NON QUI
	 * public int lancioDadi(int numeroDadiLanciati) {
		int sommaDadi = 0;
		for(int i=0; i<numeroDadiLanciati; i++) {
			sommaDadi += dado.tira();
		}
		return sommaDadi;
	}*/
	
}