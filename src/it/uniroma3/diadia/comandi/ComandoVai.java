package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
    private String direzione;

    public ComandoVai(String direzione) {
        this.direzione = direzione;
    }
    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        Stanza prossimaStanza = null;

        if (direzione == null) {
        	partita.getConsole().mostraMessaggio("Dove vuoi andare?");
        	partita.getConsole().mostraMessaggio("Devi specificare una direzione");
            return;
        }

        prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
        	partita.getConsole().mostraMessaggio("Direzione inesistente");
            return;
        }

        partita.getLabirinto().setStanzaCorrente(prossimaStanza);
        partita.getConsole().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
}