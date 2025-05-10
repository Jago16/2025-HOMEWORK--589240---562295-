package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String attrezzoStanzaBuia;
	private String statoStanza = "Qui c'e' un buio pesto!";
	
	public StanzaBuia(String nome) {
		super(nome);
		this.attrezzoStanzaBuia = "lanterna";
	}
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoStanzaBuia = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoStanzaBuia)) {
			return super.toString();
		}
		return this.toString();
	}

	
	@Override
	public String toString() {
		return this.statoStanza;
	}
}
