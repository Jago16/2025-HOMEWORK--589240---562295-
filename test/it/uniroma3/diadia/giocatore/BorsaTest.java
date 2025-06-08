package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Borsa borsaPiùAttrezzi;
	private Borsa borsaDaOrdinare_Piena;
	private Attrezzo attrezzo;
	private Attrezzo spada;
	private Attrezzo torcia;
	private Attrezzo scudo;
	private Attrezzo stessoPesoTorcia;

	@Before
	public void setUp(){
		this.borsaVuota = new Borsa();

		this.borsaPiena = new Borsa();
		this.spada = new Attrezzo("Spada",10);
		this.borsaPiena.addAttrezzo(this.spada);

		this.borsaPiùAttrezzi = new Borsa(20);
		this.scudo = new Attrezzo("Scudo",5);
		this.torcia = new Attrezzo("Torcia", 2);
		this.borsaPiùAttrezzi.addAttrezzo(this.scudo);
		this.borsaPiùAttrezzi.addAttrezzo(this.torcia);
		this.attrezzo = new Attrezzo("Attrezzo", 10);

		this.borsaDaOrdinare_Piena = new Borsa();
		this.stessoPesoTorcia = new Attrezzo("Stesso peso torcia", 2);
		this.borsaDaOrdinare_Piena.addAttrezzo(this.torcia);
		this.borsaDaOrdinare_Piena.addAttrezzo(this.scudo);
		this.borsaDaOrdinare_Piena.addAttrezzo(this.stessoPesoTorcia);
	}

	@Test
	public void testGetPesoBorsaVuota() {
		assertEquals(0, this.borsaVuota.getPeso());
	}


	@Test
	public void testGetPesoBorsa1Attrezzo_Piena() {
		assertEquals(10, this.borsaPiena.getPeso());
	}

	@Test
	public void testGetPesoBorsaPiùAttrezzi() {
		assertEquals(7, this.borsaPiùAttrezzi.getPeso());
	}

	@Test
	public void testInserimentoRifiutato_BorsaPiena() {
		assertFalse(this.borsaPiena.addAttrezzo(this.attrezzo));
	}

	@Test
	public void testInserimentoAccettato_BorsaPiùAttrezzi() {
		assertTrue(this.borsaPiùAttrezzi.addAttrezzo(this.spada));
	}

	@Test
	public void testGetAttrezzo_Presente() {
		assertEquals(this.torcia,this.borsaPiùAttrezzi.getAttrezzo("Torcia"));
	}

	@Test
	public void testGetAttrezzo_Assente() {
		assertNull(this.borsaPiena.getAttrezzo("Inesistente"));
	}

	@Test
	public void testRemoveAttrezzo_Rimosso() {
		assertTrue(this.borsaPiùAttrezzi.hasAttrezzo("Scudo"));
		this.borsaPiùAttrezzi.removeAttrezzo("Scudo");
		assertFalse(this.borsaPiùAttrezzi.hasAttrezzo("Scudo"));
	}

	@Test
	public void testRemoveAttrezzo_Inesistente() {
		assertNull(this.borsaPiùAttrezzi.removeAttrezzo("Inesistente"));
	}

	@Test
	public void testGetSortedSetOrdinatoPerPeso_BorsaPiena() {
		SortedSet<Attrezzo> ordinato = this.borsaDaOrdinare_Piena.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = ordinato.iterator();
		assertEquals(it.next(),this.stessoPesoTorcia);
		assertEquals(it.next(),this.torcia);
		assertEquals(it.next(),this.scudo);
	}

	@Test
	public void testGetSortedSetOrdinatoPerPeso_BorsaVuota() {
		assertNull(this.borsaVuota.getSortedSetOrdinatoPerPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaPiena() {
		List<Attrezzo> ordinata = this.borsaDaOrdinare_Piena.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = ordinata.iterator();
		assertEquals(it.next(),this.stessoPesoTorcia);
		assertEquals(it.next(),this.torcia);
		assertEquals(it.next(),this.scudo);
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso_BorsaVuota() {
		assertNull(this.borsaVuota.getContenutoOrdinatoPerPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome_BorsaPiena() {
		SortedSet<Attrezzo> ordinato = this.borsaDaOrdinare_Piena.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = ordinato.iterator();
		assertEquals(it.next(),this.scudo);
		assertEquals(it.next(),this.stessoPesoTorcia);
		assertEquals(it.next(),this.torcia);
	}

	@Test
	public void testGetContenutoOrdinatoPerNome_BorsaVuota() {
		assertNull(this.borsaVuota.getContenutoOrdinatoPerNome());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaPiena() {
		Map<Integer, Set<Attrezzo>> raggruppatoPerPeso = this.borsaDaOrdinare_Piena.getContenutoRaggruppatoPerPeso();
		assertEquals(2,raggruppatoPerPeso.get(2).size());		//Dimensione del set con oggetti di peso 2 (Torcia e Stesso peso torcia)
		assertEquals(1,raggruppatoPerPeso.get(5).size());		//Dimensione del set con oggetti di peso 1 (Solo scudo)

		//Controllo che nel set associato alla chiave 2 (peso degli oggett) ci siano gli oggetti giusti
		assertTrue(raggruppatoPerPeso.get(2).contains(this.torcia));
		assertTrue(raggruppatoPerPeso.get(2).contains(this.stessoPesoTorcia));

		//Controllo che nel set associato alla chiave 5 (peso degli oggett) ci siano gli oggetti giusti
		assertTrue(raggruppatoPerPeso.get(5).contains(this.scudo));
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso_BorsaVuota() {
		assertNull(this.borsaVuota.getContenutoRaggruppatoPerPeso());
	}
}

