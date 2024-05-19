package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	@Test
	public void testEsegui() {
		LabirintoBuilder lb = new LabirintoBuilder();
		lb.addStanzaIniziale("Atrio")
		.addAttrezzo("Martello", 5);
		Labirinto l = lb.getLabirinto();
		Partita p = new Partita(l);
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("Martello");
		comando.esegui(p);
		
		assertEquals(true , p.getGiocatore().getBorsa().hasAttrezzo(new Attrezzo("Martello",5)));
	}

}
