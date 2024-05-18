package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import java.util.Map;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa;

	public Borsa borsa(int peso_max, Map<String,Attrezzo>attrezzi){
		this.borsa = new Borsa(peso_max);
		if(attrezzi!=null) {
			this.borsa.getAttrezzi().putAll(attrezzi);
		}
		return this.borsa;
		
	}
	
	public Borsa borsa(int peso_max,Attrezzo a, Attrezzo b) {
		this.borsa = new Borsa(peso_max);
		if(a!=null) {
			this.borsa.getAttrezzi().put(a.getNome(), a);
		}
		if(b!=null) {
			this.borsa.getAttrezzi().put(b.getNome(), b);
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
			
			assertEquals(true,borsa(10,new Attrezzo("penna",1),null).addAttrezzo(new Attrezzo("martello",5)));
		}
		
		/**
		 * Test addAttrezzo(Attrezzo a) superando il peso massimo della borsa
		 */
		@Test
		public void testAddAttrezzoPesoMaggiorePesoMax() {
			
			assertEquals(false,borsa(10,new Attrezzo("martello",5),new Attrezzo("spada", 5)).addAttrezzo(new Attrezzo("spadone", 9)));
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
			assertEquals(a1,borsa(10,a1,new Attrezzo("a2",1)).getAttrezzo(a1));
		}
		
		/**
		 * Test getAttrezzo(String nomeAttrezzo) quando l'attrezzo non e' presente nella borsa
		 */
		@Test
		public void testGetAttrezzoNonPresenteInBorsa() {
			Attrezzo a3 = new Attrezzo("a3",2);
			assertEquals(null,borsa(10,new Attrezzo("a1",3),new Attrezzo("a2",1)).getAttrezzo(a3));
		}
		
		/**
		 * Test getAttrezzo(String nomeAttrezzo) quando viene passata una stringa vuota come parametro
		 */
		@Test
		public void testGetAttrezzoParametroVuoto() {
			assertEquals(null,borsa(10,null,new Attrezzo("a2",1)).getAttrezzo(null));
		}
		
	    /**
	     * Test getAttrezzo(String nomeAttrezzo) con borsa vuota	
	     */
		@Test
		public void testGetAttrezzoBorsaVuota() {
			assertEquals(null,borsa(10,null,null).getAttrezzo(new Attrezzo("a1",2)));
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
		


// test getContenutoOrdinatoPerPeso()
		
		/**
		 * Test getContenutoOrdinatoPerPeso() su una borsa vuota
		 */
		@Test
		public void testGetContenutoOrdinatoPerPesoBorsaVuota() {
			assertEquals(0,borsa(10,null,null).getContenutoOrdinatoPerPeso().size());
		}
		
		/**
		 * Test getContenutoOrdinatoPerPeso() su una borsa con un solo attrezzo
		 */
		@Test
		public void testGetContenutoOrdinatoPerPesoBorsaConUnAttrezzo() {
			Attrezzo a1 = new Attrezzo("a1",2);
			assertEquals(a1,borsa(10,a1,null).getContenutoOrdinatoPerPeso().get(0));
		}
		
		/**
		 * Test getContenutoOrdinatoPerPeso() su una borsa con piu' attrezzi
		 */
		@Test
		public void testGetContenutoOrdinatoPerPesoBorsaConPiuAttrezzi() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",4);
			assertEquals(a1,borsa(10,a1,a2).getContenutoOrdinatoPerPeso().get(0));
			assertEquals(a2,borsa(10,a1,a2).getContenutoOrdinatoPerPeso().get(1));
		}
		
		/**
		 * Test getContenutoOrdinatoPerPeso() su una borsa con piu' attrezzi con lo stesso peso
		 */
		@Test
		public void testGetContenutoOrdinatoPerPesoBorsaConPiuAttrezziStessoPeso() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",2);
			assertEquals(a1,borsa(10,a1,a2).getContenutoOrdinatoPerPeso().get(0));
			assertEquals(a2,borsa(10,a1,a2).getContenutoOrdinatoPerPeso().get(1));
		}



// test getContenutoOrdinatoPerNome()



		/**
		 * Test getContenutoOrdinatoPerNome() su una borsa con un solo attrezzo
		 */
		@Test
		public void testGetContenutoOrdinatoPerNomeBorsaConUnAttrezzo() {
			Attrezzo a1 = new Attrezzo("a1",2);
			assertEquals(a1,borsa(10,a1,null).getContenutoOrdinatoPerNome().first());
		}

		/**
		 * Test getContenutoOrdinatoPerNome() su una borsa con piu' attrezzi
		 */
		@Test
		public void testGetContenutoOrdinatoPerNomeBorsaConPiuAttrezzi() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",4);
			assertEquals(a1,borsa(10,a1,a2).getContenutoOrdinatoPerNome().first());
			assertEquals(a2,borsa(10,a1,a2).getContenutoOrdinatoPerNome().last());
		}

// test getContenutoRaggruppatoPerPeso()

		/**
		 * Test getContenutoRaggruppatoPerPeso() su una borsa con un solo attrezzo
		 */
		@Test
		public void testGetContenutoRaggruppatoPerPesoBorsaConUnAttrezzo() {
			Attrezzo a1 = new Attrezzo("a1",2);
			assertEquals(a1,borsa(10,a1,null).getContenutoRaggruppatoPerPeso().get(2).iterator().next());
		}

		/**
		 * Test getContenutoRaggruppatoPerPeso() su una borsa con due attrezzi
		 */
		@Test
		public void testGetContenutoRaggruppatoPerPesoBorsaConDueAttrezzi() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",4);
			assertEquals(a1,borsa(10,a1,a2).getContenutoRaggruppatoPerPeso().get(2).iterator().next());
			assertEquals(a2,borsa(10,a1,a2).getContenutoRaggruppatoPerPeso().get(4).iterator().next());
		}

		/**
		 * Test getContenutoRaggruppatoPerPeso() su una borsa con due attrezzi con lo stesso peso
		 */
		@Test
		public void testGetContenutoRaggruppatoPerPesoBorsaConDueAttrezziStessoPeso() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",2);
			// iteratore per scorrere l'insieme di attrezzi con peso 2
			assertEquals(a1,borsa(10,a1,a2).getContenutoRaggruppatoPerPeso().get(2).iterator().next());
			Iterator<Attrezzo> it = borsa(10,a1,a2).getContenutoRaggruppatoPerPeso().get(2).iterator();
			assertEquals(a1,it.next());
			assertEquals(a2,it.next());
		}

		/**
		 * Test getContenutoRaggruppatoPerPeso() su una borsa con 5 attrezzi 
		 */
		@Test
		public void testGetContenutoRaggruppatoPerPesoBorsaConCinqueAttrezzi() {
			Attrezzo a1 = new Attrezzo("a1",2);
			Attrezzo a2 = new Attrezzo("a2",2);
			Attrezzo a3 = new Attrezzo("a3",4);
			Attrezzo a4 = new Attrezzo("a4",4);
			Attrezzo a5 = new Attrezzo("a5",6);
			Map<String ,Attrezzo> map = new HashMap<>();
			map.put(a1.getNome(), a1);
			map.put(a2.getNome(), a2);
			map.put(a3.getNome(), a3);
			map.put(a4.getNome(), a4);
			map.put(a5.getNome(), a5);
			
			assertEquals(a1,borsa(10,map).getContenutoRaggruppatoPerPeso().get(2).iterator().next());
			assertEquals(a3,borsa(10,map).getContenutoRaggruppatoPerPeso().get(4).iterator().next());
			assertEquals(a5,borsa(10,map).getContenutoRaggruppatoPerPeso().get(6).iterator().next());
		}



// test getSortedSetOrdinatoPerPeso()

	/**
	 * Test getSortedSetOrdinatoPerPeso() su una borsa con un solo attrezzo
	 */
	@Test
	public void testGetSortedSetOrdinatoPerPesoBorsaConUnAttrezzo() {
		Attrezzo a1 = new Attrezzo("a1",2);
		assertEquals(a1,borsa(10,a1,null).getSortedSetOrdinatoPerPeso().first());
	}

	/**
	 * Test getSortedSetOrdinatoPerPeso() su una borsa con due attrezzi
	 */
	@Test
	public void testGetSortedSetOrdinatoPerPesoBorsaConDueAttrezzi() {
		Attrezzo a1 = new Attrezzo("a1",2);
		Attrezzo a2 = new Attrezzo("a2",4);
		assertEquals(a1,borsa(10,a1,a2).getSortedSetOrdinatoPerPeso().first());
		assertEquals(a2,borsa(10,a1,a2).getSortedSetOrdinatoPerPeso().last());
	}

	/**
	 * Test getSortedSetOrdinatoPerPeso() su una borsa con due attrezzi con lo stesso peso
	 */
	@Test
	public void testGetSortedSetOrdinatoPerPesoBorsaConDueAttrezziStessoPeso() {
		Attrezzo a1 = new Attrezzo("a1",2);
		Attrezzo a2 = new Attrezzo("a2",2);
		assertEquals(a1,borsa(10,a1,a2).getSortedSetOrdinatoPerPeso().first());
		assertEquals(a2,borsa(10,a1,a2).getSortedSetOrdinatoPerPeso().last());
	}

	/**
	 * Test getSortedSetOrdinatoPerPeso() su una borsa con 5 attrezzi 
	 */
	@Test
	public void testGetSortedSetOrdinatoPerPesoBorsaConCinqueAttrezzi() {
		Attrezzo a1 = new Attrezzo("a1",2);
		Attrezzo a2 = new Attrezzo("a2",2);
		Attrezzo a3 = new Attrezzo("a3",8);
		Attrezzo a4 = new Attrezzo("a4",4);
		Attrezzo a5 = new Attrezzo("a5",6);
		Map<String ,Attrezzo> map = new HashMap<>();
		map.put(a1.getNome(), a1);
		map.put(a2.getNome(), a2);
		map.put(a3.getNome(), a3);
		map.put(a4.getNome(), a4);
		map.put(a5.getNome(), a5);
		
		assertEquals(a1,borsa(10,map).getSortedSetOrdinatoPerPeso().first());
		assertEquals(a3,borsa(10,map).getSortedSetOrdinatoPerPeso().last());
	}






}
