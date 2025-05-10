package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	String direzioneBloccata;
	String attrezzoCheSblocca;
			
	public StanzaBloccata(String nome) {
		super(nome);
	}

	public StanzaBloccata(String nome, String direzione) {
		super(nome);
		this.direzioneBloccata = direzione;
	}
	
	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoCheSblocca = attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(attrezzoCheSblocca)) {
			return this;
		}
		else 
			return super.getStanzaAdiacente(direzione);
	}

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

	
	

}
