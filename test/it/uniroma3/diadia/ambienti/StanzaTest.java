package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;


import org.junit.Test;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

    Stanza stanza;
    
    public Stanza stanza(String nome, Stanza[] stanzeAdiacenti, Attrezzo[] attrezzi) {
        this.stanza = new Stanza(nome);
        if(stanzeAdiacenti!=null) {
            for (int i=0; i<stanzeAdiacenti.length; i++) {
                this.stanza.impostaStanzaAdiacente("direzione", stanzeAdiacenti[i]);
            }
        }
        if(attrezzi!=null) {
            for (Attrezzo attrezzo :attrezzi) {
                this.stanza.addAttrezzo(attrezzo);
            }
        }
        return this.stanza;
    }
    
// test impostaStanzaAdiacente(String direzione, Stanza stanza)
    
        /**
         * Test impostaStanzaAdiacente(String direzione, Stanza stanza) nel caso di direzione nulla
         */
        @Test (expected = NullPointerException.class) // JUnit4
        public void testImpostaStanzaAdiacenteDirezioneNullaJU4() {
            stanza("A",null,null).impostaStanzaAdiacente(null, stanza("B",null,null));	
        }
        
        /* JUnit5
        @Test 
        public void testImpostaStanzaAdiacenteDirezioneNulla() {
        
            assertThrows(NullPointerException.class,() -> stanza("A",null,null).impostaStanzaAdiacente(null, null) );
        }
          */

        /**
         *  Test impostaStanzaAdiacente(String direzione, Stanza stanza) 
         */ 
        @Test
        public void testImpostaStanzaAdiacente(){
            
            Stanza stanza_adiacente = new Stanza("B");
            stanza("A",null,null).impostaStanzaAdiacente("direzione",stanza_adiacente);
            assertEquals(stanza_adiacente, stanza.getStanzaAdiacente("direzione"));
        }
        /**
         *  Test impostaStanzaAdiacente(String direzione, Stanza stanza) con parametro stanza nullo
         */ 
        @Test
        public void testImpostaStanzaAdiacenteNulla(){
            
            stanza("A",null,null).impostaStanzaAdiacente("direzione", null);
            assertEquals(null, stanza.getStanzaAdiacente("direzione"));
        }

        /**
         * Test impostaStanzaAdiacente(String direzione, Stanza stanza) a stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testImpostaStanzaAdiacenteAStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.impostaStanzaAdiacente("direzione", stanza("B",null,null));
        }


// test getStanzaAdiacente(String direzione)
    
        /**
         * Test getStanzaAdiacente(String direzione) nel caso di direzione nulla
         */
        @Test
        public void testGetStanzaAdiacenteDirezioneNulla(){
            assertEquals(null, stanza("A",null,null).getStanzaAdiacente(null));
        }
        
        /**
         * Test getStanzaAdiacente(String direzione) nel caso non ci siano stanze adiacenti nella direzione specificata
         */
        @Test
        public void testGetStanzaAdiacenteDirezioneNonPresente(){
            assertEquals(null, stanza("A",null,null).getStanzaAdiacente("direzione"));
        }
        
        /**
         * Test getStanzaAdiacente(String direzione) nel caso ci siano stanze adiacenti nella direzione specificata    
         */
        @Test
        public void testGetStanzaAdiacenteDirezionePresente(){
            Stanza stanza_adiacente = new Stanza("B");
            stanza("A",null,null).impostaStanzaAdiacente("direzione",stanza_adiacente);
            assertEquals(stanza_adiacente, stanza.getStanzaAdiacente("direzione"));
        }

        /**
         * Test getStanzaAdiacente(String direzione) se invocato su una stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testGetStanzaAdiacenteStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.getStanzaAdiacente("direzione");
        }



// test addAttrezzo(Attrezzo attrezzo)


        /**
         * Test addAttrezzo(Attrezzo attrezzo) se invocato su una stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testAddAttrezzoStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.addAttrezzo(new Attrezzo("attrezzo", 1));
        }

    
        /**
         * Test addAttrezzo(Attrezzo attrezzo) nel caso di attrezzo nullo
         */
        @Test
        public void testAddAttrezzoParametroNullo(){
            assertEquals(false, stanza("A",null,null).addAttrezzo(null));
        }
        

        /**
         * Test addAttrezzo(Attrezzo attrezzo) nel caso di stanza vuota
         */
        @Test
        public void testAddAttrezzoStanzaVuota(){
            assertEquals(true, stanza("A",null,null).addAttrezzo(new Attrezzo("attrezzo", 1)));
        }


        /**
         * Test addAttrezzo(Attrezzo attrezzo) se si supera il numero massimo di attrezzi contenibili dalla stanza
         */
        @Test
        public void testAddAttrezzoSuperamentoNumeroMassimoAttrezzi(){
            Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
            Attrezzo[] attrezzi = {attrezzo, attrezzo, attrezzo, attrezzo, attrezzo,attrezzo,attrezzo,attrezzo,attrezzo,attrezzo};
            assertEquals(false, stanza("A",null,attrezzi).addAttrezzo(attrezzo));
        }


// test removeAttrezzo(Attrezzo attrezzo)

        /**
         * Test removeAttrezzo(Attrezzo attrezzo) se invocato su una stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testRemoveAttrezzoStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.removeAttrezzo(new Attrezzo("attrezzo", 1));
        }

        /**
         * Test removeAttrezzo(Attrezzo attrezzo) nel caso di attrezzo nullo
         */
        @Test 
        public void testRemoveAttrezzoParametroNullo(){
            assertEquals(false,stanza("A",null,null).removeAttrezzo(null));
        }

        /**
         * Test removeAttrezzo(Attrezzo attrezzo) nel caso di stanza vuota
         */
        @Test
        public void testRemoveAttrezzoStanzaVuota(){
            assertEquals(false, stanza("A",null,null).removeAttrezzo(new Attrezzo("attrezzo", 1)));
        }

        /**
         * Test removeAttrezzo(Attrezzo attrezzo) se l'attrezzo è presente nella stanza
         */
        @Test
        public void testRemoveAttrezzoPresenteInStanza(){
           assertEquals(true, stanza("A",null, new Attrezzo[] {new Attrezzo("attrezzo", 1)}).removeAttrezzo(new Attrezzo("attrezzo", 1)));
        }

        /**
         * Test removeAttrezzo(Attrezzo attrezzo) se l'attrezzo non è presente nella stanza
         */
        @Test
        public void testRemoveAttrezzoNonPresenteInStanza(){
            assertEquals(false, stanza("A",null, new Attrezzo[] {new Attrezzo("attrezzo", 1)}).removeAttrezzo(new Attrezzo("attrezzo2", 1)));
        }



// test getAttrezzo(String nomeAttrezzo)

        /**
         * Test getAttrezzo(String nomeAttrezzo) se invocato su una stanza nulla
         */
        @SuppressWarnings({ "null"})
		@Test(expected = NullPointerException.class)
        public void testGetAttrezzoStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.getAttrezzo("attrezzo");
        }

        /**
         * Test getAttrezzo(String nomeAttrezzo) nel caso di attrezzo nullo
         */
        @Test
        public void testGetAttrezzoParametroNullo(){
            assertEquals(null, stanza("A",null,null).getAttrezzo(null));
        }

        /**
         * Test getAttrezzo(String nomeAttrezzo) nel caso di stanza vuota
         */
        @Test
        public void testGetAttrezzoStanzaVuota(){
            assertEquals(null, stanza("A",null,null).getAttrezzo("attrezzo"));
        }

        /**
         * Test getAttrezzo(String nomeAttrezzo) se l'attrezzo è presente nella stanza
         */
        @Test
        public void testGetAttrezzoPresenteInStanza(){
            Attrezzo attrezzo = new Attrezzo("attrezzo", 1);
            assertEquals(attrezzo, stanza("A",null, new Attrezzo[] {attrezzo}).getAttrezzo("attrezzo"));
        }

        /**
         * Test getAttrezzo(String nomeAttrezzo) se l'attrezzo non è presente nella stanza
         */
        @Test
        public void testGetAttrezzoNonPresenteInStanza(){
            assertEquals(null, stanza("A",null, new Attrezzo[] {new Attrezzo("attrezzo", 1)}).getAttrezzo("attrezzo2"));
        }

   
// test getDirezioni()

        /**
         * Test getDirezioni() nel caso di stanza senza stanze adiacenti
         */
        @Test
        public void testGetDirezioniStanzaSenzaStanzeAdiacenti(){
            assertEquals(0, stanza("A",null,null).getDirezioni().length);
        }

        /**
         * Test getDirezioni() nel caso di stanza con stanze adiacenti
         */
        @Test
        public void testGetDirezioniStanzaConStanzeAdiacenti(){
            stanza("A",new Stanza[] {new Stanza("B")},null);
            assertEquals(1, stanza.getDirezioni().length);
        }

        /**
         * Test getDirezioni() se invocato su una stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testGetDirezioniStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.getDirezioni();
        }



// test hasAttrezzo(String nomeAttrezzo)

        /**
         * Test hasAttrezzo(String nomeAttrezzo) se invocato su una stanza nulla
         */
        @SuppressWarnings("null")
		@Test(expected = NullPointerException.class)
        public void testHasAttrezzoStanzaNulla(){
            Stanza stanzaA = null;
            stanzaA.hasAttrezzo("attrezzo");
        }

        /**
         * Test hasAttrezzo(String nomeAttrezzo) nel caso di attrezzo nullo
         */
        @Test
        public void testHasAttrezzoParametroNullo(){
            assertEquals(false,stanza("A",null,null).hasAttrezzo(null));
        }

        /**
         * Test hasAttrezzo(String nomeAttrezzo) nel caso di stanza vuota
         */
        @Test
        public void testHasAttrezzoStanzaVuota(){
            assertEquals(false, stanza("A",null,null).hasAttrezzo("attrezzo"));
        }

        /**
         * Test hasAttrezzo(String nomeAttrezzo) se l'attrezzo è presente nella stanza
         */
        @Test
        public void testHasAttrezzoPresenteInStanza(){
            assertEquals(true, stanza("A",null, new Attrezzo[] {new Attrezzo("attrezzo", 1)}).hasAttrezzo("attrezzo"));
        }

        /**
         * Test hasAttrezzo(String nomeAttrezzo) se l'attrezzo non è presente nella stanza
         */
        @Test
        public void testHasAttrezzoNonPresenteInStanza(){
            assertEquals(false, stanza("A",null, new Attrezzo[] {new Attrezzo("attrezzo", 1)}).hasAttrezzo("attrezzo2"));
        }










}