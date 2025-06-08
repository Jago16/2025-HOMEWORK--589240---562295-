package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;



public class ComandoPrendiTest {
	private Partita partita;
	private Labirinto monolocale;
	private ComandoPrendi comandoPrendi;


	@Before
	public void setUp() {
		this.monolocale = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addAttrezzo("Attrezzo", 0)
				.addAttrezzo("Pesante", 1000)
				.addStanzaVincente("Finale")
				.getLabirinto();
		this.partita = new Partita(monolocale);
		this.comandoPrendi = new ComandoPrendi();
	}

	@Test
	public void testComandoPrendi_InserimentoApprovato() {
		this.comandoPrendi.setParametro("Attrezzo");
		this.comandoPrendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
	}

	@Test
	public void testComandoPrendi_AttrezzoInesistente() {
		this.comandoPrendi.setParametro("Inesistente");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Inesistente"));
	}

	@Test
	public void testComandoPrendi_BorsaPiena() {
		this.comandoPrendi.setParametro("Pesante");
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Pesante"));
	}
}
