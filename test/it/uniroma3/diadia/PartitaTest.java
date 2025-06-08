package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class PartitaTest {
	Labirinto labirinto;
	Partita partitaFinita_CFU;
	Partita partitaFinita_Vinta;
	Partita partitaFinita_Finita;
	Partita partitaNonFinita;
	
	@Before
	public void setUp() {
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Inizio")
				.addStanzaVincente("Fine")
				.getLabirinto();
		this.partitaFinita_CFU = new Partita(this.labirinto);
		this.partitaFinita_Vinta = new Partita(this.labirinto);
		this.partitaFinita_Finita= new Partita(this.labirinto); 
		this.partitaNonFinita = new Partita(labirinto);
		this.partitaFinita_CFU.getGiocatore().setCfu(0);
		this.partitaFinita_Vinta.setStanzaCorrente(this.labirinto.getStanzaVincente());
		this.partitaFinita_Finita.setFinita();
	}
	
	@Test
	public void testPartitaFinita_CFU() {
		assertTrue(this.partitaFinita_CFU.isFinita());
	}
	
	@Test
	public void testPartitaFinita_Vinta() {
		assertTrue(this.partitaFinita_Vinta.isFinita());
	}
	
	@Test
	public void testPartitaFinita_Finita() {
		assertTrue(this.partitaFinita_Finita.isFinita());
	}
	
	@Test
	public void testPartitaNonFinita() {
		assertFalse(this.partitaNonFinita.isFinita());
	}
}
