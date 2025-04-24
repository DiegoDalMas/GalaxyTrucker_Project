package Gioco;

/*
INFORMAZIONI UTILI:
60 carte avventura
156 componenti di astronave --> connettori lati


68 tessere credito cosmico	--> crediti colore
6 tessere titolo camionista
4 alieni marroni, 4 viola

2 dadi


CREATE
55 blocchi merce
40 batterie
42 astronauti bianchi
 */


public class Magazzino {
	private Merci merceRossa;
    private Merci merceVerde;
    private Merci merceGialla;
    private Merci merceBlu;
    private Batteria[] batterie;
    private Astronauta[] astronauti;
    private Crediti [] uno;
   
    // crediti e alieni
    
    
    public Magazzino() {
    	merceRossa = new Merci(Colore.ROSSO, 8);
        merceVerde = new Merci(Colore.VERDE, 8);
        merceGialla = new Merci(Colore.GIALLO, 8);
        merceBlu = new Merci(Colore.BLU, 8);
        batterie = new Batteria[40];
        for (int i = 0; i < batterie.length; i++) {
            batterie[i] = new Batteria();
        }
        astronauti = new Astronauta[42];
        for (int i = 0; i < astronauti.length; i++) {
            astronauti[i] = new Astronauta();
        }
    }
	
}
