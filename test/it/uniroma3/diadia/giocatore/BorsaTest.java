package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Borsa borsaConUnElemento;
	private Borsa borsaConDueElementi;
	private Borsa borsaConTreElementi;
	private Borsa borsaVuota;
	private Borsa borsaPesante;
	
	@Before
	public void setUp() {
		this.borsaConUnElemento = new Borsa();
		this.borsaConTreElementi = new Borsa();
		this.borsaConDueElementi = new Borsa();
		this.borsaVuota = new Borsa();
		this.borsaPesante = new Borsa();
		this.borsaConUnElemento.addAttrezzo(new Attrezzo("lanterna", 4));
		this.borsaPesante.addAttrezzo(new Attrezzo("lanterna", 10));
		this.borsaConDueElementi.addAttrezzo(new Attrezzo("proiettore", 4));
		this.borsaConDueElementi.addAttrezzo(new Attrezzo("penna", 1));
		this.borsaConTreElementi.addAttrezzo(new Attrezzo("proiettore", 4));
		this.borsaConTreElementi.addAttrezzo(new Attrezzo("penna", 1));
		this.borsaConTreElementi.addAttrezzo(new Attrezzo("gesso", 1));
	}
	
	@Test 
	public void testBorsaVuota(){
		assertTrue(this.borsaVuota.isEmpty());
	}
	@Test 
	public void testBorsaConUnElemento(){
		assertFalse(this.borsaConUnElemento.isEmpty());
	}
	/* Test minimal per addAttrezzo*/
	@Test
	public void testAddAttrezzoBorsaVuota() {
		assertTrue(this.borsaVuota.addAttrezzo(new Attrezzo("gesso", 1)));
	}
	@Test
	public void testAddAttrezzoBorsaConUnElemento() {
		assertTrue(this.borsaConUnElemento.addAttrezzo(new Attrezzo("gesso", 1)));
	}
	@Test
	public void testAddAttrezzoBorsaPesante() { 
		assertFalse(this.borsaPesante.addAttrezzo(new Attrezzo("gesso", 1)));
	}
	
	/* Test minimal per getPeso*/
	@Test
	public void testGetPesoNullo() {
		assertEquals(0, this.borsaVuota.getPeso());
	}
	@Test
	public void testGetPesoMassimo() { 
		assertEquals(10, this.borsaPesante.getPeso());
	}

	/* Test minimal per removeAttrezzo*/
	@Test
	public void testRemoveAttrezzoBorsaConUnElementoAssente() {
		assertEquals(null, this.borsaConUnElemento.removeAttrezzo("gesso"));
	}
	@Test
	public void testRemoveAttrezzoBorsaVuota() {
		assertNull(this.borsaVuota.removeAttrezzo("gesso"));
		
	}
	@Test
	public void testRemoveAttrezzoBorsaConTreElementi() {
		assertEquals("gesso",this.borsaConTreElementi.removeAttrezzo("gesso").getNome());
	}
}
