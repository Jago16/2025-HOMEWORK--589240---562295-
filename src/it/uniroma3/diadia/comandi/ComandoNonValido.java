package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void setParametro(String parametro) {
		return;	
	}

	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("il comando inserito non e' valido.");
		
	}


}
