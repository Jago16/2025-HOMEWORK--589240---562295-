package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoFine implements Comando{

	IO io = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("Grazie di aver giocato!"); // 
	}

	@Override
	public void setParametro(String parametro) {
		return;
	}
}
