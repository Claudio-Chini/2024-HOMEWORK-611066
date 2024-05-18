package it.uniroma3.diadia.giocatore;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;





/**
 * Questa classe modella una borsa che ogni giocatore puo usare per 
 * riporvi gli ogetti
 * 
 * @author docente di POO
 * @see Borsa
 * @version base
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;

	/**
	 * Crea una Borsa attribuendole il peso max di default
	 */
	public Borsa() {
		
		this(DEFAULT_PESO_MAX_BORSA);
		this.attrezzi = new HashMap<>();
	}
	/**
	 * Crea una Borsa attribuendole il peso max fornito come parametro
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}
	
	/**
	 * Aggiunge l'attrezzo passato come parametro alla borsa  
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null ) {return false;}
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()){
			return false;
		}
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	/**
	 *  Rimuove un attrezzo dalla Borsa 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null){return false;}
		int temp = this.attrezzi.size();
		this.attrezzi.remove(attrezzo.getNome()) ;
		if(temp == this.attrezzi.size()) {return false;}
		return true;
	}
	/**
 	* @return true se l'attrezzo il cui nome e' passato come
 	* parametro e' presente nella borsa
 	*/
	public boolean hasAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.containsValue(attrezzo);
		
	}
	/**
	 * ritorna l'istanza di un attrezzo a partire dal suo nome
	
	 */
	public Attrezzo getAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null ||this.isEmpty()){return null;}
		return attrezzi.get(attrezzo.getNome());
	}
	/**
 	* @return true se nella borsa non sono presenti attrezzi
	*/
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	/**
	 * Ritorna il peso complessivo della borsa 
	 */
	public int getPeso() {
		if(this.isEmpty()) return 0; //se la borsa e' vuota il peso e' 0 (non ci sono attrezzi da pesare
		int peso = 0;	
		for (Attrezzo attrezzo : attrezzi.values()) {
			peso += attrezzo.getPeso();
		}

		return peso;
	}
	/**
	 * Restituisce una rapresentazione stringa di questa borsa 
	 * stampandone il peso corrente, il peso massimo e gli attrezzi presenti
	 */		
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for (Map.Entry<String, Attrezzo> entry : attrezzi.entrySet()) {
				s.append(entry.getValue().getNome() + " ");
			}
		}
		else{
			s.append("Borsa vuota");
		}
		return s.toString();
	}
	/**
	 * Ritorna la lista di attrezzi presenti nella borsa 
	 */
	public Map<String,Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	/**
	 * Ritorna il peso massimo supportato dalla borsa 
	 */
	public int getPesoMax() {
		return pesoMax;
	}
		


	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaAttrezzi = new ArrayList<>(this.attrezzi.values());
		Collections.sort(listaAttrezzi,new ComparatorePerPeso());
		return listaAttrezzi;
	}

	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.attrezzi.values());	
	}

	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		// per ogni peso, insieme di attrezzi con quel peso	
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		for (Attrezzo attrezzo : this.attrezzi.values()) {
			int peso = attrezzo.getPeso();
			if(!mappa.containsKey(peso)) {
				mappa.put(peso, new TreeSet<Attrezzo>());
			}
			mappa.get(peso).add(attrezzo);
		}
		return mappa;
	}

	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		// insieme di attrezzi ordinato secondo il Co0maratorePerPeso
		SortedSet<Attrezzo> set = new TreeSet<>(new ComparatorePerPeso());
		set.addAll(this.attrezzi.values());
		return set;
		
	}





}