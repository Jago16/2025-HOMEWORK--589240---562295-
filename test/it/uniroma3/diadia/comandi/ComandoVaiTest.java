package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


public class ComandoVaiTest {

    private Partita partita;
    private IOConsole io;

    @Before
    public void setUp() {
        this.partita = new Partita();
        this.io = new IOConsole();

        //this.partita.setConsole(io);
    }

    @Test
    public void eseguiTestConDirezioneNulla() {
        String direzione = null;
        Comando comando = new ComandoVai(direzione);
        comando.esegui(this.partita);

        assertEquals(this.partita.getLabirinto().getStanzaCorrente(),this.partita.getLabirinto().getStanzaCorrente());

    }

    @Test
    public void eseguiTestConDirezioneNonValida() {
        String direzione="nord-ovest";
        Comando comando=new ComandoVai(direzione);
        comando.esegui(this.partita);

        assertEquals(this.partita.getLabirinto().getStanzaCorrente(),this.partita.getLabirinto().getStanzaCorrente());
    }

    @Test
    public void eseguiTestConDirezioneCorretta() {
        String direzione="nord";
        Stanza stanza=new Stanza("stanza_test");
        this.partita.getLabirinto().getStanzaCorrente().impostaStanzaAdiacente(direzione, stanza);
        Comando comando=new ComandoVai(direzione);
        comando.esegui(this.partita);

        assertEquals(stanza,this.partita.getLabirinto().getStanzaCorrente());
    }
}


