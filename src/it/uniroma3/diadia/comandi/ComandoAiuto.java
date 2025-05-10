package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoAiuto implements Comando{
	
	IOConsole io = new IOConsole();

	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa" };


	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i] + " ");
			System.out.println();
	}


	@Override
	public void setParametro(String parametro) {
		return ;
	}
}
