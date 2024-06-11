package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

public class ComandoVai extends AbstractComando{
private Direzione direzione;

	private IO io ;
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.getParametro()==null){
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;		
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(stanzaCorrente.getStanzaAdiacente(this.direzione)==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = Direzione.buildDirezione(parametro);
	}

	public Direzione getDirezione(){
		return this.direzione;
	}


	@Override
	public String getNome() {
		return "vai";
	}


	@Override
	public String getParametro() {
		if(direzione == null){
			return null;
		}
		return this.direzione.toString();
	}
			@Override
	public void setIo(IO io){
		this.io = io;
	}
	
}