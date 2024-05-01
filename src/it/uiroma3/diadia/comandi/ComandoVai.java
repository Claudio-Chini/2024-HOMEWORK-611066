package it.uiroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
private String direzione;

	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione");
			return;		
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			System.out.println("DIrezione inesiustente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	}
	
	
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	public String getDirezione(){
		return this.direzione;
	}


	@Override
	public String getNome() {
		return "vai";
	}


	@Override
	public String getParametro() {
		return this.direzione;
	}
	
}