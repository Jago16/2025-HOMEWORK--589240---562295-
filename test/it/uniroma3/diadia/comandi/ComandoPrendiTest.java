package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {
	
	private Partita partita;
	private IOConsole console;
	
	@Before
	public void setUp() {
		
		this.console = new IOConsole();
		this.partita = new Partita(this.console);
		//this.partita.setConsole(console);
	}

	@Test
	public void eseguiTestAttrezzoNulloNonSiTroviNellaBorsa() {
		Comando comando=new ComandoPrendi("attrezzo_inesistente");
		comando.esegui(this.partita);	
		assertNull(this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo_inesistente"));
	}
	
	@Test
	public void eseguiTestAttrezzoNulloNonSiTroviNellaStanza() {
		Comando comando=new ComandoPrendi("attrezzo_inesistente");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getLabirinto().getStanzaCorrente().getAttrezzo("attrezzo_inesistente"));
	}
	
	@Test
	public void eseguiTestAttrezzoEsistenteVerificaCheSiTroviNellaBorsa() {
		Attrezzo attrezzo=new Attrezzo("attrezzo",1);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		Comando comando=new ComandoPrendi("attrezzo");
		comando.esegui(this.partita);
		
		assertEquals(attrezzo,this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo"));
	}
	
	@Test
	public void eseguiTestAttrezzoEsistenteVerificaCheNonSiTroviNellaStanza() {
		Attrezzo attrezzo=new Attrezzo("attrezzo",1);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		Comando comando=new ComandoPrendi("attrezzo");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getLabirinto().getStanzaCorrente().getAttrezzo("attrezzo"));
	}
	
	@Test
	public void eseguiTestBorsaPienaAttrezzoNonSiTroviNellaBorsa() {
		for(int i=0;i<10;i++) {
			Attrezzo attrezzo=new Attrezzo("attrezzo",0);
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		}
		Attrezzo attrezzoDaPrendere=new Attrezzo("attrezzo_da_prendere",1);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPrendere);
		Comando comando=new ComandoPrendi("attrezzo_da_prendere");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo_da_prendere"));
	}
	

	@Test
	public void eseguiTestBorsaConPesoMaxAttrezzoNonSiTroviNellaBorsa() {
		Attrezzo attrezzo=new Attrezzo("attrezzo",10);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		Attrezzo attrezzoDaPrendere=new Attrezzo("attrezzo_da_prendere",1);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPrendere);
		Comando comando=new ComandoPrendi("attrezzo_da_prendere");
		comando.esegui(this.partita);
		
		assertEquals(null,this.partita.getGiocatore().getBorsa().getAttrezzo("attrezzo_da_prendere"));
	}


}