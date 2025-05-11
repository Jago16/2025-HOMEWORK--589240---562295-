package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {
	private Partita partitaStanzaVuota;
	private Partita partitaStanzaPiena;
	private Labirinto labirintoStanzaVuota;
	private Labirinto labirintoStanzaPiena;
	private ComandoPosa comandoPosa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoRifiutato;

	@Before
	public void setUp() {
		this.labirintoStanzaVuota = new Labirinto();
		this.partitaStanzaVuota = new Partita(labirintoStanzaVuota);
		this.comandoPosa = new ComandoPosa();
		this.attrezzo = new Attrezzo("Attrezzo", 0);
		this.partitaStanzaVuota.getGiocatore().getBorsa().addAttrezzo(attrezzo);

		this.attrezzoRifiutato = new Attrezzo("Rifiutato", 0);
		this.labirintoStanzaPiena = new Labirinto();
		this.partitaStanzaPiena = new Partita(this.labirintoStanzaPiena);
		for(int i=0;i<10;i++) 
			this.partitaStanzaPiena.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		this.partitaStanzaPiena.getGiocatore().getBorsa().addAttrezzo(attrezzoRifiutato);
	}

	@Test
	public void testComandoPosa_InserimentoApprovato_AttrezzoPosato(){
		assertFalse(this.partitaStanzaVuota.getStanzaCorrente().hasAttrezzo("Attrezzo"));
		this.comandoPosa.setParametro("Attrezzo");
		this.comandoPosa.esegui(partitaStanzaVuota);
		assertTrue(this.partitaStanzaVuota.getLabirinto().getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	public void testComandoPosa_AttrezzoInesistente() {
		this.comandoPosa.setParametro("Inesistente");
		this.comandoPosa.esegui(partitaStanzaVuota);
		assertFalse(this.partitaStanzaVuota.getStanzaCorrente().hasAttrezzo("Inesistente"));
	}

	@Test
	public void testComandoPosa_InserimentoRifiutato() {
		this.comandoPosa.setParametro("Rifiutato");
		this.comandoPosa.esegui(partitaStanzaPiena);
		assertFalse(this.partitaStanzaPiena.getStanzaCorrente().hasAttrezzo("Rifiutato"));
	}
}