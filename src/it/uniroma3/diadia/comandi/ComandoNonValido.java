package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private IO ioConsole;
	private String parametro;

	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		ioConsole.mostraMessaggio("Comando non valido");
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {
		return null;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}
}
