package it.uniroma3.diadia.fixture;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Fixture {


	public static IOSimulator simulazionePartitaMonolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("Stanza Iniziale") 
				.addStanzaVincente("Stanza Iniziale") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
		return io;
	}
	
	
	public static IOSimulator simulazionePartitaBilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto bilocale = Labirinto.newBuilder()
				.addStanzaIniziale("Stanza Iniziale")
				.addStanzaVincente("Stanza Vincente")
				.addAttrezzo("chiave",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("Stanza Iniziale", "Stanza Vincente", "nord") 
				.addAdiacenza("Stanza Vincente", "Stanza Iniziale", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator simulazionePartitaTrilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("Stanza Iniziale")
				.addStanza("Altra Stanza")
				.addAttrezzo("attrezzo",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("Stanza Vincente")
				.addAdiacenza("Stanza Iniziale", "Altra Stanza", "nord")
				.addAdiacenza("Altra Stanza", "Stanza Vincente", "est")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, trilocale);
		gioco.gioca();
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
