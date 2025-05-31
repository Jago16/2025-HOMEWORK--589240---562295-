package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	final static String NOME_ATTREZZO_SBLOCCANTE = "chiave";

	String direzioneBloccata;
	String attrezzoCheSblocca;

	public StanzaBloccata(String nome, String direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoCheSblocca = NOME_ATTREZZO_SBLOCCANTE;
	}

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoCheSblocca = attrezzo;
	}	
	

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if(this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(this.attrezzoCheSblocca)) {
			stanza = this;
		}
		else {
			stanza = super.getStanzaAdiacente(direzione);
		}
		return stanza;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoCheSblocca)) {
			return super.getDescrizione();
		}
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\n-> DIREZIONE "+this.direzioneBloccata+" BLOCCATA <-");
		risultato.append("\nUscite: ");
		for (String direzione : super.getStanzeAdiacenti().keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo a : super.getAttrezzi()) {
			risultato.append(a.toString()+" ");
		}
		return risultato.toString();
	}
}