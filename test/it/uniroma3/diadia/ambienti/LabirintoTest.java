package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;

	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addStanzaVincente("Fine")
				.addAdiacenza("Inizio","Fine","Nord")
				.getLabirinto();

		this.stanzaIniziale = new Stanza("Inizio");
		this.stanzaVincente = new Stanza("Fine");

	}

	@Test
	public void testGetStanzaVincente_Vincente() {
		assertTrue(this.labirinto.getStanzaVincente().getNome().equals(this.stanzaVincente.getNome()));
	}

	@Test
	public void testGetStanzaVincente_Perdente() {
		assertFalse(this.labirinto.getStanzaVincente().getNome().equals(this.stanzaIniziale.getNome()));
	}

	@Test
	public void testGetStanzaIniziale_TRUE() {
		assertTrue(this.labirinto.getStanzaIniziale().getNome().equals(this.stanzaIniziale.getNome()));
	}

	@Test
	public void testGetStanzaIniziale_FALSE() {
		assertFalse(this.labirinto.getStanzaIniziale().getNome().equals(this.stanzaVincente.getNome()));
	}
}
