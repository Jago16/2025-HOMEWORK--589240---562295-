package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{


	@Override
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		partita.getConsole().mostraMessaggio("CFU rimasti:  " + partita.getGiocatore().getCfu());
	}

	/*
	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio(partita.getLabirinto().getStanzaCorrente() + "hai ");
		partita.getConsole().mostraMessaggio(partita.getGiocatore().getCfu() + " cfu rimanenti ");
	}
	 */


}
