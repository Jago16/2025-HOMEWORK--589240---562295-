package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String parametro;
	private IO ioConsole;
	/**
	 * Metodo che rimuove un attrezzo dalla stanza e lo mette nella borsa 
	 * @param partita sulla quale fare le modifiche
	 */
	@Override
	public void esegui(Partita partita) {
		this.ioConsole = new IOConsole();
		if(!partita.getStanzaCorrente().hasAttrezzo(this.parametro)) {
			ioConsole.mostraMessaggio("Attrezzo inesitente");
			return;
		}

		Attrezzo attrezzo;
		attrezzo=partita.getStanzaCorrente().getAttrezzo(this.parametro);
		if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {		//Controllo che posso aggiungere l'attrezzo
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			ioConsole.mostraMessaggio("Hai preso l'attrezzo");
		}else {
			this.ioConsole.mostraMessaggio("Non hai spazio in borsa");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

}