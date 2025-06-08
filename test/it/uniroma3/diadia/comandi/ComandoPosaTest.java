package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {
	private Partita partita;
	private Labirinto monolocale;
	private ComandoPosa comandoPosa;

	@Before
	public void setUp() {
		this.monolocale = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addStanzaVincente("Finale")
				.getLabirinto();

		this.partita = new Partita(monolocale);
		this.comandoPosa = new ComandoPosa();
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("Attrezzo", 0));
	}

	@Test
	public void testComandoPosa_InserimentoApprovato_AttrezzoPosato(){
		this.comandoPosa.setParametro("Attrezzo");
		this.comandoPosa.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	public void testComandoPosa_AttrezzoInesistente() {
		this.comandoPosa.setParametro("Inesistente");
		this.comandoPosa.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("Inesistente"));
	}

	/*
	 * Test inutile a livello del diaDia ma utile al livello didattico, in quanto
	 * supponiamo che non ci sono due attrezzi con lo stesso nome nel labirinto
	@Test
	public void testComandoPosa_InserimentoAggiornato() {
		this.comandoPosa.setParametro("Attrezzo");
		this.comandoPosa.esegui(partitaStanzaConAttrezzo);
		assertEquals(this.partitaStanzaConAttrezzo.getStanzaCorrente().getAttrezzo("Attrezzo"),this.attrezzoStessoNome);
		assertNotEquals(this.partitaStanzaConAttrezzo.getStanzaCorrente().getAttrezzo("Attrezzo"),this.attrezzo);
	}*/
}
