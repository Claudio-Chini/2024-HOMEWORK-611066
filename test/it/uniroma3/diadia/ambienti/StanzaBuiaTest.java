package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest extends StanzaTest{
	private Attrezzo attrezzoSpeciale = new Attrezzo("Lanterna");

	public Stanza stanzaBuia(String nome,Attrezzo attrezzo_speciale){
		return new StanzaBuia(nome, attrezzo_speciale);
	}

	@Test
	public void testGetDescrizioneConAttrezzoSpeciale() {
		Stanza s = stanzaBuia("s",attrezzoSpeciale);
		String descrizione = s.getDescrizione();
		s.addAttrezzo(attrezzoSpeciale);
		assertEquals(false,descrizione==s.getDescrizione());
	}

	@Test
	public void testGetDescrizioneSenzaAttrezzoSpeciale() {
		Stanza s = stanzaBuia("s",attrezzoSpeciale);
		assertEquals("qui c'e' un buio pesto ",s.getDescrizione());
	}


}
