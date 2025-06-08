package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	@Override
	public String getNome() {
		return "saluta";
	}

	@Override
	public void esegui(Partita partita) {
		partita.getStanzaCorrente().getPersonaggio().Salutato();
	}

}
