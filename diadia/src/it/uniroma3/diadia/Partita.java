package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

    private Labirinto labirinto;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();

		this.finita = false;
		this.giocatore = new Giocatore();
	}
	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.finita = false;
		this.giocatore = new Giocatore();
	
	}

	public Partita(Labirinto labirinto,Giocatore giocatore){
		this.labirinto = labirinto;
		this.finita = false;
		this.giocatore = giocatore;
	}

 
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}    

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.giocatore.getCfu();
	}

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);		
	}	
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Labirinto getLabirinto(){
		return this.labirinto;
	}
}
