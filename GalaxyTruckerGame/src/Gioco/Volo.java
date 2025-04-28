package Gioco;


public class Volo {		
	private int[] caselle;		//essendo circolare usiamo un'array di interi che scorre da 1 a 20 esempio
	
	
	
	private PosizioneGiocatore posizionamento;		//indica la classifica prima di iniziare i turni di volo, con dei set/get assegniamo in base alla classifica la posizione sui blocchi 1,2,3,4

	private Dado dado;
	
	public Volo() {
		
	}
	
	
	/*
	 * IL LANCIO DADI VA FATTO NELLE CARTE CHE LO PREVEDONO NON QUI
	 * public int lancioDadi(int numeroDadiLanciati) {
		int sommaDadi = 0;
		for(int i=0; i<numeroDadiLanciati; i++) {
			sommaDadi += dado.tira();
		}
		return sommaDadi;
	}*/
	
}