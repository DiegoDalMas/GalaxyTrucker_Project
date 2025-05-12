package gioco;

import java.util.Random;

//Classe astratta base per tutte le carte
public abstract class Carta {
private String nome;


public Carta(String nome) {
 this.nome = nome;
}

public String getNome() {
 return nome;
}

//Metodo astratto che definisce l'azione che la carta compie quando viene pescata
public abstract void azione();

@Override
public String toString() {
 return "Carta: " + nome;
}


}

//Classe astratta base per le carte avventura
abstract class CartaAvventura extends Carta {
public CartaAvventura(String nome) {
super(nome);
}
}

//Carta Avventura: Pianeta (Galaxy Trucker)
class CartaPianeta extends CartaAvventura {
private int numeroPianeti;
private int giorniVolo;

```
public CartaPianeta(String nome) {
 super(nome);
 Random random = new Random();
 this.numeroPianeti = random.nextInt(3) + 2; // 2-4 pianeti
 this.giorniVolo = random.nextInt(5) + 1;     // 1-5 giorni di volo
}

public int getNumeroPianeti() {
 return numeroPianeti;
}

public int getGiorniVolo() {
 return giorniVolo;
}

@Override
public void azione() {
 System.out.println(getNome() + " pescata! Ci sono " + numeroPianeti + " pianeti su cui atterrare.");
 System.out.println("Ogni atterraggio costerà " + giorniVolo + " giorni di volo (in ordine inverso di rotta).");
 System.out.println("I giocatori in ordine di rotta possono scegliere di atterrare su un pianeta.");
}


}

//Carta Avventura: Nave Abbandonata (Galaxy Trucker)
class CartaNaveAbbandonata extends CartaAvventura {
private int creditiOfferti;


public CartaNaveAbbandonata(String nome, int creditiOfferti) {
 super(nome);
 this.creditiOfferti = creditiOfferti;
}

public int getCreditiOfferti() {
 return creditiOfferti;
}

@Override
public void azione() {
 System.out.println(getNome() + " pescata! Trovata una Nave Abbandonata!");
 System.out.println("Il leader può decidere di rottamarla e guadagnare " + creditiOfferti + " crediti cosmici.");
 System.out.println("Se il leader rifiuta, l'opportunità passa agli altri giocatori in ordine di rotta.");
 System.out.println("Solo un giocatore può approfittare di questa opportunità.");
}


}

//Carta Avventura: Stazione Abbandonata (Galaxy Trucker)
class CartaStazioneAbbandonata extends CartaAvventura {
private int equipaggioNecessario;
private String[] merciDisponibili;
private int giorniVoloPersi;


public CartaStazioneAbbandonata(String nome, int equipaggioNecessario, String[] merciDisponibili, int giorniVoloPersi) {
 super(nome);
 this.equipaggioNecessario = equipaggioNecessario;
 this.merciDisponibili = merciDisponibili;
 this.giorniVoloPersi = giorniVoloPersi;
}

public int getEquipaggioNecessario() {
 return equipaggioNecessario;
}

public String[] getMerciDisponibili() {
 return merciDisponibili;
}

public int getGiorniVoloPersi() {
 return giorniVoloPersi;
}

@Override
public void azione() {
 System.out.println(getNome() + " pescata! Avvicinamento a una Stazione Abbandonata!");
 System.out.println("È necessario un equipaggio di almeno " + equipaggioNecessario + " membri per esplorarla.");
 System.out.println("Merci depredabili: " + String.join(", ", merciDisponibili));
 System.out.println("Attraccare e saccheggiare costerà " + giorniVoloPersi + " giorni di volo (in ordine inverso di rotta).");
 System.out.println("Solo un giocatore può approfittare di questa opportunità.");
}


}
