package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private StanzaBuia stanzaIlluminata;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("Buia", "Lanterna");
		this.stanzaIlluminata = new StanzaBuia("Illuminata", "Lanterna");
		this.lanterna = new Attrezzo("Lanterna", 0);
		this.stanzaIlluminata.addAttrezzo(lanterna);
	}
	
	@Test
	public void testGetDescrizioneStanzaBuia_Buia() {
		assertEquals(this.stanzaBuia.getDescrizione(),"Qui c'è un buio pesto");
	}
	
	@Test
	public void testGetDescrizioneStanzaBuia_Illuminata() {
		assertFalse(this.stanzaIlluminata.getDescrizione()=="Qui c'è un buio pesto");
	}
}
