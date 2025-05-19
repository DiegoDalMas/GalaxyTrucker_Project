package Gioco;
import java.io.*;
import java.nio.file.*;
import java.util.*;


public class GestioneTessere {
	private List<Tessera> mazzoTessere;
	
	// crea mazzo delle tessere gia mischiato
    public GestioneTessere(String path){
        this.mazzoTessere = new ArrayList<>();
        try {
        	this.mazzoTessere = caricaTessereDaFile(path);
        	Collections.shuffle(mazzoTessere);
        }catch(IOException e) {
        	System.out.println("Errore durante il caricamento del file: " + e.getMessage());
        }
    }
    
    public static List<Tessera> caricaTessereDaFile(String path) throws IOException{
        List<Tessera> tessere = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linea;
        br.readLine();      //legge la prima saltando l'indice
        while(  (linea = br.readLine()) != null){
            String[] campi = linea.split(",");
            TipoTessera tipo = TipoTessera.valueOf(campi[0]);
            TipoConnettore alto = TipoConnettore.valueOf(campi[1]);
            TipoConnettore destra = TipoConnettore.valueOf(campi[2]);
            TipoConnettore basso = TipoConnettore.valueOf(campi[3]);
            TipoConnettore sinistra = TipoConnettore.valueOf(campi[4]);
            int capacita_batterie = Integer.parseInt(campi[5]);
            int capacita_stiva = Integer.parseInt(campi[6]);
            Tessera t = new Tessera(alto, destra, basso, sinistra, tipo, capacita_batterie, capacita_stiva);
            tessere.add(t);
        }

        br.close();
        return tessere;
    }
    
    public Tessera pescaTessera() {
        if (mazzoTessere.isEmpty()) {
        	return null;
        }
        return mazzoTessere.remove(0);
    }

    public int tessereRimaste() {
        return mazzoTessere.size();
    }
    
}
