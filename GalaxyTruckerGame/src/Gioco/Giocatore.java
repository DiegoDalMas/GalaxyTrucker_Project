package Gioco;

public class Giocatore extends Astronave{
 private Colore colore;
 private PosizioneGiocatore pos;
 
public Giocatore(Colore c) {
	this.colore=c;
	Astronave a = new Astronave();
	
}
  public Colore getColore() {
	  return colore;
  }
}
