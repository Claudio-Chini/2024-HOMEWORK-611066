package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{
	private IO io;
	private Attrezzo attrezzo;
	
	/**
	 * Comando che prende un attrezzo dalla borsa del giocatore e lo posa nella stanza
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo_posato = partita.getGiocatore().getBorsa().getAttrezzo(attrezzo);
		partita.getStanzaCorrente().addAttrezzo(attrezzo_posato);
		partita.getGiocatore().getBorsa().removeAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(attrezzo));
		io.mostraMessaggio("Attrezzo " + attrezzo.getNome() + " posato");
		

	}

	@Override
	public void setParametro(String parametro) {
		Attrezzo a = new Attrezzo(parametro, 1);
		this.attrezzo= a;

	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.attrezzo.getNome();
	}
	@Override
	public void setIo(IO io){
		this.io = io;
	}

	public Object getIO() {
		return this.io;
	}


}
