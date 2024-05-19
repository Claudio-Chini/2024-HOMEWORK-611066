package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;

	/**
	 * Comando che prende un attrezzo dalla stanza e lo ripone nella borsa del giocatore
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==false)return;
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		

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
			@Override
	public void setIO(IO io){
		this.io = io;
	}

	
}
