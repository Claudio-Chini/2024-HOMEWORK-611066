package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoSpeciale ;

	public StanzaBuia(String nome,String attrezzo_speciale) {
		super(nome);
		this.attrezzoSpeciale = attrezzo_speciale;
		
	}
	
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoSpeciale)==true) {
			return super.getDescrizione();
		}else {
			return "qui c'e' un buio pesto ";
		}
		
	}
	

}
