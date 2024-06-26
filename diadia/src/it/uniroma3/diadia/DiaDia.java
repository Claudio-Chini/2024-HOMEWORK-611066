package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;

import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import java.util.Scanner;


import it.uniroma3.diadia.ambienti.Labirinto;





/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	

	private Partita partita;
	private IO io;

	public DiaDia(IO io){
		this.io = io;
	}
	public DiaDia(IO io,Labirinto labirinto) {
		this.io =  io;
		this.partita = new Partita(labirinto);
	}

	public void gioca() throws Exception {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do{
			istruzione = io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
		 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) throws Exception{
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);
	
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		}catch (ClassNotFoundException cne) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		try{
			comandoDaEseguire.esegui(this.partita);
		}catch (Exception e) {
			io.mostraMessaggio("Comando non eseguito");
		}
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (this.partita.getCfu() <= 0)
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}
	
	// implementazioni dei comandi dell'utente spostate nelle rispettive classi

	public Partita getPartita(){
		return this.partita;
	}

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);
		Labirinto labirinto = 	 Labirinto.newBuilder("labirinto.txt").getLabirinto();
		DiaDia gioco = new DiaDia( io,labirinto);
		gioco.gioca();
		scanner.close();
	}
}