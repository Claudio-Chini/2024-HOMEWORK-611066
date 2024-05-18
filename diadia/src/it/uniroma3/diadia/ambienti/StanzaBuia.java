package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{

	private Attrezzo attrezzoSpeciale = new Attrezzo("Lanterna");

	public StanzaBuia(String nome,Attrezzo attrezzo_speciale) {
		super(nome);
		this.attrezzoSpeciale = attrezzo_speciale;
		
	}
	
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoSpeciale.getNome())==true) {
			return super.getDescrizione();
		}else {
			return "qui c'e' un buio pesto ";
		}
		
	}
	

}
