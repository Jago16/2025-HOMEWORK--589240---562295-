package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzoCheNonCambia;
	private Attrezzo attrezzoCheCambia;
	
	@Before
	public void setUp() {
		this.stanzaMagica = new StanzaMagica("Stanza magica",1);
		this.attrezzoCheNonCambia = new Attrezzo("Attrezzo che non cambia", 4);
		this.attrezzoCheCambia = new Attrezzo("Attrezzo che cambia",4);
	}
	
	@Test
	public void testComportamentoMagico() {
		this.stanzaMagica.addAttrezzo(attrezzoCheNonCambia);
		assertTrue(this.stanzaMagica.hasAttrezzo("Attrezzo che non cambia"));
		assertEquals(this.stanzaMagica.getAttrezzo("Attrezzo che non cambia").getPeso(),4);
		
		this.stanzaMagica.addAttrezzo(attrezzoCheCambia);
		assertTrue(this.stanzaMagica.hasAttrezzo("aibmac ehc ozzerttA"));
		assertEquals(this.stanzaMagica.getAttrezzo("aibmac ehc ozzerttA").getPeso(),8);
	}
}
