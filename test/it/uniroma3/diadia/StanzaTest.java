package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza stanza;
	private Attrezzo spada;

	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("n11");
		this.spada = new Attrezzo("spada", 5);
	}

	@Test
	void testHasAttrezzo() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.hasAttrezzo("spada"));
	}

	@Test
	void testImpostaStanzaAdiacenteSingola() {
		Stanza stanzaTest = new Stanza("stanzaTest");
		this.stanza.impostaStanzaAdiacente("nord", stanzaTest);
		assertEquals(stanzaTest, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAggiornandoStanzaPrecedentementeInserita() {
		Stanza stanzaTest = new Stanza("stanzaTest");
		Stanza nuovaStanzaTest = new Stanza("nuovaStanzaTest");
		this.stanza.impostaStanzaAdiacente("nord", stanzaTest);
		assertEquals(stanzaTest, this.stanza.getStanzaAdiacente("nord"));
		this.stanza.impostaStanzaAdiacente("nord", nuovaStanzaTest);
		assertEquals(nuovaStanzaTest, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaDirezioneSbagliata() {
		Stanza stanzaTest = new Stanza("stanzaTest");
		this.stanza.impostaStanzaAdiacente("WEST", stanzaTest);
		assertNotEquals(stanzaTest, this.stanza.getStanzaAdiacente("WEST"));
		
	}
	
	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo("spada"));
	}

	@Test
	void testRemoveAttrezzo() {
		assertFalse(this.stanza.removeAttrezzo(spada));
		this.stanza.addAttrezzo(this.spada);
		assertTrue(this.stanza.removeAttrezzo(spada));
	}

}
