package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	private final static String NOME = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.getIo().mostraMessaggio(MESSAGGIO_FINE);

	}
	
	@Override
	public String getNome() {
		return NOME;
	}



}
