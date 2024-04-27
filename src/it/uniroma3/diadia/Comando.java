package it.uniroma3.diadia;

public interface Comando {

	/**
	 * esecuzione del comando
	 * @param partita
	 */
	
	public void esegui(Partita partita);


	/**
	 * set del parametro
	 * @param String
	 */
	public void setParametro(String parametro);


}