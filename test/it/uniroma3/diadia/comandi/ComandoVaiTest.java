package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;


public class ComandoVaiTest {

	private Partita partita;
	private Labirinto monolocale;
	private Labirinto bilocale;
	private ComandoVai comandoVai;

	@Before
	public void setUp() {
		this.monolocale = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addStanzaVincente("Fine")
				.getLabirinto();

		this.bilocale = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addStanzaVincente("Fine")
				.addAdiacenza("Inizio","Fine","Nord")
				.getLabirinto();

		this.comandoVai = new ComandoVai();
	}

	@Test
	public void testComandoVai_DirezioneEsistente() {
		this.partita = new Partita(this.bilocale);
		this.comandoVai.setParametro("Nord");
		this.comandoVai.esegui(partita);
		assertEquals(this.partita.getStanzaCorrente().getNome(),"Fine");
		assertEquals(this.partita.getGiocatore().getCfu(),19);
	}

	@Test
	public void testComandoVai_DirezioneInesistente() {
		this.partita = new Partita(this.monolocale);
		this.comandoVai.setParametro("Sud");
		this.comandoVai.esegui(partita);
		this.comandoVai.esegui(partita);	//Dato che la direzione è inesistente resto nella stanza corrente
		assertEquals(this.partita.getStanzaCorrente().getNome(),"Inizio");
		assertEquals(this.partita.getGiocatore().getCfu(),20);
	}
}
