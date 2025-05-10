package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	IOConsole console = new IOConsole();
	
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente() + 
				"hai ");
		console.mostraMessaggio(partita.getGiocatore().getCfu() + 
				" cfu rimanenti ");
		
	}

	@Override
	public void setParametro(String parametro) {
		return;
	}

	
	
	
}
