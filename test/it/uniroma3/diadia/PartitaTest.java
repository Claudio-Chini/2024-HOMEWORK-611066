package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;




public class PartitaTest {
	
	Partita partita;
	Labirinto labirinto;


	
	@Before
	public void setUp()  throws FileNotFoundException , FormatoFileNonValidoException{
		this.labirinto = Labirinto.newBuilder("labirinto_test.txt").getLabirinto();
		this.partita = new Partita(this.labirinto);
		
	}




	@Test
	public void testGetStanzaVincente() {
		assertEquals("B", this.partita.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals("A", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		Stanza stanza = new Stanza("C");
		this.partita.setStanzaCorrente(stanza);
		assertEquals("C", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testSetStanzaVincente() {
		Stanza stanza = new Stanza("D");
		this.partita.getLabirinto().setStanzaVincente(stanza);
		assertEquals("D", this.partita.getStanzaVincente().getNome());
	}


	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertEquals(true, this.partita.vinta());
	}

	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertEquals(true, this.partita.isFinita());
	}

	








}