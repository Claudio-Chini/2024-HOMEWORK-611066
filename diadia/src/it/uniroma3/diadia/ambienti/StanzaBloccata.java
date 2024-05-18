
	





package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
    private Attrezzo attrezzoSpeciale;

    public StanzaBloccata(String nome, String direzione_bloccata, String attrezzo_speciale) {
        super(nome);
        this.direzioneBloccata = direzione_bloccata;
        this.attrezzoSpeciale = new Attrezzo(attrezzo_speciale);
    }

    @Override
    public String getDescrizione() {
        if (this.hasAttrezzo(attrezzoSpeciale.getNome()) == false)
            return "Stanza bloccata nella direzione: " + direzioneBloccata + "\nPrendi il " + attrezzoSpeciale + " e posalo nella stanza";
        return super.getDescrizione();
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (direzioneBloccata.equals(direzione) && this.hasAttrezzo(attrezzoSpeciale.getNome()) == false) {
            return this;
        }
        return super.getStanzaAdiacente(direzione);
    }
}
