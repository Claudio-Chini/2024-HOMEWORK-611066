package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import java.util.List;
import it.uniroma3.diadia.ClassFinder;

public class ComandoAiuto extends AbstractComando {
    private final static String NOME = "aiuto";
	private List<String> comandi;
    @Override
    public void esegui(Partita partita) {
	   this.comandi = ClassFinder.getClassesInPackage(this.getClass().getPackage().getName());
	   for(String comando : this.comandi){
		   this.getIo().mostraMessaggio(comando);
	   }
    }

    @Override
    public String getNome() {
        return NOME;
    }
}