package it.uniroma3.diadia.personaggi;

import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

    private static final String MESSAGGIO_POSITIVO = "Ti ho trasferito in una stanza con piu' attrezzi";
    private static final String MESSAGGIO_NEGATIVO = "Poiche' non i hai salutata, ti ho trasferito in una stanza con meno attrezzi";

    public Strega(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String agisci(Partita partita) {
        if (this.haSalutato() == false){
            // trasferisce il personaggio nella stanza adiacent4e con meno attrezzi e restituisce un messaggio
            Map<Direzione,Stanza> map = partita.getStanzaCorrente().getMapStanzeAdiacenti();
            int counter = 0;
            Direzione winner_key = null;
            for (Direzione key : map.keySet()) {
                if (counter > map.get(key).getAttrezzi().size()){
                    counter = map.get(key).getAttrezzi().size();
                    winner_key = key;
                }
            }
            partita.setStanzaCorrente(map.get(winner_key));
            return MESSAGGIO_NEGATIVO;
        }

        // trasferisce il personaggio nella stanza adiacente con piu' attrezzi e restituisce un messaggio
        else {
            Map<Direzione,Stanza> map = partita.getStanzaCorrente().getMapStanzeAdiacenti();
            int counter = 0;
            Direzione winner_key = null;
            for (Direzione key : map.keySet()) {
                if (counter < map.get(key).getAttrezzi().size()){
                    counter = map.get(key).getAttrezzi().size();
                    winner_key = key;
                }
            }
            partita.setStanzaCorrente(map.get(winner_key));
            return MESSAGGIO_POSITIVO;
        }

    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        return "Non mi interessano i regali!";
   }


    

	

}
