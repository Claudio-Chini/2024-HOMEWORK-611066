package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


public class PartitaTest {
	
	Partita partita;
	Labirinto labirinto;
	Giocatore giocatore;
	
	public Partita partita(Labirinto labirinto, Giocatore giocatore) {
		this.partita = new Partita(labirinto, giocatore);
		return this.partita;
	}
	public Labirinto labirinto(Stanza entrata, Stanza uscita){
		this.labirinto = new Labirinto();
        this.labirinto.setEntrata(entrata);
        this.labirinto.setUscita(uscita);
        return this.labirinto;
    }



// test vinta()

		/**
		 ** Test vinta() nel caso di partita nulla
		*/
		@Test(expected = NullPointerException.class)
		public void testVintaNulla() {
			this.partita.vinta();
		}



		/**
		 ** Test vinta() nel caso di partita non vinta
		*/
		@Test
		public void testVintaFalse() {
			Stanza stanzaCorrente = new Stanza("stanzaCorrente");
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),null).setStanzaCorrente(stanzaCorrente);
			assertEquals(false,partita.vinta());
		}

		/**
		 ** Test vinta() nel caso di partita vinta
		*/
		@Test
		public void testVintaTrue() {
			Stanza uscita = new Stanza("uscita");
			partita(labirinto(new Stanza("entrata"),uscita),null).setStanzaCorrente(uscita);
			assertEquals(true,partita.vinta());
		}



		

// test isFinita()

		/**
		 ** Test isFinita() nel caso di partita nulla
		*/
		@Test(expected = NullPointerException.class)
		public void testIsFinitaNulla() {
			this.partita.isFinita();
		}

		/**
		 ** Test isFinita() nel caso di partita non finita
		*/
		@Test
		public void testIsFinitaFalse() {
			Stanza stanzaCorrente = new Stanza("stanzaCorrente");
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),new Giocatore()).setStanzaCorrente(stanzaCorrente);
			assertEquals(false,partita.isFinita());
		}

		/**
		 ** Test isFinita() nel caso di partita finita (vinta)
		*/
		@Test
		public void testIsFinitaTrue() {
			Stanza uscita = new Stanza("uscita");
			partita(labirinto(new Stanza("entrata"),uscita),null).setStanzaCorrente(uscita);
			assertEquals(true,partita.isFinita());
		}

		/**
		 ** Test isFinita() nel caso di partita finita per mancanza di cfu
		*/
		@Test
		public void testIsFinitaCfu() {
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),new Giocatore()).getGiocatore().setCfu(0);
			assertEquals(true,partita.isFinita());
		}




// test getStanzaVincente()


		/**
		 ** Test getStanzaVincente() nel caso di stanza vincente (uscita) nulla
		*/
		@Test
		public void testGetStanzaVincenteNulla() {
			assertEquals(null,partita(labirinto(new Stanza("e"),null),null).getStanzaVincente());
		}

		/**
		 ** Test getStanzaVincente() nel caso di stanza vincente (uscita) non nulla
		*/
		@Test
		public void testGetStanzaVincente() {
			Stanza uscita = new Stanza("uscita");
			assertEquals(uscita,partita(labirinto(new Stanza("entrata"),uscita),null).getStanzaVincente());
		}


// test setStanzaCorrente(Stanza stanzaCorrente)




		/**
		 ** Test setStanzaCorrente(Stanza stanzaCorrente) nel caso di stanza corrente nulla
		*/
		@Test
		public void testSetStanzaCorrenteNulla() {
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),null).setStanzaCorrente(null);
			assertEquals(null,	partita.getStanzaCorrente());
		}

		/**
		 ** Test setStanzaCorrente(Stanza stanzaCorrente) nel caso di stanza corrente non nulla
		*/
		@Test
		public void testSetStanzaCorrente() {
			Stanza stanzaCorrente = new Stanza("stanzaCorrente");
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),null).setStanzaCorrente(stanzaCorrente);
			assertEquals(stanzaCorrente,partita.getStanzaCorrente());
		}


// test getStanzaCorrente()


		/**
		 ** Test getStanzaCorrente() nel caso di stanza corrente nulla
		*/
		@Test
		public void testGetStanzaCorrenteNulla() {
			assertEquals(null,partita(labirinto(null,new Stanza("uscita")),null).getStanzaCorrente());
		}

		/**
		 ** Test getStanzaCorrente() nel caso di stanza corrente non nulla
		*/
		@Test
		public void testGetStanzaCorrente() {
			Stanza stanzaCorrente = new Stanza("stanzaCorrente");
			partita(labirinto(new Stanza("entrata"),new Stanza("uscita")),null).setStanzaCorrente(stanzaCorrente);
			assertEquals(stanzaCorrente,partita.getStanzaCorrente());
		}







}


