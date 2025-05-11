package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanzaBuia = new StanzaBuia("Buia", "Lanterna");
	private StanzaBuia stanzaIlluminata = new StanzaBuia("Illuminata", "Lanterna");
	private Attrezzo lanterna = new Attrezzo("Lanterna", 0);

	@Test
	public void testGetDescrizioneStanzaBuia_Buia() {
		assertEquals(this.stanzaBuia.getDescrizione(),"Qui c'e' un buio pesto!");
	}
	
	@Test
	public void testGetDescrizioneStanzaBuia_Illuminata() {
	this.stanzaIlluminata.addAttrezzo(lanterna);
		assertNotEquals(this.stanzaIlluminata.getDescrizione(), "Qui c'e' un buio pesto!");
	}
	
}