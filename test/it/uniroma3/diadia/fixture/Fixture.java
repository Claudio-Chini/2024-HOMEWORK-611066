package it.uniroma3.diadia.fixture;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Fixture {



	
	
	public static IOSimulator simulazionePartita(List<String> comandiDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto lab = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, lab);
		gioco.gioca();
		return io;
	}

	public static IOSimulator simulazionePartitaTest(List<String> comandiDaLeggere) throws Exception {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto lab = Labirinto.newBuilder("labirinto_test.txt").getLabirinto();
		DiaDia gioco = new DiaDia(io, lab);
		gioco.gioca();
		return io;
	}
	


	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
