package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {

	@Test
	public void testEsegui() {
		Attrezzo a = new Attrezzo("a",1);
		Stanza s = new Stanza("s","s");
		Partita p = new Partita();
		p.setStanzaCorrente(s);
		Giocatore g = p.getGiocatore();
		
		g.getBorsa().addAttrezzo(a);

		Comando posa = new ComandoPosa();
		posa.setParametro("a");
		posa.esegui(p);

		assertEquals(true,s.hasAttrezzo("a"));
	}

}
