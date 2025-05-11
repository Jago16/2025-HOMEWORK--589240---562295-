package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata bloccata;
	private StanzaBloccata nonBloccata;
	private Attrezzo sblocca;
	
	@Before
	public void setUp() {
		this.bloccata = new StanzaBloccata("Bloccata", "nord", "Chiave");
		this.nonBloccata = new StanzaBloccata("Sbloccata","nord", "Chiave");
		this.sblocca = new Attrezzo("Chiave", 0);
		this.nonBloccata.addAttrezzo(sblocca);
		this.nonBloccata.impostaStanzaAdiacente("nord", bloccata);
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaBloccata_Bloccata() {
		assertEquals(this.bloccata,this.bloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteStanzaBloccata_NonBloccata() {
		assertEquals(this.nonBloccata.getStanzaAdiacente("nord"),this.bloccata);
	}
}