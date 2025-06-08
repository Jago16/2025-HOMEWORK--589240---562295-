package it.uniroma3.diadia.personaggio;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO_CANE = "WOUF WOUF TI MORDO";
	
	private static final String PRESENTAZIONE = "BAU BAU";
	
	public Cane(String nome,Attrezzo attrezzo) {
		super(nome, PRESENTAZIONE);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_CANE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		//Il cibo preferito del cane è l'osso
		if(attrezzo.getNome()=="osso") {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());//Remove restituisce l'elemento rimosso dalla borsa e lo da al cane
			return "WOUF WOUF <3, tieni "+attrezzo;
		}
		return agisci(partita);
	}

}
