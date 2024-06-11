package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {


	private Comando vai;

	Labirinto labirinto;
	List<String> comandi ;
	Fixture fixture;

	@Before
	public void setUp() throws Exception {
	fixture = new Fixture();
	comandi = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testVaiDirezioneEsistente() throws Exception {
		comandi.add("vai sud");
		IOSimulator io = Fixture.simulazionePartitaTest(comandi);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("B", io.nextMessaggio());

	}

	@Test 
	public void testVaiDirezioneInesistente() throws Exception{
		comandi.clear();
		comandi.add("vai nord");
		IOSimulator io = Fixture.simulazionePartitaTest(comandi);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("A", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Direzioneinesistente", io.nextMessaggio());

	
	}

	
	
	@Test 
	public void testVaiSenzaDirezione() throws Exception {
		comandi.clear();
		comandi.add("vai");
		IOSimulator io = Fixture.simulazionePartitaTest(comandi);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("", io.nextMessaggio());
	}
	
}


