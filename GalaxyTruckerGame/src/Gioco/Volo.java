package Gioco;

//usiamo classe volo come main??
public class Volo {		//possiamo gestire la banca qua dentro?? mettendo a disposizione qua tutti i componenti del volo tipo alieni, umani, batterie ecc... in un oggetto magazzino
	private Livello livelloVolo;
	private int[] caselle;		//essendo circolare usiamo un'array di interi che scorre da 1 a 20 esempio
	
	
	//private Colore[] giocatore; gestire un array di 4 colori, uno per ogni giocatore? oppure creare 4 oggetti di tipo Giocatore a cui poi assegniamo un colore??
	private ClassificaAssemblaggioNave posizionamento;		//indica la classifica prima di iniziare i turni di volo, con dei set/get assegniamo in base alla classifica la posizione sui blocchi 1,2,3,4

	private Dado dado;
	
	
	/*
	 * public int lancioDadi(int numeroDadiLanciati) {
		int sommaDadi = 0;
		for(int i=0; i<numeroDadiLanciati; i++) {
			sommaDadi += dado.tira();
		}
		return sommaDadi;
	}*/
	
}