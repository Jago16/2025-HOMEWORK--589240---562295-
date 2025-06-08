package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private IO ioConsole;
	

	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		this.ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "fine";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
