package it.uiroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido!");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		return "comando non valido";
	}

	@Override
	public String getParametro() {
		return "";
	}

}