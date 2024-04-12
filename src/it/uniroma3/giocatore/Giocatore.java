package it.uniroma3.giocatore;
/**
 * Questa classe modella un giocatore gestendone i cfu e la borsa
 * 
 * @author caludio chini
 * 
 * @version base
 */
public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
/**
 * crea un nuovo Giocatore con un numero di default
 *  di cfu ed una borsa vuota
 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	
}
