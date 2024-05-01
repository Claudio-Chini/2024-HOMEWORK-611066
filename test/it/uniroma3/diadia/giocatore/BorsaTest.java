package it.uniroma3.diadia.giocatore;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa;

	public Borsa borsa(int peso_max, Attrezzo[]attrezzi){
		this.borsa = new Borsa(peso_max);
		if(attrezzi!=null) {
			for (Attrezzo attrezzo :attrezzi) {
				this.borsa.addAttrezzo(attrezzo);
			}
		}
		return this.borsa;
		
	}
	public Borsa borsa(int peso_max,Attrezzo a, Attrezzo b) {
		this.borsa = new Borsa(peso_max);
		if(a!=null) {
			this.borsa.addAttrezzo(a);
		}
		if(b!=null) {
			this.borsa.addAttrezzo(b);
		}
		return this.borsa;
	}
	
// test addAttrezzo(Attrezzo attrezzo)
	
		/**
		 * Test addAttrezzo(Attrezzo a) nel caso di parametro nullo
		 */
		 
		@Test 
		public void testAddAttrezzoParametroNulloJU4() {
			assertEquals(false,borsa(10,null,null).addAttrezzo(null));	
		}
		
		
		/**
		 * Test addAttrezzo(Attrezzo a) senza superare il peso massimo della borsa
		 */
		@Test 
		public void testAddAttrezzoPesoMinorePesoMax() {
			
			assertTrue(borsa(10,null,null).addAttrezzo(new Attrezzo("martello",5)));
		}
		
		/**
		 * Test addAttrezzo(Attrezzo a) superando il peso massimo della borsa
		 */
		@Test
		public void testAddAttrezzoPesoMaggiorePesoMax() {
			
			assertFalse(borsa(10,new Attrezzo("martello",5),new Attrezzo("spada", 5)).addAttrezzo(new Attrezzo("spadone", 9)));
		}
		
		/**
		 * Test addAttrezzo(Attrezzo a) superando il numero massimo di attrezzi contenibili da una borsa
		 */
		@Test
		public void testAddAttrezzoLimiteAttrezziSuperato() {
			Attrezzo[]attrezzi = {new Attrezzo("a1",1),new Attrezzo("a2",2),new Attrezzo("a3",1),new Attrezzo("a4",1),new Attrezzo("a5",1),new Attrezzo("a6",1),new Attrezzo("a7",1),new Attrezzo("a8",1),new Attrezzo("a9",1),new Attrezzo("a10",1)};
			assertFalse(borsa(20,attrezzi).addAttrezzo(new Attrezzo("a11",1)));
		}


// test removeAttrezzo(String nomeAttrezzo)
		
		
		/**
		* Test removeAttrezzo(Attrezzo a) nel caso di parametro stringa vuota
		*/
		@Test 
		public void testRemoveAttrezzoParametroNullo() {
		
			assertEquals(false, borsa(10,new Attrezzo("a1",1),null).removeAttrezzo(new Attrezzo("",1)) );
		}

		/**
		 * Test removeAttrezzo(Attrezzo a) con borsa gia vuota
		 */
		@Test
		public void testRemoveAttrezzoBorsaVuota() {
			assertEquals(false,borsa(10,null,null).removeAttrezzo((new Attrezzo("a1",1))));
		}
		
		/**
		 * Test removeAttrezzo(Attrezzo a) se l'attrezzo passato non e' nella borsa
		*/
		@Test
		public void testRemoveAttrezzoNonPresenteInBorsa() {
			assertEquals(false,borsa(10,new Attrezzo("a1",1),new Attrezzo("a2",1)).removeAttrezzo(new Attrezzo("a3",1)));
		}
		
		/**
		 * Test removeAttrezzo(Attrezzo a) se l'attrezzo passato e' nella borsa
		*/
		@Test
		public void testRemoveAttrezzoPresenteInBorsa() {
			Attrezzo a1 = new Attrezzo("a1",1);
			assertEquals(true,borsa(10,a1,new Attrezzo("a2",1)).removeAttrezzo(a1));
			
		}

// test getAttrezzo(String nomeAttrezzo)
		
		/**
		 * Test getAttrezzo(String nomeAttrezzo) quando l'attrezzo e' presente nella borsa
		 */
		@Test
		public void testGetAttrezzoPresenteInBorsa() {
			Attrezzo a1 = new Attrezzo("a1",2);
			assertEquals(a1,borsa(10,a1,new Attrezzo("a2",1)).getAttrezzo(a1.getNome()));
		}
		
		/**
		 * Test getAttrezzo(String nomeAttrezzo) quando l'attrezzo non e' presente nella borsa
		 */
		@Test
		public void testGetAttrezzoNonPresenteInBorsa() {
			Attrezzo a3 = new Attrezzo("a3",2);
			assertEquals(null,borsa(10,new Attrezzo("a1",3),new Attrezzo("a2",1)).getAttrezzo(a3.getNome()));
		}
		
		/**
		 * Test getAttrezzo(String nomeAttrezzo) quando viene passata una stringa vuota come parametro
		 */
		@Test
		public void testGetAttrezzoParametroVuoto() {
			assertEquals(null,borsa(10,null,new Attrezzo("a2",1)).getAttrezzo(""));
		}
		
	    /**
	     * Test getAttrezzo(String nomeAttrezzo) con borsa vuota	
	     */
		@Test
		public void testGetAttrezzoBorsaVuota() {
			assertEquals(null,borsa(10,null,null).getAttrezzo(new Attrezzo("a1",2).getNome()));
		}

// test getPeso()
		/**
		 * Test getPeso() su una borsa contenente attrezzi
		 */
		@Test
 		public void testGetPesoBorsaPiena() {
			assertEquals(9,borsa(10,new Attrezzo("a1",5),new Attrezzo("a2",4)).getPeso());
		}
		
		/**
		 * Test getPeso() su una borsa vuota
		 */
		@Test
		public void testGetPesoBorsaVuota() {
			assertEquals(0,borsa(10,null,null).getPeso());
		}
		
		
// test isEmpty()
		
		/**
		 * Test isEmpty() su una borsa piena
		 */
		@Test
		public void testIsEmptyBorsaPiena() {
			assertEquals(false,borsa(10,new Attrezzo("a1",2),new Attrezzo("a2",4)).isEmpty());
		}
		
		/**
		 * Test isEmpty() su una borsa vuota
		 */
		@Test
		public void testIsEmptyBorsaVuota() {
			assertEquals(true,borsa(10,null,null).isEmpty());
		}
		
}
