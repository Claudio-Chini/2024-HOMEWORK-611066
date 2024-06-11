package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;


public class ComandoPrendi extends AbstractComando{
	private IO io;
	private String nomeAttrezzo;

	/**
	 * Comando che prende un attrezzo dalla stanza e lo ripone nella borsa del giocatore
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==false)return;
		if(partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo))==false){io.mostraMessaggio("L'attrezzo "+nomeAttrezzo + " e' troppo pesante per essere preso in borsa");  return ;}
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
		io.mostraMessaggio("Attrezzo " + nomeAttrezzo + " preso");
		

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
	public void setIo(IO io){
		this.io = io;
	}

	
}
