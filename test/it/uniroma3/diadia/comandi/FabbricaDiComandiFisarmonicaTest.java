package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
	@Test
	public void testCostruisciComandoVai() {
		assertEquals(new ComandoVai().getNome(),factory.costruisciComando("vai").getNome());
		
		
	}
	@Test
	public void testCostruisciComandoNonValido(){
		assertEquals(new ComandoNonValido().getNome(),factory.costruisciComando("").getNome());
		assertEquals(new ComandoNonValido().getNome(),factory.costruisciComando("comandoInesistente").getNome());
		
	}
	@Test
	public void testCostruisciComandoPosa(){
		assertEquals(new ComandoPosa().getNome(),factory.costruisciComando("posa").getNome());
		
	}
	@Test
	public void testCostruisciComandoPrendi(){
		assertEquals(new ComandoPrendi().getNome(),factory.costruisciComando("prendi").getNome());

		
	}
	@Test
	public void testCostruisciComandoAiuto(){
		assertEquals(new ComandoAiuto().getNome(),factory.costruisciComando("aiuto").getNome());	
	}
	@Test
	public void testCostruisciComandoGuarda(){
		assertEquals(new ComandoGuarda().getNome(),factory.costruisciComando("guarda").getNome());
		
	}
	@Test
	public void testCostruisciComandoFine(){
		assertEquals(new ComandoFine().getNome(),factory.costruisciComando("fine").getNome());
		
	}



}
