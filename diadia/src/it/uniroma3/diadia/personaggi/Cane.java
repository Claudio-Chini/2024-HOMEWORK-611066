package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static String CIBO_PREFERITO= "osso";

	public Cane(String nome, String presentazione) {
		super(nome,presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return "Il cane ti ha morso, hai perso 1 cfu";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il cane e' contento, ha ricevuto il suo cibo preferito!");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
		risposta.append(attrezzo.getNome()+"il cane non e' interessato a questo regalo!");
		this.agisci(partita);
		}
		
		return risposta.toString();
	}

}
