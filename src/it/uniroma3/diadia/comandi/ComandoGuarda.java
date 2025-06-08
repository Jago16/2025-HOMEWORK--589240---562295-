package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IO ioConsole;
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		ioConsole.mostraMessaggio("Informazioni sulla stanza: " + partita.getStanzaCorrente());
		ioConsole.mostraMessaggio("Informazioni sul giocatore: " + partita.getGiocatore().getCfu()+" CFU");
		ioConsole.mostraMessaggio("Informazioni sulla borsa del giocatore:\n" + partita.getGiocatore().getBorsa());
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
