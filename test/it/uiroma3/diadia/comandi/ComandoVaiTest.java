package it.uiroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uiroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
	
	@Test
	public void  testEsegui(){
		Partita p = new Partita();
		ComandoVai comando = new ComandoVai();
		Stanza start = p.getStanzaCorrente();
		comando.setIO(new IOConsole());
		comando.setParametro("est");
		comando.esegui(p);
		
		assertFalse(start.equals( p.getStanzaCorrente()));
		
		comando.setParametro("ovest");
		comando.esegui(p);
		
		assertEquals(start, p.getStanzaCorrente() );


	}


	@Test 
	public void testSetParametro(){
		ComandoVai comando = new ComandoVai();
		comando.setParametro("est");
		assertEquals("est", comando.getDirezione());
	}
}
