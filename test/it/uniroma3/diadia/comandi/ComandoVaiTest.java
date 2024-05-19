package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.fixture.Fixture;
import it.uniroma3.diadia.IO;

public class ComandoVaiTest {
	IO io = new IOConsole();
	@Test
	public void  testEsegui(){
	LabirintoBuilder lb = new LabirintoBuilder();
	lb.addStanzaIniziale("Atrio")
	.addStanza("AulaN11")
	.addStanza("AulaN10")
	.addStanza("AulaN09")
	.addStanza("AulaN08")
	.addAdiacenza("Atrio", "AulaN11", "sud")
	.addAdiacenza("AulaN11", "Atrio", "nord");
	Partita p = new Partita(lb.getLabirinto());
	ComandoVai comando = new ComandoVai();
	comando.setIO(io);
	comando.setParametro("sud");
	comando.esegui(p);
	assertEquals("AulaN11", p.getStanzaCorrente().getNome());
	comando.setParametro("nord");
	comando.esegui(p);
	assertEquals("Atrio", p.getStanzaCorrente().getNome());
	
	}


	@Test
	public void testEsegui2(){
		Fixture fixture = new Fixture();
		List<String> comandiDaLeggere = new ArrayList<String>(List.of("vai nord","vai sud"));
		IOSimulator io = fixture.simulazionePartitaBilocale(comandiDaLeggere);
		List<String> l = io.getOutputList();
		assertEquals("Stanza Iniziale", l.get(0));
		assertEquals("Stanza Vincente", l.get(1));


	}


	@Test 
	public void testSetParametro(){
		ComandoVai comando = new ComandoVai();
		comando.setParametro("est");
		assertEquals("est", comando.getDirezione());
	}
}
