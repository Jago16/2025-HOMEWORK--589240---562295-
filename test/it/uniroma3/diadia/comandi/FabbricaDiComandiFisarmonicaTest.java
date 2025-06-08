package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbricaDiComandiFisarmonica;
	private Comando comando;
	
	@Before
	public void setUp() {
		this.fabbricaDiComandiFisarmonica = new FabbricaDiComandiFisarmonica();
		this.comando=null;
		
	}
	
	@Test
	public void testComandoAiuto() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("aiuto");
		assertEquals(comando.getNome(),"aiuto");
	}
	
	@Test
	public void testComandoFine() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("fine");
		assertEquals(comando.getNome(),"fine");
	}
	
	@Test
	public void testComandoGuarda() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("guarda");
		assertEquals(comando.getNome(),"guarda");
	}
	
	@Test
	public void testComandoNonValido() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("");
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPosa() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("posa attrezzo");
		assertEquals(comando.getNome(),"posa");
		assertEquals(comando.getParametro(),"attrezzo");
	}
	
	@Test
	public void testComandoPrendi() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("prendi attrezzo");
		assertEquals(comando.getNome(),"prendi");
		assertEquals(comando.getParametro(),"attrezzo");
	}
	
	@Test
	public void testComandoVai() {
		this.comando=this.fabbricaDiComandiFisarmonica.costruisciComando("vai direzione");
		assertEquals(comando.getNome(),"vai");
		assertEquals(comando.getParametro(),"direzione");
	}
}
