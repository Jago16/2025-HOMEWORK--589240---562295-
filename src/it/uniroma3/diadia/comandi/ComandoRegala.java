package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	
	@Override
	public String getNome() {
		return "regala";
	}

	@Override
	public void esegui(Partita partita) {
		IOConsole io = new IOConsole();
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.parametro);
		if(attrezzo==null)
			io.mostraMessaggio("Non puoi regalare "+this.parametro+" se non lo hai");
		io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
	}

}
