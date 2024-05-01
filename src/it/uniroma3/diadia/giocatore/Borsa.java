package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	/**
	 * Crea una Borsa attribuendole il peso max di default
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	/**
	 * Crea una Borsa attribuendole il peso max fornito come parametro
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge l'attrezzo passato come parametro alla borsa  
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Ritorna il peso massimo supportato dalla borsa 
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * ritorna l'istanza di un attrezzo a partire dal suo nome
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
	
		return a;
	}
	/**
	 * Ritorna il peso complessivo della borsa 
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
		}
	
	/**
	 * @return true se nella borsa non sono presenti attrezzi
	 */
		public boolean isEmpty() {
			return this.numeroAttrezzi == 0;
		}
		
	/**
	 * @return true se l'attrezzo il cui nome e' passato come
	 * parametro e' presente nella borsa
	 */
		public boolean hasAttrezzo(String nomeAttrezzo) {
			if(this.getAttrezzo(nomeAttrezzo)!=null)
				return true;
			else
				return false;
			//return this.getAttrezzo(nomeAttrezzo)!=null;
		}
		
	/**
	 * Rimuove un attrezzo dalla Borsa e ne ritorna il riferimento
	 */
		
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null){
			int i = 0;
			for(Attrezzo a : this.attrezzi) {
				if(a != null) {
					if(a.getNome().equals(attrezzo.getNome())) {
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;

			}
			return true;
		}
		else
			return false;
	}
		
	/**
	 * Restituisce una rapresentazione stringa di questa borsa 
	 * stampandone il peso corrente, il peso massimo e gli attrezzi presenti
	 */		
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
		}

		
		
	}