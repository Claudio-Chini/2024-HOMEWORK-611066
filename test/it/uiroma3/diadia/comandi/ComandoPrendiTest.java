package it.uiroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uiroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	@Test
	public void testEsegui() {
		Partita p = new Partita();
		p.getStanzaCorrente().addAttrezzo(new Attrezzo("Martello",5));
		
		
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("Martello");
		comando.esegui(p);
		
		assertEquals(true , p.getGiocatore().getBorsa().hasAttrezzo("Martello"));
	}

}
