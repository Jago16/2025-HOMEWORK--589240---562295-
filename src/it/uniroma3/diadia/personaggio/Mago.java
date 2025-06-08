package it.uniroma3.diadia.personaggio;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " + 
			"con una mia magica azione, troverai un nuovo oggetto " +
			" per il tuo borsone";
	
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla...";
	
	private static final String  PRESENTAZIONE = "Se mi saluterai riceverai un dono speciale";
	
	
	public Mago(String nome, Attrezzo attrezzo) {
		super(nome,PRESENTAZIONE);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		if(this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			return MESSAGGIO_DONO;
		}
		return MESSAGGIO_SCUSE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		Attrezzo cadeNellaStanza = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(cadeNellaStanza);
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return "Ho lasciato cadere "+attrezzo.getNome()+" nella stanza e ne ho dimezzato il peso";
	}
}
