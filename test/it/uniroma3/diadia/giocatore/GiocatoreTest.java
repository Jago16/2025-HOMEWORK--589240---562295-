package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore g;
	Borsa borsa;
	
	@Before
	public void SetUp() {
		this.g=new Giocatore();
		this.borsa=new Borsa();
		this.g.setBorsa(this.borsa);
	}

	
	@Test
	public void testGetCFU() {
		assertEquals(20,this.g.getCfu());
	}
	
	@Test
	public void testSetCFU() {
		this.g.setCfu(15);
		assertEquals(15,this.g.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		assertEquals(borsa,this.g.getBorsa());
	}
	
	@Test
	public void testSetBorsa() {
		Borsa b=new Borsa();
		this.g.setBorsa(b);
		assertEquals(b,this.g.getBorsa());
	}
}
