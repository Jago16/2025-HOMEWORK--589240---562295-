package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
		private String nomeAttrezzo;
		private IOConsole console = new IOConsole();
		
		public ComandoPrendi(String attrezzo) {
			this.nomeAttrezzo = attrezzo;
		}
		@Override
		public void setParametro(String parametro) {
			
		}

		@Override
		public void esegui(Partita partita) {
			boolean trovato = false;
					if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
						trovato = true;
						Attrezzo daRimuovere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
						this.console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
						// rimuovi attrezzo dalla stanza
						partita.getLabirinto().getStanzaCorrente().removeAttrezzo(daRimuovere);
						partita.getGiocatore().getBorsa().addAttrezzo(daRimuovere);
					}
			
					if (!trovato) {
						this.console.mostraMessaggio("L'attrezzo non e' presente nella stanza !");
					} else {
						this.console.mostraMessaggio("attrezzo " + nomeAttrezzo + " e' stato preso");
					}
			
		}
		
		
}


//private void prendi(String nomeAttrezzo) {
//

//
//	}
