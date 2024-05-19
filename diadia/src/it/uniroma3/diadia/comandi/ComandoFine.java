package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO io;
	
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return "fine";
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
