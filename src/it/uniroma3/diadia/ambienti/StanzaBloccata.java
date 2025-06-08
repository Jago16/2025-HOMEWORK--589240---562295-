package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBloccata - una stanza da cui non si può uscire senza un determinato attrezzo
 * che sblocca la stanza
 * @see Stanza
 * @see Attrezzo
 * @version 1.0
 */
public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String sbloccaStanza;

	public StanzaBloccata(String nome,String direzioneBloccata,String sbloccaStanza) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.sbloccaStanza = sbloccaStanza;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir == this.direzioneBloccata) {
			if(this.hasAttrezzo(this.sbloccaStanza))
				super.getStanzaAdiacente(dir);
			else
				return this;
		}
		return super.getStanzaAdiacente(dir);
	}

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.sbloccaStanza)) 
			return "Direzione" +this.direzioneBloccata+" bloccata"+
			"hai bisogno di "+this.sbloccaStanza+" per sbloccarla"+
			"Informazioni sulla stanza"+
			super.toString();

		return super.toString();
	}
}

