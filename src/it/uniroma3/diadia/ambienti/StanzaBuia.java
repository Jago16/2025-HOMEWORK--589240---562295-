package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBuia - una stanza buia dove non si vede nulla, tranne se hai un determinato
 * attrezzo che illumina la stanza
 * @see Stanza
 * @see Attrezzo
 * @version 1.0
 */
public class StanzaBuia extends Stanza{
	
	private String illumina;
	
	public StanzaBuia(String nome,String illumina) {
		super(nome);
		this.illumina = illumina;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(illumina))
			return "Qui c'è un buio pesto";
		
		return super.toString();
	}
}
