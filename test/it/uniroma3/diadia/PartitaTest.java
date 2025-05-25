package  it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitaTest {
	@Test
	public void testNonVinta() {
		Stanza s1 = new Stanza("N11");
		Stanza s2 = new Stanza("N12");
		assertFalse(partita(false, s1, s2,1).vinta());
	}
	public void testVinta() {
		Stanza s1 = new Stanza("N11");
		assertTrue(partita(true, s1, s1,1).vinta());
	}
	
	@Test
	public void testPartitaFinita() {
		Stanza s1 = new Stanza("N11");
		Stanza s2 = new Stanza("N12");
		assertTrue(partita(true, s1, s2,1).isFinita());
	}
	@Test
	public void testPartitaNonFinita() {
		Stanza s1 = new Stanza("N11");
		Stanza s2 = new Stanza("N12");
		assertFalse(partita(false, s1, s2,1).isFinita());
	}
	@Test
	public void testPartitaFinitaVintaNonFinita() {
		Stanza s1 = new Stanza("N11");
		assertTrue(partita(false, s1, s1, 1).isFinita());
	}
	@Test
	public void testPartitaCfuFiniti() {
		Stanza s1 = new Stanza("N11");
		Stanza s2 = new Stanza("N12");
		assertTrue(partita(false, s1, s2,0).isFinita());
	}
	
	


private Partita partita(boolean finita, Stanza corrente, Stanza vincente, int cfu) {
	Partita p = new Partita();
	p.getLabirinto().setStanzaCorrente(corrente);
	p.getLabirinto().setStanzaVincente(vincente);
	p.getGiocatore().setCfu(cfu);
	if(finita) p.setFinita();
	return p;
}
}

