package Gioco;

import java.util.ArrayList;
import java.util.List;


public class Astronave { 
	private List<Alieno> alieni;
	private List<Batteria> batterie;
	private List<Umano> umani;
	private Casella [][] griglia;
	private int size1 =8;
	private int size2 =8;
	
	public Astronave() {
		this.alieni = new ArrayList<>();
        this.batterie = new ArrayList<>();
        this.umani = new ArrayList<>();
        this.griglia= new Casella[size1][size2];
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				griglia[i][j] = new Casella(i, j);
			}
		}
	}
	
	public void crea(Tessera t) {
		//metodo che cheide la posizone e mette la tessere in griglia
		// una volta posizionata in griglia metodo che verifica se i connettori sono giusti 
		
	}
	
	
	
	public boolean assegnaAlieno(Magazzino magazzino, ColoreAlieno colore) {
		for (Alieno a : alieni) {
		    if (a.getColore() == colore) {
		    	System.out.println("hai già un alieno " + colore);
		        return false;
		    }
		}
		Alieno a = magazzino.prendiAlieno(colore);
		alieni.add(a);
		System.out.println("hai ricevuto un alieno: " + colore);
		return true;
	}
	
	public boolean assegnaBatteria(Magazzino magazzino) {
        Batteria b = magazzino.prendiBatteria();
        if (b != null) {
            batterie.add(b);
            System.out.println("hai preso una batteria");
            return true;
        }
        System.out.println("Nessuna batteria disponibile.");
        return false;
    }
	
	public boolean assegnaUmano(Magazzino magazzino) {
        Umano u = magazzino.prendiUmano();
        if (u != null) {
            umani.add(u);
            System.out.println("hai preso un umano");
            return true;
        }
        System.out.println("Nessun umano disponibile.");
        return false;
    }


}
