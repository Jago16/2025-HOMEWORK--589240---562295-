package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
		private String nomeAttrezzo;
	
		public ComandoPrendi(String attrezzo) {
			this.nomeAttrezzo = attrezzo;
		}
		@Override
		public void setParametro(String parametro) {
			this.nomeAttrezzo = parametro;
		}

		@Override
		public void esegui(Partita partita) {
			boolean trovato = false;
					if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
						trovato = true;
						Attrezzo daRimuovere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
						partita.getConsole().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
						// rimuovi attrezzo dalla stanza
						partita.getLabirinto().getStanzaCorrente().removeAttrezzo(daRimuovere);
						partita.getGiocatore().getBorsa().addAttrezzo(daRimuovere);
					}
			
					if (!trovato) {
						partita.getConsole().mostraMessaggio("L'attrezzo non e' presente nella stanza !");
					} else {
						partita.getConsole().mostraMessaggio("attrezzo " + nomeAttrezzo + " e' stato preso");
					}
			
		}
		
		
}
