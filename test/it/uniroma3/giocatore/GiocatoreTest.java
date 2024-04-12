package it.uniroma3.giocatore;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class GiocatoreTest {
	private Giocatore giocatore;

	public Giocatore giocatore() {
		this.giocatore = new Giocatore();
		return this.giocatore;
	}

// test getCfu()

	/**
	 ** Test getCfu() cfu di default
	 */
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, giocatore().getCfu());
	} 


// test setCfu()

	/**
	 ** Test setCfu() 
	 */
	@Test
	public void testSetCfu() {
		giocatore().setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}


// test setBorsa()

	/**
	 ** Test setBorsa() 
	 */
	@Test
	public void testSetBorsa() {
		Borsa borsa = new Borsa();
		giocatore().setBorsa(borsa);
		assertEquals(borsa, giocatore.getBorsa());
	}


		


}
