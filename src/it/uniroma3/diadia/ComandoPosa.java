package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private Partita partita = new Partita();
	private String nomeAttrezzo;
	
	/**
	 * Comando che prende un attrezzo dalla borsa del giocatore e lo posa nella stanza
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo_posato = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo_posato);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

}
