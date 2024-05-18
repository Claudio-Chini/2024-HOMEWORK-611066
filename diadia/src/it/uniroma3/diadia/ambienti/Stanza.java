package it.uniroma3.diadia.ambienti;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza{
	
	private String nome;
	private String descrizione;
	private Map<String,Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;


	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
	public Stanza(String nome) {
		this.nome = nome;
		this.attrezzi = new HashMap<>();
		this.stanzeAdiacenti = new HashMap<>();	
	}

	public Stanza( String nome,String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.attrezzi = new HashMap<>();
		this.stanzeAdiacenti = new HashMap<>();
	
	}
 

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null) return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null) return false;
		int temp = this.attrezzi.size();
		attrezzi.remove(attrezzo.getNome());
		if(temp == this.attrezzi.size()) return false;
		return true;
	}
	    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String attrezzo) {
		return attrezzi.containsKey(attrezzo);
	}
	/**
     * Restituisce l'attrezzo attrezzo se presente nella stanza.
	 * @param attrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String attrezzo) {
		if(attrezzo==null) return null;
		return this.attrezzi.get(attrezzo);

		/* 
		if(attrezzo==null)return null;
		for(Attrezzo a : this.attrezzi) {
			if(a != null) {
				if(a.equals(attrezzo)) {
					return a;
				}
			}
		}
		return null;
		*/
	}
	



    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     *  
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione, stanzaAdiacente);
    }
    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
	}


// getter 

	/**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
	public String getDescrizione() {
		return this.descrizione;
	}

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        return new ArrayList<Attrezzo>(this.attrezzi.values());
    }

	public Collection<String> getDirezioni() {
		return new ArrayList<String>(stanzeAdiacenti.keySet());
	}

	public Map<String, Stanza> getMapStanzeAdiacenti() {
		//return this.stanzeAdiacenti;

		Map<String, Stanza> map = new HashMap<>();
		for (String direzione : this.stanzeAdiacenti.keySet()) {
			map.put(direzione, new Stanza(this.stanzeAdiacenti.get(direzione).getNome()));
		}
		return map;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}



}