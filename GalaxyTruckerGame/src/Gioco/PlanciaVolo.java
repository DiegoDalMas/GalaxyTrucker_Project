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
	
	// Muove un giocatore in avanti di n spazi
    public boolean muoviGiocatore(Colore colore, int spazi) {
        int posAttuale = trovaPosizione(colore);
        if (posAttuale == -1){
			return false;
		}

		int delta = Math.abs(spazi);
		int nuovaPosizione = posAttuale;

		if(spazi > 0){		//movimento in avanti
			while(delta > 0){
				nuovaPosizione++;
				if(nuovaPosizione >= posizioni.length) return false;		//fuori dai limiti
				if(posizioni[nuovaPosizione] == null){
					delta--;
				}
			}
		}else if (spazi < 0){		//movimento all'indietro
			while(delta > 0){
				nuovaPosizione--;
				if(nuovaPosizione < 0) return false;		//fuori dal limite
				if(posizioni[nuovaPosizione] == null){
					delta--;
				}
			}
		}else{
			// spazi = 0 nonci muoviamo
			return false;
		}

		// movimento
		posizioni[posAttuale] = null;
		posizioni[nuovaPosizione] = colore;
		return true;
    }


	// metodo per trovare la posizione attuale di un giocatore in base al colore
    public int trovaPosizione(Colore colore) {
        for (int i=0; i<posizioni.length; i++) {
            if (posizioni[i] == colore){
				return i;
			}
        }
        return -1;
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