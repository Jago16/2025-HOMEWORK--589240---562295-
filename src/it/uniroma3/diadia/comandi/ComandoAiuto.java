package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private IO ioConsole;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa","guarda"};


/**
 * Stampa l'elenco dei comandi
 */
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			this.ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		this.ioConsole.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}
}
