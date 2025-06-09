package Gioco.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Gioco.Astronave;
import Gioco.Direzione;
import Gioco.Giocatore;
import Gioco.PlanciaVolo;
import Gioco.Tessera;

public class PioggiaDiMeteoriti extends Carta {
	
	private List<Meteorite> meteoriti;
	private Random rand = new Random();

	public PioggiaDiMeteoriti(){
		this.meteoriti = new ArrayList<>();

		//GENERA 1-2 METEORITI GRANDI
		int meteoriti_grandi = rand.nextInt(2) + 1;
		for(int i=0; i<meteoriti_grandi; i++){
			Direzione dir = Direzione.random();
			meteoriti.add(new Meteorite(TipoMeteorite.GRANDE, dir));
		}

		//GENERA 2-3 METEORITI PICCOLI
		int meteoriti_piccoli = rand.nextInt(2) + 2;
		for(int i=0; i<meteoriti_piccoli; i++){
			Direzione dir = Direzione.random();
			meteoriti.add(new Meteorite(TipoMeteorite.PICCOLO, dir));
		}

		//LI MISCHIA
		Collections.shuffle(meteoriti);
	}
	
	@Override
	public void applicaEffetto(List<Giocatore> giocatori, Giocatore leader, PlanciaVolo plancia){
		System.out.println("CARTA: PIOGGIA DI METEORITI");
        System.out.println("Totale meteoriti: " + meteoriti.size());

		for(Meteorite m: meteoriti){
			Direzione dir = m.getDirezione();
			int dado1 = rand.nextInt(6) + 1;
			int dado2 = rand.nextInt(6) + 1;
			int risultato = dado1 + dado2;

			System.out.println("Meteorite " + m.getTipo() + " da " + dir + " colpirà in " + risultato);

			for(Giocatore g: giocatori){
				Astronave nave = g.getAstronave();
				Tessera colpita = trovaTesseraColpita(nave, dir, risultato);

				if(colpita == null){
                    System.out.println("Giocatore " + g.getColore() + " NON sei stato colpito");
					continue;
				}

				if(m.getTipo() == TipoMeteorite.PICCOLO){
					gestisciPiccoloMeteorite(nave, g, colpita, dir);		//non serve il risultato dei dadi qua??
				}else{
					gestisciGrandeMeteorite(nave, g, colpita, dir, risultato);
				}
			}
		}
	}

	private Tessera trovaTesseraColpita(Astronave nave, Direzione dir, int risultato){
		switch(dir){
			case NORD:
				for(int i=0; i<nave.getNumeroRighe(); i++){
					Tessera t = nave.getTesseraDaRigaColonna(i, risultato);
					if(t != null){
						return t;
					}
				}
				break;
			
			case SUD:
				for(int i=nave.getNumeroRighe()-1; i>=0; i--){
					Tessera t = nave.getTesseraDaRigaColonna(i, risultato);
					if(t != null){
						return t;
					}
				}
				break;
			
			case EST:
				for(int j=nave.getNumeroColonne()-1; j>=0; j--){
					Tessera t = nave.getTesseraDaRigaColonna(risultato, j);
					if(t != null){
						return t;
					}
				}
				break;
			
			case OVEST:
				for(int j=0; j<nave.getNumeroColonne(); j++){
					Tessera t = nave.getTesseraDaRigaColonna(risultato, j);
					if(t != null){
						return t;
					}
				}
				break;
		}
		return null;
	}

	private void gestisciPiccoloMeteorite(Astronave nave, Giocatore g, Tessera t, Direzione dir){
		if(!nave.connettoreEsposto(t, dir)){
			System.out.println("Giocatore " + g.getColore() + " meteorite rimbalza. NESUN DANNO");
			return;
		}

		if(nave.puoUsareScudo(dir)){
			nave.usaBatteria();
			System.out.println("Giocatore " + g.getColore() + " ha attivato lo SCUDO. NESSUN DANNO");
		}else{
			nave.subisciDanno(t);
            System.out.println("Giocatore " + g.getColore() + "e' stato colpito. La tessera viene distrutta");
		}
	}

	private void gestisciGrandeMeteorite(Astronave nave, Giocatore g, Tessera t, Direzione dir, int indice){
		if(nave.puoSparareMeteorite(dir, indice)){
			nave.usaBatteria();
            System.out.println("Giocatore " + g.getColore() + " il cannone ha distrutto il meteorite");
		}else{
            nave.subisciDanno(t);
            System.out.println("Giocatore " + g.getColore() + " e' stato colpito da grosso meteorite. La tessera viene distrutta");
		}
	}
	
}
