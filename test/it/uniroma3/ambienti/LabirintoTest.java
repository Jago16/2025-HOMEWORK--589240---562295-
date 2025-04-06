package it.uniroma3.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {

	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
	}

	@Test
	void testCreaLabirinto() {
		assertNotNull(new Labirinto());
	}

	@Test
	void testSetStanzaIniziale() {
		Stanza stanzaIniziale = new Stanza("stanza di test");
		this.labirinto.setStanzaCorrente(stanzaIniziale);
		assertEquals(stanzaIniziale, labirinto.getStanzaCorrente());
	}

	@Test
	void testStanzaVincente() {
		Stanza vincente = new Stanza("questa vince");
		this.labirinto.setStanzaVincente(vincente);
		assertEquals(vincente, this.labirinto.getStanzaVincente());
	}

}
