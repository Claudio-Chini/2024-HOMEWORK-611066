package it.uiroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

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


	public String getNome();

	public String getParametro();

	

		
	


}