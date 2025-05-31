package it.uniroma3.diadia.ambienti;

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
		for (String direzione : super.getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (int i=0; i<super.getNumeroAttrezzi(); i++) {
			risultato.append(super.getAttrezzi()[i].toString()+" ");
		}
		return risultato.toString();
	}
}

		/*
	@Override
	public String getDescrizione() {
		return this.toString();
	}

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		for (String direzione : super.getDirezioni())
			if (direzione != null && direzione != this.direzioneBloccata)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (int i = 0; i < super.getNumeroAttrezzi(); i++) {
			risultato.append(super.getAttrezzi()[i].toString() + " ");
		}

		return risultato.toString();
	}
		 */



