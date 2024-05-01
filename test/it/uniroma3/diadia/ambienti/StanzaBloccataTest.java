package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest extends StanzaTest{
	
	private String direzioneBloccata = "est";
	private String attrezzoSpeciale = "Passepartout";
	
	public StanzaBloccata stanzaBloccata(String nome){
		return new StanzaBloccata(nome,direzioneBloccata,attrezzoSpeciale);
	}

// test getDescrizione()
	@Test
	public void testGetDescrizioneSenzaAttrezzoSpeciale() {
		assertEquals(("Stanza bloccata nella direzione: "+direzioneBloccata+"\nPrendi il "+attrezzoSpeciale+" e posalo nella stanza"),stanzaBloccata("s").getDescrizione());
	}
	@Test
	public void testGetDescrizioneConAttrezzoSpeciale() {
		Stanza s = stanzaBloccata(attrezzoSpeciale);
		s.addAttrezzo(new Attrezzo("Passepartout",1));
		assertEquals(s.toString(),s.getDescrizione());
	}

// test getStanzaAdiacente()
	@Test
	public void testGetStanzaAdiacenteConAttrezzoSpeciale(){
		Stanza s = stanzaBloccata("s");
		Stanza s2 = new Stanza("s2");
		s.impostaStanzaAdiacente(direzioneBloccata,s2);
		s.addAttrezzo(new Attrezzo("Passepartout",1));
		assertEquals(s2, s.getStanzaAdiacente(direzioneBloccata));
	}
	@Test
	public void testGetStanzaAdiacenteSenzaAttrezzoSpeciale(){
		Stanza s = stanzaBloccata("s");
		Stanza s2 = new Stanza("s2");
		s.impostaStanzaAdiacente(direzioneBloccata,s2);
		
		assertEquals(s, s.getStanzaAdiacente(direzioneBloccata));
	}



}
