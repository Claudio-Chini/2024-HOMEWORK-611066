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
			return this.getAttrezzo(nomeAttrezzo)!=null;
		}
		
	/**
	 * Rimuove un attrezzo dalla Borsa e ne ritorna il riferimento
	 */
		
		public Attrezzo removeAttrezzo(String nomeAttrezzo) {
			
			// ---> TODO (implementare questo metodo) <---
			if(nomeAttrezzo != "") {
				Attrezzo a = null;
				Attrezzo[] attrezzi_temp = new Attrezzo[10];
				if(this.hasAttrezzo(nomeAttrezzo)!= false) {
					int i=0;
					for (Attrezzo attrezzo : this.attrezzi) {
						if(attrezzo != null) {
							if (attrezzo.getNome() == nomeAttrezzo) {
								a = attrezzo;
								
							}else { 
								attrezzi_temp[i] = attrezzo;
								i++;
							}
						}
					}
					
				this.attrezzi = attrezzi_temp;	
				}
				
				return a;
			}else return null;
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