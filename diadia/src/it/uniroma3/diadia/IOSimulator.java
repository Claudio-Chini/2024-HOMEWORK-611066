package it.uniroma3.diadia;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO {

	private List<String> righeLette;
	private int indiceRigheLette;
	private Map<String, String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;

	public List<String> getRigheLette() {
		return righeLette;
	}

	public void setMessaggiProdotti(Map<String,String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}


	//forse si potrebbe inserire una mappa al posto della lista per ricordare ogni riga letta quale messaggi abbia prodotto

	//private List<String> messaggiProdotti;
	


	public Map<String, String> getMessaggiProdotti() {
		return messaggiProdotti;
	}


	public IOSimulator(List<String> righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new HashMap<String,String>();
	}

	@Override
	public String leggiRiga() {
		String riga = null;

		riga = this.righeLette.get(indiceRigheLette);
		this.indiceRigheLette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti.put(righeLette.get(indiceRigheLette-1), msg);
		this.indiceMessaggiProdotti++;
	}

	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}
