package it.uniroma3.diadia.ambienti;


import java.util.ArrayList;
import java.util.HashMap;
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

public class StanzaProtected{
	
	protected String nome;
	protected String descrizione;
	protected List<Attrezzo> attrezzi;
	protected Map<String, Stanza> stanzeAdiacenti;


	/**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
	public StanzaProtected(String descrizione) {
		this.descrizione = descrizione;
		this.attrezzi = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<>();
	
	}
	public StanzaProtected(String descrizione, String nome) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.attrezzi = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<>();
	
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
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null) return false;
		return this.attrezzi.add(attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
public String toString() {
	StringBuilder risultato = new StringBuilder();
	risultato.append(this.descrizione);
	risultato.append("\nUscite: ");
	for (Map.Entry<String, Stanza> entry : stanzeAdiacenti.entrySet()) {
		risultato.append(entry.getKey() + " ");
	}

	risultato.append("\nAttrezzi nella stanza: ");
	for (Attrezzo attrezzo : attrezzi) {
		risultato.append(attrezzo.getNome() + " ");
	}

	return risultato.toString();
}

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(Attrezzo attrezzo) {
		return attrezzi.contains(attrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)return null;
		for(Attrezzo a : this.attrezzi) {
			if(a != null) {
				if(a.equals(attrezzo)) {
					return a;
				}
			}
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return attrezzi.remove(attrezzo);
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
        return this.attrezzi;
    }


	
	public Set<String> getDirezioni() {

		return stanzeAdiacenti.keySet();
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