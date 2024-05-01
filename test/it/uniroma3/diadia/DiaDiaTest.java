package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
public class DiaDiaTest {

    private DiaDia diaDia;

 
    // test prendi()
        /**
         ** Test prendi() 
        */
        /* 
        @Test
        public void testPrendi() {
            Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
            diaDia().getPartita().getStanzaCorrente().addAttrezzo(attrezzo);
            assertEquals(false, diaDia.getPartita().getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
            diaDia.prendi(attrezzo.getNome());
            assertEquals(true, diaDia.getPartita().getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
        }
        */
    // test posa()
        /**
         ** Test posa() 
        */
        /* 
        @Test
        public void testPosa() {
            Attrezzo attrezzo = new Attrezzo("attrezzo", 2);
            diaDia().getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
            assertEquals(false, diaDia.getPartita().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
            diaDia.posa(attrezzo.getNome());
            assertEquals(true, diaDia.getPartita().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
        }
        */




}
