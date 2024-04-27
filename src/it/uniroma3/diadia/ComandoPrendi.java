package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private Partita partita = new Partita();
	private String nomeAttrezzo;

	/**
	 * Comando che prende un attrezzo dalla stanza e lo ripone nella borsa del giocatore
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo_preso = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo_preso);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;


	}

}
