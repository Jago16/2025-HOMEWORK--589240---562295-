package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza vuota;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Stanza stanzaPiuElementi;
	
	@Before
	public void setUp() {
		this.vuota = new Stanza("Vuota");
		this.stanza = new Stanza("Stanza");
		this.attrezzo = new Attrezzo("Attrezzo", 0);
		this.stanza.addAttrezzo(this.attrezzo);
		this.attrezzo2 = new Attrezzo("Attrezzo2",0);
		this.attrezzo3 = new Attrezzo("Attrezzo3", 0);
		this.stanzaPiuElementi = new Stanza("Più elementi");
		this.stanzaPiuElementi.addAttrezzo(attrezzo);
		this.stanzaPiuElementi.addAttrezzo(attrezzo2);
		this.stanzaPiuElementi.addAttrezzo(attrezzo3);
	}

	@Test
	public void testGetAttrezzo_StanzaVuota() {
		assertNull(this.vuota.getAttrezzo("Inesistente"));
	}

	@Test
	public void testGetAttrezzo_StanzaNonVuota_Presente() {
		assertNotNull(stanza.getAttrezzo("Attrezzo"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Assente() {
		assertNull(stanza.getAttrezzo("nomeDiAttrezzoNonPresente"));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaVuota() {
		assertFalse(this.vuota.removeAttrezzo(this.attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaNonVuota_Presente() {
		assertTrue(this.stanza.removeAttrezzo(this.attrezzo));
		assertFalse(this.stanza.hasAttrezzo("Attrezzo"));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaNonVuota_Assente() {
		assertFalse(this.stanza.removeAttrezzo(attrezzo2));
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaPiuElementi() {
		assertTrue(this.stanzaPiuElementi.removeAttrezzo(attrezzo));
		assertFalse(this.stanzaPiuElementi.hasAttrezzo("Attrezzo"));
	}
}