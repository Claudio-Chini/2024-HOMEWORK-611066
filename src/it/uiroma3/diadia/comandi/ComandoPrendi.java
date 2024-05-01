package it.uiroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


public class ComandoPrendi implements Comando {
	private Partita partita = new Partita();
	private String nomeAttrezzo;

	/**
	 * Comando che prende un attrezzo dalla stanza e lo ripone nella borsa del giocatore
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo));
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==false)System.out.println("Attrezzo non presente nella stanza");
		System.out.println(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		this.partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		System.out.println(this.partita.getGiocatore().getBorsa());
		System.out.println(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo));
		this.partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;


	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
