package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	

	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =
				new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	
	

	


	
	   /**
     * Crea tutte le stanze e le porte di collegamento
     */

	/* 
    private void creaStanze() {

		Set<Stanza> stanze = new HashSet<Stanza>();
		Set<Attrezzo> attrezzi = new HashSet<Attrezzo>();

		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		
		// crea gli attrezzi
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		stanze.add(atrio);
		stanze.add(aulaN11);
		stanze.add(aulaN10);
		stanze.add(laboratorio);
		stanze.add(biblioteca);

		attrezzi.add(lanterna);
		attrezzi.add(osso);

		
		
		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        // pone gli attrezzi nelle stanze prendendoli dal set attrezzi 
		 
		atrio.addAttrezzo(lanterna);
		aulaN11.addAttrezzo(osso);
		


		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaCorrente = atrio;
		this.stanzaVincente = biblioteca;
    }
	*/
    
    
    public Stanza getStanzaCorrente() {
    	return this.stanzaCorrente;
    }
	
	
    public Stanza getStanzaVincente() {
    	return this.stanzaVincente;

    }
  
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	public void setStanzaVincente(Stanza uscita) {
		this.stanzaVincente = uscita;
	}




	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}



	//static nested class LabirintoBuilder


	public static class LabirintoBuilder {
		

		
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> stanze;

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.stanze = new HashMap<String, Stanza>();
		}

		public Map<String, Stanza> getListaStanze() {
			return this.stanze;
		}
	
		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}

	
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(i);
			this.AggiornaUltimaStanza(i);
			return this;
		}
	
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.AggiornaUltimaStanza(s);
			return this;
		}
	
		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.AggiornaUltimaStanza(s);
			return this;
		}	
	
		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}
	
		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
			if(!Direzione.NORD.equals(direzione) && !Direzione.SUD.equals(direzione) && !Direzione.EST.equals(direzione) && !Direzione.OVEST.equals(direzione))
				return this;
			Stanza c = this.stanze.get(stanzaCorrente);
			Stanza a = this.stanze.get(stanzaAdiecente);
			if(c != null && a != null){
				c.impostaStanzaAdiacente(direzione, a);
			}
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
			Stanza stanza = new StanzaMagica(nome, sogliaMagica);
			this.AggiornaUltimaStanza(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,new Attrezzo (attrezzoPerVedere));
			this.AggiornaUltimaStanza(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome,  Direzione direzioneBloccata,String attrezzoSbloccante) {
			Stanza stanza = new StanzaBloccata(nome, direzioneBloccata,attrezzoSbloccante);
			this.AggiornaUltimaStanza(stanza);
			return this;
		}
		
		public void AggiornaUltimaStanza(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.stanze.put(stanza.getNome(), stanza);
		}
	
	}
   
}
