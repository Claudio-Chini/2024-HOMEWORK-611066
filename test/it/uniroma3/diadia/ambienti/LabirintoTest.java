package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;


import org.junit.Test;



public class LabirintoTest {
    private Labirinto labirinto;
    Stanza entrata;
    Stanza uscita;

    public Stanza entrata(Stanza entrata){
        this.entrata = entrata;
        return this.entrata;
    }
    public Stanza uscita(Stanza uscita){
        this.uscita = uscita;
        return this.uscita;
    }
    public Labirinto labirinto(Stanza entrata, Stanza uscita){
        this.labirinto = new Labirinto();
        this.labirinto.setStanzaCorrente(entrata);
        this.labirinto.setStanzaVincente(uscita);
        return this.labirinto;
    }


// test getEntrata()
    
            /**
            ** Test getEntrata() 
            */
            @Test
            public void testGetEntrata() { 
                entrata(new Stanza("e"));
                labirinto(entrata,null); 
                assertEquals(entrata,labirinto.getStanzaIniziale());
            }
// test getUscita()
        
            /**
            ** Test getUscita() 
            */
            @Test
            public void testGetUscita() {  
                labirinto(new Stanza("entrata"),uscita(new Stanza("u")));
                assertEquals(uscita,labirinto.getStanzaVincente());
            }
// test setEntrata()
            
            /**
            ** Test setEntrata() 
            */
            @Test
            public void testSetEntrata() {  
                labirinto(null,uscita(new Stanza("uscita"))).setStanzaCorrente(entrata(new Stanza("entrata")));
                assertEquals(entrata,labirinto.getStanzaIniziale());
            }

// test setUscita()
                
                /**
                ** Test setUscita() 
                */
                @Test
                public void testSetUscita() {  
                    labirinto(new Stanza("entrata"),null).setStanzaVincente(uscita(new Stanza("uscita")));
                    assertEquals(uscita,labirinto.getStanzaVincente());
                }

            

}
