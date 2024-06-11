package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;



public class LabirintoTest {

    private Partita partita;
    private Labirinto labirinto;

	@Before
	public void setUp()  throws FileNotFoundException , FormatoFileNonValidoException{
		this.labirinto = Labirinto.newBuilder("labirinto_test.txt").getLabirinto();
		this.partita = new Partita(this.labirinto);
	
	}

    @Test
    public void testGetStanzaVincente() {
        assertEquals("B", this.partita.getLabirinto().getStanzaVincente().getNome());
    }

    @Test
    public void testGetStanzaCorrente() {
        assertEquals("A", this.partita.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testSetStanzaCorrente() {
        Stanza stanza = new Stanza("C");
        this.partita.getLabirinto().setStanzaCorrente(stanza);
        assertEquals("C", this.partita.getLabirinto().getStanzaCorrente().getNome());
    }

    @Test
    public void testSetStanzaVincente() {
        Stanza stanza = new Stanza("D");
        this.partita.getLabirinto().setStanzaVincente(stanza);
        assertEquals("D", this.partita.getLabirinto().getStanzaVincente().getNome());
    }




}
