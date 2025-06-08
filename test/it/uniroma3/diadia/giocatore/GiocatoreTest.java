package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {

	Giocatore giocatoreBlank;
	Giocatore giocatore;
	Attrezzo attrezzo;

	@Before
	public void setUp() {
		this.giocatoreBlank = new Giocatore();
		this.giocatore = new Giocatore();
		this.attrezzo = new Attrezzo("Attrezzo", 0);
		this.giocatore.setCfu(10);
		this.giocatore.mettiInBorsa(attrezzo);
	}

	@Test
	public void testCFU_GiocatoreBlank() {
		assertEquals(20,this.giocatoreBlank.getCfu());
	}

	@Test
	public void testCFU_Giocatore() {
		assertEquals(10,this.giocatore.getCfu());	
	}

	@Test
	public void testMettiInBorsa_Presente() {
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("Attrezzo"));
	}

	@Test
	public void testMettiInBorsa_Assente() {
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("Inesistente"));
	}
}
