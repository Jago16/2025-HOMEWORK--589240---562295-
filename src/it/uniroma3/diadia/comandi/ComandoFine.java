package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	
	IOConsole io = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
	this.io.mostraMessaggio("Grazie di aver giocato!"); // 
	}
	
	@Override
	public void setParametro(String parametro) {
		return;
	}
}
