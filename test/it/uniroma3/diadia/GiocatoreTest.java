package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	public Giocatore giocatore;

	@BeforeEach
	public void setUp() throws Exception{
		this.giocatore = new Giocatore();
	}
	
	@Test
	void testGetCfu() {
		assertEquals(5, this.giocatore.getCfu());
	}

	@Test
	void testSetCfu() {
		this.giocatore.setCfu(15);
		assertEquals(15, this.giocatore.getCfu());
	}
	
}
