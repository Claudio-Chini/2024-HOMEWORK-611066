package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {
	private IO io;
	private final static String NOME = "guarda";
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		io.mostraMessaggio(stanzaCorrente.getDescrizione());
		//io.mostraMessaggio(stanzaCorrente.getNome());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return "";
	}
		@Override
	public void setIO(IO io){
		this.io = io;
	}

}
