package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	IOConsole console = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio("il comando inserito non e' valido.");
		
	}

	@Override
	public void setParametro(String parametro) {
		return;	
	}

}
