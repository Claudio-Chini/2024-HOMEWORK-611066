package it.uniroma3.diadia.ambienti;
import java.util.HashSet;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	
	Set<Stanza> stanze ;	
	Set<Attrezzo> attrezzi ;

	
	
	
	
	public Labirinto() {
		this.stanze = new HashSet<Stanza>();
		this.attrezzi = new HashSet<Attrezzo>();
	}
	


	
	   /**
     * Crea tutte le stanze e le porte di collegamento
     */

	/* 
    private void creaStanze() {

		Set<Stanza> stanze = new HashSet<Stanza>();
		Set<Attrezzo> attrezzi = new HashSet<Attrezzo>();

		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		
		// crea gli attrezzi
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		stanze.add(atrio);
		stanze.add(aulaN11);
		stanze.add(aulaN10);
		stanze.add(laboratorio);
		stanze.add(biblioteca);

		attrezzi.add(lanterna);
		attrezzi.add(osso);

		
		
		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        // pone gli attrezzi nelle stanze prendendoli dal set attrezzi 
		 
		atrio.addAttrezzo(lanterna);
		aulaN11.addAttrezzo(osso);
		


		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaCorrente = atrio;
		this.stanzaVincente = biblioteca;
    }
	*/
    
    
    public Stanza getStanzaCorrente() {
    	return this.stanzaCorrente;
    }
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
    public Stanza getStanzaVincente() {
    	return this.stanzaVincente;
    }
    public void setStanzaIniziale(Stanza entrata) {
    	this.stanzaIniziale = entrata;
    }
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	public void setStanzaVincente(Stanza uscita) {
		this.stanzaVincente = uscita;
	}
}
