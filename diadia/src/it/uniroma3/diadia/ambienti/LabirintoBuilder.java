package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class LabirintoBuilder {

	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Map<String, Stanza> getListaStanze() {
		return this.stanze;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
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

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
		if(!"nord".equals(direzione) && !"sud".equals(direzione) && !"est".equals(direzione) && !"ovest".equals(direzione))
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
	
	public LabirintoBuilder addStanzaBloccata(String nome,  String direzioneBloccata,String attrezzoSbloccante) {
		Stanza stanza = new StanzaBloccata(nome, direzioneBloccata,attrezzoSbloccante);
		this.AggiornaUltimaStanza(stanza);
		return this;
	}
	
	public void AggiornaUltimaStanza(Stanza stanza) {
		this.ultimaStanzaAggiunta = stanza;
		this.stanze.put(stanza.getNome(), stanza);
	}

	


}

