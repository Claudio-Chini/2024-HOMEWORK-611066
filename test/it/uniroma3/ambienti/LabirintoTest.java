package it.uniroma3.ambienti;

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
        this.labirinto.setEntrata(entrata);
        this.labirinto.setUscita(uscita);
        return this.labirinto;
    }


// test getEntrata()
    
            /**
            ** Test getEntrata() 
            */
            @Test
            public void testGetEntrata() {  
                labirinto(entrata(new Stanza("e")),new Stanza("uscita"));
                assertEquals(entrata,labirinto.getEntrata());
            }
// test getUscita()
        
            /**
            ** Test getUscita() 
            */
            @Test
            public void testGetUscita() {  
                labirinto(new Stanza("entrata"),uscita(new Stanza("u")));
                assertEquals(uscita,labirinto.getUscita());
            }
// test setEntrata()
            
            /**
            ** Test setEntrata() 
            */
            @Test
            public void testSetEntrata() {  
                labirinto(null,uscita(new Stanza("uscita"))).setEntrata(entrata(new Stanza("entrata")));
                assertEquals(entrata,labirinto.getEntrata());
            }

// test setUscita()
                
                /**
                ** Test setUscita() 
                */
                @Test
                public void testSetUscita() {  
                    labirinto(new Stanza("entrata"),null).setUscita(uscita(new Stanza("uscita")));
                    assertEquals(uscita,labirinto.getUscita());
                }

            

}
