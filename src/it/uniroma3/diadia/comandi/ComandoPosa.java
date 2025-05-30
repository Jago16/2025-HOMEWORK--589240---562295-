package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	
	public ComandoPosa(String attrezzo) {
		this.nomeAttrezzo = attrezzo;
	}
	
	public ComandoPosa() {
		this.nomeAttrezzo = null;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public void esegui(Partita partita) {
		
		boolean trovato = false;
		// attrezzi posati vengono rimossi dalla borsa e aggiunti nella stanza corrente
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			trovato = true;
			Attrezzo daPosare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(daPosare);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		}
		if (!trovato) {
			partita.getConsole().mostraMessaggio("attrezzo non trovato");
		} else {
			partita.getConsole().mostraMessaggio("attrezzo " + nomeAttrezzo + " e' stato posato");
		}
		
	}



	
	
	
}
