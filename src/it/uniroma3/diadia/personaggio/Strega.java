package it.uniroma3.diadia.personaggio;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_BUONO = "Grazie per avermi salutato, "+
			"ti porto in un posto speciale!!";
	
	private static final String MESSAGGIO_CATTIVO = "Impara l'educazione, vattene via di qui!";
	private static final String RISATA = "AHHAAHHAHAHAHAHAHAHHAHAAAAHAHAHAHAHAHAHAHHAHAHAHHAHAHAHAHAHAHHAAH";
	private static final String PRESENTAZIONE = "Sono molto permalosa";


	public Strega(String nome) {
		super(nome, PRESENTAZIONE);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.haSalutato())
			msg = MESSAGGIO_BUONO;
		msg = MESSAGGIO_CATTIVO;
		partita.setStanzaCorrente(partita.getStanzaCorrente().stanzaPiùMenoAttrezzi(partita.getStanzaCorrente().getMapStanzeAdiacenti(), this.haSalutato()));
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {		
		this.attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return RISATA;
	}

}

