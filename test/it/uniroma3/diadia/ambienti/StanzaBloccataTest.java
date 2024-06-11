package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest extends StanzaTest{
	
	private Direzione direzioneBloccata = Direzione.EST;
	private Attrezzo attrezzoSpeciale = new Attrezzo("Passepartout");
	
	public StanzaBloccata stanzaBloccata(String nome){
		return new StanzaBloccata(nome,this.direzioneBloccata,this.attrezzoSpeciale.getNome());
	}
	public StanzaBloccata stanzaBloccata(String nome,Direzione direzioneBloccata_,Attrezzo attrezzoSpeciale_){
		return new StanzaBloccata(nome,direzioneBloccata_,attrezzoSpeciale_.getNome());
	}

// test getDescrizione()
	@Test
	public void testGetDescrizioneSenzaAttrezzoSpeciale() {
		assertEquals(("Stanza bloccata nella direzione: "+direzioneBloccata+"\nPrendi il "+attrezzoSpeciale+" e posalo nella stanza"),stanzaBloccata("s").getDescrizione());
	}
	@Test
	public void testGetDescrizioneConAttrezzoSpeciale() {
		Stanza s = stanzaBloccata("stanzaBloccata",direzioneBloccata,attrezzoSpeciale);
		String descrizione = s.getDescrizione();
		
		s.addAttrezzo(attrezzoSpeciale);
		
		assertEquals(false,descrizione==s.getDescrizione());
	}

// test getStanzaAdiacente()
	@Test
	public void testGetStanzaAdiacenteConAttrezzoSpeciale(){
		Stanza s = stanzaBloccata("s");
		Stanza s2 = new Stanza("s2");
		s.impostaStanzaAdiacente(direzioneBloccata,s2);
		s.addAttrezzo(attrezzoSpeciale);
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
