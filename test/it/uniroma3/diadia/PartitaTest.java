package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private Stanza vincente;

	@BeforeEach
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.vincente = new Stanza("Biblioteca");
	}

	@Test
	public void testNuovaPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}

	@Test
	public void testPartitaVinta() {
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testPartitaPersa() {
		partita.getGiocatore().setCfu(0);
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testPartitaFinitaENonFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
