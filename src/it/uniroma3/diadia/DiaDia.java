package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa" };

	private Partita partita;
	private IOConsole console;

	public DiaDia() {
		this.partita = new Partita();
		this.console = new IOConsole();
	}

	public void gioca() {
		String istruzione;

		System.out.println(MESSAGGIO_BENVENUTO);
		do
			istruzione = this.console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome() == null)
			return false;

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else {
			System.out.println("Comando sconosciuto");
		}
		if (this.partita.isFinita()) {
			if (this.partita.vinta())
				System.out.println("Hai vinto!");
			return true;
		}
		return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for (int i = 0; i < elencoComandi.length; i++)
			System.out.print(elencoComandi[i] + " ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if (direzione == null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		System.out.println(partita);
	}

	private void prendi(String nomeAttrezzo) {

		boolean trovato = false;

		if (this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			trovato = true;
			Attrezzo daRimuovere = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			System.out.println("trovato!");
			// rimuovi attrezzo dalla stanza
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(daRimuovere);
			this.partita.getGiocatore().getBorsa().addAttrezzo(daRimuovere);
		}

		if (!trovato) {
			System.out.println("attrezzo non trovato");
		} else {
			System.out.println("attrezzo " + nomeAttrezzo + " e' stato preso");
		}

	}

	private void posa(String nomeAttrezzo) {
		
		boolean trovato = false;
		//attrezzi posati vengono rimossi dalla borsa e aggiunti nella stanza corrente		
		if (this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			trovato = true;
			Attrezzo daPosare = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(daPosare);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
		if (!trovato) {
			System.out.println("attrezzo non trovato");
		} else {
			System.out.println("attrezzo " + nomeAttrezzo + " e' stato posato");
		}
			
		

	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {

		System.out.println("Grazie di aver giocato!"); // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}